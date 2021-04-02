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
    List<Employee> findByEmailAddress(String emailAddress);
    List<Employee> findByEmailAddressAndEmployeeSalaryGreaterThan(String emailAddress, double employeeSalary);

    @Query("{'empName' : :#{#empName}, 'emailAddress' : :#{#emailAddress} }")
    List<Employee> findByEmpNameAndEmailAddress(String empName, String emailAddress);
    @Query("{'employeeBandLevel' : :#{#employeeBandLevel}, 'employeeSalary' : :#{#employeeSalary} }")
    List<Employee> findByEmployeeBandLevelAndEmployeeSalary(String employeeBandLevel, double employeeSalary);
    @Query("{'employeeContactNumber' : :#{#employeeContactNumber}, 'emailAddress' : :#{#emailAddress} }")
    List<Employee> findByEmployeeContactNumberAndEmailAddress(String employeeContactNumber, String emailAddress);

    List<Employee> findByAddress(Address address);

    void deleteByEmpId(String empId);
}
