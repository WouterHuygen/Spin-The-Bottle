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


    public int getrotation(boolean button , float Velocity) {
        int temp;
        if (button) {
            temp = (r.nextInt(720)+1080)-60;
            rotation = 360;
        }
        else{
             temp = (int)Velocity;
             rotation = 360;
        }
        this.rotation+= temp;
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

