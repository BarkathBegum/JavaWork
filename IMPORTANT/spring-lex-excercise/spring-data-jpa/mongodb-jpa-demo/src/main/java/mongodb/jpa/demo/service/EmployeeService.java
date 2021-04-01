package mongodb.jpa.demo.service;

import mongodb.jpa.demo.model.Employee;
import mongodb.jpa.demo.model.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    void insert(Employee emp);
    List<Employee> findAll();
    Page<Employee> findAll(Pageable page);
    List<Employee> findAll(Sort sort);

    List<Employee> findByEmpId(String empId);
    void save(Employee employee);
    void deleteByEmpId(String empId);
}
