package pl.piomin.services.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import pl.piomin.services.domain.Employee;
import pl.piomin.services.dto.EmploymentDTO;
import pl.piomin.services.repository.EmployeeRepository;
import pl.piomin.services.repository.EmploymentRepository;

import java.util.Optional;
import java.util.Set;

@Controller("employments")
public class EmploymentController {

    @Inject
    EmployeeRepository employeeRepository;
    @Inject
    EmploymentRepository repository;

    @Get("/employee/{employeeId}")
    public Set<EmploymentDTO> findByEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return repository.findByEmployeeOrderByStartDesc(employee.get());
    }

}
