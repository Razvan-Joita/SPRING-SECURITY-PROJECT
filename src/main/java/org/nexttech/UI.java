//package org.nexttech;
//
//import lombok.AllArgsConstructor;
//import org.nexttech.controller.StudentController;
//import org.nexttech.dtos.*;
//import org.nexttech.exceptions.StudentNotDeletedException;
//import org.nexttech.validators.implementation.CNPValidator;
//import org.nexttech.validators.implementation.NameValidator;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//import java.util.Scanner;
//
////@Component
//@AllArgsConstructor
//public class UI {
//
//    private final StudentController studentController;
//    private final Scanner scanner;
//
//    public UI(StudentController studentController) {
//        this.studentController = studentController;
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void run() {
//        boolean running = true;
//        while (running) {
//            displayMenu();
//            int choice = getUserChoice();
//            switch (choice) {
//                case 1:
//                    addStudent();
//                    break;
//                case 2:
//                    removeStudent();
//                    break;
//                case 3:
//                    updateStudent();
//                    break;
//                case 4:
//                    findStudent();
//                    break;
//                case 5:
//                    filterStudentsByName();
//                    break;
//                case 6:
//                    getAllStudents();
//                    break;
//                case 0:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//            }
//        }
//    }
//
//    private void displayMenu() {
//        System.out.println("1. a – add new student");
//        System.out.println("2. d - delete student information");
//        System.out.println("3. u- update student information");
//        System.out.println("4. r – read student information");
//        System.out.println("5. f – filter students");
//        System.out.println("6. get all students");
//        System.out.println("0. Exit");
//    }
//
//    private int getUserChoice() {
//        System.out.print("Enter your choice: ");
//        return scanner.nextInt();
//    }
//
//    private void addStudent() {
//        System.out.print("Enter CNP: ");
//        Long cnp = scanner.nextLong();
//        scanner.nextLine();
//        if (!CNPValidator.isValidCNP(cnp.toString())) {
//            System.out.println("Invalid CNP format. Please try again.");
//            return;
//        }
//        System.out.print("Enter first name: ");
//        String firstName = scanner.nextLine();
//        if (!NameValidator.isValidName(firstName)) {
//            System.out.println("Invalid first name format. Please try again.");
//            return;
//        }
//        System.out.print("Enter last name: ");
//        String lastName = scanner.nextLine();
//        if (!NameValidator.isValidName(lastName)) {
//            System.out.println("Invalid last name format. Please try again.");
//            return;
//        }
//
//        StudentRequestDTOAdd student = new StudentRequestDTOAdd();
//        student.setCnp(cnp);
//        student.setFirstName(firstName);
//        student.setLastName(lastName);
//
//        StudentResponseDTOAdd studentResponseDTOAdd = studentController.addStudent(student);
//        System.out.println(studentResponseDTOAdd);
//    }
//
//    private void removeStudent() {
//        System.out.print("Enter student ID to remove: ");
//        int id = scanner.nextInt();
//        Integer result = studentController.removeStudent(id);
//        if (result == null) {
//            throw new StudentNotDeletedException("Student does not exist");
//        } else {
//            System.out.println("Student " + result + " removed successfully");
//        }
//    }
//
//    private void updateStudent() {
//        System.out.print("Enter student ID to update: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Enter new CNP: ");
//        Long cnp = scanner.nextLong();
//        scanner.nextLine();
//        System.out.print("Enter new first name: ");
//        String firstName = scanner.nextLine();
//        System.out.print("Enter new last name: ");
//        String lastName = scanner.nextLine();
//
//        StudentRequestDTOUpdate updatedStudent = new StudentRequestDTOUpdate();
//        updatedStudent.setId(id);
//        updatedStudent.setCnp(cnp);
//        updatedStudent.setFirstName(firstName);
//        updatedStudent.setLastName(lastName);
//
////        StudentResponseDTOUpdate dtoResponse = studentController.updateStudent(updatedStudent).getBody();
////        System.out.println(dtoResponse);
//        System.out.println("Student updated successfully.");
//    }
//
//    private void findStudent() {
//        System.out.print("Enter student ID to find: ");
//        int id = scanner.nextInt();
//        StudentResponseDTOFind foundStudent = studentController.findStudent(id);
//        if (foundStudent != null) {
//            System.out.println("Found student: " + foundStudent);
//        } else {
//            System.out.println("Student not found");
//        }
//    }
//
//    private void filterStudentsByName() {
//        System.out.print("Enter text to filter students by first name or last name: ");
//        String filterText = scanner.next();
//        List<StudentResponseDTOFind> filteredStudents = studentController.filterStudentsByName(filterText);
//        System.out.println("Filtered Students:");
//        for (StudentResponseDTOFind student : filteredStudents) {
//            System.out.println(student);
//        }
//    }
//    private void getAllStudents() {
//        ResponseEntity<List<StudentResponseDTOFind>> response = studentController.getAllStudents();
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            List<StudentResponseDTOFind> allStudents = response.getBody();
//            System.out.println("All Students:");
//            for (StudentResponseDTOFind student : allStudents) {
//                System.out.println(student);
//            }
//        } else {
//            System.out.println("Failed to retrieve students: " + response.getStatusCode());
//        }
//    }
//
//
//}
//
