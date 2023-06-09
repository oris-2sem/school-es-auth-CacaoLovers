package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dao.GroupDao;
import ru.itis.exception.ResourceNotFoundException;
import ru.itis.model.Group;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService implements EntityCrudService<Group, UUID>{

    private final GroupDao groupDao;

    @Override
    public Group findById(UUID uuid) {
        return groupDao.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(uuid));
    }

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public Group createEntity(Group entity) {
        return groupDao.save(entity);
    }

    @Override
    public Group updateEntity(Group entity) {
        Group groupPersist = findById(entity.getId());

        groupPersist.setCourse(entity.getCourse());
        groupPersist.setYearOfGraduation(entity.getYearOfGraduation());
        groupPersist.setRating(entity.getRating());


        return groupDao.save(groupPersist);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        Group group = findById(uuid);
        groupDao.delete(group);
    }
}
