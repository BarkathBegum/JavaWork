package mongodb.jpa.demo.service;

import mongodb.jpa.demo.model.Address;
import mongodb.jpa.demo.model.Employee;
import mongodb.jpa.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Employee> findAll(Pageable page) {
        return employeeRepository.findAll(page);
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return employeeRepository.findAll(sort);
    }

    @Override
    public List<Employee> findByEmpId(String empId) {
        return employeeRepository.findByEmpId(empId);
    }
    public Employee findByMaxSalary() {
        return employeeRepository.maxSalary();
    }
    public List<Employee> findByAddress(Address address) {
        return employeeRepository.findByAddress(address);
    }
    public List<Employee> findByEmailAddress(String emailAddress) {
        return employeeRepository.findByEmailAddress(emailAddress);
    }
    public List<Employee> findByEmpNameAndEmailAddress(String empName, String emailAddress) {
        return employeeRepository.findByEmpNameAndEmailAddress(empName, emailAddress);
    }
    public List<Employee> findByEmailAddressAndEmployeeSalaryGreaterThan(String emailAddress, double employeeSalary) {
        return employeeRepository.findByEmailAddressAndEmployeeSalaryGreaterThan(emailAddress, employeeSalary);
    }
    public List<Employee> findByEmployeeBandLevelAndEmployeeSalary(String employeeBandLevel, double employeeSalary) {
        return employeeRepository.findByEmployeeBandLevelAndEmployeeSalary(employeeBandLevel, employeeSalary);
    }
    public List<Employee> findByEmployeeContactNumberAndEmailAddress(String employeeContactNumber, String emailAddress) {
        return employeeRepository.findByEmployeeContactNumberAndEmailAddress(employeeContactNumber, emailAddress);
    }

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    public String updateByEmployeeBandLevel(String employeeBandLevel) {
        List<Employee> employeesList = employeeRepository.findByEmployeeBandLevel(employeeBandLevel);
        double updatedSalary = 0.0;
        for(Employee employee : employeesList) {
            if(employeeBandLevel=="A")
            {
                updatedSalary=employee.getEmployeeSalary()+(employee.getEmployeeSalary()*15/100);
            }
            else if(employeeBandLevel=="B")
            {
                updatedSalary=employee.getEmployeeSalary()+(employee.getEmployeeSalary()*10/100);
            }
            else if(employeeBandLevel=="C")
            {
                updatedSalary=employee.getEmployeeSalary()+(employee.getEmployeeSalary()*5/100);
            }
            employeeRepository.updateEmployeeSalary(employeeBandLevel,updatedSalary);
        }
        return "Success";
    }

    @Override
    public void deleteByEmpId(String empId) {
        employeeRepository.deleteByEmpId(empId);
    }
}
