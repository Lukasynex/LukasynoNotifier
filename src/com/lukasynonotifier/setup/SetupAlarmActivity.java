package com.lukasynonotifier.setup;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lukasynonotifier.alarms.AbstractAlarmActivity;
import com.lukasynonotifier.alarms.CalendarActivity;
import com.lukasynonotifier.alarms.ElapsedTimeActivity;
import com.lukasynonotifier.events.ColorTransition;

public class SetupAlarmActivity extends Activity {
	public static final String TARGET_NUMBER = "number";
	public static final String TARGET_MESSAGE = "message";
	private static List<AbstractAlarmActivity> alarms = new ArrayList<AbstractAlarmActivity>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final LinearLayout lay = (LinearLayout) findViewById(R.id.LinearColorLay);
		ColorTransition.start(this, lay);
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

	public static void addAlarm(AbstractAlarmActivity al) {
		alarms.add(al);
	}

	public void cancelAlarms(View view) {
		for (AbstractAlarmActivity every_alarm : alarms)
			every_alarm.cancelAlarm();
	}

	public static void registerAlarm(AbstractAlarmActivity activity) {
		alarms.add(activity);
	}
}
