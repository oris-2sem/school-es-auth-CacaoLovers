package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Lesson;

import java.util.UUID;

public interface LessonDao extends JpaRepository<Lesson, UUID> {
}
