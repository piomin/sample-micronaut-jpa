package pl.piomin.services.controller;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import pl.piomin.services.domain.Organization;
import pl.piomin.services.repository.OrganizationRepository;
import java.util.Optional;

@Controller("organizations")
public class OrganizationController {

    @Inject
    OrganizationRepository repository;

    @Post
    public Long addOrganization(@Body Organization organization) {
        Organization organization1 = repository.save(organization);
        return organization1.getId();
    }

    @Get("/name/{name}")
    public Optional<Organization> findOrganization(@NonNull String name) {
        return repository.findByName(name);
    }

}
