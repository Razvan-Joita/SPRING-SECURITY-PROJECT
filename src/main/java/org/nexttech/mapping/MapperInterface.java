package org.nexttech.mapping;

import org.mapstruct.Mapper;
import org.nexttech.dtos.*;
import org.nexttech.repos.entity.Student;

import java.util.List;
import java.util.Optional;

/**
 * A mapping interface using MapStruct to convert between DTOs and entity objects.
 */
@Mapper(componentModel = "spring")
public interface MapperInterface {

    StudentResponseDTOAdd studentToDTO(Student entity);

    Student DTOToStudent(StudentRequestDTOAdd dto);

    StudentResponseDTOFind DTOtoStudentResponse(Student entity);

    StudentResponseDTOFind DTOtoStudentResponse(Optional<Student> entity);

    Student DTOtoStudentUpdate(StudentRequestDTOUpdate dto);

    StudentResponseDTOUpdate studenttoDTOUpdate(Student entity);

    StudentResponseDTOUpdate studenttoDTOUpdate(Optional<Student> entity);

    List<StudentResponseDTOFind> listConverting(List<Student> students);

}
