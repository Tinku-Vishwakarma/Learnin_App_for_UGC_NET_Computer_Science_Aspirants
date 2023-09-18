package com.example.ugcnetapp.ui.quiz;

public class QuestionData {
    private String Option1,Option2,Option3,Option4,question,answer;

    public QuestionData() {
    }

    public QuestionData(String option1, String option2, String option3, String option4, String question, String answer) {
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        this.question = question;
        this.answer = answer;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

