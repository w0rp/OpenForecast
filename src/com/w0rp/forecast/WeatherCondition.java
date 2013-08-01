package com.w0rp.forecast;

public enum WeatherCondition {
    UNKNOWN,
    CLEAR,
    PARTLY_CLOUDY,
    CLOUDY,
    LIGHT_DRIZZLE,
    MEDIUM_DRIZZLE,
    HEAVY_DRIZZLE,
    LIGHT_RAIN,
    MEDIUM_RAIN,
    HEAVY_RAIN,
    LIGHT_SHOWERS,
    MEDIUM_SHOWERS,
    HEAVY_SHOWERS,
    LIGHT_THUNDERSTORM,
    MEDIUM_THUNDERSTORM,
    HEAVY_THUNDERSTORM,
    LIGHT_SNOW,
    MEDIUM_SNOW,
    HEAVY_SNOW,
    SLEET,
    HAIL,
    COLD,
    HOT,
    WINDY,
    MIST,
    FOG,
    DUST,
    SMOKE,
    HAZE,
    TORNADO,
    TOPICAL_STORM,
    HURRICANE;

    public static WeatherCondition fromOpenWeatherCode(int weatherCode) {
        switch (weatherCode) {
        case 200: // thunderstorm with light rain
        case 210: // light thunderstorm
        case 230: // thunderstorm with light drizzle
            return LIGHT_THUNDERSTORM;
        case 201: // thunderstorm with rain
        case 211: // thunderstorm
        case 221: // ragged thunderstorm
        case 231: // thunderstorm with drizzle
            return MEDIUM_THUNDERSTORM;
        case 202: // thunderstorm with heavy rain
        case 212: // heavy thunderstorm
        case 232: // thunderstorm with heavy drizzle
            return HEAVY_THUNDERSTORM;
        case 300: // light intensity drizzle
        case 310: // light intensity drizzle rain
            return LIGHT_DRIZZLE;
        case 301: // drizzle
        case 311: // drizzle rain
            return MEDIUM_DRIZZLE;
        case 302: // heavy intensity drizzle
        case 312: // heavy intensity drizzle rain
            return HEAVY_DRIZZLE;
        case 500: // light rain
            return LIGHT_RAIN;
        case 501: // moderate rain
        case 511: // freezing rain
            return MEDIUM_RAIN;
        case 502: // heavy intensity rain
        case 503: // very heavy rain
        case 504: // extreme rain
            return HEAVY_RAIN;
        case 321: // shower drizzle
        case 520: // light intensity shower rain
            return LIGHT_SHOWERS;
        case 521: // shower rain
            return MEDIUM_SHOWERS;
        case 522: // heavy intensity shower rain
            return HEAVY_SHOWERS;
        case 600: // light snow
            return LIGHT_SNOW;
        case 601: // snow
        case 621: // shower snow
            return MEDIUM_SNOW;
        case 602: // heavy snow
            return HEAVY_SNOW;
        case 611: // sleet
            return SLEET;
        case 701: // mist
            return MIST;
        case 711: // smoke
            return SMOKE;
        case 721: // haze
            return HAZE;
        case 731: // Sand/Dust Whirls
            return DUST;
        case 800: // sky is clear
            return CLEAR;
        case 801: // few clouds
        case 802: // scattered clouds
            return PARTLY_CLOUDY;
        case 803: // broken clouds
        case 804: // overcast clouds
            return CLOUDY;
        case 900: // tornado
            return TORNADO;
        case 901: // tropical storm
            return TOPICAL_STORM;
        case 902: // hurricane
            return HURRICANE;
        case 903: // cold
            return COLD;
        case 904: // hot
            return HOT;
        case 905: // windy
            return WINDY;
        case 906: // hail
            return HAIL;
        default:
            return UNKNOWN;
        }
    }
}
