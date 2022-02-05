package com.globant.java.basic.model;

public class PartTimeTeacher extends Teacher{

    private int id;
    private int ultimateId;
    protected int activeHourWeek;

    public PartTimeTeacher(String name, String lastName,String identificationDocument, int age,int activeHourWeek, Double baseSalary) {
        super(name, lastName, identificationDocument,age, baseSalary);
        this.id=++ultimateId;
        this.activeHourWeek = activeHourWeek;
    }

    @Override
    public Double calculateSalary() {
        return this.getBaseSalary()*this.activeHourWeek;
    }

    @Override
    public String printData() {
       return   "Nombre: " + this.getName() +
                "\nApellidos: " + this.getLastName() +
                "\nEdad: " + this.getAge() +
                "\nDocumento nacional de identidad: "+this.getIdentificationDocument()+
                "\nModalidad: Part time"+
                "\nSalario Base:"+ this.baseSalary+
                "\nHoras activas por semana: "+this.activeHourWeek+
                "\nSalario Mensual:" +this.calculateSalary()+"\n";
    }
}
