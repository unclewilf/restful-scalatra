package com.lbi.scalatra.repositories

import com.lbi.scalatra.domain.User

class UserRepository {

  def authenticate(user:User): User = {
      println("authenticating user" + user)
      user
  }

  def create(username: String, password: String) = println("creating user")

  def delete(user: User) = println("deleting user")

}
