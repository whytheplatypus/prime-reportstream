/*
 * This file is generated by jOOQ.
 */
package gov.cdc.prime.router.azure.db.tables.pojos;


import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReportLineage implements Serializable {

    private static final long serialVersionUID = 836082947;

    private Long           reportLineageId;
    private Long           actionId;
    private UUID           parentReportId;
    private UUID           childReportId;
    private OffsetDateTime createdAt;

    public ReportLineage() {}

    public ReportLineage(ReportLineage value) {
        this.reportLineageId = value.reportLineageId;
        this.actionId = value.actionId;
        this.parentReportId = value.parentReportId;
        this.childReportId = value.childReportId;
        this.createdAt = value.createdAt;
    }

    public ReportLineage(
        Long           reportLineageId,
        Long           actionId,
        UUID           parentReportId,
        UUID           childReportId,
        OffsetDateTime createdAt
    ) {
        this.reportLineageId = reportLineageId;
        this.actionId = actionId;
        this.parentReportId = parentReportId;
        this.childReportId = childReportId;
        this.createdAt = createdAt;
    }

    public Long getReportLineageId() {
        return this.reportLineageId;
    }

    public ReportLineage setReportLineageId(Long reportLineageId) {
        this.reportLineageId = reportLineageId;
        return this;
    }

    public Long getActionId() {
        return this.actionId;
    }

    public ReportLineage setActionId(Long actionId) {
        this.actionId = actionId;
        return this;
    }

    public UUID getParentReportId() {
        return this.parentReportId;
    }

    public ReportLineage setParentReportId(UUID parentReportId) {
        this.parentReportId = parentReportId;
        return this;
    }

    public UUID getChildReportId() {
        return this.childReportId;
    }

    public ReportLineage setChildReportId(UUID childReportId) {
        this.childReportId = childReportId;
        return this;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public ReportLineage setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ReportLineage other = (ReportLineage) obj;
        if (reportLineageId == null) {
            if (other.reportLineageId != null)
                return false;
        }
        else if (!reportLineageId.equals(other.reportLineageId))
            return false;
        if (actionId == null) {
            if (other.actionId != null)
                return false;
        }
        else if (!actionId.equals(other.actionId))
            return false;
        if (parentReportId == null) {
            if (other.parentReportId != null)
                return false;
        }
        else if (!parentReportId.equals(other.parentReportId))
            return false;
        if (childReportId == null) {
            if (other.childReportId != null)
                return false;
        }
        else if (!childReportId.equals(other.childReportId))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!createdAt.equals(other.createdAt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.reportLineageId == null) ? 0 : this.reportLineageId.hashCode());
        result = prime * result + ((this.actionId == null) ? 0 : this.actionId.hashCode());
        result = prime * result + ((this.parentReportId == null) ? 0 : this.parentReportId.hashCode());
        result = prime * result + ((this.childReportId == null) ? 0 : this.childReportId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ReportLineage (");

        sb.append(reportLineageId);
        sb.append(", ").append(actionId);
        sb.append(", ").append(parentReportId);
        sb.append(", ").append(childReportId);
        sb.append(", ").append(createdAt);

        sb.append(")");
        return sb.toString();
    }
}
