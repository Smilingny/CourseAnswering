package com.example.courseanswering;

import com.example.courseanswering.Controller.AnswerWinController;
import com.example.courseanswering.Controller.QuestionWinController;
import com.example.courseanswering.Model.Question;
import com.example.courseanswering.Model.Student;
import com.example.courseanswering.Util.Dispatch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    @Override
    public void start(Stage stageQ) throws IOException {

//        启动学生端窗口
        FXMLLoader questionLoader = new FXMLLoader(getClass().getResource("QuestionWindow.fxml"));
        Scene scene = new Scene(questionLoader.load());
        stageQ.setTitle("课程答疑-学生端");
        stageQ.getIcons().add(new Image(getClass().getResource("image/logo.png").toString()));
        stageQ.setResizable(false);
        stageQ.setScene(scene);
        stageQ.show();

//        启动教师端窗口
        FXMLLoader answerLoader = new FXMLLoader(getClass().getResource("AnswerWindow.fxml"));
        Scene scene1 = new Scene(answerLoader.load());
        Stage stageA = new Stage();
        stageA.setTitle("课程答疑-教师端");
        stageA.getIcons().add(new Image(getClass().getResource("image/logo.png").toString()));
        stageA.setResizable(false);
        stageA.setScene(scene1);


//        获取学生所提问题
        Long[] time = {0L, 0L, 0L};  // time[0]为startTime,time[1]为endTime,time[2]为actualTime
        int[] index = {-1};
        ArrayList<Student> stu = new ArrayList<>();
        QuestionWinController questionWinController = questionLoader.getController();
        Button submit = (Button) scene.lookup("#submit");
        submit.setOnAction(actionEvent -> {
            Student student = questionWinController.summitQuestion();
            Dispatch.setQuestionPriority(student);
            stu.add(student);
            stageA.show();
            student = Dispatch.nextStudent(stu);
            Question question = Dispatch.nextQuestion(student);
            Text questionText = (Text) scene1.lookup("#question");
            Text name = (Text) scene1.lookup("#student");
            questionText.setText(question.getContent());
            name.setText(student.getName());
            question.answered();
            time[0] = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                if (question == student.getQuestions()[i]) {
                    index[0]=i+1;
                }
            }
        });

//        开始解答
        AnswerWinController answerWinController = answerLoader.getController();
        Button getButton = (Button) scene1.lookup("#submit");
        Text questionText = (Text) scene1.lookup("#question");
        Text name = (Text) scene1.lookup("#student");
        getButton.setOnAction(actionEvent -> {
            TextArea answer = (TextArea) scene.lookup("#question"+index[0]);
            answer.setText(answerWinController.submitAnswer());
            Student student = Dispatch.nextStudent(stu);
            Question question = Dispatch.nextQuestion(student);
            if (question != null) {
                question.answered();
                time[1] = System.currentTimeMillis();
                time[2] = time[1] - time[0];
                name.setText(student.getName());
                questionText.setText(question.getContent());
                time[0] = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    if (question == student.getQuestions()[i]) {
                        index[0] = i + 1;
                    }
                }
                student.setPriority(student.getPriority() - 1);
                if (time[2] > question.getExpectTime()) {
                    student.setPriority(student.getPriority() - 1);
                } else {
                    student.setPriority(student.getPriority() + 1);
                }
            } else{
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示信息");
                alert.setContentText("所有问题回答已经回答完成");
                alert.showAndWait();
                name.setText("");
                questionText.setText("");
            }
        });

    }


    public static void main(String[] args) {
        launch();
    }
}