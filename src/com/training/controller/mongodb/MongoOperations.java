package com.training.controller.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Date;
import java.util.Iterator;

public class MongoOperations {

    MongoCollection<Document> collection;

    public MongoOperations(MongoClient mongo) {
        MongoDatabase database = mongo.getDatabase("trainingdb");
        collection = database.getCollection("Test");
    }

    public void setData(String firstName, String lastName, Date dateOfBirth, double experience) {
        Document document = new Document("First Name", firstName);
        document.append("Last Name", lastName);
        document.append("Date", dateOfBirth);
        document.append("experience", 7);
        collection.insertOne(document);
        //System.out.println("Insertion complete");

    }

    public void getData() {
        FindIterable<Document> docCrawler = collection.find();
        Iterator it = docCrawler.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public void deleteData(String label, String condition) {
        collection.deleteOne(Filters.eq(label, condition));
        System.out.println("Deletion operation achieved");
        getData();
    }
}
