package go.faddy.com.agin2.models;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import go.faddy.com.agin2.service.FirebaseBackgroundService;

import static android.support.constraint.Constraints.TAG;
import static go.faddy.com.agin2.activities.Settings.ALARM_PER;
import static go.faddy.com.agin2.activities.Settings.TIME_10;
import static go.faddy.com.agin2.activities.Settings.TIME_6;
import static go.faddy.com.agin2.activities.Settings.TIME_7;
import static go.faddy.com.agin2.activities.Settings.TIME_8;
import static go.faddy.com.agin2.activities.Settings.TIME_9;

public class Picasso_okhttp extends Application implements Application.ActivityLifecycleCallbacks{
    private Activity mCurrentActivity;
    @Override
    public void onCreate() {
        super.onCreate();
//        FirebaseApp.initializeApp(this);
        registerActivityLifecycleCallbacks(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }

    public void for_alarm(){
        if(ALARM_PER == 1){
            if(TIME_6 == 1){
//                AlarmManager alarmManager = (AlarmManager) mCurrentActivity.getSystemService(Context.ALARM_SERVICE);
                Log.d("LOG" , "At 6");
                   Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
//        i.putExtra(AlarmClock.EXTRA_HOUR, hour);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Good Morning");
//        startActivity(i);
            }if(TIME_7 == 1){
                Log.d("LOG" , "At 7");
//                Toast.makeText(getApplicationContext(), "time_7", Toast.LENGTH_SHORT).show();

            }if(TIME_8 == 1){
                Log.d("LOG" , "At 8");

//                Toast.makeText(getApplicationContext(), "time_8", Toast.LENGTH_SHORT).show();

            }if(TIME_9 == 1){
                Log.d("LOG" , "At 9");

//                Toast.makeText(getApplicationContext(), "time_9", Toast.LENGTH_SHORT).show();

            }if(TIME_10 == 1){
                Log.d("LOG" , "At 10");

//                Toast.makeText(getApplicationContext(), "time_10" +
//                        "", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        mCurrentActivity = activity;
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
