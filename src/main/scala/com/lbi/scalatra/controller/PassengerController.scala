package com.lbi.scalatra.controller

import org.scalatra._
import scalate.ScalateSupport
import com.lbi.scalatra.repositories.PassengerRepository

import org.json4s.{DefaultFormats, Formats}

import org.scalatra.json._

class PassengerController extends ScalatraServlet with JacksonJsonSupport with ScalateSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats
  override def js

  val url = "/passenger"
  val passengerRepository = new PassengerRepository

  before() {
    contentType = formats("json")
    initialize()
  }

  get(url) {
    passengerRepository.getAll
  }

  get(url+ "/:username") {
    passengerRepository.getByUsername(params("username")) match {
      case Some(validPassenger) => validPassenger
      case None => resourceNotFound()
    }
  }

}
