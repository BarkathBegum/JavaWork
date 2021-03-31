package mongodb.jpa.demo.service;

import mongodb.jpa.demo.model.Employee;
import mongodb.jpa.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByEmpId(String empId) {
        return employeeRepository.findByEmpId(empId);
    }

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    public void deleteByEmpId(String empId) {
        employeeRepository.deleteByEmpId(empId);
    }
}
