package com.example.john.project1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Chapter2 extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Thread.currentThread().interrupt();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        sv_code.scrollTo(0, 0);


    }

    @Override
    protected void onResume() {
        super.onResume();
        sv_code.scrollTo(0, 0);
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Thread.currentThread().interrupt();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    ImageButton playbtn, stopbtn, pausebtn;
    ImageView pointer, pic_class_chap2;
    ScrollView sv_code;
    LinearLayout layoutcode;
    Boolean checkScrolling = true;
    String checkStateChap2 = "";
    TextView num1, num2, sign, result, text_returnChap2,
            resultChap2text, text_num1, text_num2, object,
            text_plus, text_minus, text_multi, text_divide, class_chap2;
    AnimatorSet amMovingNum, amMovingNum2, amMovingtextToResultBoxPlus, amMovingtextToResultBoxMinus, amMovingtextToResultBoxMulti, amMovingtextToResultBoxDivide;
    ObjectAnimator objline1, objline2, objline3, objline17, objline29, objline30, objline31,
            objline32, objline18, objline3_1, objline5, objline35, objline5_1, objline6, objline7,
            objline39, objline7_1, objline8, objline9, objline20, objline9_1, objline10, objline11, objline23, objline11_1, objline12,objline36,objline40,objline21,objline24;
    int Delaytime = 2000, count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        playbtn = (ImageButton) findViewById(R.id.playbtnChap2);
        pausebtn = (ImageButton) findViewById(R.id.pausebtnChap2);
        stopbtn = (ImageButton) findViewById(R.id.stopbtnChap2);
        pointer = (ImageView) findViewById(R.id.pointer);
        sv_code = (ScrollView) findViewById(R.id.sv_codePM);
        layoutcode = (LinearLayout) findViewById(R.id.layout_code2);
        num1 = (TextView) findViewById(R.id.num1_chap2);
        num2 = (TextView) findViewById(R.id.num2_chap2);
        sign = (TextView) findViewById(R.id.sign_chap2);
        result = (TextView) findViewById(R.id.result_chap2);
        text_returnChap2 = (TextView) findViewById(R.id.text_return_chap2);
        resultChap2text = (TextView) findViewById(R.id.result_chap2_text);
        object = (TextView) findViewById(R.id.object);
        text_num1 = (TextView) findViewById(R.id.text_num1);
        text_num2 = (TextView) findViewById(R.id.text_num2);
        text_plus = (TextView) findViewById(R.id.text_plus);
        text_minus = (TextView) findViewById(R.id.text_minus);
        text_multi = (TextView) findViewById(R.id.text_multi);
        text_divide = (TextView) findViewById(R.id.text_divide);
        pic_class_chap2 = (ImageView) findViewById(R.id.pic_class_chap2);
        class_chap2 = (TextView) findViewById(R.id.class_chap2);
        sv_code.scrollTo(0, 0);
        prepare();
       /* #87D37C*/
        pic_class_chap2.setImageResource(R.drawable.inherit_new2);
        pic_class_chap2.setVisibility(View.VISIBLE);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Chapter2.this, "Start!", Toast.LENGTH_SHORT).show();
                final Toast toadstart = Toast.makeText(Chapter2.this,"คลาสแม่คือคลาส Calculator คลาสลูกคือคลาส MyCalculator",Toast.LENGTH_SHORT);
                new CountDownTimer(9000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toadstart.show();
                    }

                    @Override
                    public void onFinish() {
                        pic_class_chap2.setVisibility(View.INVISIBLE);
                        testPointerLine1();
                    }
                }.start();
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread.currentThread().interrupt();
                recreate();
                sv_code.scrollTo(0,0);
            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count % 2 != 0) {
                    callingPause();
                    count += 1;
                } else if (count % 2 == 0) {
                    callingResume();
                    count += 1;
                }
            }
        });
    }

    //method CallingPuase
    private void callingPause() {
        if (checkStateChap2.equals("line1")) {
            objline1.pause();
            Log.d("Animation", "Line 1 Paused");
        } else if (checkStateChap2.equals("line2")) {
            objline2.pause();
            Log.d("Animation", "Line 2 Paused");
        } else if (checkStateChap2.equals("line3")) {
            objline3.pause();

            Log.d("Animation", "Line 3 Paused");
        } else if (checkStateChap2.equals("checkingnumbersmoving")) {
            amMovingNum.pause();

            Log.d("Animation", "movingNums Paused");
        } else if (checkStateChap2.equals("line17")) {
            objline17.pause();

            Log.d("Animation", "Line 17 Paused");
        } else if (checkStateChap2.equals("line29")) {
            objline29.pause();

            Log.d("Animation", "Line 29 Paused");
        } else if (checkStateChap2.equals("line30")) {
            objline30.pause();

            Log.d("Animation", "Line 30 Paused");
        } else if (checkStateChap2.equals("line31")) {
            objline31.pause();

            Log.d("Animation", "Line 31 Paused");
        } else if (checkStateChap2.equals("line32")) {
            objline32.pause();

            Log.d("Animation", "Line 32 Paused");
        } else if (checkStateChap2.equals("line18")) {
            objline18.pause();

            Log.d("Animation", "Line 18 Paused");
        } else if (checkStateChap2.equals("line3_1")) {
            objline3_1.pause();

            Log.d("Animation", "Line 3_1 Paused");
        } else if (checkStateChap2.equals("line5")) {
            objline5.pause();

            Log.d("Animation", "Line 5 Paused");
        } else if (checkStateChap2.equals("line35")) {
            objline35.pause();

            Log.d("Animation", "Line 35 Paused");
        } else if (checkStateChap2.equals("movingtextToResultBoxPlus")) {
            amMovingtextToResultBoxPlus.pause();

            Log.d("Animation", "AnimationPlus Paused");
        } else if (checkStateChap2.equals("line5_1")) {
            objline5_1.pause();

            Log.d("Animation", "Line 5_1 Paused");
        } else if (checkStateChap2.equals("line6")) {
            objline6.pause();

            Log.d("Animation", "Line 6 Paused");
        } else if (checkStateChap2.equals("line7")) {
            objline7.pause();

            Log.d("Animation", "Line 7 Paused");
        } else if (checkStateChap2.equals("line39")) {
            objline39.pause();

            Log.d("Animation", "Line 39 Paused");
        } else if (checkStateChap2.equals("movingtextToResultBoxMinus")) {
            amMovingtextToResultBoxMinus.pause();

            Log.d("Animation", "AnimationMinus Paused");
        } else if (checkStateChap2.equals("line7_1")) {
            objline7_1.pause();

            Log.d("Animation", "Line 7_1 Paused");
        } else if (checkStateChap2.equals("line8")) {
            objline8.pause();

            Log.d("Animation", "Line 8 Paused");
        } else if (checkStateChap2.equals("line9")) {
            objline9.pause();

            Log.d("Animation", "Line 9 Paused");
        } else if (checkStateChap2.equals("line20")) {
            objline20.pause();

            Log.d("Animation", "Line 20 Paused");
        } else if (checkStateChap2.equals("movingtextToResultBoxMultiply")) {
            amMovingtextToResultBoxMulti.pause();

            Log.d("Animation", "AnimationMultiply Paused");
        } else if (checkStateChap2.equals("line9_1")) {
            objline9_1.pause();

            Log.d("Animation", "Line 9_1 Paused");
        } else if (checkStateChap2.equals("line10")) {
            objline10.pause();

            Log.d("Animation", "Line 10 Paused");
        } else if (checkStateChap2.equals("line11")) {
            objline11.pause();

            Log.d("Animation", "Line 11 Paused");
        } else if (checkStateChap2.equals("line23")) {
            objline23.pause();

            Log.d("Animation", "Line 23 Paused");
        } else if (checkStateChap2.equals("movingtextToResultBoxDivide")) {
            amMovingtextToResultBoxDivide.pause();

            Log.d("Animation", "AnimationDivide Paused");
        } else if (checkStateChap2.equals("line11_1")) {
            objline11_1.pause();

            Log.d("Animation", "Line 11_1 Paused");
        } else if (checkStateChap2.equals("line12")) {
            objline12.pause();

            Log.d("Animation", "Line 12 Paused");
        }
    }

    //method callingResume()
    private void callingResume() {
        if (checkStateChap2.equals("line1")) {
            objline1.resume();

            Log.d("Animation", "Line 1 resume");
        } else if (checkStateChap2.equals("line2")) {
            objline2.resume();

            Log.d("Animation", "Line 2 resume");
        } else if (checkStateChap2.equals("line3")) {
            objline3.resume();

            Log.d("Animation", "Line 3 resume");
        } else if (checkStateChap2.equals("checkingnumbersmoving")) {
            amMovingNum.resume();

            Log.d("Animation", "movingNums resume");
        } else if (checkStateChap2.equals("line17")) {
            objline17.resume();

            Log.d("Animation", "Line 17 resume");
        } else if (checkStateChap2.equals("line29")) {
            objline29.resume();

            Log.d("Animation", "Line 29 resume");
        } else if (checkStateChap2.equals("line30")) {
            objline30.resume();

            Log.d("Animation", "Line 30 resume");
        } else if (checkStateChap2.equals("line31")) {
            objline31.resume();

            Log.d("Animation", "Line 31 resume");
        } else if (checkStateChap2.equals("line32")) {
            objline32.resume();

            Log.d("Animation", "Line 32 resume");
        } else if (checkStateChap2.equals("line18")) {
            objline18.resume();

            Log.d("Animation", "Line 18 resume");
        } else if (checkStateChap2.equals("line3_1")) {
            objline3_1.resume();

            Log.d("Animation", "Line 3_1 resume");
        } else if (checkStateChap2.equals("line5")) {
            objline5.resume();

            Log.d("Animation", "Line 5 resume");
        } else if (checkStateChap2.equals("line35")) {
            objline35.resume();

            Log.d("Animation", "Line 35 resume");
        } else if (checkStateChap2.equals("movingtextToResultBoxPlus")) {
            amMovingtextToResultBoxPlus.resume();

            Log.d("Animation", "AnimationPlus resume");
        } else if (checkStateChap2.equals("line5_1")) {
            objline5_1.resume();

            Log.d("Animation", "Line 5_1 resume");
        } else if (checkStateChap2.equals("line6")) {
            objline6.resume();

            Log.d("Animation", "Line 6 resume");
        } else if (checkStateChap2.equals("line7")) {
            objline7.resume();

            Log.d("Animation", "Line 7 resume");
        } else if (checkStateChap2.equals("line39")) {
            objline39.resume();

            Log.d("Animation", "Line 39 resume");
        } else if (checkStateChap2.equals("movingtextToResultBoxMinus")) {
            amMovingtextToResultBoxMinus.resume();

            Log.d("Animation", "AnimationMinus resume");
        } else if (checkStateChap2.equals("line7_1")) {
            objline7_1.resume();

            Log.d("Animation", "Line 7_1 resume");
        } else if (checkStateChap2.equals("line8")) {
            objline8.resume();

            Log.d("Animation", "Line 8 resume");
        } else if (checkStateChap2.equals("line9")) {
            objline9.resume();

            Log.d("Animation", "Line 9 resume");
        } else if (checkStateChap2.equals("line20")) {
            objline20.resume();

            Log.d("Animation", "Line 20 resume");
        } else if (checkStateChap2.equals("movingtextToResultBoxMultiply")) {
            amMovingtextToResultBoxMulti.resume();

            Log.d("Animation", "AnimationMultiply resume");
        } else if (checkStateChap2.equals("line9_1")) {
            objline9_1.resume();

            Log.d("Animation", "Line 9_1 resume");
        } else if (checkStateChap2.equals("line10")) {
            objline10.resume();

            Log.d("Animation", "Line 10 resume");
        } else if (checkStateChap2.equals("line11")) {
            objline11.resume();

            Log.d("Animation", "Line 11 resume");
        } else if (checkStateChap2.equals("line23")) {
            objline23.resume();

            Log.d("Animation", "Line 23 resume");
        } else if (checkStateChap2.equals("movingtextToResultBoxDivide")) {
            amMovingtextToResultBoxDivide.resume();

            Log.d("Animation", "AnimationDivide resume");
        } else if (checkStateChap2.equals("line11_1")) {
            objline11_1.resume();

            Log.d("Animation", "Line 11_1 resume");
        } else if (checkStateChap2.equals("line12")) {
            objline12.resume();

            Log.d("Animation", "Line 12 resume");
        }
    }

    //Method Prepare to hide    objects
    private void prepare() {
        sv_code.scrollTo(0, 0);
        text_returnChap2.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        num1.setVisibility(View.INVISIBLE);
        num2.setVisibility(View.INVISIBLE);
        sign.setVisibility(View.INVISIBLE);
        object.setVisibility(View.INVISIBLE);
        resultChap2text.setVisibility(View.INVISIBLE);
        text_num1.setVisibility(View.INVISIBLE);
        text_num2.setVisibility(View.INVISIBLE);
        text_plus.setVisibility(View.INVISIBLE);
        text_minus.setVisibility(View.INVISIBLE);
        text_multi.setVisibility(View.INVISIBLE);
        text_divide.setVisibility(View.INVISIBLE);
        pic_class_chap2.setVisibility(View.INVISIBLE);
    }


    private void testPointerLine1() {
        checkStateChap2 = "line1";
        objline1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 0);
        objline1.setDuration(500);
        objline1.start();
        objline1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pic_class_chap2.setImageResource(R.drawable.color_green);
                pic_class_chap2.setScaleType(ImageView.ScaleType.FIT_XY);
                pic_class_chap2.setVisibility(View.VISIBLE);
                class_chap2.setVisibility(View.VISIBLE);
                testPointerLine2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line2
    private void testPointerLine2() {
        checkStateChap2 = "line2";
        objline2 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 60);
        objline2.setDuration(3000);
        objline2.start();
        objline2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final Toast toastline2 = Toast.makeText(Chapter2.this, "โปรแกรมเริ่มทำงานที่เมธอด main", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline2.show();
                    }

                    @Override
                    public void onFinish() {
                        testPointerLine3();
                    }
                }.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void testPointerLine3() {
        checkStateChap2 = "line3";
        objline3 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 125);
        objline3.setDuration(2000);
        objline3.setInterpolator(new LinearInterpolator());
        objline3.start();
        objline3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pic_class_chap2.setImageResource(R.drawable.shape_circle_class);
                pic_class_chap2.setBackgroundColor(Color.parseColor("#87D37C"));
                object.setVisibility(View.VISIBLE);
                num1.setVisibility(View.VISIBLE);
                num2.setVisibility(View.VISIBLE);
                final Toast toastline3 = Toast.makeText(Chapter2.this, "สร้าง object จากคลาส MyCalculator โดยส่งค่า 10 และ 5 เข้าไปยัง constructor", Toast.LENGTH_LONG);
                new CountDownTimer(9000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline3.show();
                    }

                    @Override
                    public void onFinish() {
                        checkingnumbersmoving();
                    }
                }.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Checking number moving
    private void checkingnumbersmoving() {
        checkStateChap2 = "checkingnumbersmoving";
        ObjectAnimator objnum1_x = ObjectAnimator.ofFloat(num1, View.TRANSLATION_X, 250);
        ObjectAnimator objnum1_y = ObjectAnimator.ofFloat(num1, View.TRANSLATION_Y, -350);
        amMovingNum = new AnimatorSet();
        amMovingNum.setDuration(3000);
        amMovingNum.setInterpolator(new LinearInterpolator());
        amMovingNum.playTogether(objnum1_x, objnum1_y);
        amMovingNum.start();
        amMovingNum.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_num1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator objnum2_x = ObjectAnimator.ofFloat(num2, View.TRANSLATION_X, -250);
        ObjectAnimator objnum2_y = ObjectAnimator.ofFloat(num2, View.TRANSLATION_Y, -350);
        amMovingNum2 = new AnimatorSet();
        amMovingNum2.setDuration(3000);
        amMovingNum2.setInterpolator(new LinearInterpolator());
        amMovingNum2.playTogether(objnum2_x, objnum2_y);
        ;
        amMovingNum2.start();
        amMovingNum2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {


            }

            @Override
            public void onAnimationEnd(Animator animator) {
                text_num2.setVisibility(View.VISIBLE);
                // scrolling down
                testScrollingDown(2200);
                testPointerLine17();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line17
    private void testPointerLine17() {
        checkStateChap2 = "line17";
        objline17 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 680);
        objline17.setDuration(2000);
        objline17.start();
        objline17.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                num1.setText("0");
                num2.setText("0");
               final Toast toadline17 = Toast.makeText(Chapter2.this, "super หมายถึงการเรียก constructor ของคลาสที่สืบทอด จึงส่งค่าไปทำงานที่ constructor ของคลาสแม่", Toast.LENGTH_LONG);
                new CountDownTimer(9000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toadline17.show();
                    }

                    @Override
                    public void onFinish() {
                        new CountDownTimer(5000,1000)
                        {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                testScrollingDown(1400);
                                testPointerLine29();
                            }
                        }.start();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line29
    private void testPointerLine29() {
        checkStateChap2 = "line29";
        objline29 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 610);
        objline29.setDuration(4000);
        objline29.start();
        objline29.setStartDelay(Delaytime);
        objline29.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                testPointerLine30();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void testPointerLine30() {
        checkStateChap2 = "line30";
        objline30 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 670);
        objline30.setDuration(3800);
        objline30.start();
        objline30.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                testPointerLine31();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line31
    private void testPointerLine31() {
        checkStateChap2 = "line31";
        objline31 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 730);
        objline31.setDuration(3800);
        objline31.start();
        objline31.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                num1.setText("10");
                final Toast toastline31 = Toast.makeText(Chapter2.this, "กำหนดค่าให้กับตัวแปร num1", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline31.show();
                    }

                    @Override
                    public void onFinish() {
                        testPointerLine32();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void testPointerLine32() {
        checkStateChap2 = "line32";
        objline32 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 790);
        objline32.setDuration(3800);
        objline32.start();
        objline32.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                num2.setText("5");
               final Toast toadline32 = Toast.makeText(Chapter2.this, "กำหนดค่าให้กับตัวแปร num2", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toadline32.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingUp(2000);
                        testPointeLine18();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line18
    private void testPointeLine18() {
        checkStateChap2 = "line18";
        objline18 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 550);
        objline18.setDuration(7000);
        objline18.start();
        objline18.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                testScrollingUp(2480);
                testPointerLine3_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Line3_1
    private void testPointerLine3_1() {
        checkStateChap2 = "line3_1";
        objline3_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 125);
        objline3_1.setDuration(4000);
        objline3_1.start();
        objline3_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Chapter2.this, "object พร้อมใช้งาน", Toast.LENGTH_SHORT).show();
                testPointerLine5();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line5
    private void testPointerLine5() {
        checkStateChap2 = "line5";
        objline5 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 240);
        objline5.setDuration(4000);
        objline5.start();
        objline5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                result.setText("");
                result.setVisibility(View.VISIBLE);
                resultChap2text.setVisibility(View.VISIBLE);
               final Toast toastline5 =  Toast.makeText(Chapter2.this, "เรียกเมธอด plus() ซึ่งอยู่ในคลาสแม่", Toast.LENGTH_LONG);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline5.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingDown(1000);
                        testPointerLine35();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line35
    private void testPointerLine35() {
        checkStateChap2 = "line35";
        objline35 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 570);
        objline35.setDuration(9000);
        objline35.start();
        objline35.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                sign.setText("+");
                sign.setVisibility(View.VISIBLE);
                text_returnChap2.setVisibility(View.VISIBLE);
               final Toast toastline35 = Toast.makeText(Chapter2.this, "คำนวณโดยใช้ค่าจาก attribute ของคลาส", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline35.show();
                    }

                    @Override
                    public void onFinish() {
                        line36();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line36
    private void line36()
    {
        checkStateChap2="line36";
        objline36 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,630);
        objline36.setDuration(4000);
        objline36.setInterpolator(new LinearInterpolator());
        objline36.start();
        objline36.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final Toast toadline36 = Toast.makeText(Chapter2.this,"ส่งผลลัพธ์จากการคำนวณกลับไปยังส่วนที่เรียก",Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toadline36.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingUp(2480);
                        testPointerLine5_1();
                    }
                }.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }
    //movingtextToResult method
    private void movingtextToResultBoxPlus() {
        checkStateChap2 = "movingtextToResultBoxPlus";
        Toast.makeText(Chapter2.this, "ส่งค่าผลลัพธ์ที่ได้จากการคำนวณกลับไปที่ตัวแปร result", Toast.LENGTH_SHORT).show();
        ObjectAnimator objGoX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, -500);
        objGoX.setDuration(1000);
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, -450);
        objGoY.setDuration(1000);
        //Hidding
        ObjectAnimator objHide = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 0f);
        objHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, 0);
        objReturnX.setDuration(50);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, 0);
        objReturnY.setDuration(50);
        //Showing
        ObjectAnimator objShow = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 1f);
        amMovingtextToResultBoxPlus = new AnimatorSet();
        amMovingtextToResultBoxPlus.playSequentially(objGoX, objGoY, objHide, objReturnX, objReturnY, objShow);
        checkStateChap2 = "amMovingtextToResultBoxPlus";
        amMovingtextToResultBoxPlus.start();
        amMovingtextToResultBoxPlus.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                testPointerLine6();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line5_1
    private void testPointerLine5_1() {
        checkStateChap2 = "line5_1";
        objline5_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 240);
        objline5_1.setDuration(9000);
        objline5_1.start();
        objline5_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                movingtextToResultBoxPlus();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line 6
    private void testPointerLine6() {
        checkStateChap2 = "line6";
        objline6 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 300);
        objline6.setDuration(4000);
        objline6.start();
        objline6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                result.setText("15");
                text_plus.setVisibility(View.VISIBLE);
               final Toast tostline6 = Toast.makeText(Chapter2.this, "แสดงผลลัพธ์ออกทางหน้าจอ", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        tostline6.show();
                    }

                    @Override
                    public void onFinish() {
                        testPointerLine7();
                    }
                }.start();
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
    private void testPointerLine7() {
        checkStateChap2 = "line7";
        objline7 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 365);
        objline7.setDuration(4000);
        objline7.start();
        objline7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final Toast toastline7 = Toast.makeText(Chapter2.this, "เรียกเมธอด minus() ซึ่งอยู่ในคลาสแม่", Toast.LENGTH_LONG);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline7.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingDown(1000);
                        testPointerLine39();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line39
    private void testPointerLine39() {
        checkStateChap2 = "line39";
        objline39 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 810);
        objline39.setDuration(9000);
        sign.setText("-");
        objline39.start();
        objline39.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setText("5");
                text_returnChap2.setVisibility(View.VISIBLE);
                final Toast toastline39 =  Toast.makeText(Chapter2.this, "คำนวณโดยใช้ค่าจาก attribute ของคลาส", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline39.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingUp(2480);
                        testPointerLine7_1();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Minus animation
    private void movingtextToResultBoxMinus() {
        checkStateChap2 = "movingtextToResultBoxMinus";
        Toast.makeText(Chapter2.this, "ส่งค่าผลลัพธ์ที่ได้จากการคำนวณกลับไปที่ตัวแปร result", Toast.LENGTH_SHORT).show();
        ObjectAnimator objGoX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, -500);
        objGoX.setDuration(1000);
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, -450);
        objGoY.setDuration(1000);
        //Hidding
        ObjectAnimator objHide = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 0f);
        objHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setVisibility(View.INVISIBLE);
                result.setText("");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, 0);
        objReturnX.setDuration(50);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, 0);
        objReturnY.setDuration(50);
        ObjectAnimator objshow = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 1f);
        amMovingtextToResultBoxMinus = new AnimatorSet();
        amMovingtextToResultBoxMinus.playSequentially(objGoX, objGoY, objHide, objReturnX, objReturnY, objshow);
        amMovingtextToResultBoxMinus.start();
        amMovingtextToResultBoxMinus.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                testPointerLine8();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //Line7_1
    private void testPointerLine7_1() {
        checkStateChap2 = "line7_1";
        objline7_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 365);
        objline7_1.setDuration(9000);
        objline7_1.start();
        objline7_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                movingtextToResultBoxMinus();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line8
    private void testPointerLine8() {
        checkStateChap2 = "line8";
        objline8 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 420);
        objline8.setDuration(4000);
        objline8.start();
        objline8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                result.setText("5");
                text_minus.setVisibility(View.VISIBLE);
               final Toast toastline8 = Toast.makeText(Chapter2.this, "แสดงผลลัพธ์ออกทางหน้าจอ", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline8.show();
                    }

                    @Override
                    public void onFinish() {
                        testPointerLine9();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line9
    private void testPointerLine9() {
        checkStateChap2 = "line9";
        objline9 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 485);
        objline9.setDuration(9000);
        objline9.start();
        objline9.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
              final Toast toastline9 =  Toast.makeText(Chapter2.this, "เรียกใช้เมธอด multiply() ซึ่งอยู่ในคลาสลูก", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline9.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingDown(1700);
                        testPointerLine20();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line20
    private void testPointerLine20() {
        checkStateChap2 = "line20";
        sign.setText("*");
        objline20 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 360);
        objline20.setDuration(7000);
        objline20.start();
        objline20.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setText("50");
                text_returnChap2.setVisibility(View.VISIBLE);
               final Toast toastline20 = Toast.makeText(Chapter2.this, "คำนวณโดยใช้ค่าจาก attribute ของคลาส", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline20.show();
                    }
                    @Override
                    public void onFinish() {
                        line21();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }//line21
    private void line21()
    {
        objline21 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,420);
        objline21.setDuration(4000);
        objline21.setInterpolator(new LinearInterpolator());
        objline21.start();
        objline21.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final Toast toastline21 = Toast.makeText(Chapter2.this,"ส่งผลลัพธ์จากการคำนวณกลับไปยังส่วนที่เรียก",Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline21.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingUp(2480);
                        testPointerLine9_1();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //multiply animation
    private void movingtextToResultBoxMutiply() {
        checkStateChap2 = "movingtextToResultBoxMultiply";

        Toast.makeText(Chapter2.this, "ส่งค่าผลลัพธ์ที่ได้จากการคำนวณกลับไปที่ตัวแปร result", Toast.LENGTH_SHORT).show();
        ObjectAnimator objGoX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, -500);
        objGoX.setDuration(1000);
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, -450);
        objGoY.setDuration(1000);
        //Hidding
        ObjectAnimator objHide = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 0f);
        objHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setVisibility(View.INVISIBLE);
                result.setText("");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, 0);
        objReturnX.setDuration(50);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, 0);
        objReturnY.setDuration(50);
        //Showing
        ObjectAnimator objShow = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 1f);
        amMovingtextToResultBoxMulti = new AnimatorSet();
        amMovingtextToResultBoxMulti.playSequentially(objGoX, objGoY, objHide, objReturnX, objReturnY, objShow);
        amMovingtextToResultBoxMulti.start();
        amMovingtextToResultBoxMulti.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                testPointerLine10();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //line9_1
    private void testPointerLine9_1() {
        checkStateChap2 = "line9_1";
        objline9_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 485);
        objline9_1.setDuration(4000);
        objline9_1.start();
        objline9_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                movingtextToResultBoxMutiply();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line10
    private void testPointerLine10() {
        checkStateChap2 = "line10";
        objline10 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 540);
        objline10.setDuration(4000);
        objline10.start();
        objline10.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                result.setText("50");
                text_multi.setVisibility(View.VISIBLE);
               final Toast toastline10 = Toast.makeText(Chapter2.this, "แสดงผลลัพธ์ออกทางหน้าจอ", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline10.show();
                    }

                    @Override
                    public void onFinish() {
                        testPointerLine11();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line11
    private void testPointerLine11() {
        checkStateChap2 = "line11";
        objline11 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 600);
        objline11.setDuration(4000);
        objline11.start();
        objline11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
               final Toast toastline11 = Toast.makeText(Chapter2.this, "เรียกใช้เมธอด divide() ซึ่งอยู่ในคลาสลูก", Toast.LENGTH_SHORT);
                new CountDownTimer(9000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline11.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingDown(1700);
                        testPointerLine23();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line23
    private void testPointerLine23() {
        checkStateChap2 = "line23";
        sign.setText("/");
        text_returnChap2.setText("2");
        objline23 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 540);
        objline23.setDuration(7000);
        objline23.start();
        objline23.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setText("2");
                text_returnChap2.setVisibility(View.VISIBLE);
               final Toast toastline23 =  Toast.makeText(Chapter2.this, "คำนวณโดยใช้ค่าจาก attribute ของคลาส", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline23.show();
                    }

                    @Override
                    public void onFinish() {
                        line24();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //line24
    private void line24()
    {
        objline24 = ObjectAnimator.ofFloat(pointer,View.TRANSLATION_Y,600);
        objline24.setDuration(4000);
        objline24.setInterpolator(new LinearInterpolator());
        objline24.start();
        objline24.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final Toast toastline24 = Toast.makeText(Chapter2.this,"ส่งผลลัพธ์จากการคำนวณกลับไปยังส่วนที่เรียก",Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline24.show();
                    }

                    @Override
                    public void onFinish() {
                        testScrollingUp(2480);
                        testPointerLine11_1();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    //divide animation
    private void movingtextToResultBoxDivide() {
        checkStateChap2 = "movingtextToResultBoxDivide";
        text_returnChap2.setText("2");
        text_returnChap2.setVisibility(View.VISIBLE);
        Toast.makeText(Chapter2.this, "ส่งค่าผลลัพธ์ที่ได้จากการคำนวณกลับไปที่ตัวแปร result", Toast.LENGTH_SHORT).show();
        ObjectAnimator objGoX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, -500);
        objGoX.setDuration(1000);
        ObjectAnimator objGoY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, -450);
        objGoY.setDuration(1000);
        //Hidding
        ObjectAnimator objHide = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 0f);
        objHide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_returnChap2.setVisibility(View.INVISIBLE);
                result.setText("");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator objReturnX = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_X, 0);
        objReturnX.setDuration(50);
        ObjectAnimator objReturnY = ObjectAnimator.ofFloat(text_returnChap2, View.TRANSLATION_Y, 0);
        objReturnY.setDuration(50);
        ObjectAnimator objShow = ObjectAnimator.ofFloat(text_returnChap2, View.ALPHA, 1f);
        amMovingtextToResultBoxDivide = new AnimatorSet();
        amMovingtextToResultBoxDivide.playSequentially(objGoX, objGoY, objHide, objReturnX, objReturnY, objShow);
        amMovingtextToResultBoxDivide.start();
        amMovingtextToResultBoxDivide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                testPointerLine12();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //line11_1
    private void testPointerLine11_1() {
        checkStateChap2 = "line11_1";
        objline11_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 600);
        objline11_1.setDuration(4000);
        objline11_1.start();
        objline11_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                movingtextToResultBoxDivide();
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
    private void testPointerLine12() {
        checkStateChap2 = "line12";
        objline12 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 660);
        objline12.setDuration(4000);
        objline12.start();
        objline12.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                result.setText("2");
                text_divide.setVisibility(View.VISIBLE);
               final Toast toastline12 = Toast.makeText(Chapter2.this, "แสดงผลลัพธ์ออกทางหน้าจอ", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline12.show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(Chapter2.this,"Finish", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Scrolling up
    private void testScrollingUp(final int a) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //Checking what 'CheckingControl' is ?
                if (checkScrolling) {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    checkScrolling = false;
                    //Looping when 'CheckControl' is false.
                    while (!checkScrolling) {
                        try {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_code.scrollBy(0, -1);
                                    //If reachs the bottom line of code then stops it.
                                    if (sv_code.getScrollY() == layoutcode.getHeight() - a) {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        checkScrolling = true;
                                    }
                                }
                            });
                            //Slowing speed of scroll down.
                            Thread.sleep(5);
                        }
                        //To handle ThreadException by handler 'InteruptException'.
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //If 'checkControl' is not 'true' then makes it 'true'.
                else {
                    checkScrolling = true;
                }
            }
        }//This statement for starting the new thread execution.
        ).start();
    }

    //SCrolling down
    private void testScrollingDown(final int a) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //Checking what 'CheckingControl' is ?
                if (checkScrolling) {
                    //CheckControl is 'false' then Creates runOnUIThread's method.
                    checkScrolling = false;
                    //Looping when 'CheckControl' is false.
                    while (!checkScrolling) {
                        try {
                            //Creating runOnUiThread for scrolling down the code.
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Scrolling down the code every 1 px.
                                    sv_code.scrollBy(0, 1);
                                    //If reachs the bottom line of code then stops it.
                                    if (sv_code.getScrollY() == layoutcode.getBottom() - a) {

                                        //Changing 'checkControl' to 'true' for exit while loop.
                                        checkScrolling = true;
                                    }
                                }
                            });
                            //Slowing speed of scroll down.
                            Thread.sleep(5);
                        }
                        //To handle ThreadException by handler 'InteruptException'.
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //If 'checkControl' is not 'true' then makes it 'true'.
                else {
                    checkScrolling = true;
                }
            }
        }//This statement for starting the new thread execution.
        ).start();
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, inheritance_teach.class);
        sv_code.scrollTo(0, 0);
        startActivity(intent);
        finish();
    }
}
