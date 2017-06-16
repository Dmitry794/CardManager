package com.example.malets.caw;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MessageManager {
    private static final String SENDER = "1234567";
    public static void setMessagesAsRead(Context context){
        Log.d("MY", "START");
        Uri uri = Uri.parse("content://sms/inbox");
        ContentResolver resolver = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put("read", 1);
        int count = resolver.update(uri, values, "_id=2", null);

        Log.d("MY", "UPDATED: "+String.valueOf(count));
/*
        Cursor cursor = resolver.query(uri, null, "address="+SENDER+" and read=0", null, null);
//        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
//
//        for (String name : cursor.getColumnNames()) {
//            Log.d("MY", name);
//        }
//        Log.d("MY","---------------------------------");
        Set<Map<String,String>> messages = new HashSet<>();
        Set<String> fields = new HashSet<>(Arrays.asList(new String[]{"_id","address","status","body","read"}));

        while (cursor.moveToNext()) {
            Map<String, String> message = new HashMap<>();
            int read = cursor.getInt(cursor.getColumnIndex("read"));

                for (String field : fields) {
                    String value = cursor.getString(cursor.getColumnIndex(field));

                    message.put(field, value);
                }
                messages.add(message);

        }
        cursor.close();
        Log.d("MY", "COUNT: " + messages.size());
        Log.d("MY", "============================================");
        for (Map<String, String> message : messages) {
            for (Map.Entry<String, String> entry : message.entrySet()) {
                Log.d("MY", entry.getKey() + " : " + entry.getValue());
            }
            Log.d("MY", "============================================");
        }


        Toast.makeText(context, "DONE!", Toast.LENGTH_LONG).show();
*/
    }
}
