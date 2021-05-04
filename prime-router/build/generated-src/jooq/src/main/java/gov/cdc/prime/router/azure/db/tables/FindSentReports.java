/*
 * This file is generated by jOOQ.
 */
package gov.cdc.prime.router.azure.db.tables;


import gov.cdc.prime.router.azure.db.Public;
import gov.cdc.prime.router.azure.db.tables.records.FindSentReportsRecord;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FindSentReports extends TableImpl<FindSentReportsRecord> {

    private static final long serialVersionUID = 1396593626;

    /**
     * The reference instance of <code>public.find_sent_reports</code>
     */
    public static final FindSentReports FIND_SENT_REPORTS = new FindSentReports();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FindSentReportsRecord> getRecordType() {
        return FindSentReportsRecord.class;
    }

    /**
     * The column <code>public.find_sent_reports.find_sent_reports</code>.
     */
    public final TableField<FindSentReportsRecord, UUID> FIND_SENT_REPORTS_ = createField(DSL.name("find_sent_reports"), org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * Create a <code>public.find_sent_reports</code> table reference
     */
    public FindSentReports() {
        this(DSL.name("find_sent_reports"), null);
    }

    /**
     * Create an aliased <code>public.find_sent_reports</code> table reference
     */
    public FindSentReports(String alias) {
        this(DSL.name(alias), FIND_SENT_REPORTS);
    }

    /**
     * Create an aliased <code>public.find_sent_reports</code> table reference
     */
    public FindSentReports(Name alias) {
        this(alias, FIND_SENT_REPORTS);
    }

    private FindSentReports(Name alias, Table<FindSentReportsRecord> aliased) {
        this(alias, aliased, new Field[1]);
    }

    private FindSentReports(Name alias, Table<FindSentReportsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.function());
    }

    public <O extends Record> FindSentReports(Table<O> child, ForeignKey<O, FindSentReportsRecord> key) {
        super(child, key, FIND_SENT_REPORTS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public FindSentReports as(String alias) {
        return new FindSentReports(DSL.name(alias), this, parameters);
    }

    @Override
    public FindSentReports as(Name alias) {
        return new FindSentReports(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public FindSentReports rename(String name) {
        return new FindSentReports(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public FindSentReports rename(Name name) {
        return new FindSentReports(name, null, parameters);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<UUID> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * Call this table-valued function
     */
    public FindSentReports call(UUID startReportId) {
        return new FindSentReports(DSL.name(getName()), null, new Field[] { 
              DSL.val(startReportId, org.jooq.impl.SQLDataType.UUID)
        });
    }

    /**
     * Call this table-valued function
     */
    public FindSentReports call(Field<UUID> startReportId) {
        return new FindSentReports(DSL.name(getName()), null, new Field[] { 
              startReportId
        });
    }
}
