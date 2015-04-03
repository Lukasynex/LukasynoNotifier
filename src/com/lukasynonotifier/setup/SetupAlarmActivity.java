package com.lukasynonotifier.setup;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.lukasynonotifier.alarms.AbstractAlarm;
import com.lukasynonotifier.alarms.CalendarActivity;
import com.lukasynonotifier.alarms.ElapsedTimeActivity;

public class SetupAlarmActivity extends Activity {
	public static final String TARGET_NUMBER = "number";
	public static final String TARGET_MESSAGE = "message";
	private List<AbstractAlarm> alarms = new ArrayList<AbstractAlarm>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void createElapsedAlarm(View v) {
		EditText numb = (EditText) findViewById(R.id.number2sent);
		EditText mess = (EditText) findViewById(R.id.message2sent);
		
		Intent intent = new Intent();
		intent.setClass(this, ElapsedTimeActivity.class);
		intent.putExtra(TARGET_NUMBER, numb.getText().toString());
		intent.putExtra(TARGET_MESSAGE, mess.getText().toString());
		
		startActivity(intent);
	}

	public void createCalendarAlarm(View v) {
		EditText numb = (EditText) findViewById(R.id.number2sent);
		EditText mess = (EditText) findViewById(R.id.message2sent);
		
		Intent intent = new Intent();
		intent.setClass(this, CalendarActivity.class);
		intent.putExtra(TARGET_NUMBER, numb.getText().toString());
		intent.putExtra(TARGET_MESSAGE, mess.getText().toString());

		startActivity(intent);
	}

	public void cancelAlarms(View view) {
		for (AbstractAlarm every_alarm : alarms)
			every_alarm.cancelAlarm();
	}
}
