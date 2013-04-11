package com.lbi.scalatra.repositories

import org.specs2.Specification

class FlightRepositorySpec extends Specification {

  def is =
    "PassengerRepository"                                   ^
      "should contain VA001"                                ! findFlight^
      "should return none for an invalid passenger"         ! findPassengerByValidUsername_returnsNone^
      end

  val flightRepository = new FlightRepository

  def findFlight = {
    flightRepository.getById("VA001").get.name == "Boston to Heathrow"
  }

  def findPassengerByValidUsername_returnsNone = {
    flightRepository.getById("invalid user") == None
  }

}
