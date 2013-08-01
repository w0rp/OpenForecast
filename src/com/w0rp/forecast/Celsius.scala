package com.w0rp.forecast

class Celsius(val num: Double) extends AnyVal {
    def unary_- = new Celsius(-num)
    def unary_+ = this
    def +(other : Celsius) = new Celsius(num + other.num)
    def -(other : Celsius) = new Celsius(num - other.num)
    def /(other : Celsius) = new Celsius(num / other.num)
    def *(other : Celsius) = new Celsius(num * other.num)
    def toFahrenheit = new Fahrenheit(num * 9 / 5 + 32)
}