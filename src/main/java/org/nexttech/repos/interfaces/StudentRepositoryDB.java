package org.nexttech.repos.interfaces;

import org.nexttech.repos.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryDB extends JpaRepository<Student, Long> {
    Optional<Student> findByCnp(Long cnp);

    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1% OR s.lastName LIKE %?1%")
    List<Student> findAllByFirstNameContainingOrLastNameContaining(String filterText, String filterText1);
}
