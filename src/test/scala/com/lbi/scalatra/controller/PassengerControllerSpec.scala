package com.lbi.scalatra.controller

import org.scalatra.test.specs2._

class PassengerControllerSpec extends ScalatraSpec {
  def is =
  "GET / on PassengerController"                ^
    "return all passengers with status 200"     ! returnAllPassengers^
    "get by invalid passenger id throws 404"    ! invalidPassengerIdThrowsException^
    "get by valid passenger id"                 ! validPassengerId^
                                                end

  val passengerController = new PassengerController

  addServlet(classOf[PassengerController], "/*")

  def returnAllPassengers = get("/passenger") {
    status must_== 200
  }

  def invalidPassengerIdThrowsException = get("/passenger/invalid_id") {
    status must_== 404
  }

  def validPassengerId = get("/passenger/tj") {
    status must_== 200
  }

}
