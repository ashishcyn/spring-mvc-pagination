# spring-mvc-pagination



**Step1:**   
[Set up a spring boot, H2 project](https://github.com/ashishcyn/spring-boot-persistence-h2). Include lombok dependency as well

```xml
<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <optional>true</optional>
</dependency>
```

**Step2:**
- Enable the H2 in the application.properties file
- Prepare data.sql with student records for seeding the h2 DB 

**Step3:**
- Student Entity

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String course;
    private int admissionYear;
}
```

- Repository

```java
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where name like %?1%")
    Page<Student> findByName(String name, Pageable pageable);

}
```

- Service

```java
@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Page<Student> findByName(
            Optional<String> name,
            Optional<Integer> page,
            Optional<String> sortBy) {
        return studentRepository.findByName(name.orElse("_"),
                PageRequest.of(
                        page.orElse(0), 5,
                        Sort.Direction.ASC, sortBy.orElse("id")));

    }

}
```

- Controller

```java
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
```

**Step4:** 
Run the spring boot application and verify the output  
[http://localhost:8080/students?name=john](http://localhost:8080/students?name=john)   
[http://localhost:8080/students?page=0](http://localhost:8080/students?page=0)   
[http://localhost:8080/students?page=0&sortBy=name](http://localhost:8080/students?page=0&sortBy=name)   





**Happy Coding**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[dill]: <https://github.com/joemccann/dillinger>
[Reference]:<https://www.youtube.com/watch?v=i0Cto2IWybo>

 

