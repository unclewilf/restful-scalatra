package com.lbi.scalatra.repositories

import org.specs2.Specification

class PassengerRepositorySpec extends Specification {

  def is =
    "PassengerRepository"                                   ^
      "should contain the correct number of passengers"     ! containsCorrectPassengers^
      "should contain tj"                                   ! findPassengerByValidUsername_returnsPassenger^
      "should return none for an invalid passenger"         ! findPassengerByValidUsername_returnsNone^
      end

  val passengerRepository = new PassengerRepository

  def containsCorrectPassengers = {
    passengerRepository.getAll.size == 3
  }

  def findPassengerByValidUsername_returnsPassenger = {
    passengerRepository.getByUsername("tj").get.name == "Ted Jones"
  }

  def findPassengerByValidUsername_returnsNone = {
    passengerRepository.getByUsername("invalid user") == None
  }

}
