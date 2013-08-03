package com.w0rp.forecast

import android.location.Location

trait Coordinates {
    def latitude : Double;
    def longitude : Double;
}

class MutableCoordinates extends Coordinates {
    var latitude = Double.NaN;
    var longitude = Double.NaN;
}

class TupleCoordinates(val tuple: (Double, Double)) extends Coordinates {
    def latitude = tuple._1
    def longitude = tuple._2
}

object TupleCoordinates {
    implicit def tupleCoordinates(tup: (Double, Double)): Coordinates = {
        return new TupleCoordinates(tup);
    }
}

class LocationCoordinates(location: Location) extends Coordinates {
    assert(location != null);

    def latitude = location.getLatitude()
    def longitude = location.getLongitude()
}