package com.lbi.scalatra

import controller.AllTasksServlet
import org.scalatra.test.specs2._

class AllTasksServletSpec extends ScalatraSpec {
  def is =
  "GET / on AllTasksServlet"                     ^
    "should return status 200"                  ! root200^
    "should have a url of test"                 ! urlIsTest^
                                                end

  val allTasksServlet = new AllTasksServlet

  addServlet(classOf[AllTasksServlet], "/*")

  def root200 = get("/test") {
    status must_== 200
  }

  def urlIsTest = (allTasksServlet.url == "/test")

}
