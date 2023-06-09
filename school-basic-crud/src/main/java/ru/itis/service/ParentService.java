package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dao.ParentDao;
import ru.itis.exception.ResourceNotFoundException;
import ru.itis.model.Parent;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ParentService implements EntityCrudService<Parent, UUID>{

    private final ParentDao parentDao;
    @Override
    public Parent findById(UUID uuid) {
        return parentDao.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(uuid));
    }

    @Override
    public List<Parent> findAll() {
        return parentDao.findAll();
    }

    @Override
    public Parent createEntity(Parent entity) {
        return parentDao.save(entity);
    }

    @Override
    public Parent updateEntity(Parent entity) {
        Parent parent = findById(entity.getId());

        parent.setName(entity.getName());

        return parentDao.save(parent);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        Parent parent = findById(uuid);

        parentDao.delete(parent);
    }
}
