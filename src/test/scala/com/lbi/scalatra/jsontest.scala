package com.lbi.scalatra

import org.scalatra.test.specs2.ScalatraSpec
import org.json4s._


class Jsontest extends ScalatraSpec {
  def is =
    "test the json support"                ^
      "should produce json"                  ! produceJsonFromObject^
      end

  def produceJsonFromObject = {
    val list = "name\":\"Bob Smith\",\"username\":\"bs\",\"password\":\"12345\"}"
    val parsed = string2JsonInput(list).toString
    println(parsed)
    true
  }

}
