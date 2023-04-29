package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Timetable;

import java.util.UUID;

public interface TimetableDao extends JpaRepository<Timetable, UUID> {

}
