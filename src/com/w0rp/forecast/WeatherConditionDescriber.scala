package com.w0rp.forecast

import java.util.Locale

sealed trait WeatherConditionDescriber {
  def describe(condition : WeatherCondition) : String;
}

sealed class EnglishWeatherConditionDescriber
extends WeatherConditionDescriber {
    import com.w0rp.forecast.WeatherCondition._

    override def describe(condition : WeatherCondition) = condition match {
      case UNKNOWN => "Unknown"
      case CLEAR => "Clear"
      case PARTLY_CLOUDY => "Partly cloudy"
      case CLOUDY => "Cloudy"
      case LIGHT_DRIZZLE => "Light drizzle"
      case MEDIUM_DRIZZLE => "Medium drizzle"
      case HEAVY_DRIZZLE => "Heavy drizzle"
      case LIGHT_RAIN => "Light rain"
      case MEDIUM_RAIN => "Medium rain"
      case HEAVY_RAIN => "Heavy rain"
      case LIGHT_SHOWERS => "Light showers"
      case MEDIUM_SHOWERS => "Medium showers"
      case HEAVY_SHOWERS => "Heavy showers"
      case LIGHT_THUNDERSTORM => "Light thunderstorm"
      case MEDIUM_THUNDERSTORM => "Medium thunderstorm"
      case HEAVY_THUNDERSTORM => "Heavy thunderstorm"
      case LIGHT_SNOW => "Light snow"
      case MEDIUM_SNOW => "Medium snow"
      case HEAVY_SNOW => "Heavy snow"
      case SLEET => "Sleet"
      case HAIL => "Hail"
      case COLD => "Cold"
      case HOT => "Hot"
      case WINDY => "Windy"
      case MIST => "Mist"
      case FOG => "Fog"
      case DUST => "Dust"
      case SMOKE => "Smoke"
      case HAZE => "Haze"
      case TORNADO => "Tornado"
      case TROPICAL_STORM => "Tropical storm"
      case HURRICANE => "Hurricane"
    }
}

object WeatherConditionDescriber {
    val english = new EnglishWeatherConditionDescriber();

    def forLocale(locale : Locale) = locale.getLanguage() match {
        case _ => english
    }
}

