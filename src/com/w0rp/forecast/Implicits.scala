package com.w0rp.forecast

import java.net.URI

object Implicits {
  implicit def StringToURI(str: String) = new URI(str)
}