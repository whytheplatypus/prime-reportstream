/*
 * The Flyway tool applies this migration to create the database.
 *
 * Follow this style guide https://about.gitlab.com/handbook/business-ops/data-team/platform/sql-style-guide/
 * use VARCHAR(63) for names in organization and schema
 *
 * Copy a version of this comment into the next migration
 *
 */


/*
  Change the type of the values column to jsonb so queries are faster and
  doing operations on the underlying JSON objects is easier
 */
ALTER TABLE Setting ALTER COLUMN values TYPE jsonb;

/*
    we need to remove the useAphlNamingFormat because we are moving
    to an enum instead.

    This update statement looks very complex, but it's not so bad once you
    break apart the individual pieces.

    The brief breakdown is here, but the documentation from postgresql is very good.
    Find more information at this link: https://www.postgresql.org/docs/11/functions-json.html

    Below, I am checking the value of useAphlNamingFormat in the translation object. There's three
    possible values: 'true', 'false', and null. If useAphlNamingFormat is null, we just pass through
    the existing value because we don't need to migrate the value.

    If the value for useAphlNamingFormat is 'true' then we need to set the new nameFormat key to
    "APHL".

    If the value for useAphlNamingFormat is 'false' then we need to add a value for nameFormat in the
    translation object.

    I'm doing this via a set of nested jsonb_set calls, the first to update the translation object
    itself, and then updating each value with the new jsonb.

    jsonb_set takes three params: the blob to update, the key to add/update, and the value to set it to.

    The other thing to note is that pgsql lets you subtract keys from JSON directly by using the '-'
    operator. For example, removing useAphlNamingFormat from translation is done just by subtracting it
    from the JSON.
*/
UPDATE
  setting s
SET
  values = CASE (s.values::jsonb#>'{translation,useAphlNamingFormat}')
             WHEN 'true' THEN
               -- set the value in setting back to the whole computed blob
               -- after updating the translation object to the return from
               -- the inner call to jsonb_set
               JSONB_SET(
                 s.values::jsonb,
                 '{translation}',
                 JSONB_SET(
                   ((s.values::jsonb -> 'translation') - 'useAphlNamingFormat'),      -- remove key
                   '{nameFormat}',                                                    -- add nameFormat
                   '"APHL"'                                                           -- to APHL
                 )
               )
             WHEN 'false' THEN
               JSONB_SET(
                 s.values::jsonb,
                 '{translation}',
                 JSONB_SET(
                   ((s.values::jsonb -> 'translation') - 'useAphlNamingFormat'),          -- remove key
                   '{nameFormat}',                                                        -- add nameFormat
                   COALESCE((s.values::jsonb#>'{translation,nameFormat}'), '"STANDARD"')  -- set to what already exists
                 )                                                                        -- or to STANDARD
               )
             ELSE s.values::jsonb
        END
WHERE
  s.type = 'RECEIVER'
  AND s.values::jsonb#>'{translation}' IS NOT NULL
;

-- now if there's any setting that doesn't have a nameFormat value after our update, let's add
-- nameFormat to defaulted to "STANDARD"
UPDATE
  setting s
SET
  values = jsonb_set(s.values::jsonb, '{translation,nameFormat}', '"STANDARD"')
WHERE
  s.type = 'RECEIVER'
  AND s.values::jsonb#>'{translation,nameFormat}' IS NULL
;

