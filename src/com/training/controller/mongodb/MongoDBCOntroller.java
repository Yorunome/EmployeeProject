package com.training.controller.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class MongoDBCOntroller {
    public MongoClient startDB() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoCredential credential;
        credential = MongoCredential.createCredential("training", "trainingdb", "nagito".toCharArray());
        System.out.println("Connection established successfully");

        MongoDatabase database = mongo.getDatabase("trainingdb");
        return mongo;

//        CreateCollection collection = new CreateCollection();
//        collection.createCollection(mongo);
//        MongoOperations operator = new MongoOperations(mongo);
        //operator.setData();
//        operator.getData();
//        operator.deleteData("title", "Employee Table");

    }
}
