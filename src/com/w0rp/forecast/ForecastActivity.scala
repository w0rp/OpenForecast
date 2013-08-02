package com.w0rp.forecast

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.util.Log
import java.util.Locale

class ForecastActivity extends Activity {
    override def onCreate(savedInstanceState : Bundle) = {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
    }

    override def onCreateOptionsMenu(menu : Menu) : Boolean = {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_forecast, menu);
        return true;
    }
}