package pl.piomin.services.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq")
	@SequenceGenerator(name = "department_id_seq", sequenceName = "department_id_seq", allocationSize = 1)
	private Long id;
	private String name;
	@OneToMany
	private Set<Employee> employees;
	@ManyToOne
	private Organization organization;

	public Department() {
		
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
