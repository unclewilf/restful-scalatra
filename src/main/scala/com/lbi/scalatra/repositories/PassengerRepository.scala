package com.lbi.scalatra.repositories

import com.lbi.scalatra.domain.Passenger

object PassengerRepository {

  def getAll: List[Passenger] = {
    List(
      Passenger("Bob Smith", "bs", "12345"),
      Passenger("Ted Jones", "tj", "12345"),
      Passenger("Dave Jackson", "dj", "12345")
    )
  }

//  def authenticate(user:Passenger): Passenger = {
//      println("authenticating user" + user)
//      user
//  }
//
//  def create(username: String, password: String) = println("creating user")
//
//  def delete(user: Passenger) = println("deleting user")

}
