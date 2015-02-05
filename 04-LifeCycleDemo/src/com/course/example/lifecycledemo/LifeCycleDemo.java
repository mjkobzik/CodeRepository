/* This example demonstrates the state changes of an Activity.
 * Type CNTL + F11 to emulate change from portrait to landscape orientation.
 * The OS will destroy the Activity and then reinitialize it. 
 * This will cause onRestoreInstanceState() to be called.
*/
package com.course.example.lifecycledemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;

public class LifeCycleDemo extends Activity {

	EditText txtMsg;
	Button btnFinish;
	TextView txtToDo;
	String instanceData;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		//restore instance value
		if (savedInstanceState != null) {
			Toast.makeText(this, "Bundle not null", Toast.LENGTH_LONG)
			.show();
			} else {
				Toast.makeText(this, "Bundle null", Toast.LENGTH_LONG)
				.show();
			}
		
		txtMsg = (EditText) findViewById(R.id.txtMsg);
		txtToDo = (TextView) findViewById(R.id.txtToDo);
		txtMsg = (EditText) findViewById(R.id.txtMsg);
		instanceData = new Date().toString();
		
		String msg = "Instructions:                	                 \n "
				+ "0. New instance (onCreate, onStart, onResume)   \n "
				+ "1. Back Arrow   (onPause, onStop, onDestroy)    \n "
				+ "2. Finish       (onPause, onStop, onDestroy)    \n "
				+ "3. Home		 (onPause, onStop)	 \n "
				+ "4. After 3> App Tab> re-execute current app     \n "
				+ "  (onRestart, onStart, onResume)		 \n "
				+ "5. Run DDMS> Receive a phone call or SMS	 \n "
				+ "  (onRestart, onStart, onResume)		 \n "
				+ "6. Enter some data - repeat steps 1-5   	 \n ";

		txtToDo.setText(msg);
		txtMsg.setHint("Enter some data here");

		btnFinish = (Button) findViewById(R.id.btnFinish);

		btnFinish.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {				
				finish();
			}
		});

		Toast.makeText(this, "onCreate - Demo", Toast.LENGTH_LONG)
				.show();
	}//onCreate
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "onDestroy - Demo", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(this, "onPause - Demo", Toast.LENGTH_LONG)
				.show();

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart - Demo", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResume - Demo", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "onStart - Demo", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "onStop - Demo", Toast.LENGTH_LONG)
				.show();
	}

	/*
	 * This method is called after onStart() when the activity is being
	 * re-initialized from a previously saved state. The default implementation
	 * of this method performs a restore of any view state that had previously
	 * been frozen by onSaveInstanceState(Bundle). Only called to restore state
	 * if activity was previously killed by OS. Most apps use onCreate(bundle)
	 * to restore view state.
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		instanceData = savedInstanceState.getString("date");
		Toast.makeText(this, "onRestoreInstanceState ... " + instanceData,
				Toast.LENGTH_LONG).show();
	}

	/*
	 * Called to save instance state of an activity before being
	 * killed so that the state can be restored in onCreate(Bundle) or
	 * onRestoreInstanceState(Bundle) (the Bundle populated by this method will
	 * be passed to both). This method is called before an activity may be
	 * killed so that when it comes back some time in the future it can restore
	 * its state. For example, if activity B is launched in front of activity A,
	 * and at some point activity A is killed to reclaim resources, activity A
	 * will have a chance to save the current state of its user interface via
	 * this method so that when the user returns to activity A, the state of the
	 * user interface can be restored via: onCreate(Bundle) or
	 * onRestoreInstanceState(Bundle).
	 */
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putString("date", new Date().toString());
		Toast.makeText(this, "onSaveInstanceState ...BUNDLING",
				Toast.LENGTH_LONG).show();
	} 
	
}
