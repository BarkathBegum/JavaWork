package mongodb.jpa.demo.repository;

import mongodb.jpa.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void updateEmployeeSalary(String employeeBandLevel, double employeeSalary) {
        Query query = new Query().addCriteria(where("employeeBandLevel").is(employeeBandLevel));

        Update update = new Update();
        update.set("employeeSalary", employeeSalary);
        mongoTemplate.update(Employee.class).matching(query).apply(update).first();
    }

}
