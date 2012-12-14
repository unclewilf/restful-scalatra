package com.lbi.scalatra.domain

trait OnOffDeviceComponentImpl extends OnOffDeviceComponent {

  class Heater extends OnOffDevice {
    def on = println("heater.on")
    def off = println("heater.off")
  }

}
