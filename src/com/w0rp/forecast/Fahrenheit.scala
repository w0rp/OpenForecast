package com.w0rp.forecast

class Fahrenheit(val num: Double) extends AnyVal {
    def unary_- = new Fahrenheit(-num)
    def unary_+ = this
    def +(other : Fahrenheit) = new Fahrenheit(num + other.num)
    def -(other : Fahrenheit) = new Fahrenheit(num - other.num)
    def /(other : Fahrenheit) = new Fahrenheit(num / other.num)
    def *(other : Fahrenheit) = new Fahrenheit(num * other.num)
    def toCelsius = new Celsius((num - 32) * 5 / 9)
}