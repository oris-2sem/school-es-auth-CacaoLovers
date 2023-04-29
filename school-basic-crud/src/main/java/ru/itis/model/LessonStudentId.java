package ru.itis.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonStudentId implements Serializable {
    @Column(name = "student_id")
    private UUID studentId;

    @Column(name = "lesson_id")
    private UUID lessonId;
}
