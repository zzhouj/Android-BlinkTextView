package com.coco.blinktextview.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.coco.blinktextview.BlinkTextView;

public class BlinkTextViewTestActivity extends Activity implements OnSeekBarChangeListener {

	private BlinkTextView mBlinkTextView;

	private TextView mFadingDurationText;
	private TextView mDelayAfterFadeinText;
	private TextView mDelayAfterFadeoutText;

	private SeekBar mFadingDurationSeek;
	private SeekBar mDelayAfterFadeinSeek;
	private SeekBar mDelayAfterFadeoutSeek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blink_text_view_test);

		mBlinkTextView = (BlinkTextView) findViewById(R.id.blink_text);

		mFadingDurationText = (TextView) findViewById(R.id.fading_duration_text);
		mDelayAfterFadeinText = (TextView) findViewById(R.id.delay_after_fadein_text);
		mDelayAfterFadeoutText = (TextView) findViewById(R.id.delay_after_fadeout_text);

		mFadingDurationText.setText(String.valueOf(mBlinkTextView.getFadingDuration()));
		mDelayAfterFadeinText.setText(String.valueOf(mBlinkTextView.getDelayAfterFadein()));
		mDelayAfterFadeoutText.setText(String.valueOf(mBlinkTextView.getDelayAfterFadeout()));

		mFadingDurationSeek = (SeekBar) findViewById(R.id.fading_duration_seek);
		mDelayAfterFadeinSeek = (SeekBar) findViewById(R.id.delay_after_fadein_seek);
		mDelayAfterFadeoutSeek = (SeekBar) findViewById(R.id.delay_after_fadeout_seek);

		mFadingDurationSeek.setProgress((int) mBlinkTextView.getFadingDuration());
		mDelayAfterFadeinSeek.setProgress((int) mBlinkTextView.getDelayAfterFadein());
		mDelayAfterFadeoutSeek.setProgress((int) mBlinkTextView.getDelayAfterFadeout());

		mFadingDurationSeek.setOnSeekBarChangeListener(this);
		mDelayAfterFadeinSeek.setOnSeekBarChangeListener(this);
		mDelayAfterFadeoutSeek.setOnSeekBarChangeListener(this);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		if (fromUser) {
			if (seekBar == mFadingDurationSeek) {
				mBlinkTextView.setFadingDuration(progress);
				mFadingDurationText.setText(String.valueOf(mBlinkTextView.getFadingDuration()));
			} else if (seekBar == mDelayAfterFadeinSeek) {
				mBlinkTextView.setDelayAfterFadein(progress);
				mDelayAfterFadeinText.setText(String.valueOf(mBlinkTextView.getDelayAfterFadein()));
			} else if (seekBar == mDelayAfterFadeoutSeek) {
				mBlinkTextView.setDelayAfterFadeout(progress);
				mDelayAfterFadeoutText.setText(String.valueOf(mBlinkTextView.getDelayAfterFadeout()));
			}
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// do nothing
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// do nothing
	}

}
