/*
 * This file is generated by jOOQ.
 */
package gov.cdc.prime.router.azure.db.tables;


import gov.cdc.prime.router.azure.db.Indexes;
import gov.cdc.prime.router.azure.db.Keys;
import gov.cdc.prime.router.azure.db.Public;
import gov.cdc.prime.router.azure.db.enums.SettingType;
import gov.cdc.prime.router.azure.db.tables.records.SettingRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.JSON;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
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
public class Setting extends TableImpl<SettingRecord> {

    private static final long serialVersionUID = 511844314;

    /**
     * The reference instance of <code>public.setting</code>
     */
    public static final Setting SETTING = new Setting();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SettingRecord> getRecordType() {
        return SettingRecord.class;
    }

    /**
     * The column <code>public.setting.setting_id</code>.
     */
    public final TableField<SettingRecord, Integer> SETTING_ID = createField(DSL.name("setting_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('setting_setting_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.setting.type</code>.
     */
    public final TableField<SettingRecord, SettingType> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false).asEnumDataType(gov.cdc.prime.router.azure.db.enums.SettingType.class), this, "");

    /**
     * The column <code>public.setting.name</code>.
     */
    public final TableField<SettingRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(63).nullable(false), this, "");

    /**
     * The column <code>public.setting.organization_id</code>.
     */
    public final TableField<SettingRecord, Integer> ORGANIZATION_ID = createField(DSL.name("organization_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.setting.values</code>.
     */
    public final TableField<SettingRecord, JSON> VALUES = createField(DSL.name("values"), org.jooq.impl.SQLDataType.JSON, this, "");

    /**
     * The column <code>public.setting.is_deleted</code>.
     */
    public final TableField<SettingRecord, Boolean> IS_DELETED = createField(DSL.name("is_deleted"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.setting.is_active</code>.
     */
    public final TableField<SettingRecord, Boolean> IS_ACTIVE = createField(DSL.name("is_active"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.setting.version</code>.
     */
    public final TableField<SettingRecord, Integer> VERSION = createField(DSL.name("version"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.setting.created_by</code>.
     */
    public final TableField<SettingRecord, String> CREATED_BY = createField(DSL.name("created_by"), org.jooq.impl.SQLDataType.VARCHAR(63).nullable(false), this, "");

    /**
     * The column <code>public.setting.created_at</code>.
     */
    public final TableField<SettingRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false), this, "");

    /**
     * Create a <code>public.setting</code> table reference
     */
    public Setting() {
        this(DSL.name("setting"), null);
    }

    /**
     * Create an aliased <code>public.setting</code> table reference
     */
    public Setting(String alias) {
        this(DSL.name(alias), SETTING);
    }

    /**
     * Create an aliased <code>public.setting</code> table reference
     */
    public Setting(Name alias) {
        this(alias, SETTING);
    }

    private Setting(Name alias, Table<SettingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Setting(Name alias, Table<SettingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Setting(Table<O> child, ForeignKey<O, SettingRecord> key) {
        super(child, key, SETTING);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SETTING_ORGANIZATION_ID_IDX, Indexes.SETTING_TYPE_ORGANIZATION_ID_NAME_IDX);
    }

    @Override
    public Identity<SettingRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SETTING;
    }

    @Override
    public UniqueKey<SettingRecord> getPrimaryKey() {
        return Keys.SETTING_PKEY;
    }

    @Override
    public List<UniqueKey<SettingRecord>> getKeys() {
        return Arrays.<UniqueKey<SettingRecord>>asList(Keys.SETTING_PKEY, Keys.SETTING_TYPE_ORGANIZATION_ID_NAME_VERSION_KEY);
    }

    @Override
    public List<ForeignKey<SettingRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SettingRecord, ?>>asList(Keys.SETTING__SETTING_ORGANIZATION_ID_FKEY);
    }

    public Setting setting() {
        return new Setting(this, Keys.SETTING__SETTING_ORGANIZATION_ID_FKEY);
    }

    @Override
    public Setting as(String alias) {
        return new Setting(DSL.name(alias), this);
    }

    @Override
    public Setting as(Name alias) {
        return new Setting(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Setting rename(String name) {
        return new Setting(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Setting rename(Name name) {
        return new Setting(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, SettingType, String, Integer, JSON, Boolean, Boolean, Integer, String, OffsetDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
