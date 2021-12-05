package com.sintern.api.request;

import com.sintern.domain.entity.QuizQuestion;

import java.util.List;
import java.util.UUID;

public class CreateQuizRequest {

    private List<QuizQuestion> quizzQuestion;
    private UUID openInternPositionID;

    public List<QuizQuestion> getQuizzQuestion() {
        return quizzQuestion;
    }

    public void setQuizzQuestion(List<QuizQuestion> quizQuestion) {
        this.quizzQuestion = quizQuestion;
    }

    public UUID getOpenInternPositionID() {
        return openInternPositionID;
    }

    public void setOpenInternPositionID(UUID openInternPositionID) {
        this.openInternPositionID = openInternPositionID;
    }
}
