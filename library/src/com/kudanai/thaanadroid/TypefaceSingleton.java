package com.kudanai.thaanadroid;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Singleton class to manage handling Typeface instances.
 * using this is recommended, as it will save a lot of memory
 * when managing a large number of views with custom fonts.
 * 
 * @author kudanai
 *
 */
public class TypefaceSingleton {
	
	static TypefaceSingleton _instance = null;
	private AssetManager assets;
	private Map<String,Typeface> fontmap=null;

	
	/**
	 * private constructor for singleton
	 * 
	 * @param AssetManager asset manager with access to application context
	 */
	private TypefaceSingleton(AssetManager am){
		this.assets=am;
	}
	
	
	/**
	 * returns an instance of the singleton
	 * 
	 * @param context application context with access to assetmanager
	 * @return TypefaceSingleton instance
	 */
	public static TypefaceSingleton getInstance(Context context) {
		
		//lazy instantiation
		if (_instance==null)
			_instance=new TypefaceSingleton(context.getAssets());
		
		return _instance;
	}
	
	/**
	 * tries to return an instance of the specified font asset.
	 * the font must exit in the applications assset folder.
	 * ex: assets/fonts/faruma.ttf
	 * 
	 * @param font_asset path of the font relative to the assets folder (including extension)
	 * @exception will throw a NullPointerException if the font_asset is invalid
	 * @return a cached Typeface instance for the specified font.
	 */
	public Typeface getFont(String font_asset){
		
		//lazy instantiation
		if(fontmap==null)
			fontmap=new HashMap<String,Typeface>();
		
		//check if a typeface reference exists
		Typeface font=fontmap.get(font_asset);
		
		if(font==null) {
			font=Typeface.createFromAsset(assets,font_asset);
			fontmap.put(font_asset, font);
		}
		
		return font;
		
	}
	
} //end class
