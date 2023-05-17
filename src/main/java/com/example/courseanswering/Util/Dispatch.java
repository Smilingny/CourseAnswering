package com.example.courseanswering.Util;

import com.example.courseanswering.Model.Question;
import com.example.courseanswering.Model.Student;

import java.util.ArrayList;

public class Dispatch {
    /**
     * （詹负责） 删除students中所有问题回答完成的student（isAllAnswered=true），并返回剩下student中优先级最高的
     * priority默认为5
     */
    public static Student nextStudent(ArrayList<Student> students){
        ArrayList<Student> toRemove = new ArrayList<>();//创建待删除列表
        Student highestPriority = null;
        for (Student student : students) {
            if (student.isAllAnswered()) {
                toRemove.add(student);
            } //回答完问题学生加入待删除列表
            else if (highestPriority == null || student.getPriority() > highestPriority.getPriority()) {
                highestPriority = student;
            }//设置高优先级，如果还没有找到，就将当前学生设置为高优先级
        }
        students.removeAll(toRemove);//删除
        return highestPriority;
    }

    /**
     * （黄负责） 返回该学生提出的所有未回答的问题（isAnswered=false)中优先级最高的问题
     * priority默认为3
     * @param student
     * @return
     */
    public static Question nextQuestion(Student student) {
        int highestPriority = Integer.MAX_VALUE; // 初始化为最高优先级
        Question highestPriorityQuestion = null;
        Question[] questions = student.getQuestions();
        for (Question question : questions) {
            // 如果该问题未被回答且优先级比当前最高优先级高
            if (!question.isAnswered() && question.getPriority() < highestPriority) {
                highestPriority = question.getPriority(); // 更新最高优先级
                highestPriorityQuestion = question; // 记录该问题
            }
        }
        return highestPriorityQuestion;
    }

    /**
     * （黄负责） 根据问题的预期时间设置问题优先级（priority属性）
     * priority默认为3
     * @param student
     */
    public static void setQuestionPriority(Student student) {
        Question[] questions = student.getQuestions();
        for (Question question : questions) {
            long expectedTime = question.getExpectedTime(); // 获取预期时间
            if (expectedTime <= 20) {
                question.setPriority(1);
            } else if (expectedTime <= 60) {
                question.setPriority(2);
            } else if (expectedTime <= 120) {
                question.setPriority(3);
            } else {
                question.setPriority(4);
            }
        }
    }
}
