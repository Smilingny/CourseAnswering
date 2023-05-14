package com.example.courseanswering.Controller;

import com.example.courseanswering.Model.Question;
import com.example.courseanswering.Model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class QuestionWinController {

    @FXML
    private AnchorPane aa;

    @FXML
    private Button submit;

    @FXML
    private TextArea question3;

    @FXML
    private TextArea question2;

    @FXML
    private TextArea question5;

    @FXML
    private TextArea question4;

    @FXML
    private TextArea question1;

    @FXML
    private ChoiceBox<Integer> expectTime1;

    @FXML
    private ChoiceBox<Integer> expectTime4;

    @FXML
    private ChoiceBox<Integer> expectTime5;

    @FXML
    private ChoiceBox<Integer> expectTime2;

    @FXML
    private ChoiceBox<Integer> expectTime3;

    @FXML
    private TextField name;


    @FXML
    public Student summitQuestion() {
        Student student = new Student(name.getText());
        Question[] questions = new Question[5];

        TextArea[] question = new TextArea[5];
        question[0] = question1;
        question[1] = question2;
        question[2] = question3;
        question[3] = question4;
        question[4] = question5;

        ChoiceBox<Integer>[] epTime = new ChoiceBox[5];
        epTime[0] = expectTime1;
        epTime[1] = expectTime2;
        epTime[2] = expectTime3;
        epTime[3] = expectTime4;
        epTime[4] = expectTime5;

        for (int i = 0; i < 5; i++) {
            if (!question[i].getText().equals("")) {
                questions[i] = new Question(question[i].getText(), epTime[i].getValue().longValue() * 60000);
                question[i].clear();
                epTime[i].setValue(null);
            }
        }
        student.setQuestions(questions);
        name.clear();
        return student;
    }


}


