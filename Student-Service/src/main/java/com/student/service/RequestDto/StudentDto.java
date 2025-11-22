package com.student.service.RequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @PositiveOrZero(message = "Age cannot be negative")
    private int age;

    @Email(message = "Invalid email")
    private String email;

    private List<Long> courseIds;
}
