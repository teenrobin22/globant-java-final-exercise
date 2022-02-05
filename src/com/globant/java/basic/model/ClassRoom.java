package com.globant.java.basic.model;

import com.globant.java.basic.service.IPrint;

public class ClassRoom implements IPrint {
    private int id;
    private static int ultimateId;
    private String name;
    private String ubication;
    private int capacity;

    public ClassRoom(String name,int capacity, String ubication) {
        this.name = name;
        this.ubication = ubication;
        this.capacity= capacity;
        this.id=++ultimateId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String printData() {
        return "Aula:" + this.name +
                "\nCapacidad:"+this.capacity+
                "\nUbicación:"+this.ubication;
    }
}
