package com.kudanai.thaanadroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import com.kudanai.thaanadroid.TypefaceSingleton;

public class ThaanaTextView extends TextView {


	public ThaanaTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setup(attrs);
	}
	
    public ThaanaTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setup(attrs);
    }
    
    
    /**
     * called by constructor to setup the view
     * @param attrs AttributeSet for the view
     */
	private void setup(AttributeSet attrs){
		
		// check if the widget is in edit mode (graphical editor)
		// obviously you won't get a nice preview of the widget
		if(isInEditMode())
			return;
		
		//set the typeface
		TypedArray attribs = getContext().obtainStyledAttributes(attrs,R.styleable.ThaanaDroid);
		String font=attribs.getString(R.styleable.ThaanaDroid_thaanaFont);
		if(font==null)
			Log.w("ThaanaEditText", "Please specify thaanaFont for the widget");
		else {
			Typeface tf = TypefaceSingleton.getInstance(getContext()).getFont(font);
			this.setTypeface(tf);
		}
		
		
		//set text to the right side and stuff
		this.setGravity(Gravity.RIGHT);
			
		//API 17+
		if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
			this.setTextDirection(TEXT_DIRECTION_RTL); 
		}
		
		//don't forget this
		attribs.recycle();
	}
}
