package com.training.controller.Threads;

import com.training.controller.MyCollection;

public class MongoWriterFromCollection extends Thread{
    public MongoWriterFromCollection(){
        super("Mongo Writer Thread");
    }

    public void run(){
        MyCollection collection = new MyCollection();
        collection.writeIntoMongoDB();
    }
}
