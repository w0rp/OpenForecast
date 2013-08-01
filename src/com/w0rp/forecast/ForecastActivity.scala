package com.w0rp.forecast

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.util.Log

class ForecastActivity extends Activity {
    override def onCreate(savedInstanceState : Bundle) = {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        val temp = new Celsius(40);

        val temp2 : Fahrenheit = temp.toFahrenheit;

        val x, y = new Celsius(30);
    }

    override def onCreateOptionsMenu(menu : Menu) : Boolean = {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_forecast, menu);
        return true;
    }
}