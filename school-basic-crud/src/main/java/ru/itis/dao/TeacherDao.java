package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.model.Teacher;

import java.util.UUID;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, UUID> {

}
