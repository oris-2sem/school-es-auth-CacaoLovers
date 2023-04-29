package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Parent;

import java.util.UUID;

public interface ParentDao extends JpaRepository<Parent, UUID> {

}
