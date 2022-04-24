package employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employee.management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
