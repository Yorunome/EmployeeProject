package com.training.controller.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class CreateCollection {
    void createCollection(MongoClient mongo){
        MongoDatabase database = mongo.getDatabase("trainingdb");
        database.createCollection("Test");
        System.out.println("Collection created successfully");
    }
}