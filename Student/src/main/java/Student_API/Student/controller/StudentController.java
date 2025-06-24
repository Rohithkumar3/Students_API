package Student_API.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Student_API.Student.model.Student;
import Student_API.Student.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) 
    {
        return new ResponseEntity<>(service.save(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) 
    {
        return service.getById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
