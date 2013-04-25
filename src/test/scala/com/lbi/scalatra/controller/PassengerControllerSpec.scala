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

  addServlet(classOf[PassengerController], "/passengers/*")

  def returnAllPassengers = get("/passengers") {
    status must_== 200
  }

  def invalidPassengerIdThrowsException = get("/passengers/invalid_id") {
    status must_== 404
  }

  def validPassengerId = get("/passengers/tj") {
    status must_== 200
  }

}
