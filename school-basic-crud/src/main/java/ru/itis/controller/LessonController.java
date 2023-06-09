package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.LessonApi;
import ru.itis.model.Lesson;
import ru.itis.service.LessonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LessonController implements LessonApi {

    private final LessonService lessonService;

    @Override
    public Lesson findEntityById(UUID uuid) {
        return lessonService.findById(uuid);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonService.findAll();
    }

    @Override
    public Lesson createEntity(Lesson entity) {
        return lessonService.createEntity(entity);
    }

    @Override
    public Lesson updateEntity(Lesson entity) {
        return lessonService.updateEntity(entity);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        lessonService.deleteEntity(uuid);
    }
}
