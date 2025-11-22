package com.student.service.controller;

import com.student.service.RequestDto.StudentDto;
import com.student.service.ResponseDto.StudentResponseDto;
import com.student.service.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentDto dto){
        return new ResponseEntity<>(studentService.createStudent(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all/student")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/update/student/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable long id, @Valid @RequestBody StudentDto dto){
        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    @GetMapping("/search/student")
    public ResponseEntity<List<StudentResponseDto>> searchStudent(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        if(name != null && email != null){
            // you can implement combined search if needed
            // for now, return name based search if both provided
            return ResponseEntity.ok(studentService.searchByName(name));
        } else if(name != null){
            return ResponseEntity.ok(studentService.searchByName(name));
        } else if(email != null){
            return ResponseEntity.ok(studentService.searchByEmail(email));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<StudentResponseDto>> searchByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        return ResponseEntity.ok(studentService.getStudentPage(page, size, sortBy));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
}
