package com.lbi.scalatra.domain

trait OnOffDeviceComponent {

  val onOff: OnOffDevice

  trait OnOffDevice {
    def on: Unit
    def off: Unit
  }

}
