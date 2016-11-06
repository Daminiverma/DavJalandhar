package com.example.babyd_000.dav_jalandhar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.pushbots.push.PBNotificationIntent;
import com.pushbots.push.Pushbots;
import com.pushbots.push.utils.PBConstants;

import java.util.HashMap;

public class customHandler extends BroadcastReceiver {
    SharedPreferences.Editor editor;

    private static final String TAG = "customHandler";

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();

        String action = intent.getAction();
        Log.d(TAG, "action=" + action);
        // Handle Push Message when opened
        if (action.equals(PBConstants.EVENT_MSG_OPEN)) {
            //Check for Pushbots Instance
            Pushbots pushInstance = Pushbots.sharedInstance();
            if (!pushInstance.isInitialized()) {
                Log.d(TAG, "Initializing Pushbots");
                //Log.d("Initializing Pushbots.");
                Pushbots.sharedInstance().init(context.getApplicationContext());
            }

            //Clear Notification array
            if (PBNotificationIntent.notificationsArray != null) {
                PBNotificationIntent.notificationsArray = null;
            }

            HashMap<?, ?> PushdataOpen = (HashMap<?, ?>) intent.getExtras().get(PBConstants.EVENT_MSG_OPEN);
            Log.w(TAG, "User clicked notification with Message: " + PushdataOpen.get("message"));

            //Report Opened Push Notification to Pushbots
            if (Pushbots.sharedInstance().isAnalyticsEnabled()) {
                Pushbots.sharedInstance().reportPushOpened((String) PushdataOpen.get("PUSHANALYTICS"));
            }

            //Start lanuch Activity
            String packageName = context.getPackageName();
            Intent resultIntent = new Intent(context.getPackageManager().getLaunchIntentForPackage(packageName));
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            resultIntent.putExtras(intent.getBundleExtra("pushData"));
            Pushbots.sharedInstance().startActivity(resultIntent);

            // Handle Push Message when received
        } else if (action.equals(PBConstants.EVENT_MSG_RECEIVE)) {
            HashMap<?, ?> PushdataOpen = (HashMap<?, ?>) intent.getExtras().get(PBConstants.EVENT_MSG_RECEIVE);
            Log.w(TAG, "User Received notification with Message: " + PushdataOpen.get("message"));
            String temp = pref.getString("notification", "");
            if (!temp.equals(""))
            {
                String temp2 = "";
                String temp1[] = temp.split("<br><br>");
                if (temp1.length>5)
                {
                    for(int i=0; i<5;i++)
                    {
                        if (temp2!="")
                        {
                            temp2 = temp2+"<br><br>"+temp1[i];
                        }
                        else
                        {
                            temp2 =temp1[i];
                        }

                    }
                    editor.putString("notification","*  "+ PushdataOpen.get("message").toString() + "<br><br>" + temp2);
                    editor.commit();
                }
                else
                {
                    editor.putString("notification","*  "+ PushdataOpen.get("message").toString() + "<br><br>" + temp);
                    editor.commit();
                }
            }
            else
            {
                editor.putString("notification","*  "+ PushdataOpen.get("message").toString() + "<br><br>");
                editor.commit();
            }
        }
    }
}