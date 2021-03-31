package mongodb.jpa.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import statements
@Document(collection = "employee")
public class Employee {

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
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", address=" + address +
                '}';
    }
}
