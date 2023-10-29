package com.chous.wordle;

import android.view.Gravity;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Message {
    public static void show(int tryIndex) {
        Toasty.Config.getInstance()
                .setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 300).apply();
        switch (tryIndex){
            case 0:{
                Toasty.normal(App.getContext(), "Genius", Toast.LENGTH_SHORT).show();
                break;
            }
            case 1:{
                Toasty.normal(App.getContext(), "Magnificent", Toast.LENGTH_SHORT).show();
                break;
            }
            case 2:{
                Toasty.normal(App.getContext(), "Impressive", Toast.LENGTH_SHORT).show();
                break;
            }
            case 3:{
                Toasty.normal(App.getContext(), "Splendid", Toast.LENGTH_SHORT).show();
                break;
            }
            case 4:{
                Toasty.normal(App.getContext(), "Great", Toast.LENGTH_SHORT).show();
                break;
            }
            case 5:{
                Toasty.normal(App.getContext(), "Phew", Toast.LENGTH_SHORT).show();
                break;
            }
        }



    }
}
