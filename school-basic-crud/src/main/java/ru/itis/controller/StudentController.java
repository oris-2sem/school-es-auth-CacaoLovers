package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.StudentApi;
import ru.itis.model.Student;
import ru.itis.service.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {

    private final StudentService studentService;

    @Override
    public Student findEntityById(UUID uuid) {
        return studentService.findById(uuid);
    }

    @Override
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @Override
    public Student createEntity(Student entity) {
        return studentService.createEntity(entity);
    }

    @Override
    public Student updateEntity(Student entity) {
        return studentService.updateEntity(entity);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        studentService.deleteEntity(uuid);
    }
}
