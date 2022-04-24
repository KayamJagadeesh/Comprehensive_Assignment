package employee.management.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import employee.management.exception.ResourceNotFoundException;
import employee.management.model.Employee;
import employee.management.repository.EmployeeRepository;
import employee.management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee given id is exist in DB or not
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setName(employee.getName());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setDesignation(employee.getDesignation());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}




}
