package pl.piomin.services.repository;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import pl.piomin.services.domain.Organization;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    @Join(value = "departments", type = Join.Type.LEFT_FETCH)
    @Join(value = "employees", type = Join.Type.LEFT_FETCH)
    Optional<Organization> findByName(String name);

}
