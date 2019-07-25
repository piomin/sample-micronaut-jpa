package pl.piomin.services.domain;

public class ChangeJobRequest {

    private Long employeeId;
    private Long targetOrganizationId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getTargetOrganizationId() {
        return targetOrganizationId;
    }

    public void setTargetOrganizationId(Long targetOrganizationId) {
        this.targetOrganizationId = targetOrganizationId;
    }
}
