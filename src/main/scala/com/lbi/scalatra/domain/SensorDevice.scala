package com.lbi.scalatra.domain

trait SensorDeviceComponent {

  val sensor: SensorDevice

  trait SensorDevice {
    def isCoffeePresent: Boolean
  }

}
