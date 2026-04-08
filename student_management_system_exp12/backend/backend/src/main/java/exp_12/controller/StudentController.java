package exp_12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exp_12.model.Student;
import exp_12.service.StudentService;

@RestController
@CrossOrigin(origins = "*")   // better practice
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student s) {
        Student savedStudent = service.saveStudent(s);
        return ResponseEntity.ok(savedStudent);
    }

    // ✅ READ
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student s) {
        Student updatedStudent = service.updateStudent(id, s);
        return ResponseEntity.ok(updatedStudent);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}