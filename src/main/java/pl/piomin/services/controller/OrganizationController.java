package pl.piomin.services.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import pl.piomin.services.domain.Organization;
import pl.piomin.services.repository.OrganizationRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
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
    public Optional<Organization> findOrganization(@NotNull String name) {
        return repository.findByName(name);
    }

}
