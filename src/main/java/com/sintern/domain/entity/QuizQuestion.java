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

    @NotNull int correctAnswerIndex;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    Quiz quiz;

    public boolean isCorrect(String answer) {
        if (answer.equals(answer1) && correctAnswerIndex == 1) {
            return true;
        }
        if (answer.equals(answer2) && correctAnswerIndex == 2) {
            return true;
        }
        if (answer.equals(answer3) && correctAnswerIndex == 3) {
            return true;
        }
        return answer.equals(answer4) && correctAnswerIndex == 4;
    }
}
