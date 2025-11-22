package com.student.service.service.ImplementationService;

import com.student.service.RequestDto.StudentDto;
import com.student.service.ResponseDto.StudentResponseDto;
import com.student.service.exception.ResourceNotFoundException;
import com.student.service.model.Student;
import com.student.service.repo.StudentRepo;
import com.student.service.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    private StudentResponseDto mapToDto(Student student){
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .courseIds(student.getCourseIds())
                .build();
    }

    private Student mapToEntity(StudentDto dto, Student student){
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        student.setCourseIds(dto.getCourseIds());
        return student;
    }

    @Override
    public StudentResponseDto createStudent(StudentDto dto) {
        Student s = mapToEntity(dto, new Student());
        studentRepo.save(s);
        return mapToDto(s);
    }

    @Override
    public StudentResponseDto updateStudent(long id, StudentDto dto) {
        Student s = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        s = mapToEntity(dto, s);
        studentRepo.save(s);
        return mapToDto(s);
    }

    @Override
    public StudentResponseDto getStudentById(long id) {
        Student s = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return mapToDto(s);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    @Transactional
    public String deleteStudent(long id) {
        Student s = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepo.delete(s);
        return "Student Deleted Successfully";
    }

    @Override
    public List<StudentResponseDto> searchByName(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name).stream().map(this::mapToDto).toList();
    }

    @Override
    public List<StudentResponseDto> searchByEmail(String email) {
        return studentRepo.findByEmailContainingIgnoreCase(email).stream().map(this::mapToDto).toList();
    }

    @Override
    public Page<StudentResponseDto> getStudentPage(int page, int size, String sortBy) {
        PageRequest pr = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Student> pageRes = studentRepo.findAll(pr);
        return pageRes.map(this::mapToDto);
    }
}
