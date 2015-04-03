package com.lukasynonotifier.events;

import java.util.Calendar;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SMS_Sender {
	private static Context context = null;
	private static String targetNumber = null;
	private static String targetMessage = null;
	
	public static void setTargetNumber(String targetNumber) {
		SMS_Sender.targetNumber = targetNumber;
	}
	public static void setTargetMessage(String targetMessage) {
		SMS_Sender.targetMessage = targetMessage;
	}
	public static void setContext(Context c){
		context = c;
			
	}
	private static Context getBaseContext(){
		return context.getApplicationContext();
	}
	public static void sendPreparedSMS(){
		if(targetMessage != null && targetNumber != null)
			sendSMS(targetNumber, targetMessage);
	}
	public static void sendSMS(String phoneNumber, String message) {
		if(context==null)
			return;
		String SENT = "SMS_SENT";
		String DELIVERED = "SMS_DELIVERED";

		PendingIntent sentPI = PendingIntent.getBroadcast(context, 0, new Intent(
				SENT), 0);

		PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
				new Intent(DELIVERED), 0);

		// ---when the SMS has been sent---
		context.registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS sent",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(getBaseContext(), "Generic failure",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getBaseContext(), "No service",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getBaseContext(), "Null PDU",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(getBaseContext(), "Radio off",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter(SENT));

		// ---when the SMS has been delivered---
		context.registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS delivered",
							Toast.LENGTH_SHORT).show();
					break;
				case Activity.RESULT_CANCELED:
					Toast.makeText(getBaseContext(), "SMS not delivered",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter(DELIVERED));

		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);

	}
	public static String getMonthInPolish(Calendar calendar) {
		switch (calendar.get(Calendar.MONTH)) {
		case Calendar.JANUARY: {
			return "stycznia";
		}
		case Calendar.FEBRUARY: {
			return "lutego";
		}
		case Calendar.MARCH: {
			return "marca";
		}
		case Calendar.APRIL: {
			return "kwietnia";
		}
		case Calendar.MAY: {
			return "maja";
		}
		case Calendar.JUNE: {
			return "czerwca";
		}
		case Calendar.JULY: {
			return "lipca";
		}
		case Calendar.AUGUST: {
			return "sierpnia";
		}
		case Calendar.SEPTEMBER: {
			return "wrzeúnia";
		}
		case Calendar.OCTOBER: {
			return "paüdziernika";
		}
		case Calendar.NOVEMBER: {
			return "listopada";
		}
		case Calendar.DECEMBER: {
			return "grudnia";
		}

		}
		return null;
	}
}
