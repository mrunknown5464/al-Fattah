package com.mrunknown.alfattah;


import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mrunknown.alfattah.Questions.Question;


public class QuizActivity extends AppCompatActivity {
    Set<Integer> list=new HashSet<>();
    int count=0;
    String ans="hello";
    int score=0;
    Button btn1,btn2,btn3,btn4;
    EditText ques;
    TextView txtscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        overridePendingTransition(R.anim.act_fade_in,R.anim.act_fade_out);
        dropDownMethod();



        btn1=findViewById(R.id.btnAnswOne);
        btn2=findViewById(R.id.btnAnswtwo);
        btn3=findViewById(R.id.btnAnswthree);
        btn4=findViewById(R.id.btnAnswFour);
        ques=findViewById(R.id.txtQuestion);
        txtscore=findViewById(R.id.txtScoreCount);

        loadQuestion();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResult(btn1.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResult(btn2.getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResult(btn3.getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResult(btn4.getText().toString());
            }
        });
    }

    public int genrateRandomNum()
    {
        int len=20;
        int num;
        Random random=new Random();
         num=random.nextInt(len);
        while(list.contains(num))
            num=random.nextInt(len);
        list.add(num);
       return num;
    }
    public void checkResult(String str)
    {
        count++;
        if(str.equals(ans))
        {
            score++;
        }
        txtscore.setText(Integer.toString(score));
        if(score<10)
            txtscore.setTextColor(Color.RED);
        else if(score>=10 && score < 15)
            txtscore.setTextColor(Color.DKGRAY);
        else if(score<=15)
            txtscore.setTextColor(Color.GREEN);

        if(count<20)
            loadQuestion();
        else
            startActivity(new Intent(this,HomeActivity.class));
    }
    public void loadQuestion()
    {
        Question question=new Question();
        int id=genrateRandomNum();
        question.nextQuestion(id,btn1,btn2,btn3,btn4,ques,ans);
    }

    public void dropDownMethod()
    {
        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"English", "Urdu", "Hindi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }
}