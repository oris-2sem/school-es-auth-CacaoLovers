package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.TaskApi;
import ru.itis.model.LessonStudentId;
import ru.itis.model.Task;
import ru.itis.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    public Task findEntityById(LessonStudentId lessonStudentId) {
        return taskService.findById(lessonStudentId);
    }

    @Override
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @Override
    public Task createEntity(Task entity) {
        return taskService.createEntity(entity);
    }

    @Override
    public Task updateEntity(Task entity) {
        return taskService.updateEntity(entity);
    }

    @Override
    public void deleteEntity(LessonStudentId lessonStudentId) {
        taskService.deleteEntity(lessonStudentId);
    }
}
