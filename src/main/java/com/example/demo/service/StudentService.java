package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student createStudent(Student student) {
        // Caller checks uniqueness (controller does)
        return repo.save(student);
    }

    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> getById(Long id) {
        return repo.findById(id);
    }

    public Student updateStudent(Long id, Student updated) {
        return repo.findById(id).map(s -> {
            s.setName(updated.getName());
            s.setAge(updated.getAge());
            s.setEmail(updated.getEmail());
            return repo.save(s);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
