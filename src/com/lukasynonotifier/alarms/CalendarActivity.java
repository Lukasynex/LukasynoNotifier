package com.lukasynonotifier.alarms;

import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

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
		final TimePicker timepicker = (TimePicker) findViewById(R.id.timePicker1);
		final DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker1);
		timepicker.clearFocus();
		int hours = timepicker.getCurrentHour();
		int minutes = timepicker.getCurrentMinute();

		int dayOfMonth = datepicker.getDayOfMonth();
		int year = datepicker.getYear();
		int month = datepicker.getMonth();
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.HOUR, hours);

		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		
		date = calendar.getTime();
		
		manager.set(AlarmManager.RTC, date.getTime(), pendingIntent);
	}

}
