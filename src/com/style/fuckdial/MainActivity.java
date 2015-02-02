package com.style.fuckdial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_dial = (Button) findViewById(R.id.btn_dial);
        Button btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_dial.setOnClickListener(new Call());
        btn_exit.setOnClickListener(new Call());
    }

    private class Call implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_dial:
				EditText et_number = (EditText) findViewById(R.id.et_number);
				String number = et_number.getText().toString();
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+number));
				startActivity(intent);
				break;
			case R.id.btn_exit:
				android.os.Process.killProcess(android.os.Process.myPid());
			default:
				break;
			}
		}
    }
}
