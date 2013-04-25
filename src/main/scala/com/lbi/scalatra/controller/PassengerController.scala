package com.lbi.scalatra.controller

import org.scalatra._
import scalate.ScalateSupport
import com.lbi.scalatra.repositories.PassengerRepository

import org.json4s.{DefaultFormats, Formats}

import org.scalatra.json._

class PassengerController extends ScalatraServlet with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  val url = "/passengers"
  val passengerRepository = new PassengerRepository

  before() {
    contentType = formats("json")
  }

  get() {
    passengerRepository.getAll
  }

  get("/:username") {
    passengerRepository.getByUsername(params("username")) match {
      case Some(validPassenger) => validPassenger
      case None => resourceNotFound()
    }
  }

}
