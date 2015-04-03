package com.lukasynonotifier.alarms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lukasynonotifier.events.SMS_Sender;
import com.lukasynonotifier.setup.R;

public class ElapsedTimeActivity extends Activity {
	public final static String TARGET_NUMBER = "number";
	public final static String TARGET_MESSAGE = "message";
	private String phoneNumber = null;
	private String message = null;
	private ElapsedTimeAlarm alarm = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.elapsed_time_activity);
		Bundle bundle = getIntent().getExtras();

		if (bundle.getString(TARGET_MESSAGE) != null
				&& bundle.getString(TARGET_NUMBER) != null) {
			message = bundle.getString(TARGET_MESSAGE);
			phoneNumber = bundle.getString(TARGET_NUMBER);
		} else
			finish();
	}

	public void startAlarm(View v) {
		SMS_Sender.setTargetMessage(message);
		SMS_Sender.setTargetNumber(phoneNumber);
		
		final EditText inputDelay = (EditText) findViewById(R.id.delayedit);
		final EditText inputInterval = (EditText) findViewById(R.id.intervaledit);
		alarm = new ElapsedTimeAlarm(this);
		long delay = 1000 * 60 * Integer.parseInt(inputDelay.getText()
				.toString());
		long interval = 1000 * 60 * Integer.parseInt(inputInterval.getText()
				.toString());

		alarm.setDelay(delay);
		alarm.setInterval(interval);
		alarm.startAlarm();
	}
}
