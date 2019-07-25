package pl.piomin.services.dto;

import io.micronaut.core.annotation.Introspected;
import pl.piomin.services.domain.Organization;

import java.util.Date;

@Introspected
public class EmploymentDTO {

    private Organization organization;
    private Date start;
    private Date end;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
