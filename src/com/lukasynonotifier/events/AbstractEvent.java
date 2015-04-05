package com.lukasynonotifier.events;

import android.content.Context;

public abstract class AbstractEvent {
	protected Context context;

	public AbstractEvent(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public abstract void performAction();

	public abstract void onPrepare();
}
