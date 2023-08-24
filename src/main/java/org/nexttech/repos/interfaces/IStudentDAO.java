//package org.nexttech.repos.interfaces;
//
//import org.nexttech.repos.entity.Student;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface IStudentDAO extends JpaRepository<Student, Integer> {
//    boolean isUniqueCNP(Long cnp);
//    @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) LIKE %:filterText% OR LOWER(s.lastName) LIKE %:filterText%")
//
//    Page<Student> filterByFirstNameOrByLastName(String filterText, Pageable pageable);
//}
