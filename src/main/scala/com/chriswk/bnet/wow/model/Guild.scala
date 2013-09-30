package com.chriswk.bnet.wow.model

/**
 * A Wow Guild
 */
case class Guild(
                  lastModified: Long,
                  name: String,
                  realm: String,
                  battlegroup: String,
                  level: Int,
                  side: Int,
                  achievementPoints: Int,
                  emblem: Emblem,
                  members: List[CharHolder]
                  )
