package dev.rahulhgdev.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText title, message;
    private Button channel1, channel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.input_title);
        message = (EditText) findViewById(R.id.input_message);
        channel1 = (Button) findViewById(R.id.btn_chnl1);
        channel2 = (Button) findViewById(R.id.btn_chnl2);


        // FOR SDK VERSION >= 26(Oreo) we have to make notification Channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("channel1ID","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        channel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notification codes

                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(MainActivity.this, "channel1ID");
                nBuilder.setContentTitle(title.getText().toString());
                nBuilder.setContentText(message.getText().toString());
                nBuilder.setAutoCancel(true);
                nBuilder.setSmallIcon(R.drawable.ic_chnl1);

                // to manage and show notification

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, nBuilder.build());

            }
        });

        channel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notification codes

                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(MainActivity.this, "channel1ID");
                nBuilder.setContentTitle(title.getText().toString());
                nBuilder.setContentText(message.getText().toString());
                nBuilder.setAutoCancel(true);
                nBuilder.setSmallIcon(R.drawable.ic_chnl2);

                // to manage and show notification

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(2, nBuilder.build());

            }
        });


    }
}