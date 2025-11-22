package com.student.service.service;

import com.student.service.RequestDto.StudentDto;
import com.student.service.ResponseDto.StudentResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    StudentResponseDto createStudent(StudentDto dto);
    StudentResponseDto updateStudent(long id, StudentDto dto);
    StudentResponseDto getStudentById(long id);
    List<StudentResponseDto> getAllStudents();
    String deleteStudent(long id);
    List<StudentResponseDto> searchByName(String name);
    List<StudentResponseDto> searchByEmail(String email);
    Page<StudentResponseDto> getStudentPage(int page, int size, String sortBy);
}
