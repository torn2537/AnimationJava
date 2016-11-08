package com.example.john.project1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Constructor_chapter extends AppCompatActivity {
    //Declare reference
    ImageView pointer,classCode_construct;
    TextView class_text_construct,object_text_construct,
            str_header,str_text_construct,num_header,num_text_construct,error_text,output_construct;
    ImageButton playConstruct,pauseConstruct,stopConstruct;
    ObjectAnimator objLine1,objLine4,objLine6,objLine7, objLine8,objLine9,objLine10,objLine11,objLine11_1,objLine12,objLine13;
    String checkState_Construct="";
    AnimatorSet amMovingAnimations1;
    int CountPush=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constructor_chapter);
        //Views
        pointer = (ImageView)findViewById(R.id.pointer_construct);
        classCode_construct = (ImageView)findViewById(R.id.pic_construct);
        class_text_construct =(TextView)findViewById(R.id.class_text_Construct);
        object_text_construct =(TextView)findViewById(R.id.object_text_Construct);
        str_header =(TextView)findViewById(R.id.str_header);
        str_text_construct =(TextView)findViewById(R.id.text_str_construct);
        num_header =(TextView)findViewById(R.id.num_header);
        num_text_construct =(TextView)findViewById(R.id.num_construct);
        error_text =(TextView)findViewById(R.id.error_text);
        output_construct =(TextView)findViewById(R.id.output_construct);
        prepareScreen();
        //Buttons
        playConstruct = (ImageButton)findViewById(R.id.playbtnConstruct);
        pauseConstruct =(ImageButton)findViewById(R.id.pausebtnConstruct);
        stopConstruct = (ImageButton)findViewById(R.id.stopbtnConstruct);

        //playbutton
        playConstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Constructor_chapter.this, "Start!", Toast.LENGTH_SHORT).show();

                testPointerLine1();
            }
        });
        //pausebutton
        pauseConstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CountPush%2!=0)
                {
                    PauseAniomation();
                    CountPush +=1;
                }
                else if(CountPush%2==0)
                {
                    ResumeAnimation();
                    CountPush +=1;
                }
            }
        });
        //stopbutton
        stopConstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }
    //Pause method
    private void PauseAniomation()
    {
        if(checkState_Construct.equals("line1"))
        {
            Log.d("State","line1 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine1.pause();
        }
        else if (checkState_Construct.equals("line9"))
        {
            Log.d("State","line9 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
             objLine9.pause();
        }
        else if (checkState_Construct.equals("line10"))
        {
            Log.d("State","line10 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine10.pause();
        }
        else if (checkState_Construct.equals("line11"))
        {
            Log.d("State","line11 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine11.pause();
        }
        else if (checkState_Construct.equals("movingAnimation1"))
        {
            Log.d("State","movingAnimation paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            amMovingAnimations1.pause();
        }
        else if (checkState_Construct.equals("line4"))
        {
            Log.d("State","line4 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine4.pause();
        }
        else if (checkState_Construct.equals("line6"))
        {
            Log.d("State","line6 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine6.pause();
        }
        else if (checkState_Construct.equals("line7"))
        {
            Log.d("State","line7 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine7.pause();
        }
        else if (checkState_Construct.equals("line8"))
        {
            Log.d("State","line8 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine8.pause();
        }
        else if (checkState_Construct.equals("line11_1"))
        {
            Log.d("State","line11_1 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine11_1.pause();
        }
        else if (checkState_Construct.equals("line12"))
        {
            Log.d("State","line12 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine12.pause();
        }
        else if (checkState_Construct.equals("line13"))
        {
            Log.d("State","line13 paused");
            Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            objLine13.pause();
        }
    }
    //Resume method
    private void ResumeAnimation()
    {
        if(checkState_Construct.equals("line1"))
        {
            Log.d("State","line1 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine1.resume();
        }
        else if (checkState_Construct.equals("line9"))
        {
            Log.d("State","line9 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine9.resume();
        }
        else if (checkState_Construct.equals("line10"))
        {
            Log.d("State","line10 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine10.resume();
        }
        else if (checkState_Construct.equals("line11"))
        {
            Log.d("State","line11 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine11.resume();
        }
        else if (checkState_Construct.equals("movingAnimation1"))
        {
            Log.d("State","movingAnimation resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            amMovingAnimations1.resume();
        }
        else if (checkState_Construct.equals("line4"))
        {
            Log.d("State","line4 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine4.resume();
        }
        else if (checkState_Construct.equals("line6"))
        {
            Log.d("State","line6 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine6.resume();
        }
        else if (checkState_Construct.equals("line7"))
        {
            Log.d("State","line7 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine7.resume();
        }
        else if (checkState_Construct.equals("line8"))
        {
            Log.d("State","line8 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine8.resume();
        }
        else if (checkState_Construct.equals("line11_1"))
        {
            Log.d("State","line11_1 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine11_1.resume();
        }
        else if (checkState_Construct.equals("line12"))
        {
            Log.d("State","line12 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine12.resume();
        }
        else if (checkState_Construct.equals("line13"))
        {
            Log.d("State","line13 resumed");
            Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
            objLine13.resume();
        }
    }
    //Prepare screen
    private void prepareScreen()
    {
        classCode_construct.setVisibility(View.INVISIBLE);
        class_text_construct.setVisibility(View.INVISIBLE);
        object_text_construct.setVisibility(View.INVISIBLE);
        str_header.setVisibility(View.INVISIBLE);
        str_text_construct.setVisibility(View.INVISIBLE);
        num_header.setVisibility(View.INVISIBLE);
        num_text_construct.setVisibility(View.INVISIBLE);
        error_text.setVisibility(View.INVISIBLE);
        output_construct.setVisibility(View.INVISIBLE);
    }
    //Line 1
    private  void testPointerLine1()
    {
        checkState_Construct="line1";
        objLine1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,0);
        objLine1.setDuration(2000);
        objLine1.start();
        objLine1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                classCode_construct.setVisibility(View.VISIBLE);
                class_text_construct.setVisibility(View.VISIBLE);
                num_header.setVisibility(View.VISIBLE);
                num_text_construct.setVisibility(View.VISIBLE);
                //Go to line2
                Log.d("State","line1 finished");
                testPointerLine9();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Line9
    private void testPointerLine9()
    {
        checkState_Construct="line9";
        objLine9 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,480);
        objLine9.setDuration(2000);
        objLine9.start();
        objLine9.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //go to line10
                Log.d("State","Line9 finished");
                testPointerLine10();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line10
    private void testPointerLine10()
    {
        checkState_Construct="line10";
        objLine10 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,540);
        objLine10.setDuration(2000);
        objLine10.start();
        objLine10.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                str_header.setVisibility(View.VISIBLE);
                str_text_construct.setVisibility(View.VISIBLE);
                Log.d("State","Line10 finished");
                //Got to line11
                testPointerLine11();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line11
    private void testPointerLine11()
    {
        checkState_Construct="line11";
        objLine11 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,610);
        objLine11.setDuration(2000);
        objLine11.start();
        objLine11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","Line11 finished");
                classCode_construct.setImageResource(R.drawable.shape_circle_class);
                object_text_construct.setVisibility(View.VISIBLE);
                //Moving animation
                movingAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //MovingAnimation method
    private void movingAnimation()
    {
        checkState_Construct="movingAnimation1";
        //str header
        ObjectAnimator strheaderGoY = ObjectAnimator.ofFloat(str_header,View.TRANSLATION_Y,-300);
        ObjectAnimator strheaderGoX = ObjectAnimator.ofFloat(str_header,View.TRANSLATION_X,300);
        //str text
        ObjectAnimator strTextGoY = ObjectAnimator.ofFloat(str_text_construct,View.TRANSLATION_Y,-270);
        ObjectAnimator strTextGoX = ObjectAnimator.ofFloat(str_text_construct,View.TRANSLATION_X,270);

        //AnimatorSet
        amMovingAnimations1 = new AnimatorSet();
        amMovingAnimations1.playTogether(strheaderGoX,strheaderGoY,strTextGoY,strTextGoX);
        amMovingAnimations1.setDuration(2000);
        amMovingAnimations1.start();
        amMovingAnimations1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
            //Goto Line4
                Log.d("State","line11 finished");
                testPointerLine4();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line4
    private void testPointerLine4()
    {
        checkState_Construct="line4";
        objLine4 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,180);
        objLine4.setDuration(2000);
        objLine4.start();
        objLine4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line 4 finished");
                testPointerLine6();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line6
    private void testPointerLine6()
    {
        checkState_Construct="line6";
        objLine6 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,300);
        objLine6.setDuration(2000);
        objLine6.start();
        objLine6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line6 finished");
                //Goto Line7
                testPointerLine7();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line7
    private void testPointerLine7()
    {
        checkState_Construct="line7";
        objLine7 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,360);
        objLine7.setDuration(2000);
        objLine7.start();
        objLine7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line7 finished");
                //Goto line8
                testPointerLine8();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line8
    private void testPointerLine8()
    {
        checkState_Construct="line8";
        objLine8 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,420);
        objLine8.setDuration(2000);
        objLine8.start();
        objLine8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line 8 finished");
                num_text_construct.setText("1");
                //Goto line 11 again
                testPointerLine11_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line11Again
    private void testPointerLine11_1()
    {
        checkState_Construct ="line11_1";
        objLine11_1 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,610);
        objLine11_1.setDuration(2000);
        objLine11_1.start();
        objLine11_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","line11 finished");
                //Goto Line12
                testPointerLine12();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line12
    private void testPointerLine12()
    {
        checkState_Construct="line12";
        objLine12 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,665);
        objLine12.setDuration(2000);
        objLine12.start();
        objLine12.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","Line12 finished");
                output_construct.setVisibility(View.VISIBLE);
                //Go to Line13
                testPointerLine13();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //Line13
    private void testPointerLine13()
    {
        objLine13 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,720);
        objLine13.setDuration(2000);
        objLine13.start();
        objLine13.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State","Line13 finished");
                prepareScreen();
                classCode_construct.setBackgroundColor(Color.parseColor("#1B5E20"));
                error_text.setVisibility(View.VISIBLE);
                class_text_construct.setVisibility(View.VISIBLE);
                classCode_construct.setVisibility(View.VISIBLE);
                output_construct.setText("ต้องส่งค่า parameter ชนิด String เข้าไปด้วย");
                output_construct.setVisibility(View.VISIBLE);
                Toast.makeText(Constructor_chapter.this, "Finished", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
;    //Test moving pointer
    private void testMoving(int a1)
    {
        ObjectAnimator obj = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y,a1);
        obj.setDuration(2000);
        obj.start();
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,List_chapter.class);
        startActivity(intent);
        finish();
    }
}