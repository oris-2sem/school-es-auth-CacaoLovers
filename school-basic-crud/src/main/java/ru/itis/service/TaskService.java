package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.LessonStudentId;
import ru.itis.model.Task;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService implements EntityCrudService<Task, LessonStudentId>{
    @Override
    public Task findById(LessonStudentId lessonStudentId) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task createEntity(Task entity) {
        return null;
    }

    @Override
    public Task updateEntity(Task entity) {
        return null;
    }

    @Override
    public void deleteEntity(LessonStudentId lessonStudentId) {

    }
}
