package com.lukasynonotifier.alarms;

import com.lukasynonotifier.setup.AlarmReceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public abstract class AbstractAlarm {
	protected Context context;
	protected PendingIntent pendingIntent;
	protected AlarmManager manager;

	public AbstractAlarm(Context context) {
		this.context = context;
		Intent alarmIntent = new Intent(context, AlarmReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

	}

	public void cancelAlarm() {
		if (pendingIntent != null)
			manager.cancel(pendingIntent);
	}

	public abstract void prepareAlarm();

	public abstract void startAlarm();

}
