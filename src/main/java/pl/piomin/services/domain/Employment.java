package pl.piomin.services.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employment_id_seq")
    @SequenceGenerator(name = "employment_id_seq", sequenceName = "employment_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Organization organization;
    @Temporal(TemporalType.DATE)
    private Date start;
    @Temporal(TemporalType.DATE)
    private Date end;

    public Employment() {
    }

    public Employment(Employee employee, Organization organization, Date start) {
        this.employee = employee;
        this.organization = organization;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

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
