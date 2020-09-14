package com.ashi.tech.springmvcpagination.web.rest;

import com.ashi.tech.springmvcpagination.domain.Student;
import com.ashi.tech.springmvcpagination.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/students")
    public Page<Student> findByName(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy)
    {
        return studentService.findByName(name,page,sortBy);
    }
}
