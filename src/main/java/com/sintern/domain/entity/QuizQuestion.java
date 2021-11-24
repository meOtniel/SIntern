package com.sintern.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "quiz_question")
public class QuizQuestion {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    @NotNull String question;

    @NotNull String answer1;

    @NotNull String answer2;

    @NotNull String answer3;

    @NotNull String answer4;

    @NotNull String correctAnswer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    Quiz quiz;

    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer);
    }
}
