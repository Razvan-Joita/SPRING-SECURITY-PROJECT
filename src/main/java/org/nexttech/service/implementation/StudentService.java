package org.nexttech.service.implementation;

import lombok.AllArgsConstructor;
import org.nexttech.dtos.*;
import org.nexttech.exceptions.InvalidNameException;
import org.nexttech.exceptions.StudentNotFoundException;
import org.nexttech.exceptions.StudentNotUniqueCNP;
import org.nexttech.mapping.MapperInterface;
import org.nexttech.repos.entity.Student;
import org.nexttech.repos.interfaces.StudentRepositoryDB;
import org.nexttech.service.interfaces.IService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService implements IService<StudentResponseDTOAdd, StudentResponseDTOUpdate, StudentResponseDTOFind> {

    private final StudentRepositoryDB studentRepository;
    private final MapperInterface mapperInterface;

    @Override
    public StudentResponseDTOAdd add(StudentRequestDTOAdd studentRequestDTOAdd) {
        if (!isValidName(studentRequestDTOAdd.getFirstName()) || !isValidName(studentRequestDTOAdd.getLastName())) {
            throw new InvalidNameException("Invalid first name or last name");
        }


        if (!isUniqueCNP(studentRequestDTOAdd.getCnp())) {
            throw new StudentNotUniqueCNP("This CNP is already assigned to another student!");
        }

        if(!isUniqueCNP(studentRequestDTOAdd.getCnp()))
        {
            throw new StudentNotUniqueCNP("This cnp is already assigned to other person");
        }

        Student student = mapperInterface.DTOToStudent(studentRequestDTOAdd);
        student.setCreatedAt(LocalDate.now());
        Student addedStudent = studentRepository.save(student);

        StudentResponseDTOAdd responseDTOAdd = mapperInterface.studentToDTO(addedStudent);
        responseDTOAdd.setCreatedAt(addedStudent.getCreatedAt());

        return responseDTOAdd;
    }

    @Override
    public Integer remove(int id) {
        studentRepository.findById((long) id)
                .orElseThrow(() -> new StudentNotFoundException("No student with ID " + id + " found"));

        studentRepository.deleteById((long) id);
        return id;
    }

    @Override
    public StudentResponseDTOUpdate update(StudentRequestDTOUpdate requestDTOUpdate) {
       // Student student = mapperInterface.DTOtoStudentUpdate(requestDTOUpdate);


        Student s1 = studentRepository.findById(Long.valueOf(requestDTOUpdate.getId()))
                .orElseThrow(() -> new StudentNotFoundException("No student with ID " + requestDTOUpdate.getId() + " found"));

        s1.setCnp(requestDTOUpdate.getCnp());
        s1.setLastName(requestDTOUpdate.getLastName());
        s1.setFirstName(requestDTOUpdate.getFirstName());
        s1.setUpdatedAt(LocalDate.now());


        Student updatedStudent = studentRepository.save(s1);

        return mapperInterface.studenttoDTOUpdate(updatedStudent);
    }

    @Override
    public StudentResponseDTOFind find(Integer id) {
        Student studentResponseforFind = studentRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new StudentNotFoundException("No student with ID " + id + " found"));

        StudentResponseDTOFind responseDTOFind = mapperInterface.DTOtoStudentResponse(studentResponseforFind);
        responseDTOFind.setCreatedAt(studentResponseforFind.getCreatedAt());

        return responseDTOFind;
    }

    @Override
    public List<StudentResponseDTOFind> filterByFirstNameOrByLastName(String filterText, int page, int pageSize) {
        List<Student> filteredStudents = studentRepository.findAllByFirstNameContainingOrLastNameContaining(filterText, filterText);

        return filteredStudents.stream()
                .map(student -> {
                    StudentResponseDTOFind responseDTO = mapperInterface.DTOtoStudentResponse(student);
                    responseDTO.setCreatedAt(student.getCreatedAt());
                    return responseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTOFind> getAllStudents(int page, int pageSize) {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> {
                    StudentResponseDTOFind responseDTO = mapperInterface.DTOtoStudentResponse(student);
                    responseDTO.setCreatedAt(student.getCreatedAt());
                    return responseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Boolean isUniqueCNP(Long cnp) {
        Optional<Student> existingStudent = studentRepository.findByCnp(cnp);
        return existingStudent.isEmpty();
    }

    @Override
    public Boolean isValidName(String name) {
        return name != null && name.matches("^[^\\d]*$");
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
