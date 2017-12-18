package com.example.wouter.spinthebottle;

import android.content.Context;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import java.util.Random;

/**
 * Created by crist on 17-12-2017.
 */

public class Gameplay {


    public Gameplay() {

    }
    private static Random r = new Random();
    private int rotation = 360;


    public int getrotation() {
        this.rotation+= (r.nextInt(720)+1080)-60;
        if(rotation > 6000)
            rotation = 360+(r.nextInt(360)+720)/2;
        return rotation;
    }
    public void Rotateanimation (ImageView WhattoSpin){
        RotateAnimation bottlerotation = new RotateAnimation(0,rotation,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        bottlerotation.setFillAfter(true);
        bottlerotation.setDuration(1000);
        WhattoSpin.startAnimation(bottlerotation);

    }
    }

