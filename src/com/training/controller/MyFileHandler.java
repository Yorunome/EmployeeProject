package com.training.controller;

interface MyFileHandler {
    public int readCounter=0;
    void read();
    void write();
}