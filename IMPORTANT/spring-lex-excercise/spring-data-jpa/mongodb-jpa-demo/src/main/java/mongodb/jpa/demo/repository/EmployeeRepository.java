package mongodb.jpa.demo.repository;

import mongodb.jpa.demo.model.Address;
import mongodb.jpa.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String>, CustomRepository {

    List<Employee> findByEmpId(String empId);
    List<Employee> findByEmployeeBandLevel(String employeeBandLevel);

    List<Employee> findByAddress(Address address);

    void deleteByEmpId(String empId);
}
