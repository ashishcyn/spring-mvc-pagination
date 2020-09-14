package com.ashi.tech.springmvcpagination.service;

import com.ashi.tech.springmvcpagination.domain.Student;
import com.ashi.tech.springmvcpagination.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Page<Student> findByName(Optional<String> name, Optional<Integer> page, Optional<String> sortBy){
        return studentRepository.findByName(name.orElse("_"),
                PageRequest.of(
                        page.orElse(0), 5,
                        Sort.Direction.ASC, sortBy.orElse("id")));

    }

}
