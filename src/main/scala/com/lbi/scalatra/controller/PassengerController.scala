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

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get(url) {
    PassengerRepository.getAll
  }

  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }

}
