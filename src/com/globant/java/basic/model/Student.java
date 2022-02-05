package com.globant.java.basic.model;

public class Student extends Person {
    private int id;
    private static int ultimateId;

    public Student(String name, String lastName, String identificationDocument, int age) {
        super(name,lastName,identificationDocument, age);
        this.id = ++this.ultimateId;
    }

    public int getId() {
        return this.id;
    }

}
