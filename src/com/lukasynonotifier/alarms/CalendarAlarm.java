package com.lukasynonotifier.alarms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lukasynonotifier.setup.SetupAlarmActivity;

import android.app.AlarmManager;
import android.content.Context;
import android.widget.Toast;

public class CalendarAlarm extends AbstractAlarm {
	private Date date = null;
	public CalendarAlarm(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startAlarm() {
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
//		((SetupAlarmActivity)context).get
		
		Date date = null;
		try {
			date = parser.parse("21:37");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (date != null){
				manager.set(AlarmManager.RTC, date.getTime(), pendingIntent);
				Toast.makeText(context, "Alarm set at"+date.toString(), Toast.LENGTH_LONG);
			}else
				Toast.makeText(context, "Unable to set date alarm", Toast.LENGTH_LONG);
		}
	}

	@Override
	public void prepareAlarm() {
		// TODO Auto-generated method stub
		
	}

}
