package com.coco.blinktextview.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BlinkTextViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blink_text_view_test);
	}

}
