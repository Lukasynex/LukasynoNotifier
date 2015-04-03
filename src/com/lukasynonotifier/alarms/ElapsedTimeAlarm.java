package com.lukasynonotifier.alarms;

import android.app.AlarmManager;
import android.content.Context;

public class ElapsedTimeAlarm extends AbstractAlarm {

	public ElapsedTimeAlarm(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startAlarm() {
		manager.set(AlarmManager.ELAPSED_REALTIME,
		        AlarmManager.INTERVAL_HALF_HOUR,
		        pendingIntent);
	}
	
	@Override
	public void prepareAlarm() {
		// TODO Auto-generated method stub
		
	}

}
