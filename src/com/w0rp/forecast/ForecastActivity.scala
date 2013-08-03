package com.w0rp.forecast

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import com.w0rp.androidutils.Net
import com.w0rp.androidutils.SLog
import com.w0rp.forecast.TupleCoordinates.tupleCoordinates
import com.w0rp.androidutils.SingleAsyncTask

class ForecastActivity extends Activity {
    sealed class WeatherRequestTask
    extends SingleAsyncTask[Coordinates, Void, List[ForecastPoint]] {
        override def doInBackground(coords: Coordinates)
        : List[ForecastPoint] = {
            val request = ForecastProcessing.requestForCoordinates(coords)

            SLog.d(request.getURI())

            val response = Net.openRequest(request)

            return ForecastProcessing.parseForecastList(response.download())
        }

        override def onPostExecute(pointList: List[ForecastPoint]) = {
            pointList.foreach(point => {
                SLog.d(JSONForecastPoint.toJSON(point));
            })
        }
    }

    override def onCreate(savedInstanceState : Bundle) = {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        new WeatherRequestTask().execute((10.0, 10.0))
    }

    override def onCreateOptionsMenu(menu : Menu) : Boolean = {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_forecast, menu);
        return true;
    }
}