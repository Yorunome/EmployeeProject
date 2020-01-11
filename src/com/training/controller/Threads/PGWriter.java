package com.training.controller.Threads;

import com.training.controller.MyCollection;

import java.sql.SQLException;

public class PGWriter extends Thread{
    public PGWriter(){
        super("Mongo Writer Thread");
    }

    public void run(){
        MyCollection collection = new MyCollection();
        try {
            collection.writeInPostGres();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
