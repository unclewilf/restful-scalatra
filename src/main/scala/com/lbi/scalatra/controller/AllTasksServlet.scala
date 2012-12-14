package com.lbi.scalatra.controller

import org.scalatra._
import scalate.ScalateSupport

class AllTasksServlet extends ScalatraServlet with ScalateSupport {

  val url = "/test"

  get(url) {
    "content"
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
