package com.lukasynonotifier.setup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.lukasynonotifier.events.Player;
/**
 * when alarm is fired, onReceive(..) is called
 * @author Lukas
 *
 */
public class AlarmReceiver extends BroadcastReceiver {
	boolean isStarted = true;

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		if (isStarted) {
			new Thread(new Runnable() {
				public void run() {
					Player.play();
//					SMS_Sender.sendPreparedSMS();
				}
			}).start();
		}
//		isStarted = false;
		
	}
}