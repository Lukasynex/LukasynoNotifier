//package com.lukasynonotifier.setup;
//
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Handler;
//import android.os.storage.StorageManager;
//import android.widget.Toast;
//
//public class SMSThread {
//	private static boolean isStarted = false;
//	private static Handler handler = new Handler();
//	private static int minutes = -1;
//	private static int interval= -1;
//	
//	private static Activity activity;
//	public static boolean isActive = true;
//
//	private static Runnable stepTimer = new Runnable() {
//		@Override
//		public void run() {
//			if (isActive) {
////				SMS_Sender.sendPreparedSMS();
//				Player.play();
//				if(interval != -1)
//					handler.postDelayed(this, interval);
////				else if(minutes!= -1){
////					handler.postDelayed(this, minutes);
////				}else
////					isActive = false;
//			}
//		}
//	};
//	public static void setInterval(int interval){
//		interval *=60*1000;
//		SMSThread.interval = interval;
//		
//	}
//	public static void setDelay(int minutes){
//		minutes *=60*1000;
//		
//		SMSThread.minutes = minutes;
//	}
//	public static void start(Activity view) {
//		if (!isStarted) {
//			if(minutes != -1)
//				handler.postDelayed(stepTimer, minutes);
////			else
////				Toast.makeText(view.getApplicationContext(), "NOOOO", Toast.LENGTH_SHORT);
//			isStarted = true;
//		}
//		activity = view;
//	}
//	}
