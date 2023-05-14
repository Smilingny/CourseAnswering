package com.example.courseanswering.Util;

import com.example.courseanswering.Model.Question;
import com.example.courseanswering.Model.Student;

import java.util.ArrayList;

public class Dispatch {
    /**
     * （詹负责） 删除students中所有问题回答完成的student（isAllAnswered=true），并返回剩下student中优先级最高的
     * priority默认为5
     * @param students
     * @return
     */
    public static Student nextStudent(ArrayList<Student> students){
        return new Student("test1");  // 编写时删除该行
    }

    /**
     * （黄负责） 返回该学生提出的所有未回答的问题（isAnswered=false)中优先级最高的问题
     * priority默认为3
     * @param student
     * @return
     */
    public static Question nextQuestion(Student student) {
        return new Question("test2",100L); // 编写时删除该行
    }

    /**
     * （黄负责） 根据问题的预期时间设置问题优先级（priority属性）
     * priority默认为3
     * @param student
     */
    public static void setQuestionPriority(Student student) {

    }
}
