package com.lbi.scalatra.controller

import org.scalatra._
import com.lbi.scalatra.repositories.{FlightRepository, PassengerRepository}

import org.json4s.{DefaultFormats, Formats}

import org.scalatra.json._

class FlightController extends ScalatraServlet with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  val url = "/flights"
  val flightRepository = new FlightRepository

  before() {
    contentType = formats("json")
  }

  get("/:id") {
    flightRepository.getById(params("id")) match {
      case Some(validFlight) => validFlight
      case None => resourceNotFound()
    }
  }

}
