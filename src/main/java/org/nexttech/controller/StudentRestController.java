package org.nexttech.controller;

import jakarta.validation.Valid;
import org.nexttech.dtos.StudentRequestDTOAdd;
import org.nexttech.dtos.StudentRequestDTOUpdate;
import org.nexttech.dtos.StudentResponseDTOAdd;
import org.nexttech.dtos.StudentResponseDTOFind;
import org.nexttech.dtos.StudentResponseDTOUpdate;
import org.nexttech.service.interfaces.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/students")
@Validated
public class StudentRestController {

    private final IService<StudentResponseDTOAdd, StudentResponseDTOUpdate, StudentResponseDTOFind> studentService;

    public StudentRestController(IService<StudentResponseDTOAdd, StudentResponseDTOUpdate, StudentResponseDTOFind> studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<StudentResponseDTOAdd> addStudent(@Valid @RequestBody StudentRequestDTOAdd studentRequestDTOAdd) {
        StudentResponseDTOAdd addedStudent = studentService.add(studentRequestDTOAdd);
        return ResponseEntity.ok(addedStudent);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Integer> removeStudent(@PathVariable Integer id) {
        Integer deletedId = studentService.remove(id);
        return ResponseEntity.ok(deletedId);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponseDTOFind> findStudent(@PathVariable Integer id) {
        StudentResponseDTOFind student = studentService.find(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("")
    public ResponseEntity<StudentResponseDTOUpdate> updateStudent(@Valid @RequestBody StudentRequestDTOUpdate requestDTOUpdate) {
        StudentResponseDTOUpdate updatedStudent = studentService.update(requestDTOUpdate);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/filter/{filterText}/{page}/{pageSize}")
    public ResponseEntity<List<StudentResponseDTOFind>> filterStudents(
            @PathVariable String filterText,
            @PathVariable int page,
            @PathVariable int pageSize) {
        List<StudentResponseDTOFind> students = studentService.filterByFirstNameOrByLastName(filterText, page, pageSize);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/all/{page}/{pageSize}")
    public ResponseEntity<List<StudentResponseDTOFind>> getAllStudents(
            @PathVariable int page,
            @PathVariable int pageSize) {
        List<StudentResponseDTOFind> students = studentService.getAllStudents(page, pageSize);
        return ResponseEntity.ok(students);
    }
}
