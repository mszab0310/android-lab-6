package com.example.laborator6;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public MyService service = new MyService();
    boolean isConnected = false;
    private EditText p;
    private EditText volume;
    private EditText duration;
    private Timer timer;

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service1) {
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) service1;
            service = binder.getBoundService();
            isConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnected = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p = findViewById(R.id.period);
        volume = findViewById(R.id.volume);
        duration = findViewById(R.id.duration);

        Intent intent_1 = new Intent(this, MyService.class);
        bindService(intent_1, serviceConnection, Context.BIND_AUTO_CREATE);
        Button play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(p.getText().toString()) || TextUtils.isEmpty(duration.getText().toString()) || TextUtils.isEmpty(volume.getText().toString())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a value.", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            service.getSound(Integer.parseInt(String.valueOf(duration.getText())), Integer.parseInt(String.valueOf(volume.getText())));
                        }
                    }, 1000L * Integer.parseInt(String.valueOf(p.getText())));
                }
            }
        });
    }


}