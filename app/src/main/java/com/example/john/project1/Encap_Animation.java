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
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Encap_Animation extends AppCompatActivity {
    ImageView pointer, code_encap, class_encap;
    TextView objEncap_text, classEncap_text, getter_text, setter_text, Getter_box, Setter_Box, output_header, output_result, text_parameter;
    LinearLayout output_layout;
    ImageButton PlaybtnEncap, PauseBtnEncap, StopBtnEncap;
    ObjectAnimator line11, line13, line1, line13_1, line14, line6, line7, line8, line14_1, line15, line3, line4, line5, line15_1;
    AnimatorSet movingAnimation, setAnimation, getAnimation;
    String CheckStateEncap = "";
    int countPush = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encap__animation);
        //ImageView
        pointer = (ImageView) findViewById(R.id.pointer_PM);
        code_encap = (ImageView) findViewById(R.id.code_encap);
        class_encap = (ImageView) findViewById(R.id.class_PM);

        //TextView
        objEncap_text = (TextView) findViewById(R.id.object_PM_text);
        classEncap_text = (TextView) findViewById(R.id.classPM_text);
        getter_text = (TextView) findViewById(R.id.getter_text);
        setter_text = (TextView) findViewById(R.id.setter_text);
        Getter_box = (TextView) findViewById(R.id.GetterName_box);
        Setter_Box = (TextView) findViewById(R.id.SetterName_box);
        output_header = (TextView) findViewById(R.id.output_header);
        output_result = (TextView) findViewById(R.id.output_reseult);
        text_parameter = (TextView) findViewById(R.id.text_parameter);
        //Linearlayout
        output_layout = (LinearLayout) findViewById(R.id.output_layoutPM);

        //ImageButtons
        PlaybtnEncap = (ImageButton) findViewById(R.id.playbtnEncap);
        PauseBtnEncap = (ImageButton) findViewById(R.id.pausebtnEncap);
        StopBtnEncap = (ImageButton) findViewById(R.id.stopbtn_encap);
        hide();
        //play btn
        PlaybtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Toast toast1 = Toast.makeText(Encap_Animation.this,"Start!",Toast.LENGTH_SHORT);
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toast1.show();
                    }

                    @Override
                    public void onFinish() {
                        GoLine11();
                    }
                }.start();
            }
        });
        //pause button
        PauseBtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    countPush += 1;
                    if (countPush % 2 != 0) {
                        PauseAnimation();
                    } else if (countPush % 2 == 0) {
                        ResumeAnimation();
                    }
                } catch (Exception e) {
                    Log.d("State", "Error happening!");
                    e.printStackTrace();
                }
            }
        });
        StopBtnEncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Encap_Animation.this, "stop", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
    }

    //pauseAnimation
    private void PauseAnimation() {
        if (CheckStateEncap.equals("line11")) {
            Log.d("State", "line11 paused");

            line11.pause();
        } else if (CheckStateEncap.equals("line13")) {
            Log.d("State", "line13 paused");

            line13.pause();
        } else if (CheckStateEncap.equals("line1")) {
            Log.d("State", "line1 paused");

            line1.pause();
        } else if (CheckStateEncap.equals("line13_1")) {
            Log.d("State", "line13_1 paused");

            line13_1.pause();
        } else if (CheckStateEncap.equals("line14")) {
            Log.d("State", "line14 paused");

            line14.pause();
        } else if (CheckStateEncap.equals("line6")) {
            Log.d("State", "line6 paused");

            line6.pause();
        } else if (CheckStateEncap.equals("line7")) {
            Log.d("State", "line7 paused");

            line7.pause();
        } else if (CheckStateEncap.equals("line8")) {
            Log.d("State", "line8 paused");
            line8.pause();
        } else if (CheckStateEncap.equals("line14")) {
            Log.d("State", "line14 paused");

            line14.pause();
        } else if (CheckStateEncap.equals("line15")) {
            Log.d("State", "line15 paused");

            line15.pause();
        } else if (CheckStateEncap.equals("line3")) {
            Log.d("State", "line3 paused");

            line3.pause();
        } else if (CheckStateEncap.equals("line4")) {
            Log.d("State", "line4 paused");

            line4.pause();
        } else if (CheckStateEncap.equals("line5")) {
            Log.d("State", "line5 paused");

            line5.pause();
        } else if (CheckStateEncap.equals("line15")) {
            Log.d("State", "line15_1 paused");

            line15_1.pause();
        } else if (CheckStateEncap.equals("playAnimation_text")) {
            Log.d("State", " movingAnimation paused");

            movingAnimation.pause();
        } else if (CheckStateEncap.equals("playsetAnimation")) {
            Log.d("State", "playsetAnimation paused");

            setAnimation.pause();
        } else if (CheckStateEncap.equals("playgetAnimation")) {
            Log.d("State", "playgetAnimation paused");

            getAnimation.pause();
        }
    }

    //PauseAniamtion
    private void ResumeAnimation() {
        if (CheckStateEncap.equals("line11")) {
            Log.d("State", "line11 resume");

            line11.resume();
        } else if (CheckStateEncap.equals("line13")) {
            Log.d("State", "line13 resume");

            line13.resume();
        } else if (CheckStateEncap.equals("line1")) {
            Log.d("State", "line1 resume");

            line1.resume();
        } else if (CheckStateEncap.equals("line13_1")) {
            Log.d("State", "line13_1 resume");

            line13_1.resume();
        } else if (CheckStateEncap.equals("line14")) {
            Log.d("State", "line14 resume");

            line14.resume();
        } else if (CheckStateEncap.equals("line6")) {
            Log.d("State", "line6 resumed");

            line6.resume();
        } else if (CheckStateEncap.equals("line7")) {
            Log.d("State", "line7 resume");

            line7.resume();
        } else if (CheckStateEncap.equals("line8")) {
            Log.d("State", "line8 resume");

            line8.resume();
        } else if (CheckStateEncap.equals("line14")) {
            Log.d("State", "line14 resume");

            line14.resume();
        } else if (CheckStateEncap.equals("line15")) {
            Log.d("State", "line15 resume");

            line15.resume();
        } else if (CheckStateEncap.equals("line3")) {
            Log.d("State", "line3 resume");

            line3.resume();
        } else if (CheckStateEncap.equals("line4")) {
            Log.d("State", "line4 resume");

            line4.resume();
        } else if (CheckStateEncap.equals("line5")) {
            Log.d("State", "line5 resume");

            line5.resume();
        } else if (CheckStateEncap.equals("line15")) {
            Log.d("State", "line15_1 resume");

            line15_1.resume();
        } else if (CheckStateEncap.equals("playAnimation_text")) {
            Log.d("State", " movingAnimation resume");

            movingAnimation.resume();
        } else if (CheckStateEncap.equals("playsetAnimation")) {
            Log.d("State", "playsetAnimation resume");

            setAnimation.resume();
        } else if (CheckStateEncap.equals("playgetAnimation")) {
            Log.d("State", "playgetAnimation resume");

            getAnimation.resume();
        }
    }

    //Hide object's method
    private void hide() {
        class_encap.setVisibility(View.INVISIBLE);
        classEncap_text.setVisibility(View.INVISIBLE);
        objEncap_text.setVisibility(View.INVISIBLE);
        getter_text.setVisibility(View.INVISIBLE);
        setter_text.setVisibility(View.INVISIBLE);
        Getter_box.setVisibility(View.INVISIBLE);
        Setter_Box.setVisibility(View.INVISIBLE);
        output_header.setVisibility(View.INVISIBLE);
        output_result.setVisibility(View.INVISIBLE);
        output_layout.setVisibility(View.INVISIBLE);
        text_parameter.setVisibility(View.INVISIBLE);
    }

    private void GoLine11() {
        CheckStateEncap = "line11";
        line11 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 610);
        line11.setDuration(3000);
        line11.start();
        line11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                class_encap.setVisibility(View.VISIBLE);
                classEncap_text.setVisibility(View.VISIBLE);
               final Toast toastline11 = Toast.makeText(Encap_Animation.this, "โปรแกรมเริ่มทำงานที่เมธอด main", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline11.show();
                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line11 finished");
                        GoLine13();
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

    //line13
    private void GoLine13() {
        CheckStateEncap = "line13";
        line13 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 720);
        line13.setDuration(3000);
        line13.start();
        line13.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                class_encap.setImageResource(R.drawable.shape_circle_class);
                objEncap_text.setVisibility(View.VISIBLE);
                final Toast toastline13 = Toast.makeText(Encap_Animation.this, "สร้าง object จากคลาส Employee", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline13.show();
                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line13 finished");
                        //Goline13 again
                        GoLine14();
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

    private void GoLine14() {
        CheckStateEncap = "line14";
        line14 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 780);
        line14.setDuration(3000);
        line14.start();
        line14.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                text_parameter.setVisibility(View.VISIBLE);
               final Toast toastline14 = Toast.makeText(Encap_Animation.this, "กำหนดค่าให้กับ attribute ของคลาส Employee ผ่านเมธอด setName()", Toast.LENGTH_SHORT);
                new CountDownTimer(9000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline14.show();
                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line14 finished");
                        //playAnimation
                        playAnimation_text();
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

    private void playAnimation_text() {
        CheckStateEncap = "playAnimation_text";
        ObjectAnimator goX = ObjectAnimator.ofFloat(text_parameter, View.TRANSLATION_Y, -85);
        ObjectAnimator goY = ObjectAnimator.ofFloat(text_parameter, View.TRANSLATION_X, 245);

        //AnimatorSet
        movingAnimation = new AnimatorSet();
        movingAnimation.playSequentially(goX, goY);
        movingAnimation.setDuration(3000);
        movingAnimation.start();
        movingAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "Animation_text finished");
                        //Goto Line6
                        GoLine6();
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

    //GoLine6
    private void GoLine6() {
        CheckStateEncap = "line6";
        line6 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 300);
        line6.setDuration(3000);
        line6.start();
        line6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
               new CountDownTimer(3000,1000)
               {
                   @Override
                   public void onTick(long millisUntilFinished) {

                   }

                   @Override
                   public void onFinish() {
                       setter_text.setVisibility(View.VISIBLE);
                       Setter_Box.setVisibility(View.VISIBLE);
                       Log.d("State", "line6 finished");
                       //Goto Line7
                       GoLine7();
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
    private void GoLine7() {
        CheckStateEncap = "line7";
        line7 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 360);
        line7.setDuration(4000);
        line7.start();
        line7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State", "line17 finished");
                //goLine8
               final Toast toastline7 = Toast.makeText(Encap_Animation.this, "กำหนดค่าให้กับ attribute empName", Toast.LENGTH_LONG);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline7.show();
                    }

                    @Override
                    public void onFinish() {
                        GoLine8();
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
    //GoLine8
    private void GoLine8() {
        CheckStateEncap = "line8";
        line8 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 420);
        line8.setDuration(6000);
        line8.start();
        line8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line8 finished");
                        //play setanimation
                        playsetAnimation();
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
    //play setAnimation
    private void playsetAnimation() {
        CheckStateEncap = "playsetAnimation";
        ObjectAnimator goY = ObjectAnimator.ofFloat(text_parameter, View.TRANSLATION_Y, -250);
        ObjectAnimator hide = ObjectAnimator.ofFloat(text_parameter, View.ALPHA, 0f);
        hide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Setter_Box.setText("Torn");
                Setter_Box.setTextColor(Color.parseColor("#FFFFFF"));
                Setter_Box.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator returnY = ObjectAnimator.ofFloat(text_parameter, View.TRANSLATION_Y, 0);
        //AnimatorSet
        setAnimation = new AnimatorSet();
        setAnimation.playSequentially(goY, hide, returnY);
        setAnimation.setDuration(2000);
        setAnimation.start();
        setAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State", "playsetAnimation finished");
                //Go to Line14_1
                GoLine14_1();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //Go Line14_1
    private void GoLine14_1() {
        CheckStateEncap = "line14_1";
        line14_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 790);
        line14_1.setDuration(3000);
        line14_1.start();
        line14_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line14_1 finished");
                        //Goline 15
                        GoLine15();
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

    //GoLine15
    private void GoLine15() {
        CheckStateEncap = "line15";
        line15 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 840);
        line15.setDuration(3000);
        line15.start();
        line15.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                final Toast toastline15 = Toast.makeText(Encap_Animation.this, "ดึงค่าจาก attribute ของคลาส Employee ผ่านเมธอด  getName()", Toast.LENGTH_SHORT);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline15.show();
                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line15 finished");
                        //GoLine3
                        GoLine3();
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

    //GoLine3
    private void GoLine3() {
        CheckStateEncap = "line3";
        line3 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 120);
        line3.setDuration(3000);
        line3.start();
        line3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        getter_text.setVisibility(View.VISIBLE);
                        Getter_box.setVisibility(View.VISIBLE);
                        Log.d("State", "line3 finished");
                        //Go to line4
                        GoLine4();
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

    //line4
    private void GoLine4() {
        CheckStateEncap = "line4";
        line4 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 190);
        line4.setDuration(3000);
        line4.start();
        line4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line4 finished");
                        Getter_box.setTextColor(Color.parseColor("#FFFFFF"));
                        //Goto Line5
                        GoLine5();
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

    //Line5
    private void GoLine5() {
        CheckStateEncap = "line5";
        line5 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 250);
        line5.setDuration(3000);
        line5.start();
        line5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Getter_box.setText("Torn");
               final Toast toastline5= Toast.makeText(Encap_Animation.this, "ส่งค่าที่อยู่ใน attribute กลับ", Toast.LENGTH_LONG);
                new CountDownTimer(6000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toastline5.show();
                    }

                    @Override
                    public void onFinish() {
                        Log.d("State", "line5 finished");
                        output_header.setVisibility(View.VISIBLE);
                        output_layout.setVisibility(View.VISIBLE);
                        GoLine15_1();
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

    //playgetAnimation
    private void playgetAnimation() {
        CheckStateEncap = "playgetAnimation";
        ObjectAnimator moveDown = ObjectAnimator.ofFloat(Getter_box, View.TRANSLATION_Y, 600);
        ObjectAnimator hide = ObjectAnimator.ofFloat(Getter_box, View.ALPHA, 0f);
        hide.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        getAnimation = new AnimatorSet();
        getAnimation.setDuration(2500);
        getAnimation.playSequentially(moveDown, hide);
        getAnimation.start();
        getAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("State", "playgetAnimation finished");
                //Go to line15
                GoLine15_1();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //line15_1
    private void GoLine15_1() {
        CheckStateEncap = "line15_1";
        line15_1 = ObjectAnimator.ofFloat(pointer, View.TRANSLATION_Y, 840);
        line15_1.setDuration(3000);
        line15_1.start();
        line15_1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new CountDownTimer(3000,1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        output_result.setVisibility(View.VISIBLE);
                        Toast.makeText(Encap_Animation.this, "แสดงค่าที่ส่งกลับออกทางหน้าจอ", Toast.LENGTH_SHORT).show();
                        Log.d("State", "Application finished");
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Encap_Animation.this, encap_teach.class);
        startActivity(intent);
        finish();
    }
}
