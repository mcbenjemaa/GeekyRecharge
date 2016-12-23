package com.geekycoders.geekyrecharge;

import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
ImageView head;
  ImageView head_bread;
  ImageView body_left;
  ImageView body_right;
  ImageView body_opened;
  TextView title;

  // swipe right
  //http://stackoverflow.com/questions/4139288/android-how-to-handle-right-to-left-swipe-gestures
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ActionBar actionbar = getSupportActionBar();
   // actionbar.setTitle(Html.fromHtml("<font color='#ef0000'>geeky Recharge </font>"));
    body_right=(ImageView)findViewById(R.id.body_right);
    body_opened=(ImageView)findViewById(R.id.body_opened);
    title=(TextView)findViewById(R.id.title);
    String fontPath = "fonts/Face Your Fears.ttf";
    title.setTypeface(Typeface.createFromAsset(getAssets(), fontPath));


     RunAnimation(title);
    //title.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
     body_right.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
       public void onSwipeTop() {
         //Toast.makeText(MyActivity.this, "top", Toast.LENGTH_SHORT).show();
       }
       public void onSwipeRight() {
         body_right.setVisibility(View.INVISIBLE);
         body_opened.setVisibility(View.VISIBLE);
       }
       public void onSwipeLeft() {
         //Toast.makeText(MyActivity.this, "left", Toast.LENGTH_SHORT).show();
       }
       public void onSwipeBottom() {
         //Toast.makeText(MyActivity.this, "bottom", Toast.LENGTH_SHORT).show();
       }

     });
    body_opened.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
      public void onSwipeTop() {
        //Toast.makeText(MyActivity.this, "top", Toast.LENGTH_SHORT).show();
      }
      public void onSwipeRight() {
       // Toast.makeText(MyActivity.this, "right", Toast.LENGTH_SHORT).show();
      }
      public void onSwipeLeft() {
        body_opened.setVisibility(View.INVISIBLE);
        body_right.setVisibility(View.VISIBLE);

      }
      public void onSwipeBottom() {
       // Toast.makeText(MyActivity.this, "bottom", Toast.LENGTH_SHORT).show();
      }

    });

  }


  private void RunAnimation(TextView tv)
  {
    Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
    a.reset();

    tv.clearAnimation();
    tv.startAnimation(a);

  }
}
