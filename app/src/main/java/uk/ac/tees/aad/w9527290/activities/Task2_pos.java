package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;
import uk.ac.tees.aad.w9527290.R;

public class Task2_pos extends AppCompatActivity {

    CountDownTimer timer;
    public long remainingtime= 100000;
    public TextView txt;
    int selection;
    GifImageView gifimageView;
    Button video;
    String  URLS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2_pos);

        txt = findViewById(R.id.cnttimer);
        video = findViewById(R.id.shwovideo);

        Intent recieved_intent = getIntent();
        Bundle bundle = recieved_intent.getExtras();
        gifimageView = findViewById(R.id.imageView5);

        if(bundle!= null) {
            selection = bundle.getInt("exercise");
            //  Toast.makeText(Task1_pos.this, selection, Toast.LENGTH_SHORT).show();

            if (selection == 0) {
                gifimageView.setImageResource(R.drawable.slowwalk);
                remainingtime = 80000;
                URLS = "https://www.youtube.com/watch?v=1DQ88KfKUy8";
            }
            if (selection == 1) {
                gifimageView.setImageResource(R.drawable.bandhand);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=wB80LcjqqA0";

            }
            if (selection == 2) {
                gifimageView.setImageResource(R.drawable.backlegs);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=jFjgWYIB_4Y";
            }
            if (selection == 3) {
                gifimageView.setImageResource(R.drawable.day_five);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=G_ERMS1NPT4";

            }
            if (selection == 4) {
                gifimageView.setImageResource(R.drawable.ceilingreach);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=-bU8yDUcqj8";

            }
            if (selection == 5) {
                gifimageView.setImageResource(R.drawable.ballcrunches);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=xrts0odDIJ4";

            }
            if (selection == 6) {
                gifimageView.setImageResource(R.drawable.ballcrunches);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=xrts0odDIJ4";

            }
            if (selection == 7) {
                gifimageView.setImageResource(R.drawable.ballcrunches);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=xrts0odDIJ4";

            }
            if (selection == 8) {
                gifimageView.setImageResource(R.drawable.ballcrunches);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=xrts0odDIJ4";

            }
            if (selection == 9) {
                gifimageView.setImageResource(R.drawable.ballcrunches);
                remainingtime = 100000;
                URLS = "https://www.youtube.com/watch?v=xrts0odDIJ4";

            }
        }
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(URLS));
                startActivity(viewIntent);
            }
        });
        timer = new CountDownTimer(remainingtime,100) {
            @Override
            public void onTick(long l) {

                remainingtime = l;
                updateText();

            }

            @Override
            public void onFinish() {

                finish();
            }
        }.start();

    }
    public void updateText()
    {

        int min = ((int)remainingtime/1000)/60;
        int sec = ((int)remainingtime/1000)%60;

        String timeleftformat = String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        txt.setText(timeleftformat.toString());

    }

}