package mongodb.jpa.demo.repository;

import mongodb.jpa.demo.model.Address;
import mongodb.jpa.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository  extends MongoRepository<Address, String> {
}
