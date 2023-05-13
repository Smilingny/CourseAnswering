package com.example.courseanswering;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stageQ) throws IOException {
        FXMLLoader questionLoader = new FXMLLoader(getClass().getResource("QuestionWindow.fxml"));
        Scene scene = new Scene(questionLoader.load());
        stageQ.setTitle("课程答疑-学生端");
        stageQ.getIcons().add(new Image(getClass().getResource("image/logo.png").toString()));
        stageQ.setResizable(false);
        stageQ.setScene(scene);
        stageQ.show();

        FXMLLoader answerLoader = new FXMLLoader(getClass().getResource("AnswerWindow.fxml"));
        Scene scene1 = new Scene(answerLoader.load());
        Stage stageA = new Stage();
        stageA.setTitle("课程答疑-教师端");
        stageA.getIcons().add(new Image(getClass().getResource("image/logo.png").toString()));
        stageA.setResizable(false);
        stageA.setScene(scene1);
        stageA.show();

    }

    public static void main(String[] args) {
        launch();
    }
}