package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dao.StudentDao;
import ru.itis.exception.ResourceNotFoundException;
import ru.itis.model.Student;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class StudentService implements EntityCrudService<Student, UUID>{

    private final StudentDao studentDao;
    @Override
    public Student findById(UUID uuid) {
        return studentDao.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(uuid));
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student createEntity(Student entity) {
        return studentDao.save(entity);
    }

    @Override
    public Student updateEntity(Student entity) {
        Student student = findById(entity.getId());

        student.setGroup(entity.getGroup());
        student.setName(entity.getName());
        student.setRating(entity.getRating());

        return studentDao.save(student);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        Student student = findById(uuid);

        studentDao.delete(student);
    }
}
