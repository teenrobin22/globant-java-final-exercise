package com.globant.java.basic.model;

public abstract class Person {
    private int id;
    private static int ultimateId;
    private String name;
    private String lastName;
    private String identificationDocument;
    private int age;

    public Person(String name,String lastName,String identificationDocument, int age) {
        this.id = ++this.ultimateId;
        this.name = name;
        this.lastName = lastName;
        this.identificationDocument = identificationDocument;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getIdentificationDocument() {
        return identificationDocument;
    }

}
