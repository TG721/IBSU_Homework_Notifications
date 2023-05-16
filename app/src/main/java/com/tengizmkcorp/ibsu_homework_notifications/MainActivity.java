package com.tengizmkcorp.ibsu_homework_notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tengizmkcorp.ibsu_homework_notifications.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NotificationService notificationService = new NotificationService(getApplicationContext());
        // Access views using binding object
        binding.buttonExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationService.showNotification(NotificationType.EXCHANGE);
            }
        });
        binding.buttonNapoliGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationService.showNotification(NotificationType.GAME);
            }
        });
        binding.buttonPoliticalNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationService.showNotification(NotificationType.NEWS);
            }
        });
        binding.buttonWeather.setOnClickListener(view -> notificationService.showNotification(NotificationType.WEATHER));
        binding.buttonTime.setOnClickListener(view -> notificationService.showNotification(NotificationType.TIME));
    }
}