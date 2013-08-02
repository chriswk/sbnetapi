package com.chriswk.bnet.wow.model

/**
 * A Wow Character
 */
case class Character(lastModified: Long,
                     name: String,
                     achievementPoints: Int,
                     battlegroup: String,
                     calcClass: String,
                     `class`: Int,
                     level: Int,
                     race: Int,
                     realm: String,
                     thumbnail: String
                     )