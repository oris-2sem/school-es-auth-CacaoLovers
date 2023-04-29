package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Group;

import java.util.UUID;

public interface GroupDao extends JpaRepository<Group, UUID> {
}
