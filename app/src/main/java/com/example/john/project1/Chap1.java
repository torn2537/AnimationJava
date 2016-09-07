package com.example.john.project1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Chap1 extends AppCompatActivity {
    //Creating objects.
    Intent intent;
    ImageView imgPointer,pic_class,output;
    ImageButton playbtn,stopbtn;
    ScrollView sv_code;
    LinearLayout layout_code;
    TextView textnum1,textnum2,textResult,textsign,textReturn;
    int a;
     Boolean control =true;
    //Declaring variables.
    Boolean checkControl = true; //Logically variable for controlling.
    int timeThread=5; //Time for delaying pointer's moving.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap1);

        //Selecting view by use findviewById
        imgPointer = (ImageView)findViewById(R.id.pointer);
        playbtn = (ImageButton)findViewById(R.id.playbtn);
        stopbtn = (ImageButton)findViewById(R.id.stopbtn);
        sv_code =(ScrollView)findViewById(R.id.sv_code);
        layout_code=(LinearLayout)findViewById(R.id.layout_code);
        pic_class =(ImageView)findViewById(R.id.pic_class);
        textnum1 =(TextView) findViewById(R.id.text_num1);
        textnum2 =(TextView) findViewById(R.id.text_num2);
        textResult=(TextView)findViewById(R.id.text_result);
        textsign = (TextView)findViewById(R.id.text_sign);
        textReturn = (TextView)findViewById(R.id.textReturn);
        output = (ImageView)findViewById(R.id.output);

        //Using method onClickListener for event handler on play button.
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method 'startPointer()'.
                /*startMoving();
                testPointer(800);*/
                /*output.setVisibility(View.VISIBLE);
                movingtoOutput();*/
                playstep1();



            }
        });
        //Using method onClickListener for event handler on stop button.
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calling method 'stopPlaying()'
                stopPlaying();
            }
        });
     }
    //method 'playstep1()'
    private void playstep1()
    {
        pic_class.setVisibility(View.VISIBLE);
        textnum1.setVisibility(View.VISIBLE);
        textnum2.setVisibility(View.VISIBLE);
        testPointer(50); //Going to ine2.
        control = true;
            playstep2();
    }
    private void playstep2()
    {
        if(control)
        {
            testPointer(110); //Going to line3.
            //Showing object's picture.
            pic_class.setImageResource(R.drawable.shape_circle_class);
        }

        control =false;

        if(!control)
        {
        //Calling 'movingNums'
        movingNums();
        }
    }
    private void playstep3()
    {
            //Going to class 'Chapter' on line 11
            testPointer(595);

            //Going to line12.
            testPointer(650);

            //Going to line14.
            testPointer(775);

            //Setting pointer's position in 0 px and Scrolling down
            startMoving();
            testPointer(200);
            //Calling playstep4()
            playstep4();
        }
    //playstep4()'s method
    private void playstep4() {
        ///Going to line15
        testPointerLine15(260);

    }
    private  void playstep5()
    {
        gotop();
        //Going to line4
        testPointerLine4_1(170);
    }
    //playstep6
    private  void playstep6()
    {
        //Going to line 19
        testPointerLine19(500);
    }
    //playrstep7
    private void playstep7()
    {
        //Going to line 6
        testPointerLine6(300);
    }
    //playstep8
    private void playstep8()
    {
        //Going to line 7
        gotop();
        testPointerLine7(350);
    }
    private void playstep9()
    {
     //Going to line 23
        testPointerLine23(740);
    }
    //Method 'play'
    private void play()
    {


        //Going to line4.
        testPointer(170);
        //Showing the result's picture and set its position.
        textResult.setVisibility(View.VISIBLE);


        //Going to line5.
        testPointer(235);
        //Going to class 'Chapter' on line 11
        testPointer(595);
        //Going to line14.
        testPointer(775);

        //Scrolling down code's picture to the bottom.
        startMoving();
        //Going to line 15.
        testPointer(115);
        flipnum1();
        //Going to line 16.
        testPointer(215);
        flipnum2();

        //Go to lime 19.
        testPointer(395);
        textsign.setVisibility(View.VISIBLE);
        movingSign();

        //Go to lime 20.
        testPointer(455);
        textReturn.setVisibility(View.VISIBLE);
        movingTextreturn();

        //Scrolling to the top.
        gotop();
        //Going to line 6.
        testPointer(300);
        output.setVisibility(View.VISIBLE);
        //Moving red box into output
        movingtoOutput();

        //Going to line 7.
        testPointer(350);
        //Scrolling down
        startMoving();

        //Going to class 'Chapter' on line 11
        testPointer(595);

        //Going to line12.
        testPointer(650);

        //Going to line14.
        testPointer(775);

        //Going to line15 and playing animation on num1 and num2 's pictures
        testPointer(115);
        flipnum1();

        //Going to line16
        testPointer(215);
        flipnum2();

        //Going to line 23
        testPointer(635);
        textsign.setText("-");
        //Changing text to return.
        textReturn.setText("5");
        testPointer(700);
        //Returning a result into the red box.
        movingTextreturn();

        //Scrolling up
        gotop();
        //Going to line 8
        testPointer(410);
        //Moving red box into output
        movingtoOutput();
    }

    //method 'movingTextStartpoint'
    private void movingTextStartpoint()
    {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,0);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,0);
        //Fade out picture of 'return'.
        ObjectAnimator t3 = ObjectAnimator.ofFloat(textReturn,View.ALPHA,0f);
        AnimatorSet am = new AnimatorSet();
        am.playSequentially(t1,t2);
        am.setDuration(3000);
        am.start();

        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'movingTextreturn'
    private void movingTextreturn()
    {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_X,-500);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textReturn,View.TRANSLATION_Y,-500);
        //Fade out picture of 'return'.
        ObjectAnimator t3 = ObjectAnimator.ofFloat(textReturn,View.ALPHA,0f);
        AnimatorSet am = new AnimatorSet();
        am.playSequentially(t1,t2,t3);
        am.setDuration(3000);
        am.start();

        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setText("15");
                textResult.setTextColor(Color.parseColor("#ECF0F1"));
                gotop();
                playstep7();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method 'movingTextreturn2'
    private void movingTextreturn2() {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textReturn, View.TRANSLATION_Y, -500);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textReturn, View.TRANSLATION_X, -500);
        //Fade out picture of 'return'.
        ObjectAnimator t3 = ObjectAnimator.ofFloat(textReturn, View.ALPHA, 0f);
        AnimatorSet am = new AnimatorSet();
        am.playSequentially(t1, t2, t3);
        am.setDuration(2000);
        am.start();

        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {


            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'movingtoOutput'
    private void movingtoOutput()
    {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,1000);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,700);
        ObjectAnimator t3 = ObjectAnimator.ofFloat(textResult,View.ALPHA,0f);
        //For going back to primary position.
        ObjectAnimator t11 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,0);
        ObjectAnimator t12 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,0);
        AnimatorSet am = new AnimatorSet();
        am.setDuration(2000);
        am.setInterpolator(new LinearInterpolator());
        am.playSequentially(t1,t2,t11,t12);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                playstep8();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }


    //movingSign's method
    private void movingSign()
    {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textsign,View.TRANSLATION_X,-510);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textsign,View.TRANSLATION_Y,340);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setDuration(1000);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Go to lime 20.
                testPointerLine20(560);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //movingSign's method
    private void movingSign2()
    {
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textsign,View.TRANSLATION_X,-510);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textsign,View.TRANSLATION_Y,340);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setDuration(1000);
        am.start();
    }
    //method 'gotop'
    private void gotop()
    {
        sv_code.scrollTo(0,0);
    }
    //movingValue's method
    private void movingValue()
    {
        /*textResult.setVisibility(View.VISIBLE);*/
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_X,505);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textResult,View.TRANSLATION_Y,570);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setDuration(1000);
        am.start();
        am.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method 'movingNums'
    private void movingNums()
    {
        //Moving num 1 and num 2 into center of circle by using AnimatorSet.
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_X,250);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum1,View.TRANSLATION_Y,-350);
        AnimatorSet am = new AnimatorSet();
        am.playTogether(t1,t2);
        am.setInterpolator(new LinearInterpolator());
        am.setDuration(5000);
        am.start();

        ObjectAnimator u1 = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_X,-250);
        ObjectAnimator u2 = ObjectAnimator.ofFloat(textnum2,View.TRANSLATION_Y,-350);
        AnimatorSet am1 = new AnimatorSet();
        am1.playTogether(u1,u2);
        am1.setInterpolator(new LinearInterpolator());
        am1.setDuration(5000);
        am1.start();

        //Add animatorSet Listener
        am1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                playstep3();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method'flipnum1'
    private void flipnum1()
    {
        textnum1.setVisibility(View.VISIBLE);
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textnum1,View.ROTATION_Y,360);
        t1.setDuration(2000);;
        t1.start();
       t1.addListener(new Animator.AnimatorListener() {
           @Override
           public void onAnimationStart(Animator animator) {

           }

           @Override
           public void onAnimationEnd(Animator animator) {
               testPointerLine16(320);
           }

           @Override
           public void onAnimationCancel(Animator animator) {

           }

           @Override
           public void onAnimationRepeat(Animator animator) {

           }
       });

    }
    //method'flipnum1'
    private void flipnum1_1()
    {
        textnum1.setVisibility(View.VISIBLE);
        ObjectAnimator t1 = ObjectAnimator.ofFloat(textnum1,View.ROTATION_Y,360);
        t1.setDuration(2000);;
        t1.start();
        t1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                testPointerLine16_1(320);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }
    //method'flipnum2'
    private void flipnum2()
    {
        textnum2.setVisibility(View.VISIBLE);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum2,View.ROTATION_Y,360);
        t2.setDuration(2000);
        t2.start();
        t2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Starting at line 4
                playstep5();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method'flipnum2_1'
    private void flipnum2_1()
    {
        textnum2.setVisibility(View.VISIBLE);
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum2,View.ROTATION_Y,360);
        t2.setDuration(2000);
        t2.start();
        t2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                playstep6();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method'flipnum2_2'
    private void flipnum2_2()
    {
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum2,View.ROTATION_Y,360);
        t2.setDuration(1000);
        t2.start();
        t2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                playstep9();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //flipnum1_2
    private void flipnum1_2()
    {
        ObjectAnimator t2 = ObjectAnimator.ofFloat(textnum2,View.ROTATION_Y,360);
        t2.setDuration(2000);
        t2.start();
        t2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                    testPointerLine16_2(320);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //methd 'startMoving'
    private void startMoving()
    {
        new Thread(new Runnable() {
            @Override
            public void run()
            {

                //Checking what 'CheckingControl' is ?
                if(checkControl)
                {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    checkControl = false;
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //Scrolling the code to top edge.
                            sv_code.scrollTo(0,0);
                        }
                    });
                    //Looping when 'CheckControl' is false.
                    while(!checkControl)
                    {
                        try
                        {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_code.scrollBy(0,1);
                                    //If reachs the bottom line of code then stops it.
                                    if(sv_code.getScrollY()==layout_code.getBottom()-370)
                                    {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        checkControl=true;
                                    }
                                }
                            });
                            //Slowing speed of scroll down.
                            Thread.sleep(timeThread);
                        }
                        //To handle ThreadException by handler 'InteruptException'.
                        catch (InterruptedException e) {}
                    }
                }
               //If 'checkControl' is not 'true' then makes it 'true'.
                else
                {
                    checkControl =true;
                }
            }
        }
        //This statement for starting the new thread execution.
        ).start();
    }

    //method 'stopPlaying()'
    private void stopPlaying()
    {
        //Cancelling scroll down the code example's picture. By using boolean = 'true'
        checkControl=true;
        //taking a code's picture scrolls to the top.
        sv_code.scrollTo(0,0);
        /*Calling object of Class 'Chap1' then
        call method name 'testPointer' to make pointer go to startpoint*/
        testPointer(0);

    }

    //method 'testPointer'
    private void testPointer(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
    }
    //method 'testPointerLine4'
    private void testPointerLine4(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setVisibility(View.VISIBLE);
                testPointerLine5(235);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method 'testPointerLine4_1'
    private void testPointerLine4_1(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(3000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setVisibility(View.VISIBLE);
                testPointerLine5_1(235);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method 'testPointerLine14_1'
    private void testPointerLine14_1(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                testPointerLine15_1(260);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //testpointerLine14_2
    private void testPointerLine14_2(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                    testPointerLine15_2(260);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'testPointerLine5'
    private void testPointerLine5(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setVisibility(View.VISIBLE);
                movingValue();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'testPointerLine5_1'
    private void testPointerLine5_1(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(3000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textResult.setVisibility(View.VISIBLE);
                //Going down
                startMoving();
                //Going to line 14
                testPointerLine14_1(200);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method 'testPointerLine6'
    private void testPointerLine6(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Showing output picture
                output.setVisibility(View.VISIBLE);
               movingtoOutput();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'testPointerLine7'
    private void testPointerLine7(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startMoving();
                testPointerLine14_2(200);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'testPointerLine15'
    private void testPointerLine15(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                flipnum1();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //method 'testPointerLine15_1'
    private void testPointerLine15_1(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
               testPointerLine16_1(320);

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //method 'testPointerLine15_2'
    private void testPointerLine15_2(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                flipnum1_2();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //TestPointerLine16
    private void testPointerLine16(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                flipnum2();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //TestPointerLine16_1
    private void testPointerLine16_1(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                playstep6();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //TestPointerLine16_2
    private void testPointerLine16_2(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                flipnum2_2();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //TestPointer line 19
    private void testPointerLine19(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Showing mathematical sign
                textsign.setVisibility(View.VISIBLE);
                //moving mathematical sign to a position.
                movingSign();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Testpointer line 20
    private void testPointerLine20(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                textReturn.setVisibility(View.VISIBLE);
                movingTextreturn();
             }
            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //testPointer line 23
    private void testPointerLine23(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
              textsign.setText("-");
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //testpointer line 24
    private void testPointerLine24(int a)
    {
        /*Creating object of class 'ObjectAnimator' and configs these properties.
        * The important of this statement is parameter 'a' which will moving pointer on px mode*/
        ObjectAnimator test1 = ObjectAnimator.ofFloat(imgPointer,View.TRANSLATION_Y,a);
        /*Setting time for moving.This time is milliseconds,NOT seconds.*/
        test1.setDuration(2000);
        test1.setInterpolator(new LinearInterpolator());
        /*Starting a pointer's moving*/
        test1.start();
        test1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                flipnum2();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    //Calling method 'OnBackPressed.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Going back to FirstPage's Activity.
        //Creating intent.
        intent = new Intent(this,Content.class);
        //Going to that activity's name in the intent that created.
        startActivity(intent);
        //Closing this activity.
        finish();
    }
}
