package com.coco.blinktextview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;

public class BlinkTextView extends TextView {
	private static final String TAG = "BlinkTextView";
	private static final boolean DEBUG = true;

	private static void DEBUG_LOG(String msg) {
		if (DEBUG) {
			Log.v(TAG, msg);
		}
	}

	private static final int MIN_ALPHA = 0;
	private static final int MAX_ALPHA = 255;
	private static final int MAX_FADING_DURATION = 2000; // ms
	private static final int MIN_FADING_DELAY = 300; // ms
	private static final int MAX_FADING_DELAY = 800; // ms

	// blink
	private ColorStateList mOriginalColors;
	private int mTextColorAlpha;

	private Scroller mScroller;
	private boolean mIsFadein;
	private boolean mBlinkStarted;

	private final Runnable mReverseFadingRunnable = new Runnable() {
		public void run() {
			mIsFadein = !mIsFadein;
			DEBUG_LOG("mReverseFadingRunnable mIsFadein=" + mIsFadein);
			startBlink();
		}
	};

	public BlinkTextView(Context context) {
		super(context);
		initBlinkTextView();
	}

	public BlinkTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initBlinkTextView();
	}

	public BlinkTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initBlinkTextView();
	}

	private void initBlinkTextView() {
		final Context context = getContext();
		mScroller = new Scroller(context, new LinearInterpolator());
		mTextColorAlpha = MAX_ALPHA;
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		startBlink();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		stopBlink();
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		super.onWindowFocusChanged(hasWindowFocus);
		DEBUG_LOG("onWindowFocusChanged hasWindowFocus=" + hasWindowFocus);
		if (hasWindowFocus) {
			startBlink();
		} else {
			stopBlink();
		}
	}

	@Override
	public void setTextAppearance(Context context, int resid) {
		super.setTextAppearance(context, resid);
		saveOriginalColor();
	}

	@Override
	public void setTextColor(ColorStateList colors) {
		super.setTextColor(colors);
		saveOriginalColor();
	}

	@Override
	public void setTextColor(int color) {
		super.setTextColor(color);
		saveOriginalColor();
	}

	private void saveOriginalColor() {
		mOriginalColors = getTextColors().withAlpha(mTextColorAlpha);
	}

	private void startBlink() {
		int sx;
		int dx;
		if (mIsFadein) {
			sx = MIN_ALPHA;
			dx = MAX_ALPHA;
		} else {
			sx = MAX_ALPHA;
			dx = -MAX_ALPHA;
		}
		mScroller.abortAnimation();
		mScroller.startScroll(sx, 0, dx, 0, MAX_FADING_DURATION);
		ViewCompat.postInvalidateOnAnimation(this);
		mBlinkStarted = true;
	}

	private void stopBlink() {
		mScroller.abortAnimation();
		getHandler().removeCallbacks(mReverseFadingRunnable);
		mBlinkStarted = false;
	}

	@Override
	public void computeScroll() {
		if (!mBlinkStarted) {
			// blink stopped.
			return;
		}
		if (!mScroller.isFinished() && mScroller.computeScrollOffset()) {
			mTextColorAlpha = Math.max(MIN_ALPHA, Math.min(MAX_ALPHA, Math.abs(mScroller.getCurrX())));
			DEBUG_LOG("computeScroll mTextColorAlpha=" + mTextColorAlpha + " mIsFadein=" + mIsFadein);
			super.setTextColor(mOriginalColors.withAlpha(mTextColorAlpha));

			// Keep on drawing until the animation has finished.
			ViewCompat.postInvalidateOnAnimation(this);
			return;
		}

		// Done with scroll, clean up state.
		final long delayMillis = mIsFadein ? MAX_FADING_DELAY : MIN_FADING_DELAY;
		getHandler().removeCallbacks(mReverseFadingRunnable);
		getHandler().postDelayed(mReverseFadingRunnable, delayMillis);
	}

}
