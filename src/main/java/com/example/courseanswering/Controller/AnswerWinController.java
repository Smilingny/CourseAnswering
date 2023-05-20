package com.example.courseanswering.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class AnswerWinController {

    @FXML
    private TextArea answer;

    @FXML
    private Text question;

    @FXML
    private Button submit;

    @FXML
    private Text student;

    @FXML
    public String submitAnswer() {
        String a = answer.getText();
        answer.clear();
        return a;
    }

}


