package com.w0rp.forecast

class MilesPerHour(val num: Double) extends AnyVal {
    def unary_- = new MilesPerHour(-num)
    def unary_+ = this
    def +(other : MilesPerHour) = new MilesPerHour(num + other.num)
    def -(other : MilesPerHour) = new MilesPerHour(num - other.num)
    def /(other : MilesPerHour) = new MilesPerHour(num / other.num)
    def *(other : MilesPerHour) = new MilesPerHour(num * other.num)
    def toKilometersPerHour = new KilometersPerHour(num * 1.609)
}