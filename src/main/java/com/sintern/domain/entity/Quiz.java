package com.sintern.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    @OneToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    OpenInternPosition openInternPosition;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz", cascade = CascadeType.ALL)
    List<QuizQuestion> quizQuestions;

}
