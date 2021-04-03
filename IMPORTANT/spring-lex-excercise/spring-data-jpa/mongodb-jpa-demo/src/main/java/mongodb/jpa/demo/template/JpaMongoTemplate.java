package mongodb.jpa.demo.template;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.schema.JsonSchemaProperty.object;
import static org.springframework.data.mongodb.core.schema.JsonSchemaProperty.string;

@Service
public class JpaMongoTemplate {
    public MongoOperations createCollection(String tableName) throws ClassNotFoundException {

        MongoOperations mongoOps = getMongoOps();

        String tableToClassName = tableName.substring(0, 1).toUpperCase() + tableName.substring(1);
        String className = "mongodb.jpa.demo.model."+tableToClassName;
        Class collectionName = Class.forName(className);

        if(!mongoOps.collectionExists(collectionName))
        {
            mongoOps.createCollection(collectionName, getSchemaOption(collectionName));
        }
        return mongoOps;
    }
    private MongoOperations getMongoOps()
    {
        SimpleMongoClientDatabaseFactory databaseFactory = new SimpleMongoClientDatabaseFactory(MongoClients.create(), "mongo-practice");
        MongoOperations mongoOps = new MongoTemplate(databaseFactory);
        return mongoOps;
    }
    private CollectionOptions getSchemaOption(Class collectionName) {
        MongoJsonSchema schema = MongoJsonSchemaCreator.create(getMongoOps().getConverter())
                .createSchemaFor(collectionName);

        CollectionOptions options = CollectionOptions.empty().schema(schema);
        return options;
    }
}
