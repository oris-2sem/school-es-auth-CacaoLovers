package ru.itis.app;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.itis.dao.*;
import ru.itis.model.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@AllArgsConstructor
public class Client {

    private final TeacherDao teacherDao;
    private final GroupDao groupDao;
    private final StudentDao studentDao;
    private final TaskDao taskDao;
    private final TimetableDao timetableDao;
    private final ParentDao parentDao;
    private final LessonDao lessonDao;

    private static final Integer DURATION_OF_EDUCATION = 5;

    @Transactional
    public void work() {
        Teacher roman = Teacher.builder()
                .name("Roman")
                .rating(10.0)
                .build();

        Teacher misha = Teacher.builder()
                .name("Misha")
                .rating(9.0)
                .build();

        Teacher sasha = Teacher.builder()
                .name("Sasha")
                .rating(9.0)
                .build();


        roman = teacherDao.save(roman);
        misha = teacherDao.save(misha);
        sasha = teacherDao.save(sasha);
        teacherDao.flush();

        Group group102 = Group.builder()
                .course(2)
                .rating(10.0)
                .teacher(roman)
                .build();


        Group group101 = Group.builder()
                .course(2)
                .rating(7.0)
                .teacher(sasha)
                .build();

        group102.setYearOfGraduation(computeYearOfGraduation(LocalDate.now(),
                group102.getCourse()));
        group101.setYearOfGraduation(computeYearOfGraduation(LocalDate.now(),
                group101.getCourse()));

        group102 = groupDao.save(group102);
        group101 = groupDao.save(group101);
        groupDao.flush();

        Parent parentOne = Parent.builder()
                .name("Alex")
                .build();

        Parent parentTwo = Parent.builder()
                .name("Lesli")
                .build();

        parentOne = parentDao.save(parentOne);
        parentTwo = parentDao.save(parentTwo);
        parentDao.flush();

        Student jerry = Student.builder()
                .name("Jerry")
                .rating(9.0)
                .group(group101)
                .parent(parentOne)
                .build();

        Student kevin = Student.builder()
                .name("Kevin")
                .rating(5.6)
                .group(group102)
                .parent(parentTwo)
                .build();

        Student lolly = Student.builder()
                .name("Lolly")
                .rating(5.6)
                .group(group101)
                .parent(parentOne)
                .build();

        jerry = studentDao.save(jerry);
        kevin = studentDao.save(kevin);
        lolly = studentDao.save(lolly);
        studentDao.flush();

        Timetable timetableFirst = Timetable.builder()
                .teacher(roman)
                .group(group102)
                .dateTime(LocalDateTime.now())
                .room("1409")
                .build();

        Timetable timetableSecond = Timetable.builder()
                .teacher(sasha)
                .group(group101)
                .dateTime(LocalDateTime.now().plus(2, ChronoUnit.HOURS))
                .room("1509")
                .build();

        Timetable timetableLast = Timetable.builder()
                .teacher(sasha)
                .group(group102)
                .dateTime(LocalDateTime.now().plus(1, ChronoUnit.DAYS))
                .room("208")
                .build();

        timetableFirst = timetableDao.save(timetableFirst);
        timetableSecond = timetableDao.save(timetableSecond);
        timetableLast = timetableDao.save(timetableLast);
        timetableDao.flush();

        Lesson lesson = Lesson.builder()
                .subject("ORIS")
                .timetable(timetableFirst)
                .theme("Hibernate")
                .build();

        Lesson lessonTwo = Lesson.builder()
                .subject("ORIS")
                .timetable(timetableSecond)
                .theme("Hibernate")
                .build();

        Lesson lessonThree = Lesson.builder()
                .subject("ORIS")
                .timetable(timetableLast)
                .theme("Hibernate")
                .build();

        lesson = lessonDao.save(lesson);
        lessonTwo = lessonDao.save(lessonTwo);
        lessonThree = lessonDao.save(lessonThree);
        lessonDao.flush();

        LessonStudentId lessonStudentId = LessonStudentId.builder()
                .studentId(lolly.getId())
                .lessonId(lesson.getId())
                .build();

        LessonStudentId lessonStudentIdTwo = LessonStudentId.builder()
                .studentId(lolly.getId())
                .lessonId(lessonTwo.getId())
                .build();

        LessonStudentId lessonStudentIdThree = LessonStudentId.builder()
                .studentId(kevin.getId())
                .lessonId(lesson.getId())
                .build();

        Task taskOne = Task.builder()
                .id(lessonStudentId)
                .lesson(lesson)
                .student(lolly)
                .commentary("Nice")
                .description("How work Embedded?")
                .mark("A")
                .build();

        Task taskTwo = Task.builder()
                .id(lessonStudentIdTwo)
                .student(lolly)
                .lesson(lessonTwo)
                .commentary("Nice")
                .description("How work Embedded?")
                .mark("A")
                .build();

        Task taskThree = Task.builder()
                .id(lessonStudentIdThree)
                .lesson(lesson)
                .student(kevin)
                .commentary("Nice")
                .description("How work Embedded?")
                .mark("A")
                .build();
        taskOne = taskDao.save(taskOne);
        taskTwo = taskDao.save(taskTwo);
        taskThree = taskDao.save(taskThree);
        taskDao.flush();

    }

    @Transactional
    public void workWithData(){
        List<Group> groups = groupDao.findAll();
        List<Teacher> teachers = teacherDao.findAll();
    }

    public LocalDate computeYearOfGraduation(LocalDate time, Integer course) {
        time = time.with(ChronoField.MONTH_OF_YEAR, 6)
                .plus(DURATION_OF_EDUCATION - course, ChronoUnit.YEARS);
        return time;
    }
}

