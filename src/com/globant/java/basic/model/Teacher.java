package com.globant.java.basic.model;

import com.globant.java.basic.service.IPrint;

public abstract class Teacher extends Person implements IPrint {
    private int id;
    private static int ultimateId;
    private Double baseSalary;

    public Teacher(String name,String lastName,String identificationDocument, int age,Double baseSalary) {
        super(name,lastName,identificationDocument, age);
        this.baseSalary = baseSalary;
        this.id = ++ultimateId;
    }

    public int getId() {
        return id;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public abstract Double calculateSalary();

}
