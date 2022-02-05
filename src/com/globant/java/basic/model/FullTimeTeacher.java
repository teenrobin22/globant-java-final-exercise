package com.globant.java.basic.model;

public class FullTimeTeacher extends Teacher {
    private int id;
    private static int ultimateId;
    private  int experienceYears;

    public FullTimeTeacher(String name, String lastName,String identificationDocument, int age, int experienceYears, Double baseSalary) {
        super(name, lastName, identificationDocument,age, baseSalary);
        this.id = ++ultimateId;
        this.experienceYears =experienceYears;
    }

    @Override
    public Double calculateSalary() {
        return this.getBaseSalary() * (1.1 * this.experienceYears);
    }

    @Override
    public String printData() {
        return "Nombre: " + this.getName() +
                "\nApellidos: " + this.getLastName() +
                "\nEdad: " + this.getAge() +
                "\nDocumento nacional de identidad: "+this.getIdentificationDocument()+
                "\nModalidad: Full time"+
                "\nSalario Base:"+ this.getBaseSalary()+
                "\nAños de experiencia: "+this.experienceYears+
                "\nSalario Mensual:" +this.calculateSalary()+"\n";
    }

}
