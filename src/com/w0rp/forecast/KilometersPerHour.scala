package com.w0rp.forecast

class KilometersPerHour(val num: Double) extends AnyVal {
  def unary_- = new KilometersPerHour(-num)
  def unary_+ = this
  def +(other : KilometersPerHour) = new KilometersPerHour(num + other.num)
  def -(other : KilometersPerHour) = new KilometersPerHour(num - other.num)
  def /(other : KilometersPerHour) = new KilometersPerHour(num / other.num)
  def *(other : KilometersPerHour) = new KilometersPerHour(num * other.num)
  def toMilesPerHour = new MilesPerHour(num * 0.6214)
}