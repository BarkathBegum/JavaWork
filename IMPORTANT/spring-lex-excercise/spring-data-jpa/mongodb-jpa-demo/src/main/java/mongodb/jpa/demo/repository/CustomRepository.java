package mongodb.jpa.demo.repository;

import mongodb.jpa.demo.model.Employee;

public interface CustomRepository {

    void updateEmployeeSalary(String employeeBandLevel, double employeeSalary);
    public Employee maxSalary();
}
