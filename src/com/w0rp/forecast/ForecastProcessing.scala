package com.w0rp.forecast

import scala.collection.mutable.ListBuffer
import org.json.JSONArray
import org.json.JSONObject
import java.util.Date
import com.w0rp.forecast.Implicits._
import com.w0rp.androidutils.Net
import com.w0rp.androidutils.SLog

object ForecastProcessing  {
    def requestForCoordinates(coords: Coordinates) =
        Net.prepareGet(("http://api.openweathermap.org/"
            + "data/2.5/forecast?mode=json&units=metric&lat=%f&lon=%f")
        .format(coords.latitude, coords.longitude))

    def parseForecastList(jsonString : String) : List[ForecastPoint] = {
        val buffer = new ListBuffer[ForecastPoint]

        // Parse the forecast JSON.
        var resultObject = new JSONObject(jsonString)
        val resultList = resultObject.getJSONArray("list")

        // Load the forecast JSON into our own objects.
        for (i <- 0 until resultList.length) {
            val obj = resultList.getJSONObject(i)
            // The weather object is wrapped in an array for some reason.
            val weatherObj = obj.getJSONArray("weather").getJSONObject(0);

            val point = new MutableForecastPoint

            point.date = new Date(obj.getLong("dt"));
            point.condition = WeatherCondition.fromOpenWeatherCode(
                weatherObj.getInt("id"))
            point.temperature = new Celsius(
                obj.getJSONObject("main").getDouble("temp"))

            val wind = obj.getJSONObject("wind")

            point.windSpeed = new KilometersPerHour(wind.getDouble("speed"))
            point.windDirection = wind.getDouble("deg")

            buffer += point
        }

        return buffer.toList
    }
}