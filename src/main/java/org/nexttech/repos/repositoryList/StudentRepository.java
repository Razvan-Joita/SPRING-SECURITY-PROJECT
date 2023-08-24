//package org.nexttech.repos.repositoryList;
//
//import org.nexttech.repos.entity.Student;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//
//@Repository
//public class StudentRepository implements IStudentRepository {
//    private final List<Student> students = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(0);
//
//    @Override
//    public Student add(Student entity) {
//        boolean isCnpUnique = isUniqueCNP(entity.getCnp());
//
//        if (isCnpUnique) {
//            int generatedId = idCounter.incrementAndGet();
//            entity.setId(generatedId);
//            entity.setCreatedAt(LocalDate.now());
//            students.add(entity);
//            return entity;
//        }
//        return null;
//    }
//
//    @Override
//    public Integer remove(Integer id) {
//        Student studentToRemove = students.stream()
//                .filter(student -> student.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//
//        if (studentToRemove != null) {
//            students.remove(studentToRemove);
//            return studentToRemove.getId();
//        }
//        return null;
//    }
//
//    @Override
//    public Student update(Student newEntity) {
//        Student existingStudent = students.stream()
//                .filter(student -> Objects.equals(student.getId(), newEntity.getId()))
//                .findFirst()
//                .orElse(null);
//
//        if (existingStudent != null && isUniqueCNP(newEntity.getCnp())) {
//            existingStudent.setCnp(newEntity.getCnp());
//            existingStudent.setFirstName(newEntity.getFirstName());
//            existingStudent.setLastName(newEntity.getLastName());
//            existingStudent.setUpdatedAt(LocalDate.now());
//            return existingStudent;
//        }
//        return null;
//    }
//
//    @Override
//    public Student find(Integer id) {
//        return students.stream()
//                .filter(student -> student.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public List<Student> filterByFirstNameOrByLastName(String filterText, int page, int pageSize) {
//        List<Student> filteredStudents = students.stream()
//                .filter(student -> student.getFirstName().toLowerCase().contains(filterText.toLowerCase()) ||
//                        student.getLastName().toLowerCase().contains(filterText.toLowerCase()))
//                .collect(Collectors.toList());
//
//        int start = (page - 1) * pageSize;
//        int end = Math.min(start + pageSize, filteredStudents.size());
//
//        return filteredStudents.subList(start, end);
//    }
//
//    @Override
//    public Boolean isUniqueCNP(Long cnp) {
//        return students.stream().noneMatch(student -> student.getCnp().equals(cnp));
//    }
//
//    @Override
//    public List<Student> getAllStudents(int page, int pageSize) {
//        int start = (page - 1) * pageSize;
//        int end = Math.min(start + pageSize, students.size());
//
//        return students.subList(start, end);
//    }
//}
