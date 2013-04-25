package com.lbi.scalatra.controller

import org.scalatra.test.specs2._
import com.lbi.scalatra.controller.FlightController

class FlightControllerSpec extends ScalatraSpec {
  def is =
  "GET / on Flight Controller"                ^
    "get by invalid flight id throws 404"    ! invalidFlightIdThrowsException^
    "get by valid flight id"                 ! validFlightId^
                                                end

  val flightController = new FlightController

  addServlet(classOf[FlightController], "/flights/*")

  def invalidFlightIdThrowsException = get("/flights/invalid_id") {
    status must_== 404
  }

  def validFlightId = get("/flights/VA001") {
    status must_== 200
  }

}
