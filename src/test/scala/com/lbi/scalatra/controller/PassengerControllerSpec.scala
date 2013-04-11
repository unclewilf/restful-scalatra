package com.lbi.scalatra.controller

import org.scalatra.test.specs2._

class PassengerControllerSpec extends ScalatraSpec {
  def is =
  "GET / on PassengerController"                ^
    "should return status 200"                  ! returnAllPassengers^
    "should have a url of test"                 ! urlIsTest^
    "get by invalid passenger id throws 404"    ! invalidPassengerIdThrowsException^
    "get by valid passenger id throws 202"      ! validPassengerIdThrowsException^
    "get by valid passenger id throws 202"      ! validPassengerIdThrowsException^
                                                end

  val passengerController = new PassengerController

  addServlet(classOf[PassengerController], "/*")

  def returnAllPassengers = get("/passenger") {
    status must_== 200
  }

  def urlIsTest = (passengerController.url == "/passenger")

  def invalidPassengerIdThrowsException = get("/passenger/invalid_id") {
    status must_== 404
  }

  def validPassengerIdThrowsException = get("/passenger/tj") {
    status must_== 200
  }

}
