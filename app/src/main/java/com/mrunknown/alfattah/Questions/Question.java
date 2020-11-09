package com.mrunknown.alfattah.Questions;

import android.widget.Button;
import android.widget.EditText;

public class Question {

    public void nextQuestion(int id,Button op1, Button op2, Button op3, Button op4, EditText ques,String ans)
    {
        op1.setText("hello");
        op2.setText("hi");
        op3.setText("good");
        op4.setText("bad");
        ques.setText("how are you?");
        ans="hi";
    }
}
