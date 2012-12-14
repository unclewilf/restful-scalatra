package com.lbi.scalatra

import controller.AllTasksServlet
import org.scalatra.test.specs2._

class AllTasksServletSpec extends ScalatraSpec {
  def is =
  "GET /test on AllTasksServlet"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[AllTasksServlet], "/*")

  def root200 = get("/test") {
    status must_== 200
  }

}
