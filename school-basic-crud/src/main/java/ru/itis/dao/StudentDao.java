package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Student;

import java.util.UUID;

public interface StudentDao extends JpaRepository<Student, UUID> {
}
