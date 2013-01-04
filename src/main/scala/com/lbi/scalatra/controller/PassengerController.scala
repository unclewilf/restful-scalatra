package com.lbi.scalatra.controller

import org.scalatra._
import scalate.ScalateSupport
import com.lbi.scalatra.repositories.PassengerRepository

// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._

class PassengerController extends ScalatraServlet with JacksonJsonSupport with ScalateSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  val url = "/passenger"
  val passengerRepository = new PassengerRepository

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get(url) {
    passengerRepository.getAll
  }

  get(url+ "/:username") {
    val passenger = passengerRepository.getByUsername(params("username"))
    passenger match {
      case Some(validPassenger) => validPassenger
      case None => resourceNotFound()
    }
  }

}
