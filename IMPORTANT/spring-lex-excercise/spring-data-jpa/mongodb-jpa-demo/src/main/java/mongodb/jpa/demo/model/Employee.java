package mongodb.jpa.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import statements
@Document(collection = "employee")
public class Employee {

    @Field(name = "_id")
    private ObjectId Id;

    public ObjectId getId() {
        return Id;
    }

    public void setId(ObjectId id) {
        Id = id;
    }

    private String empId;
    private String empName;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private String department;
    private String baseLocation;
    private Address address;
    private double employeeSalary;
    private String employeeBandLevel;
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private String employeeContactNumber;

    public Employee() {
    }

    public Employee(String empName, String department, String baseLocation, Address address, double employeeSalary, String employeeBandLevel, String employeeContactNumber, String emailAddress) {
        empIdCounter = empIdCounter+1;
        this.empId = String.valueOf(empIdCounter);
        this.empName = empName;
        this.department = department;
        this.baseLocation = baseLocation;
        this.address = address;
        this.employeeSalary = employeeSalary;
        this.employeeBandLevel = employeeBandLevel;
        this.employeeContactNumber = employeeContactNumber;
        this.emailAddress = emailAddress;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeBandLevel() {
        return employeeBandLevel;
    }

    public void setEmployeeBandLevel(String employeeBandLevel) {
        this.employeeBandLevel = employeeBandLevel;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    private static int empIdCounter = 1000;

    public Employee(String empName, String department, String baseLocation, Address address) {
        empIdCounter = empIdCounter+1;
        this.empId = String.valueOf(empIdCounter);
        this.empName = empName;
        this.department = department;
        this.baseLocation = baseLocation;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", address=" + address +
                ", employeeSalary=" + employeeSalary +
                ", employeeBandLevel='" + employeeBandLevel + '\'' +
                ", employeeContactNumber='" + employeeContactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
