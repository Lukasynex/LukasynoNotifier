package com.lukasynonotifier.events;

import android.content.Context;
import android.media.MediaPlayer;
import com.lukasynonotifier.setup.R;

public class Player {
	private static Player instance = null;
	private static MediaPlayer player;

	private Player(Context context) {
		player = MediaPlayer.create(context, R.raw.aaa);
	}

	public static Player getInstance(Context context) {
		if (instance == null)
			instance = new Player(context);
		return instance;
	}

	public static void play() {
		player.start();
	}
}
