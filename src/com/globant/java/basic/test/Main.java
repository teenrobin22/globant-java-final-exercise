package com.globant.java.basic.test;

import com.globant.java.basic.model.*;
import com.globant.java.basic.util.ResponseMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University("Universidad Nacional del Callao", "UNAC");
        loadData(university);
        boolean keepLoop = true;
        while (keepLoop) {
            printMenu(university);
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                printDataTeachers(university.getTeachers());
            } else if (option == 2) {
                printDataCourses(university);
            } else if (option == 3) {
                createStudent(university);
            } else if (option == 4) {
                createCourse(university);
            } else if (option == 5) {
                findCoursesByStudent(university);
            } else if (option == 6) {
                keepLoop = false;
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
            if (keepLoop) {
                keepLoop = continueProcess("Desea relizar otra operación: Si(1) / No(2)");
            }
        }
    }

    public static void printMenu(University university) {
        System.out.println(university.getName() + " - " + university.getInitials());
        System.out.println("+++++++++++++++++Menú++++++++++++++++++");
        System.out.println("1.- Imprimir Profesores");
        System.out.println("2.- Imprimir Clases");
        System.out.println("3.- Crear nuevo estudiante");
        System.out.println("4.- Crear nuevo curso");
        System.out.println("5.- Listar cursos por estudiante");
        System.out.println("6.- Salir");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("-->Ingrese opción:");
    }

    public static void loadData(University university) {
        university.addTeacher(new FullTimeTeacher("Martin", "Carrillo Durand", "43408900", 35, 5, 1500.00));
        university.addTeacher(new FullTimeTeacher("Rusbelth", "Espinoza Castro", "04145586", 35, 6, 1000.00));
        university.addTeacher(new PartTimeTeacher("Oscar", "Benitez Bartra", "03453456", 35, 6, 1000.00));
        university.addTeacher(new PartTimeTeacher("Osvaldo", "Ramirez Rivera", "43407688", 35, 7, 1000.00));

        university.addStudent(new Student("Karina", "Espetia Aguirre", "06141879", 23));
        university.addStudent(new Student("Fiorella", "Mariñas Mosquera", "06783452", 22));
        university.addStudent(new Student("Victor Hugo", "Juarez Arboleda", "58698722", 20));
        university.addStudent(new Student("Gerardo", "Castillo Espinoza", "", 22));
        university.addStudent(new Student("Omar", "Collazos Nizama", "33454378", 24));
        university.addStudent(new Student("Yanira", "Mendoza Guerra", "33322245", 19));

        university.addClassRoom(new ClassRoom("A101", 30, "Primer piso"));
        university.addClassRoom(new ClassRoom("A102", 40, "Primer piso"));
        university.addClassRoom(new ClassRoom("B101", 30, "Segundo piso"));
        university.addClassRoom(new ClassRoom("B102", 20, "Segundo piso"));
        university.addClassRoom(new ClassRoom("C101", 30, "Tercer piso"));

        university.addCourse(new Course("Matemática 3", university.getTeachers().get(0), university.getClassRooms().get(0)));
        university.addCourse(new Course("Economía", university.getTeachers().get(1), university.getClassRooms().get(1)));
        university.addCourse(new Course("Teoría General de Sistemas", university.getTeachers().get(2), university.getClassRooms().get(2)));
        university.addCourse(new Course("Sistemas Distribuidos", university.getTeachers().get(3), university.getClassRooms().get(3)));
        university.getCourses().get(0).addStudentToCourse(university.getStudents().get(0));
        university.getCourses().get(0).addStudentToCourse(university.getStudents().get(1));
        university.getCourses().get(1).addStudentToCourse(university.getStudents().get(2));
        university.getCourses().get(1).addStudentToCourse(university.getStudents().get(3));
        university.getCourses().get(2).addStudentToCourse(university.getStudents().get(4));
        university.getCourses().get(2).addStudentToCourse(university.getStudents().get(5));
        university.getCourses().get(3).addStudentToCourse(university.getStudents().get(0));
        university.getCourses().get(3).addStudentToCourse(university.getStudents().get(3));
    }

    public static void printDataTeachers(List<Teacher> teacherList) {
        System.out.println("****************Listado de Profesores****************");
        teacherList.forEach(x -> System.out.println(x.printData()));
    }

    public static void printDataCourses(University university) {
        boolean keepLoop = true;
        while (keepLoop) {
            System.out.println("*************Listado de Clases******************");
            printCourses(university.getCourses());
            System.out.println("************************************************");
            System.out.println("-->Ingrese número de clase para ver su detalle: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            Course course = university.findCourseById(option);
            if (course != null) {
                System.out.println(course.printData());
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
            keepLoop = continueProcess("-->Desea volvera a listar las clases: Si (1) No (2)");
        }
    }

    public static void createStudent(University university) {
        boolean keepLoop = true;
        while (keepLoop) {
            Scanner sc = new Scanner(System.in);
            System.out.println("**********Nuevo Registro de Estudiante***********");
            System.out.println("--------------I.- Datos Personales---------------");
            System.out.println("-->Ingrese documento nacional de identidad:");
            String document = sc.next();
            Student foundStudent = university.findStudentByIdentificationDocument(document);
            if (foundStudent == null) {
                sc.nextLine();
                System.out.println("-->Ingrese nombre:");
                String name = sc.nextLine();
                System.out.println("-->Ingrese apellidos");
                String lastName = sc.nextLine();
                System.out.println("-->Ingrese edad");
                int age = sc.nextInt();
                System.out.println("----------II.- Clases Disponibles---------");
                printCourses(university.getCourses());
                boolean keepLoopCourse = true;
                while (keepLoopCourse) {
                    System.out.println("-->Ingrese número de clase a matricular");
                    int option = sc.nextInt();
                    Course course = university.findCourseById(option);
                    if (course != null) {
                        Student newStudent = new Student(name, lastName, document, age);
                        university.addStudent(newStudent);
                        course.addStudentToCourse(newStudent);
                        System.out.println(ResponseMessage.SUCCESSFULL_PROCESS);
                        keepLoopCourse = false;
                    } else {
                        System.out.println(ResponseMessage.INCORRECT_OPTION);
                    }
                }
            } else {
                System.out.println("El estudiante ya se encuentra registrado!!");
            }
            keepLoop = continueProcess("-->Desea registrar otro estudiante: Si (1) No (2)");
        }
    }

    public static void createCourse(University university) {
        Scanner sc = new Scanner(System.in);
        Course newCourse = new Course();
        System.out.println("***********Nuevo Registro de Curso**************");
        System.out.println("-->Ingrese nombre de curso");
        newCourse.setName(sc.nextLine());
        boolean keepLoopClassRoom = true;
        System.out.println("-------------Asignación de Aula-------------");
        printClassRooms(university.getClassRooms());
        while (keepLoopClassRoom) {
            System.out.println("-->Ingrese número de aula a asignar:");
            ClassRoom foundClassRoom = university.findClassRoomById(sc.nextInt());
            if (foundClassRoom != null) {
                newCourse.setClassRoom(foundClassRoom);
                keepLoopClassRoom = false;
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
        }
        boolean keepLoopTeacher = true;
        System.out.println("--------Asignación de Profesor--------");
        printTeachers(university.getTeachers());
        while (keepLoopTeacher) {
            System.out.println("-->Ingrese número de profesor a asignar:");
            Teacher foundTeacher = university.findTeacherById(sc.nextInt());
            if (foundTeacher != null) {
                newCourse.setTeacher(foundTeacher);
                keepLoopTeacher = false;
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
        }
        boolean keepLoopStudent = true;
        List<Student> temporalList = new ArrayList<>();
        temporalList.addAll(university.getStudents());
        while (keepLoopStudent) {
            System.out.println("----------Estudiantes disponibles------");
            printStudents(temporalList);
            System.out.println("-->Ingrese número de studiante a registrar en el curso:");
            Student foundStudent = university.findStudentById(sc.nextInt());
            if (foundStudent != null) {
                newCourse.addStudentToCourse(foundStudent);
                temporalList.remove(foundStudent);
                if (temporalList.size() > 0) {
                    keepLoopStudent = continueProcess("Desea registrar otro estudiante? Si(1) / No(2)");
                    if (!keepLoopStudent) {
                        university.addCourse(newCourse);
                    }
                } else {
                    keepLoopStudent = false;
                }
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
        }
    }

    public static void findCoursesByStudent(University university) {
        boolean keepLoopStudent = true;
        while (keepLoopStudent) {
            System.out.println("********Listado de Estudiantes********");
            printStudents(university.getStudents());
            System.out.println("-->Ingrese código de estudiante:");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            Student foundStudent = university.findStudentById(option);
            if (foundStudent != null) {
                List<Course> foundCourses = new ArrayList<>();
                for (Course course : university.getCourses()) {
                    for (Student student : course.getStudents()) {
                        if (student.getId() == option) {
                            foundCourses.add(course);
                        }
                    }
                }
                if (foundCourses.size() > 0) {
                    System.out.println("El estudiante se encuentra matriculado en los siguientes cursos:");
                    printCourses(foundCourses);
                } else {
                    System.out.println("El alumno no se encuentra matriculado en ningún curso.");
                }
                keepLoopStudent = continueProcess("Desea realizar otra búsqueda? Si(1) / No(2)");
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
        }
    }

    public static boolean continueProcess(String message) {
        boolean response = true;
        boolean keepLoop = true;
        while (keepLoop) {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                keepLoop = false;
            } else if (option == 2) {
                response = false;
                keepLoop = false;
            } else {
                System.out.println(ResponseMessage.INCORRECT_OPTION);
            }
        }
        return response;
    }

    public static void printTeachers(List<Teacher> teacherList) {
        teacherList.forEach(x -> System.out.println(x.getId() + ".- " + x.getName() + " " + x.getLastName()));
    }

    public static void printCourses(List<Course> courseList) {
        courseList.forEach(x -> System.out.println(x.getId() + ".-" + x.getName()));
    }

    public static void printClassRooms(List<ClassRoom> clasRoomList) {
        clasRoomList.forEach(x -> System.out.println(x.getId() + ".- " + x.getName()));
    }

    public static void printStudents(List<Student> studentList) {
        studentList.forEach(x -> System.out.println(x.getId() + ".- " + x.getName() + " " + x.getLastName()));
    }
}

