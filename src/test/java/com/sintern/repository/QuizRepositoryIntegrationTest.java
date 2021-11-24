package com.sintern.repository;

import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.entity.Quiz;
import com.sintern.domain.entity.QuizQuestion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuizRepositoryIntegrationTest {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Autowired
    private OpenInternPositionRepository openInternPositionRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void should_returnQuiz_given_openInternPositionId_when_findByOpenInternPositionId() {
        //GIVEN
        Company company = new Company();
        company.setName("Company name");
        company.setEmail("email"+ UUID.randomUUID()+"@email.com");
        company.setPassword("Password1234!");
        company.setAddress("Address");
        companyRepository.save(company);

        OpenInternPosition openInternPosition = new OpenInternPosition();
        openInternPosition.setCompany(company);
        openInternPositionRepository.save(openInternPosition);

        Quiz quiz = new Quiz();
        quiz.setOpenInternPosition(openInternPosition);
        quizRepository.save(quiz);

        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setQuestion("Question");
        quizQuestion.setAnswer1("first answer");
        quizQuestion.setAnswer2("second answer");
        quizQuestion.setAnswer3("third answer");
        quizQuestion.setAnswer4("fourth answer");
        quizQuestion.setCorrectAnswer("first answer");
        quizQuestion.setQuiz(quiz);

        QuizQuestion quizQuestion2 = new QuizQuestion();
        quizQuestion2.setQuestion("Question2");
        quizQuestion2.setAnswer1("first answer2");
        quizQuestion2.setAnswer2("second answer2");
        quizQuestion2.setAnswer3("third answer2");
        quizQuestion2.setAnswer4("fourth answer2");
        quizQuestion2.setCorrectAnswer("first answer2");
        quizQuestion2.setQuiz(quiz);

        quizQuestionRepository.save(quizQuestion);
        quizQuestionRepository.save(quizQuestion2);

        //WHEN
        Quiz foundQuiz = quizRepository.findByOpenInternPositionId(openInternPosition.getId());

        //THEN
        assertThat(foundQuiz.getQuizQuestions().size()).isEqualTo(2);
    }

}
