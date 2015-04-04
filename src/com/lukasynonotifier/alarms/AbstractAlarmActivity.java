package com.lukasynonotifier.alarms;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lukasynonotifier.setup.AlarmReceiver;

public abstract class AbstractAlarmActivity extends Activity {
	protected PendingIntent pendingIntent;
	protected AlarmManager manager;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent alarmIntent = new Intent(this, AlarmReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
	}

	public void cancelAlarm() {
		if (manager != null)
			manager.cancel(pendingIntent);
	}

	public abstract void prepareAlarm(View v);

}
