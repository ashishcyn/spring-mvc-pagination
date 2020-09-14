package com.ashi.tech.springmvcpagination.repository;

import com.ashi.tech.springmvcpagination.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where name like %?1%")
    Page<Student> findByName(String name, Pageable pageable);

}
