package mongodb.jpa.demo.repository;

import mongodb.jpa.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByEmpId(String empId);

    void deleteByEmpId(String empId);
}
