package com.lbi.scalatra

import controller.PassengerController
import org.scalatra.test.specs2._

class PassengerControllerSpec extends ScalatraSpec {
  def is =
  "GET / on PassengerController"                     ^
    "should return status 200"                  ! root200^
    "should have a url of test"                 ! urlIsTest^
                                                end

  val allTasksServlet = new PassengerController

  addServlet(classOf[PassengerController], "/*")

  def root200 = get("/passenger") {
    status must_== 200
  }

  def urlIsTest = (allTasksServlet.url == "/passenger")

}
