package co.martinbrown.example.interpolator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class AnimationInterpolatorExampleActivity extends Activity {

    TextView tv;
    Button decel;
    Button bounce;
    Button overshoot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv = (TextView) findViewById(R.id.textView1);
        decel = (Button) findViewById(R.id.button1);
        bounce = (Button) findViewById(R.id.button2);
        overshoot = (Button) findViewById(R.id.button3);

        decel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation anim = new RotateAnimation(0, 720);
                anim.setInterpolator(new DecelerateInterpolator(2.0f));
                anim.setDuration(2000);

                tv.startAnimation(anim);
            }
        });

        bounce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation anim = new RotateAnimation(0, 720);
                anim.setInterpolator(new BounceInterpolator());
                anim.setDuration(2000);

                tv.startAnimation(anim);
            }
        });

        overshoot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation anim = new RotateAnimation(0, -720);
                anim.setInterpolator(new OvershootInterpolator());
                anim.setDuration(2000);

                tv.startAnimation(anim);
            }
        });
    }
}