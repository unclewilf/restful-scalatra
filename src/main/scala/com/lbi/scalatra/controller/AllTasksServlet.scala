package com.lbi.scalatra.controller

import org.scalatra._
import scalate.ScalateSupport
import com.lbi.scalatra.configuration.ComponentRegistry

class AllTasksServlet extends ScalatraServlet with ScalateSupport {

  val url = "/test"

  get(url) {
    val warmer = ComponentRegistry.warmer
    warmer.trigger
    "TEST URL"
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
