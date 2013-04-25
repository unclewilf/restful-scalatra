package com.lbi.scalatra.repositories

import com.lbi.scalatra.domain.{Flight, Passenger}

class PassengerRepository {

  val flightRepository = new FlightRepository

  def getAll: List[Passenger] = {
    List(
      Passenger("Bob Smith", "bs", "12345", List(Flight("/flights/VA001", "Boston to Heathrow"))),
      Passenger("Ted Jones", "tj", "12345", List(Flight("/flights/VA001", "Boston to Heathrow"))),
      Passenger("Dave Jackson", "dj", "12345", List(Flight("/flights/VA001", "Boston to Heathrow")))
    )
  }

  def getByUsername(username: String): Option[Passenger] = {
    getAll.find(passenger => passenger.username == username)
  }

}
