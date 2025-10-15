package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Course createCourse(Course c) { return repo.save(c); }
    public List<Course> getAll() { return repo.findAll(); }
    public Optional<Course> getById(Long id) { return repo.findById(id); }
    public Course updateCourse(Long id, Course updated) {
        return repo.findById(id).map(c -> {
            c.setTitle(updated.getTitle());
            c.setCredits(updated.getCredits());
            return repo.save(c);
        }).orElseThrow(() -> new RuntimeException("Course not found"));
    }
    public void deleteById(Long id) { repo.deleteById(id); }
}
