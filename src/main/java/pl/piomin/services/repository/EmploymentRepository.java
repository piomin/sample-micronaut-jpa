package pl.piomin.services.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import pl.piomin.services.domain.Employee;
import pl.piomin.services.domain.Employment;
import pl.piomin.services.dto.EmploymentDTO;

import java.util.Set;

@Repository
public interface EmploymentRepository extends CrudRepository<Employment, Long> {

    Set<EmploymentDTO> findByEmployeeOrderByStartDesc(Employee employee);

    Employment findByEmployeeAndEndIsNull(Employee employee);

}
