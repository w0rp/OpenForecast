package com.w0rp.forecast

trait ForecastPoint {
    def windSpeed : KilometersPerHour;
    def condition : WeatherCondition;
    def temperature : Fahrenheit;
}

class MutableForecastPoint extends ForecastPoint {
    private var _windSpeed = new KilometersPerHour(Double.NaN);
    private var _condition = WeatherCondition.UNKNOWN;
    private var _temperature = new Fahrenheit(Double.NaN);

    def windSpeed = _windSpeed;
    def windSpeed_(value:KilometersPerHour):Unit = _windSpeed = value

    def condition = _condition;
    def condition_(value:WeatherCondition):Unit = _condition = value

    def temperature = _temperature;
    def temperature_(value:Fahrenheit):Unit = _temperature = value
}
