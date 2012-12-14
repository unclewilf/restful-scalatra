package com.lbi.scalatra.configuration

import com.lbi.scalatra.domain.{WarmerComponentImpl, SensorDeviceComponentImpl, OnOffDeviceComponentImpl}

object ComponentRegistry extends

  OnOffDeviceComponentImpl with
  SensorDeviceComponentImpl with
  WarmerComponentImpl {

  val onOff = new Heater
  val sensor = new PotSensor
  val warmer = new Warmer

}
