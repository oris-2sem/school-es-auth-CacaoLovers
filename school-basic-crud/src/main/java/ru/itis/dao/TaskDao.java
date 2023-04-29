package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.LessonStudentId;
import ru.itis.model.Task;

public interface TaskDao extends JpaRepository<Task, LessonStudentId> {

}
