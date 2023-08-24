package org.nexttech.service.interfaces;

import org.nexttech.dtos.StudentRequestDTOAdd;
import org.nexttech.dtos.StudentRequestDTOUpdate;
import org.nexttech.dtos.StudentResponseDTOFind;
import org.nexttech.dtos.StudentResponseDTOAdd;
import org.nexttech.dtos.StudentResponseDTOUpdate;
import org.nexttech.repos.entity.Student;

import java.util.List;

public interface IService<T, U, V> {

    T add(StudentRequestDTOAdd studentRequestDTOAdd);

    U update(StudentRequestDTOUpdate requestDTOUpdate);

    Integer remove(int id);

    V find(Integer id);

    List<V> filterByFirstNameOrByLastName(String filterText, int page, int pageSize);

    List<V> getAllStudents(int page, int pageSize);

    Boolean isUniqueCNP(Long cnp);

    Boolean isValidName(String name);

    List<Student> getAllStudents();
}
