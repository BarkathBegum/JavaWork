package mongodb.jpa.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

//import statements
@Document(collection = "address")
public class Address {
    private String addressId;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    private String city;
    private String pincode;

    public Address(String addressId, String city, String pincode) {
        this.addressId = addressId;
        this.city = city;
        this.pincode = pincode;
    }
    // constructors
    // getter and setter methods
}

