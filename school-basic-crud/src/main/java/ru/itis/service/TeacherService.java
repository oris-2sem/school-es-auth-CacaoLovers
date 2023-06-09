package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Teacher;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherService implements EntityCrudService<Teacher, UUID>{
    @Override
    public Teacher findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher createEntity(Teacher entity) {
        return null;
    }

    @Override
    public Teacher updateEntity(Teacher entity) {
        return null;
    }

    @Override
    public void deleteEntity(UUID uuid) {

    }
}
