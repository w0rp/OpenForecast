package com.w0rp.forecast

import java.util.Date
import org.json.JSONObject

trait ForecastPoint {
    def windSpeed : KilometersPerHour;
    def condition : WeatherCondition;
    def temperature : Celsius;
    def date : Date;
    def windDirection : Double;
}

class MutableForecastPoint extends ForecastPoint {
    var windSpeed = new KilometersPerHour(Double.NaN);
    var condition = WeatherCondition.UNKNOWN;
    var temperature = new Celsius(Double.NaN);
    var date = new Date(0);
    private var _windDirection = Double.NaN;

    def windDirection = _windDirection;
    def windDirection_=(value:Double) {
        require(value >= 0);
        require(value <= 360);

        _windDirection = value;
    }
}

object JSONForecastPoint {
    def fromJSON(obj: JSONObject): ForecastPoint = {
        val point = new MutableForecastPoint();

        point.windSpeed = new KilometersPerHour(obj.getDouble("windSpeed"))
        point.condition = WeatherCondition.valueOf(obj.getString("condition"))
        point.temperature = new Celsius(obj.getDouble("temperature"))
        point.date = new Date(obj.getLong("date"))
        point.windDirection = obj.getDouble("windDirection")

        return point;
    }

    def toJSON(point: ForecastPoint): JSONObject = {
        val obj = new JSONObject();

        obj.put("windSpeed", point.windSpeed.num)
        obj.put("condition", point.condition.name())
        obj.put("temperature", point.temperature.num)
        obj.put("date", point.date.getTime())
        obj.put("windDirection", point.windDirection)

        return obj;
    }
}
