package org.nexttech.services.implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.nexttech.dtos.*;
import org.nexttech.exceptions.InvalidNameException;
import org.nexttech.exceptions.StudentNotFoundException;
import org.nexttech.mapping.MapperInterface;
import org.nexttech.repos.entity.Student;
import org.nexttech.repos.interfaces.StudentRepositoryDB;
import org.nexttech.service.implementation.StudentService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepositoryDB studentRepository;
    @Mock
    private MapperInterface mapperInterface;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void testAdd_ValidInput_ReturnsStudentResponseDTOAdd() {
        // Given
        StudentRequestDTOAdd request = new StudentRequestDTOAdd();
        request.setCnp(1234567890L);
        request.setFirstName("Razvan");
        request.setLastName("Joita");

        Student student = new Student();
        student.setCnp(request.getCnp());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());

        StudentResponseDTOAdd expectedResponse = new StudentResponseDTOAdd();
        expectedResponse.setId(1);
        expectedResponse.setCreatedAt(LocalDate.now());


        when(mapperInterface.DTOToStudent(request)).thenReturn(student);
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(mapperInterface.studentToDTO(student)).thenReturn(expectedResponse);

        // When
        StudentResponseDTOAdd actualResponse = studentService.add(request);

        // Then
        assertEquals(expectedResponse, actualResponse);

        // Verify interactions
        verify(studentRepository, times(1)).save(any(Student.class));
        verify(mapperInterface, times(1)).studentToDTO(student);
    }


    @Test
    public void testAdd_InvalidName_ThrowsException() {
        // Given
        StudentRequestDTOAdd request = new StudentRequestDTOAdd();
        request.setCnp(1234567890L);
        request.setFirstName(null);
        request.setLastName("Joita");

        // Mock the repository and mapper
        StudentRepositoryDB studentRepository = mock(StudentRepositoryDB.class);
        MapperInterface mapper = mock(MapperInterface.class);

        // Create the service and inject the mocked repository and mapper
        StudentService studentService = new StudentService(studentRepository, mapper);

        // When and Then
        assertThrows(InvalidNameException.class, () -> studentService.add(request));

        // Verify interactions with the repository
        verify(studentRepository, never()).save(any());
    }


    @Test
    public void testAdd_InvalidFirstName_ThrowsException() {
        StudentRequestDTOAdd request = new StudentRequestDTOAdd();
        request.setCnp(1234567890L);
        request.setFirstName("Razvan");
        request.setLastName(null);

        verifyNoInteractions(studentRepository);
    }

    @Test
    public void testFind_ExistingStudent_ReturnsStudent() {
        //given
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Razvan-Gabriel");
        student.setLastName("Joita");

        when(studentRepository.findById(Long.valueOf(student.getId()))).thenReturn(Optional.of(student));

        StudentResponseDTOFind studentResponseDTO = new StudentResponseDTOFind();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setFirstName(student.getFirstName());
        studentResponseDTO.setLastName(student.getLastName());

        //when
        when(mapperInterface.DTOtoStudentResponse(student)).thenReturn(studentResponseDTO);

        StudentResponseDTOFind foundStudent = studentService.find(student.getId());

        // then
        assertNotNull(foundStudent);
        assertEquals(student.getId(), foundStudent.getId());
        assertEquals(student.getFirstName(), foundStudent.getFirstName());
        assertEquals(student.getLastName(), foundStudent.getLastName());

        verify(studentRepository, times(1)).findById(Long.valueOf(student.getId()));
        verify(mapperInterface, times(1)).DTOtoStudentResponse(student);
        verifyNoMoreInteractions(studentRepository, mapperInterface);
    }

    @Test
    public void testUpdate_NonExistingStudent_ThrowsException() {
        //given
        StudentRequestDTOUpdate request = new StudentRequestDTOUpdate();
        request.setId(1);
        request.setFirstName("Razvan");
        request.setLastName("Joita");

        //when
        when(studentRepository.findById(Long.valueOf(request.getId()))).thenReturn(Optional.empty());

        StudentNotFoundException expectedException = assertThrows(
                StudentNotFoundException.class,
                () -> studentService.update(request)
        );
        //then
        assertThat(expectedException.getMessage()).isEqualTo("No student with ID " + request.getId() + " found");
        verify(studentRepository, times(1)).findById(Long.valueOf(request.getId()));
    }


    @Test
    public void testRemove_NonExistingStudent_ThrowsException() {
        //given
        int nonExistingStudentId = 1;

        //when
        when(studentRepository.findById((long) nonExistingStudentId)).thenReturn(Optional.empty());

        StudentNotFoundException exception = assertThrows(
                StudentNotFoundException.class,
                () -> studentService.remove(nonExistingStudentId)
        );
        //then
        verify(studentRepository, times(1)).findById((long) nonExistingStudentId);
        verifyNoMoreInteractions(studentRepository);
        assertEquals("No student with ID " + nonExistingStudentId + " found", exception.getMessage());
    }

    @Test
    public void testRemove_ExistingStudent_RemovesStudent() {
        //given
        Student student = new Student(4, 5021201324790L, "ionut", "baias", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 10));

        //when
        when(studentRepository.findById(Long.valueOf(student.getId()))).thenReturn(Optional.of(student));

        Integer result = studentService.remove(student.getId());

        //then
        assertEquals(student.getId(), result);
        verify(studentRepository, times(1)).deleteById(Long.valueOf(student.getId()));
        verify(studentRepository, times(1)).findById(Long.valueOf(student.getId()));
        verifyNoMoreInteractions(studentRepository);
    }


    @Test
    public void testFilterByLastName_ReturnsFilteredStudents() {
        // given
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("Razvan");
        student1.setLastName("Joita");
        students.add(student1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("Gabriel");
        student2.setLastName("Joita");
        students.add(student2);

        StudentResponseDTOFind responseDTO1 = new StudentResponseDTOFind();
        responseDTO1.setId(student1.getId());
        responseDTO1.setFirstName(student1.getFirstName());
        responseDTO1.setLastName(student1.getLastName());

        StudentResponseDTOFind responseDTO2 = new StudentResponseDTOFind();
        responseDTO2.setId(student2.getId());
        responseDTO2.setFirstName(student2.getFirstName());
        responseDTO2.setLastName(student2.getLastName());

        // when
        when(studentRepository.findAllByFirstNameContainingOrLastNameContaining("Joita", "Joita"))
                .thenReturn(students);
        when(mapperInterface.DTOtoStudentResponse(student1)).thenReturn(responseDTO1);
        when(mapperInterface.DTOtoStudentResponse(student2)).thenReturn(responseDTO2);

        List<StudentResponseDTOFind> filteredStudents = studentService.filterByFirstNameOrByLastName("Joita", 1, 2);

        // then
        assertNotNull(filteredStudents);
        assertEquals(2, filteredStudents.size());

        for (StudentResponseDTOFind dto : filteredStudents) {
            assertNotNull(dto);

            if (dto.getId() == student1.getId()) {
                assertEquals(responseDTO1.getId(), dto.getId());
                assertEquals(responseDTO1.getFirstName(), dto.getFirstName());
                assertEquals(responseDTO1.getLastName(), dto.getLastName());
            } else if (dto.getId() == student2.getId()) {
                assertEquals(responseDTO2.getId(), dto.getId());
                assertEquals(responseDTO2.getFirstName(), dto.getFirstName());
                assertEquals(responseDTO2.getLastName(), dto.getLastName());
            }
        }
        verify(studentRepository, times(1)).findAllByFirstNameContainingOrLastNameContaining("Joita", "Joita");
        verify(mapperInterface, times(1)).DTOtoStudentResponse(student1);
        verify(mapperInterface, times(1)).DTOtoStudentResponse(student2);
    }

    @Test
    public void testFilterByFirstName_ReturnsFilteredStudents() {
        // given
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("Razvan");
        student1.setLastName("Joita");
        students.add(student1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("Gabriel");
        student2.setLastName("Joita");
        students.add(student2);

        StudentResponseDTOFind responseDTO1 = new StudentResponseDTOFind();
        responseDTO1.setId(student1.getId());
        responseDTO1.setFirstName(student1.getFirstName());
        responseDTO1.setLastName(student1.getLastName());

        StudentResponseDTOFind responseDTO2 = new StudentResponseDTOFind();
        responseDTO2.setId(student2.getId());
        responseDTO2.setFirstName(student2.getFirstName());
        responseDTO2.setLastName(student2.getLastName());

        // when
        when(studentRepository.findAllByFirstNameContainingOrLastNameContaining("Razvan", "Razvan"))
                .thenReturn(students);
        when(mapperInterface.DTOtoStudentResponse(student1)).thenReturn(responseDTO1);
        when(mapperInterface.DTOtoStudentResponse(student2)).thenReturn(responseDTO2);

        List<StudentResponseDTOFind> filteredStudents = studentService.filterByFirstNameOrByLastName("Razvan", 1, 2);

        // then
        assertNotNull(filteredStudents);
        assertEquals(2, filteredStudents.size());

        for (StudentResponseDTOFind dto : filteredStudents) {
            assertNotNull(dto);

            if (dto.getId() == student1.getId()) {
                assertEquals(responseDTO1.getId(), dto.getId());
                assertEquals(responseDTO1.getFirstName(), dto.getFirstName());
                assertEquals(responseDTO1.getLastName(), dto.getLastName());
            } else if (dto.getId() == student2.getId()) {
                assertEquals(responseDTO2.getId(), dto.getId());
                assertEquals(responseDTO2.getFirstName(), dto.getFirstName());
                assertEquals(responseDTO2.getLastName(), dto.getLastName());
            }
        }
        verify(studentRepository, times(1)).findAllByFirstNameContainingOrLastNameContaining("Razvan", "Razvan");
        verify(mapperInterface, times(1)).DTOtoStudentResponse(student1);
        verify(mapperInterface, times(1)).DTOtoStudentResponse(student2);
    }

    @Test
    public void testUpdate_ValidStudent_ReturnsUpdatedStudent() {
        // Given
        StudentRequestDTOUpdate request = new StudentRequestDTOUpdate();
        request.setId(1);
        request.setCnp(1234567890L);
        request.setFirstName("John");
        request.setLastName("Doe");

        // Mock the repository and mapper
        StudentRepositoryDB studentRepository = mock(StudentRepositoryDB.class);
        MapperInterface mapper = mock(MapperInterface.class);

        // Create the service and inject the mocked repository and mapper
        StudentService studentService = new StudentService(studentRepository, mapper);

        // Mock the behavior of the repository
        Student existingStudent = new Student();
        existingStudent.setId(1);
        existingStudent.setCnp(9876543210L);
        existingStudent.setFirstName("Alice");
        existingStudent.setLastName("Smith");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(existingStudent));

        Student updatedStudent = new Student();

        when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);

        // Mock the mapper
        StudentResponseDTOUpdate responseDTO = new StudentResponseDTOUpdate();

        when(mapper.studenttoDTOUpdate(updatedStudent)).thenReturn(responseDTO);

        // When
        StudentResponseDTOUpdate result = studentService.update(request);

        // Then
        assertEquals(responseDTO, result);
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).save(any(Student.class));
        verify(mapper, times(1)).studenttoDTOUpdate(updatedStudent);
    }


}