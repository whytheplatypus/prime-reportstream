/*
 * This file is generated by jOOQ.
 */
package gov.cdc.prime.router.azure.db.tables;


import gov.cdc.prime.router.azure.db.Indexes;
import gov.cdc.prime.router.azure.db.Keys;
import gov.cdc.prime.router.azure.db.Public;
import gov.cdc.prime.router.azure.db.enums.TaskAction;
import gov.cdc.prime.router.azure.db.tables.records.TaskRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.JSON;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row15;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Task extends TableImpl<TaskRecord> {

    private static final long serialVersionUID = 484994252;

    /**
     * The reference instance of <code>public.task</code>
     */
    public static final Task TASK = new Task();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TaskRecord> getRecordType() {
        return TaskRecord.class;
    }

    /**
     * The column <code>public.task.report_id</code>.
     */
    public final TableField<TaskRecord, UUID> REPORT_ID = createField(DSL.name("report_id"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.task.next_action</code>.
     */
    public final TableField<TaskRecord, TaskAction> NEXT_ACTION = createField(DSL.name("next_action"), org.jooq.impl.SQLDataType.VARCHAR.asEnumDataType(gov.cdc.prime.router.azure.db.enums.TaskAction.class), this, "");

    /**
     * The column <code>public.task.next_action_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> NEXT_ACTION_AT = createField(DSL.name("next_action_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.schema_name</code>.
     */
    public final TableField<TaskRecord, String> SCHEMA_NAME = createField(DSL.name("schema_name"), org.jooq.impl.SQLDataType.VARCHAR(63).nullable(false), this, "");

    /**
     * The column <code>public.task.receiver_name</code>.
     */
    public final TableField<TaskRecord, String> RECEIVER_NAME = createField(DSL.name("receiver_name"), org.jooq.impl.SQLDataType.VARCHAR(63), this, "");

    /**
     * The column <code>public.task.item_count</code>.
     */
    public final TableField<TaskRecord, Integer> ITEM_COUNT = createField(DSL.name("item_count"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.task.body_format</code>.
     */
    public final TableField<TaskRecord, String> BODY_FORMAT = createField(DSL.name("body_format"), org.jooq.impl.SQLDataType.VARCHAR(63), this, "");

    /**
     * The column <code>public.task.body_url</code>.
     */
    public final TableField<TaskRecord, String> BODY_URL = createField(DSL.name("body_url"), org.jooq.impl.SQLDataType.VARCHAR(2048), this, "");

    /**
     * The column <code>public.task.created_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.translated_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> TRANSLATED_AT = createField(DSL.name("translated_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.batched_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> BATCHED_AT = createField(DSL.name("batched_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.sent_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> SENT_AT = createField(DSL.name("sent_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.wiped_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> WIPED_AT = createField(DSL.name("wiped_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.errored_at</code>.
     */
    public final TableField<TaskRecord, OffsetDateTime> ERRORED_AT = createField(DSL.name("errored_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE, this, "");

    /**
     * The column <code>public.task.retry_token</code>.
     */
    public final TableField<TaskRecord, JSON> RETRY_TOKEN = createField(DSL.name("retry_token"), org.jooq.impl.SQLDataType.JSON, this, "");

    /**
     * Create a <code>public.task</code> table reference
     */
    public Task() {
        this(DSL.name("task"), null);
    }

    /**
     * Create an aliased <code>public.task</code> table reference
     */
    public Task(String alias) {
        this(DSL.name(alias), TASK);
    }

    /**
     * Create an aliased <code>public.task</code> table reference
     */
    public Task(Name alias) {
        this(alias, TASK);
    }

    private Task(Name alias, Table<TaskRecord> aliased) {
        this(alias, aliased, null);
    }

    private Task(Name alias, Table<TaskRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Task(Table<O> child, ForeignKey<O, TaskRecord> key) {
        super(child, key, TASK);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TASK_NEXT_ACTION_IDX);
    }

    @Override
    public UniqueKey<TaskRecord> getPrimaryKey() {
        return Keys.TASK_PKEY;
    }

    @Override
    public List<UniqueKey<TaskRecord>> getKeys() {
        return Arrays.<UniqueKey<TaskRecord>>asList(Keys.TASK_PKEY);
    }

    @Override
    public Task as(String alias) {
        return new Task(DSL.name(alias), this);
    }

    @Override
    public Task as(Name alias) {
        return new Task(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Task rename(String name) {
        return new Task(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Task rename(Name name) {
        return new Task(name, null);
    }

    // -------------------------------------------------------------------------
    // Row15 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row15<UUID, TaskAction, OffsetDateTime, String, String, Integer, String, String, OffsetDateTime, OffsetDateTime, OffsetDateTime, OffsetDateTime, OffsetDateTime, OffsetDateTime, JSON> fieldsRow() {
        return (Row15) super.fieldsRow();
    }
}
