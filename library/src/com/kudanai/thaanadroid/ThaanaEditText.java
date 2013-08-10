package com.kudanai.thaanadroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;

/**
 * an extention of android.widget.EditText
 * which will substitute characters for thaana on the fly
 * 
 * @author kudanai
 *
 */
public class ThaanaEditText extends EditText{
	
	/**
	 * interface is called when the edittext contents are modified,
	 * and then "thaanafied". use this instead of the textmodifiedlistener
	 *
	 */
	public static interface ThaanaEditTextThaanafiedListener{
		abstract void onEditTextThaanafied(CharSequence s, int start, int before, int count);
	}

	private ThaanaEditTextThaanafiedListener listener;
	private TextWatcher tWatcher;
	private ThaanaUtils tu;
	
	public ThaanaEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		setup(attrs);
	}
	
	public ThaanaEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setup(attrs);
	}
	
	
    /**
     * called by constructor to setup the view
     * @param attrs AttributeSet for the view
     */
	private void setup(AttributeSet attrs){
		
		//set default listener
		listener=new ThaanaEditTextThaanafiedListener(){
			@Override
			public void onEditTextThaanafied(CharSequence s, int start,
					int before, int count) {
				return;
			}
		};
		
		//utils and stuff
		tu=new ThaanaUtils();
		
		//----------------------------PROPERTIES---------------------
		//This is all pretty much the same as ThaanaTextView
		
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
		
		
		//----------------------------TEXTWATCHER----------------
		
		final ThaanaEditText v=this;	//reference to object
		tWatcher=new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				v.removeTextChangedListener(tWatcher);//after this line you do the editing code
				v.setText(tu.transposeChars(s));
				v.setSelection(v.getText().length());
				v.listener.onEditTextThaanafied(v.getText().toString(), start, before, count);
				v.addTextChangedListener(tWatcher); // you register again for listener callbacks
			}
			
		};
		
		this.addTextChangedListener(tWatcher); //register textchanged listener
		
		//don't forget this
		attribs.recycle();
	}
	
	/**
	 * set the callback listener for thaanaedittextthaanafied events
	 * 
	 * @param listener
	 */
	public void setThaanafiedListener(ThaanaEditTextThaanafiedListener listener){
		this.listener=listener;
	}

}
