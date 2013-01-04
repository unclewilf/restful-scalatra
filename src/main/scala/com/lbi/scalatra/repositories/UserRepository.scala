package com.lbi.scalatra.repositories

import com.lbi.scalatra.domain.Passenger

class UserRepository {

  def authenticate(user:Passenger): Passenger = {
      println("authenticating user" + user)
      user
  }

  def create(username: String, password: String) = println("creating user")

  def delete(user: Passenger) = println("deleting user")

}
