package com.sintern.service;

import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.entity.Quiz;
import com.sintern.domain.entity.QuizQuestion;
import com.sintern.exception.ExistentQuizException;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final OpenInternPositionRepository openInternPositionRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, OpenInternPositionRepository openInternPositionRepository) {
        this.quizRepository = quizRepository;
        this.openInternPositionRepository = openInternPositionRepository;
    }

    @Override
    public void addQuiz(List<QuizQuestion> quizQuestionList, UUID openInternPositionID) {
        if (quizRepository.findByOpenInternPositionId(openInternPositionID) != null) {
            throw new ExistentQuizException("A quiz with the same ID already exists!");
        }
        OpenInternPosition openInternPosition = openInternPositionRepository.getById(openInternPositionID);
        Quiz quiz = new Quiz();
        quiz.setQuizQuestions(quizQuestionList);
        quiz.setOpenInternPosition(openInternPosition);
        quizQuestionList.forEach(quizQuestion -> quizQuestion.setQuiz(quiz));
        quizRepository.save(quiz);
    }
}
