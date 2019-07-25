package pl.piomin.services.controller;

import io.micronaut.http.annotation.*;
import pl.piomin.services.domain.ChangeJobRequest;
import pl.piomin.services.domain.Employee;
import pl.piomin.services.domain.Organization;
import pl.piomin.services.dto.EmployeeDTO;
import pl.piomin.services.repository.EmployeeRepository;
import pl.piomin.services.repository.OrganizationRepository;
import pl.piomin.services.service.SampleService;

import javax.inject.Inject;
import java.util.Optional;
import java.util.Set;

@Controller("employees")
public class EmployeeController {

    @Inject
    EmployeeRepository repository;
    @Inject
    OrganizationRepository organizationRepository;
    @Inject
    SampleService service;

    @Get("/salary/{salary}")
    public Set<EmployeeDTO> findEmployeesBySalary(int salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    @Get("/organization/{organizationId}")
    public Set<EmployeeDTO> findEmployeesByOrganization(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        return repository.findByOrganization(organization.get());
    }

    @Get("/salary-avg/age/{age}")
    public int findAvgSalaryByAge(int age) {
        return repository.findAvgSalaryByAge(age);
    }

    @Get("/salary-avg/organization/{organizationId}")
    public int findAvgSalaryByAge(Long organizationId) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        return repository.findAvgSalaryByOrganization(organization.get());
    }

    @Post("/{departmentId}")
    public void addNewEmployee(@Body Employee employee, Long departmentId) {
        service.hireEmployee(employee, departmentId);
    }

    @Put("/change-job")
    public void changeJob(@Body ChangeJobRequest request) {
        service.changeJob(request.getEmployeeId(), request.getTargetOrganizationId());
    }

}
