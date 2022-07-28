package com.appsflyer.androidsampleapp.vanh;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
//import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    static final String LOG_TAG = "MainActivity";

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetInstallDataText();


        Button trackEventButton = findViewById(R.id.trackEventButton);
        trackEventButton.setOnClickListener(v -> {
            /* Track Events in real time */
            Map<String, Object> eventValue = new HashMap<>();
            eventValue.put(AFInAppEventParameterName.REVENUE, 200);
            eventValue.put(AFInAppEventParameterName.CONTENT_TYPE, "category_a");
            eventValue.put(AFInAppEventParameterName.CONTENT_ID, "1234567");
            eventValue.put(AFInAppEventParameterName.CURRENCY, "USD");
            AppsFlyerLib.getInstance().logEvent(
                    getApplicationContext(),
                    AFInAppEventType.PURCHASE,
                    eventValue);
        });
    }

    /*** Ignore - used to display install data ***/
    public void SetInstallDataText(){
        handler.postDelayed(() -> {
            TextView installData = findViewById(R.id.installDataText);
            installData.setText(AFApplication.InstallConversionData);
        }, 5000);

        Log.i(LOG_TAG,"SetInstallDataText is called");
    }

}
