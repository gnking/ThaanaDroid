#Thaana Droid

ThaanaDroid is a collection of classes and widgets which I have developed and used for various Thaana based android projects. You can import it as a library into your own project, and forego the hassle of doing thaana stuff..

#Usage

##importing ThaanaDroid

These instructions mostly apply to Eclipse. ThaanaDroid is a an Android library project, and needs to be added to your workspace.

* import the library project from the `library` folder. 
	* Select **File > Import**.
	* Select **Existing Android Code Into Workspace** and click Next. 
	* Find where you downloaded ThaanaDroid and import it
	
* in your project, right click and select *properties*
	* in the `library` pane, click Add, and select ThaanaDroid
	
##usage

There are currently two major components. a `ThaanaTextView` and a `ThaanaEditText` which can both be added to your layouts (see example).

include the `xmlns:thaanadroid="http://schemas.android.com/apk/res/YOUR_PACKAGE_NAME` namespace and specify the font you want to use (`thaanadroid:thaanaFont="fonts/faruma.ttf"`). the font **MUST be present in your assets folder**. for the EditText, it is recommeneded to attach an `ThaanaEditTextThaanafiedListener` if you need to catch textchange events, instead of using a TextWatcher (which you could also do, but will not catch the "thaanafied" text)

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:thaanadroid="http://schemas.android.com/apk/res/YOUR_PACKAGE_NAME">

    <com.kudanai.thaanadroid.ThaanaTextView
        android:id="@+id/textv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/hello_thaana"
        thaanadroid:thaanaFont="fonts/faruma.ttf"/>
    
    <com.kudanai.thaanadroid.ThaanaEditText
        android:layout_below="@id/textv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="14sp"
        thaanadroid:thaanaFont="fonts/faruma.ttf"/>

	</RelativeLayout>

##additional usage

for other usage docs, refer to the JavaDocs or the source code

#Contributing

If you find bugs, or wish to contribute additional features/fixes, please feel free to clone and submit fixes.


#Developed By
* [@kudanai](http://kudanai.com)

#License

This project is licensed under Apache 2.0

    Copyright 2012 Naail Abdul Rahman (@kudanai)

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

   		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.