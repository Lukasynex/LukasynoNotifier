package com.lukasynonotifier.alarms;

import java.util.Date;

import android.app.AlarmManager;
import android.os.Bundle;
import android.view.View;

import com.lukasynonotifier.events.Player;
import com.lukasynonotifier.setup.R;

public class CalendarActivity extends AbstractAlarmActivity {
	public final static String TARGET_NUMBER = "number";
	public final static String TARGET_MESSAGE = "message";
	public Date date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendar_activity);
		Player.getInstance(this);
	}

	@Override
	public void prepareAlarm(View v) {
		// TODO Auto-generated method stub
	}

}
