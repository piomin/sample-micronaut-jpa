package pl.piomin.services.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import pl.piomin.services.domain.Employee;
import pl.piomin.services.domain.Organization;
import pl.piomin.services.dto.EmployeeDTO;

import java.util.Set;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Set<EmployeeDTO> findBySalaryGreaterThan(int salary);
    Set<EmployeeDTO> findByOrganization(Organization organization);
    int findAvgSalaryByAge(int age);
    int findAvgSalaryByOrganization(Organization organization);

}
