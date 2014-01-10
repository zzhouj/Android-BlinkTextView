Android-BlinkTextView
=====================

Android blink text view with it's text repeatly fade in & fade out.

Features
========

+ Android SDK **level 4+**.
+ Text color repeatly fade in & fade out.
+ Options settings: fading duration, delay after fade in/out.

Snapshots
=========

[fadein]: https://github.com/zzhouj/Android-BlinkTextView/raw/master/snapshot/fadein.png  "Fadein"
[fadeout]: https://github.com/zzhouj/Android-BlinkTextView/raw/master/snapshot/fadeout.png  "Fadeout"

![Fadein snapshot][fadein]
![Fadeout snapshot][fadeout]

Usage
=====
1. Add layout xml fragment like below:

		<com.coco.blinktextview.BlinkTextView
		    android:id="@+id/blink_text"
		    android:layout_width="match_parent"
		    android:layout_height="0dp"
		    android:layout_weight="1"
		    android:background="@color/orange"
		    android:gravity="center"
		    android:text="BlinkTextView"
		    android:textColor="@color/white"
		    android:textSize="40sp" />

2. Options settings:

		// Fading duration (min: 150) 
		mBlinkTextView.setFadingDuration(fadingDuration);
		
		// Delay after fadein (min: 0)
		mBlinkTextView.setDelayAfterFadein(delayAfterFadein);
		
		// Delay after fadeout (min: 0)
		mBlinkTextView.setDelayAfterFadeout(delayAfterFadeout);

License
=======

    The MIT License (MIT)
    
    Copyright (c) 2014 justin
    
    Permission is hereby granted, free of charge, to any person obtaining a copy of
    this software and associated documentation files (the "Software"), to deal in
    the Software without restriction, including without limitation the rights to
    use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
    the Software, and to permit persons to whom the Software is furnished to do so,
    subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
    FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
    COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
    IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
    CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
