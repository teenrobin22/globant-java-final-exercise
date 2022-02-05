package com.globant.java.basic.model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int id;
    private static int ultimateId;
    private String name;
    private String initials;
    private List<Course> courses;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<ClassRoom> classRooms;

    public University(String name,String initials) {
        this.id = ++ultimateId;
        this.name = name;
        this.initials = initials;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.classRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addClassRoom(ClassRoom classRoom) {
        this.classRooms.add(classRoom);
    }

    public Teacher findTeacherById(int id){
        Teacher foundTeacher = null;
        for (Teacher teacher : this.teachers) {
            if (teacher.getId() == id) {
                foundTeacher = teacher;
            }
        }
        return foundTeacher;
    }

    public Course findCourseById(int id) {
        Course foundCourse = null;
        for (Course course : this.courses) {
            if (course.getId() == id) {
                foundCourse = course;
            }
        }
        return foundCourse;
    }

    public ClassRoom findClassRoomById(int id) {
        ClassRoom foundClassRoom = null;
        for (ClassRoom classRoom : this.classRooms) {
            if (classRoom.getId() == id) {
                foundClassRoom = classRoom;
            }
        }
        return foundClassRoom;
    }

    public Student findStudentByIdentificationDocument(String document) {
        Student foundStudent = null;
        for (Student student : this.students) {
            if (student.getIdentificationDocument().equals(document)) {
                foundStudent = student;
            }
        }
        return foundStudent;
    }

    public Student findStudentById(int id) {
        Student foundStudent = null;
        for (Student student : this.students) {
            if (student.getId() == id) {
                foundStudent = student;
            }
        }
        return foundStudent;
    }
}
