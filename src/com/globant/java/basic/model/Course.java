package com.globant.java.basic.model;

import com.globant.java.basic.service.IPrint;

import java.util.ArrayList;
import java.util.List;

public class Course implements IPrint {
    private int id;
    private static int ultimateId;
    private String name;
    private Teacher teacher;
    private List<Student> students;
    private ClassRoom classRoom;

    public Course() {
        this.id = ++this.ultimateId;
        this.students = new ArrayList<>();
    }

    public Course(String name, Teacher teacher, ClassRoom classRoom) {
        this.name = name;
        this.teacher = teacher;
        this.classRoom = classRoom;
        this.id = ++this.ultimateId;
        this.students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudentToCourse(Student student) {
        this.students.add(student);
    }

    @Override
    public String printData() {
        String studentList = "";
        for (Student student: this.students){
            studentList = studentList+"-"+student.printData()+"\n";
        }
        return "Curso:" + this.name + "\n" +
                this.classRoom.printData() + "\n" +
                "Profesor: " + this.teacher.getName() + " " + this.teacher.getLastName() +
                "\nEstudiantes:\n"+studentList;
    }
}
