package com.globant.java.basic.model;

import com.globant.java.basic.service.IPrint;

public class Student extends Person implements IPrint {
    private int id;
    private static int ultimateId;

    public Student(String name, String lastName, String identificationDocument, int age) {
        super(name,lastName,identificationDocument, age);
        this.id = ++this.ultimateId;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String printData() {
        return this.getName() + " "+this.getLastName();
    }
}
