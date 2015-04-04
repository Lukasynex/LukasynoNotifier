package com.lukasynonotifier.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lukasynonotifier.events.ColorTransition;
import com.lukasynonotifier.events.Player;
import com.lukasynonotifier.setup.CoreApplication;
import com.lukasynonotifier.setup.R;
import com.lukasynonotifier.setup.SetupAlarmActivity;

public class ElapsedTimeActivity extends AbstractAlarmActivity {
	public final static String TARGET_NUMBER = "number";
	public final static String TARGET_MESSAGE = "message";

	private long delay = AlarmManager.INTERVAL_HALF_HOUR;
	private long interval = AlarmManager.INTERVAL_HALF_HOUR;

	private String phoneNumber = null;
	private String message = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.elapsed_time_activity);
		Player.getInstance(this);
		final LinearLayout lay = (LinearLayout) findViewById(R.id.LinearLayoutelapsed);
		ColorTransition.start(this, lay);
	
	}

	@Override
	public void prepareAlarm(View v) {
		final EditText inputDelay = (EditText) findViewById(R.id.delayedit);
		final EditText inputInterval = (EditText) findViewById(R.id.intervaledit);
		final TextView logger = (TextView) findViewById(R.id.elapsed_log);

		CoreApplication.addAlarm(this);
		delay = 1000 * 60 * Integer.parseInt(inputDelay.getText().toString());
		interval = 1000 * 60 * Integer.parseInt(inputInterval.getText()
				.toString());
		logger.setText("Alarm set. Delay is " + delay / 60000 + " min long.");
		manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		manager.setRepeating(AlarmManager.RTC_WAKEUP, delay, interval,
				pendingIntent);
	}

}
