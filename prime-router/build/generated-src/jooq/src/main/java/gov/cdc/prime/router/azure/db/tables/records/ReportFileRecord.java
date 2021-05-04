/*
 * This file is generated by jOOQ.
 */
package gov.cdc.prime.router.azure.db.tables.records;


import gov.cdc.prime.router.azure.db.enums.TaskAction;
import gov.cdc.prime.router.azure.db.tables.ReportFile;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record20;
import org.jooq.Row20;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReportFileRecord extends UpdatableRecordImpl<ReportFileRecord> implements Record20<UUID, Long, TaskAction, OffsetDateTime, String, String, String, String, String, String, String, String, String, String, String, byte[], Integer, OffsetDateTime, OffsetDateTime, String> {

    private static final long serialVersionUID = -249907728;

    /**
     * Setter for <code>public.report_file.report_id</code>.
     */
    public ReportFileRecord setReportId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.report_id</code>.
     */
    public UUID getReportId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.report_file.action_id</code>.
     */
    public ReportFileRecord setActionId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.action_id</code>.
     */
    public Long getActionId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.report_file.next_action</code>.
     */
    public ReportFileRecord setNextAction(TaskAction value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.next_action</code>.
     */
    public TaskAction getNextAction() {
        return (TaskAction) get(2);
    }

    /**
     * Setter for <code>public.report_file.next_action_at</code>.
     */
    public ReportFileRecord setNextActionAt(OffsetDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.next_action_at</code>.
     */
    public OffsetDateTime getNextActionAt() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>public.report_file.sending_org</code>.
     */
    public ReportFileRecord setSendingOrg(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.sending_org</code>.
     */
    public String getSendingOrg() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.report_file.sending_org_client</code>.
     */
    public ReportFileRecord setSendingOrgClient(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.sending_org_client</code>.
     */
    public String getSendingOrgClient() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.report_file.receiving_org</code>.
     */
    public ReportFileRecord setReceivingOrg(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.receiving_org</code>.
     */
    public String getReceivingOrg() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.report_file.receiving_org_svc</code>.
     */
    public ReportFileRecord setReceivingOrgSvc(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.receiving_org_svc</code>.
     */
    public String getReceivingOrgSvc() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.report_file.transport_params</code>.
     */
    public ReportFileRecord setTransportParams(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.transport_params</code>.
     */
    public String getTransportParams() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.report_file.transport_result</code>.
     */
    public ReportFileRecord setTransportResult(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.transport_result</code>.
     */
    public String getTransportResult() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.report_file.schema_name</code>.
     */
    public ReportFileRecord setSchemaName(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.schema_name</code>.
     */
    public String getSchemaName() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.report_file.schema_topic</code>.
     */
    public ReportFileRecord setSchemaTopic(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.schema_topic</code>.
     */
    public String getSchemaTopic() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.report_file.body_url</code>.
     */
    public ReportFileRecord setBodyUrl(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.body_url</code>.
     */
    public String getBodyUrl() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.report_file.external_name</code>.
     */
    public ReportFileRecord setExternalName(String value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.external_name</code>.
     */
    public String getExternalName() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.report_file.body_format</code>.
     */
    public ReportFileRecord setBodyFormat(String value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.body_format</code>.
     */
    public String getBodyFormat() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.report_file.blob_digest</code>.
     */
    public ReportFileRecord setBlobDigest(byte[] value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.blob_digest</code>.
     */
    public byte[] getBlobDigest() {
        return (byte[]) get(15);
    }

    /**
     * Setter for <code>public.report_file.item_count</code>.
     */
    public ReportFileRecord setItemCount(Integer value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.item_count</code>.
     */
    public Integer getItemCount() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>public.report_file.wiped_at</code>.
     */
    public ReportFileRecord setWipedAt(OffsetDateTime value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.wiped_at</code>.
     */
    public OffsetDateTime getWipedAt() {
        return (OffsetDateTime) get(17);
    }

    /**
     * Setter for <code>public.report_file.created_at</code>.
     */
    public ReportFileRecord setCreatedAt(OffsetDateTime value) {
        set(18, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return (OffsetDateTime) get(18);
    }

    /**
     * Setter for <code>public.report_file.downloaded_by</code>.
     */
    public ReportFileRecord setDownloadedBy(String value) {
        set(19, value);
        return this;
    }

    /**
     * Getter for <code>public.report_file.downloaded_by</code>.
     */
    public String getDownloadedBy() {
        return (String) get(19);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row20<UUID, Long, TaskAction, OffsetDateTime, String, String, String, String, String, String, String, String, String, String, String, byte[], Integer, OffsetDateTime, OffsetDateTime, String> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    @Override
    public Row20<UUID, Long, TaskAction, OffsetDateTime, String, String, String, String, String, String, String, String, String, String, String, byte[], Integer, OffsetDateTime, OffsetDateTime, String> valuesRow() {
        return (Row20) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return ReportFile.REPORT_FILE.REPORT_ID;
    }

    @Override
    public Field<Long> field2() {
        return ReportFile.REPORT_FILE.ACTION_ID;
    }

    @Override
    public Field<TaskAction> field3() {
        return ReportFile.REPORT_FILE.NEXT_ACTION;
    }

    @Override
    public Field<OffsetDateTime> field4() {
        return ReportFile.REPORT_FILE.NEXT_ACTION_AT;
    }

    @Override
    public Field<String> field5() {
        return ReportFile.REPORT_FILE.SENDING_ORG;
    }

    @Override
    public Field<String> field6() {
        return ReportFile.REPORT_FILE.SENDING_ORG_CLIENT;
    }

    @Override
    public Field<String> field7() {
        return ReportFile.REPORT_FILE.RECEIVING_ORG;
    }

    @Override
    public Field<String> field8() {
        return ReportFile.REPORT_FILE.RECEIVING_ORG_SVC;
    }

    @Override
    public Field<String> field9() {
        return ReportFile.REPORT_FILE.TRANSPORT_PARAMS;
    }

    @Override
    public Field<String> field10() {
        return ReportFile.REPORT_FILE.TRANSPORT_RESULT;
    }

    @Override
    public Field<String> field11() {
        return ReportFile.REPORT_FILE.SCHEMA_NAME;
    }

    @Override
    public Field<String> field12() {
        return ReportFile.REPORT_FILE.SCHEMA_TOPIC;
    }

    @Override
    public Field<String> field13() {
        return ReportFile.REPORT_FILE.BODY_URL;
    }

    @Override
    public Field<String> field14() {
        return ReportFile.REPORT_FILE.EXTERNAL_NAME;
    }

    @Override
    public Field<String> field15() {
        return ReportFile.REPORT_FILE.BODY_FORMAT;
    }

    @Override
    public Field<byte[]> field16() {
        return ReportFile.REPORT_FILE.BLOB_DIGEST;
    }

    @Override
    public Field<Integer> field17() {
        return ReportFile.REPORT_FILE.ITEM_COUNT;
    }

    @Override
    public Field<OffsetDateTime> field18() {
        return ReportFile.REPORT_FILE.WIPED_AT;
    }

    @Override
    public Field<OffsetDateTime> field19() {
        return ReportFile.REPORT_FILE.CREATED_AT;
    }

    @Override
    public Field<String> field20() {
        return ReportFile.REPORT_FILE.DOWNLOADED_BY;
    }

    @Override
    public UUID component1() {
        return getReportId();
    }

    @Override
    public Long component2() {
        return getActionId();
    }

    @Override
    public TaskAction component3() {
        return getNextAction();
    }

    @Override
    public OffsetDateTime component4() {
        return getNextActionAt();
    }

    @Override
    public String component5() {
        return getSendingOrg();
    }

    @Override
    public String component6() {
        return getSendingOrgClient();
    }

    @Override
    public String component7() {
        return getReceivingOrg();
    }

    @Override
    public String component8() {
        return getReceivingOrgSvc();
    }

    @Override
    public String component9() {
        return getTransportParams();
    }

    @Override
    public String component10() {
        return getTransportResult();
    }

    @Override
    public String component11() {
        return getSchemaName();
    }

    @Override
    public String component12() {
        return getSchemaTopic();
    }

    @Override
    public String component13() {
        return getBodyUrl();
    }

    @Override
    public String component14() {
        return getExternalName();
    }

    @Override
    public String component15() {
        return getBodyFormat();
    }

    @Override
    public byte[] component16() {
        return getBlobDigest();
    }

    @Override
    public Integer component17() {
        return getItemCount();
    }

    @Override
    public OffsetDateTime component18() {
        return getWipedAt();
    }

    @Override
    public OffsetDateTime component19() {
        return getCreatedAt();
    }

    @Override
    public String component20() {
        return getDownloadedBy();
    }

    @Override
    public UUID value1() {
        return getReportId();
    }

    @Override
    public Long value2() {
        return getActionId();
    }

    @Override
    public TaskAction value3() {
        return getNextAction();
    }

    @Override
    public OffsetDateTime value4() {
        return getNextActionAt();
    }

    @Override
    public String value5() {
        return getSendingOrg();
    }

    @Override
    public String value6() {
        return getSendingOrgClient();
    }

    @Override
    public String value7() {
        return getReceivingOrg();
    }

    @Override
    public String value8() {
        return getReceivingOrgSvc();
    }

    @Override
    public String value9() {
        return getTransportParams();
    }

    @Override
    public String value10() {
        return getTransportResult();
    }

    @Override
    public String value11() {
        return getSchemaName();
    }

    @Override
    public String value12() {
        return getSchemaTopic();
    }

    @Override
    public String value13() {
        return getBodyUrl();
    }

    @Override
    public String value14() {
        return getExternalName();
    }

    @Override
    public String value15() {
        return getBodyFormat();
    }

    @Override
    public byte[] value16() {
        return getBlobDigest();
    }

    @Override
    public Integer value17() {
        return getItemCount();
    }

    @Override
    public OffsetDateTime value18() {
        return getWipedAt();
    }

    @Override
    public OffsetDateTime value19() {
        return getCreatedAt();
    }

    @Override
    public String value20() {
        return getDownloadedBy();
    }

    @Override
    public ReportFileRecord value1(UUID value) {
        setReportId(value);
        return this;
    }

    @Override
    public ReportFileRecord value2(Long value) {
        setActionId(value);
        return this;
    }

    @Override
    public ReportFileRecord value3(TaskAction value) {
        setNextAction(value);
        return this;
    }

    @Override
    public ReportFileRecord value4(OffsetDateTime value) {
        setNextActionAt(value);
        return this;
    }

    @Override
    public ReportFileRecord value5(String value) {
        setSendingOrg(value);
        return this;
    }

    @Override
    public ReportFileRecord value6(String value) {
        setSendingOrgClient(value);
        return this;
    }

    @Override
    public ReportFileRecord value7(String value) {
        setReceivingOrg(value);
        return this;
    }

    @Override
    public ReportFileRecord value8(String value) {
        setReceivingOrgSvc(value);
        return this;
    }

    @Override
    public ReportFileRecord value9(String value) {
        setTransportParams(value);
        return this;
    }

    @Override
    public ReportFileRecord value10(String value) {
        setTransportResult(value);
        return this;
    }

    @Override
    public ReportFileRecord value11(String value) {
        setSchemaName(value);
        return this;
    }

    @Override
    public ReportFileRecord value12(String value) {
        setSchemaTopic(value);
        return this;
    }

    @Override
    public ReportFileRecord value13(String value) {
        setBodyUrl(value);
        return this;
    }

    @Override
    public ReportFileRecord value14(String value) {
        setExternalName(value);
        return this;
    }

    @Override
    public ReportFileRecord value15(String value) {
        setBodyFormat(value);
        return this;
    }

    @Override
    public ReportFileRecord value16(byte[] value) {
        setBlobDigest(value);
        return this;
    }

    @Override
    public ReportFileRecord value17(Integer value) {
        setItemCount(value);
        return this;
    }

    @Override
    public ReportFileRecord value18(OffsetDateTime value) {
        setWipedAt(value);
        return this;
    }

    @Override
    public ReportFileRecord value19(OffsetDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ReportFileRecord value20(String value) {
        setDownloadedBy(value);
        return this;
    }

    @Override
    public ReportFileRecord values(UUID value1, Long value2, TaskAction value3, OffsetDateTime value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, byte[] value16, Integer value17, OffsetDateTime value18, OffsetDateTime value19, String value20) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReportFileRecord
     */
    public ReportFileRecord() {
        super(ReportFile.REPORT_FILE);
    }

    /**
     * Create a detached, initialised ReportFileRecord
     */
    public ReportFileRecord(UUID reportId, Long actionId, TaskAction nextAction, OffsetDateTime nextActionAt, String sendingOrg, String sendingOrgClient, String receivingOrg, String receivingOrgSvc, String transportParams, String transportResult, String schemaName, String schemaTopic, String bodyUrl, String externalName, String bodyFormat, byte[] blobDigest, Integer itemCount, OffsetDateTime wipedAt, OffsetDateTime createdAt, String downloadedBy) {
        super(ReportFile.REPORT_FILE);

        set(0, reportId);
        set(1, actionId);
        set(2, nextAction);
        set(3, nextActionAt);
        set(4, sendingOrg);
        set(5, sendingOrgClient);
        set(6, receivingOrg);
        set(7, receivingOrgSvc);
        set(8, transportParams);
        set(9, transportResult);
        set(10, schemaName);
        set(11, schemaTopic);
        set(12, bodyUrl);
        set(13, externalName);
        set(14, bodyFormat);
        set(15, blobDigest);
        set(16, itemCount);
        set(17, wipedAt);
        set(18, createdAt);
        set(19, downloadedBy);
    }
}
