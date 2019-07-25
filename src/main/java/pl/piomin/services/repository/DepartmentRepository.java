package pl.piomin.services.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import pl.piomin.services.domain.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
