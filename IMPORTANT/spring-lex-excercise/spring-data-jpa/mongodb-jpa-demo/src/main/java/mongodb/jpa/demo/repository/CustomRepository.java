package mongodb.jpa.demo.repository;

public interface CustomRepository {

    void updateEmployeeSalary(String employeeBandLevel, double employeeSalary);
}
