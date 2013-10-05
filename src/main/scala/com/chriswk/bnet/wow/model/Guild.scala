package com.chriswk.bnet.wow.model

/**
 * A Wow Guild
 */

case class Member(character: Character, rank: Int)
case class Guild(
                  name: String,
                  realm: String,
                  battlegroup: String,
                  level: Int,
                  side: Int,
                  achievementPoints: Int,
                  emblem: Emblem,
                  members: Option[List[Member]]
                  )
