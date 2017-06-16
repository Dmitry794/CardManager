package com.example.malets.caw;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.RemoteViews;

public class CardWidget extends AppWidgetProvider {
    public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    RemoteViews remoteviews;

    //
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    //
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    // Widget
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    // Widget?
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    //
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED_ACTION)) {
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");
            for (Object pdu : pdus) {
                SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);
                String sender = message.getOriginatingAddress();
                String content = message.getMessageBody();
                if (remoteviews == null) {
                    remoteviews = new RemoteViews(context.getPackageName(),
                            R.layout.main);
                }
                remoteviews.setTextViewText(R.id.sender, sender);
                remoteviews.setTextViewText(R.id.message, content + "\n");
                AppWidgetManager appWidgetManger = AppWidgetManager
                        .getInstance(context);
                int[] appIds = appWidgetManger
                        .getAppWidgetIds(new ComponentName(context,
                                CardWidget.class));
                appWidgetManger.updateAppWidget(appIds, remoteviews);

            }
        }
        Log.i("my", intent.getAction());
    }
}
