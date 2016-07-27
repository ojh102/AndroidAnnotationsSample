package com.github.ojh.androidannotationssample.view;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.ojh.androidannotationssample.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Timer;
import java.util.TimerTask;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.count)
    TextView tvCount;

    int count = 0;

    @AfterInject
    void setView() {
        increaseCount();
    }

    @Background
    void increaseCount() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setCountView(count++);
            }
        }, 1000, 1000);
    }

    @UiThread
    void setCountView(int count){
        tvCount.setText("count : "+count);
    }
}
