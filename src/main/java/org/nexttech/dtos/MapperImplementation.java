//package org.nexttech.dtos;
//
//
//import org.nexttech.mapping.MapperInterface;
//import org.nexttech.repos.entity.Student;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
////@Component
//
//public class MapperImplementation implements MapperInterface {
//    @Override
//    public StudentResponseDTOAdd studentToDTO(Student entity) {
//        if ( entity == null ) {
//            return null;
//        }
//
//        StudentResponseDTOAdd studentResponseDTOAdd = new StudentResponseDTOAdd();
//
//        studentResponseDTOAdd.setId( entity.getId() );
//
//        studentResponseDTOAdd.setCreatedAt( entity.getCreatedAt() );
//
//        return studentResponseDTOAdd;
//    }
//
//
//
//    @Override
//    public Student DTOToStudent(StudentRequestDTOAdd dto) {
//        if ( dto == null ) {
//            return null;
//        }
//
//        Student student = new Student();
//
//        student.setCnp( dto.getCnp() );
//        student.setFirstName( dto.getFirstName() );
//        student.setLastName( dto.getLastName() );
//
//        return student;
//    }
//
//    @Override
//    public StudentResponseDTOFind DTOtoStudentResponse(Student entity) {
//        if ( entity == null ) {
//            return null;
//        }
//
//        StudentResponseDTOFind studentResponseDTOFind = new StudentResponseDTOFind();
//
//        studentResponseDTOFind.setId( entity.getId() );
//        studentResponseDTOFind.setCnp( entity.getCnp());
//        studentResponseDTOFind.setFirstName( entity.getFirstName() );
//        studentResponseDTOFind.setLastName( entity.getLastName() );
//        studentResponseDTOFind.setCreatedAt( entity.getCreatedAt());
//        studentResponseDTOFind.setUpdateAt( entity.getUpdatedAt() );
//
//
//        return studentResponseDTOFind;
//    }
//
//    @Override
//    public Student DTOtoStudentUpdate(StudentRequestDTOUpdate dto) {
//        if ( dto == null ) {
//            return null;
//        }
//
//        Student student = new Student();
//
//        student.setId(dto.getId());
//        student.setCnp(dto.getCnp());
//        student.setFirstName(dto.getFirstName());
//        student.setLastName(dto.getLastName());
//        return student;
//
//    }
//
//    @Override
//    public StudentResponseDTOUpdate studenttoDTOUpdate(Student entity) {
//        if ( entity == null ) {
//            return null;
//        }
//        StudentResponseDTOUpdate dto = new StudentResponseDTOUpdate();
//
//        dto.setId(entity.getId());
//        dto.setCnp(entity.getCnp());
//        dto.setFirstName(entity.getFirstName());
//        dto.setLastName(entity.getLastName());
//        dto.setUpdateAt(entity.getUpdatedAt());
//
//        return dto;
//
//    }
//
//    @Override
//    public List<StudentResponseDTOFind> listConverting(List<Student> students) {
//
//        List<StudentResponseDTOFind> studentResponseDTOFinds = new ArrayList<>();
//
//        for(Student student:students)
//        {
//            StudentResponseDTOFind studentResponseDTOFind = new StudentResponseDTOFind();
//            studentResponseDTOFind.setId(student.getId());
//            studentResponseDTOFind.setCnp(student.getCnp());
//            studentResponseDTOFind.setFirstName(student.getFirstName());
//            studentResponseDTOFind.setLastName(student.getLastName());
//            studentResponseDTOFind.setCreatedAt(student.getCreatedAt());
//            studentResponseDTOFind.setUpdateAt(student.getUpdatedAt());
//
//            studentResponseDTOFinds.add(studentResponseDTOFind);
//
//
//        }
//        return studentResponseDTOFinds;
//    }
//}