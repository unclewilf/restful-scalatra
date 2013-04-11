package com.lbi.scalatra.domain

trait SensorDeviceComponentImpl extends SensorDeviceComponent {

  class PotSensor extends SensorDevice {
    def isCoffeePresent = true
  }

}
