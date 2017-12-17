package com.example.wouter.spinthebottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ImageView Bottle = (ImageView) findViewById(R.id.bottlespinImg);
        Button playGameBtn = (Button) findViewById(R.id.gameplaybtn);

        playGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RotateAnimation bottlerotation = new RotateAnimation(0,360,
                        RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                bottlerotation.setFillAfter(true);
                bottlerotation.setDuration(1000);

                Bottle.startAnimation(bottlerotation);
            }
        });
    }
}
