package com.lbi.scalatra.repositories

import com.lbi.scalatra.domain.{Flight}

class FlightRepository {

  def getById(id: String): Option[Flight] = {
    if(id=="VA001") {
      return Option(Flight(id, "Boston to Heathrow"))
    }
    None
  }

}
