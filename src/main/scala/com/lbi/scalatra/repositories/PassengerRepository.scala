package com.lbi.scalatra.repositories

import com.lbi.scalatra.domain.Passenger

class PassengerRepository {

  def getAll: List[Passenger] = {
    List(
      Passenger("Bob Smith", "bs", "12345"),
      Passenger("Ted Jones", "tj", "12345"),
      Passenger("Dave Jackson", "dj", "12345")
    )
  }

  def getByUsername(username: String): Option[Passenger] = {
    getAll.find(passenger => passenger.username == username)
  }

}
