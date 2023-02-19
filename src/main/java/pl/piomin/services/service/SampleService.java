package pl.piomin.services.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.services.domain.Department;
import pl.piomin.services.domain.Employee;
import pl.piomin.services.domain.Employment;
import pl.piomin.services.repository.DepartmentRepository;
import pl.piomin.services.repository.EmployeeRepository;
import pl.piomin.services.repository.EmploymentRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Singleton
public class SampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

    @Inject
    DepartmentRepository departmentRepository;
    @Inject
    EmployeeRepository employeeRepository;
    @Inject
    EmploymentRepository employmentRepository;

    @Transactional
    public void changeJob(Long employeeId, Long targetDepartmentId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        employee.ifPresent(employee1 -> {
            Optional<Department> department = departmentRepository.findById(targetDepartmentId);
            department.ifPresent(department1 -> {
                employee1.setDepartment(department1);
                employee1.setOrganization(department1.getOrganization());
                Employment employment = new Employment(employee1, department1.getOrganization(), new Date());
                employmentRepository.save(employment);
                Employment previousEmployment = employmentRepository.findByEmployeeAndEndIsNull(employee1);
                previousEmployment.setEnd(new Date());
                employmentRepository.save(previousEmployment);
            });
        });
    }

    @Transactional
    public void hireEmployee(Employee employee, Long targetDepartmentId) {
        Optional<Department> department = departmentRepository.findById(targetDepartmentId);
        department.ifPresent(department1 -> {
            employee.setDepartment(department1);
            employee.setOrganization(department1.getOrganization());
            Employee employeeSaved = employeeRepository.save(employee);
            LOGGER.info("{}", employeeSaved);
            employmentRepository.save(new Employment(employeeSaved, department1.getOrganization(), new Date()));
        });
    }
}
