package com.tengizmkcorp.ibsu_homework_notifications;

import static com.tengizmkcorp.ibsu_homework_notifications.NotificationType.*;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

public class NotificationService {
    private Context context;
    private final NotificationManager notificationManager;


    public NotificationService( Context context) {
        this.context = context;
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    }

    void showNotification(NotificationType notificationType){
        String contentTitle, contentText;
        int drawableID, nofID;
        switch (notificationType){
            case WEATHER: {
                contentTitle = "Weather forecast";
                contentText = "Tbilisi, 13°C";
                drawableID = R.drawable.ic_baseline_wb_sunny_24;
                nofID = 1;
            }
            break;
            case GAME: {
                contentTitle = "Napoli-Inter game time";
                contentText = "Sun, May 21, 20:00";
                drawableID = R.drawable.ic_baseline_sports_basketball_24;
                nofID = 2;
            }
            break;
            case NEWS: {
                contentTitle = "Political News";
                contentText = "Biden Vetoes Legislation That Would Reinstate Tariffs on Some Solar Panels";
                drawableID = R.drawable.ic_baseline_news_24;
                nofID = 3;
            }
            break;
            case EXCHANGE: {
                contentTitle = "Dollars to Gel";
                contentText = "You can buy 1$ for 2.51GEL";
                drawableID = R.drawable.ic_baseline_money_24;
                nofID = 4;
            }
            break;
            case TIME: {
                contentTitle = "Next Lecture";
                contentText = "IBSU, Saturday 12:00";
                drawableID = R.drawable.graduation;
                nofID = 5;
            }
            break;
            default: {
                throw new IllegalStateException("Unexpected value: " + notificationType);
            }
        }
        Notification notification = new NotificationCompat.Builder(context, "channel_id")
                .setSmallIcon(drawableID)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
//                .setStyle()
                .build();
        notificationManager.notify(nofID, notification) ;
    }


}


