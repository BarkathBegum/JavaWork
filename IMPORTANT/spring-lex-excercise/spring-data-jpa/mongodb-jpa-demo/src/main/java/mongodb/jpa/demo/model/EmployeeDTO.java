package mongodb.jpa.demo.model;

public class EmployeeDTO {
        private String empId;
        private String empName;
        private String department;
        private String baseLocation;
        private Address address;

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

    public EmployeeDTO(String empId, String empName, String department, String baseLocation, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseLocation = baseLocation;
        this.address = address;
    }
}
