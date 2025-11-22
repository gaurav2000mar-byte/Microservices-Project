package com.student.service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @PositiveOrZero(message = "Age cannot be negative")
    private int age;

    @Email(message = "Invalid email")
    private String email;

    @ElementCollection
    @CollectionTable(name = "student_course_ids", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "course_id")
    private List<Long> courseIds;
}
