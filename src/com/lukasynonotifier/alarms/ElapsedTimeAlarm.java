package com.lukasynonotifier.alarms;

import android.app.AlarmManager;
import android.content.Context;
import android.view.View;

public class ElapsedTimeAlarm extends AbstractAlarm {
	private long delay = AlarmManager.INTERVAL_HALF_HOUR;
	private long interval= AlarmManager.INTERVAL_HALF_HOUR;
	
	public ElapsedTimeAlarm(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startAlarm() {
//		manager.set(AlarmManager.ELAPSED_REALTIME,
//		        AlarmManager.INTERVAL_HALF_HOUR,
//		        pendingIntent);
		manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
				delay, interval, pendingIntent);
	}
	
	@Override
	public void prepareAlarm() {
		//unused!
	}

	public void setDelay(long parseInt) {
		delay = parseInt;
	}

	public void setInterval(long parseInt) {
		interval = parseInt;
	}
	
}
