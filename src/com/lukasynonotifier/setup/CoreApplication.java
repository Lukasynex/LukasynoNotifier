package com.lukasynonotifier.setup;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

import com.lukasynonotifier.alarms.AbstractAlarmActivity;

public class CoreApplication extends Application {
	public static List<AbstractAlarmActivity> alarms = new ArrayList<AbstractAlarmActivity>();

	public CoreApplication() {
	}
	public static void addAlarm(AbstractAlarmActivity activity){
		alarms.add(activity);
	}
	public static void cancelAlarms(){
		for (AbstractAlarmActivity every_alarm : alarms)
			every_alarm.cancelAlarm();
		alarms.clear();
	}
	public static int AlarmListLength(){
		return alarms.size();
	}
}
