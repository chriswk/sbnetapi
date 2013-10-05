package com.chriswk.bnet.wow.model

/**
 * A Wow Character
 */

case class Spec(name: Option[String], role: String, backgroundImage: String, icon: String, description: String, order: Int)
case class Character(name: String,
                     achievementPoints: Int,
                     battlegroup: String,
                     `class`: Int,
                     level: Int,
                     race: Int,
                     realm: String,
                     thumbnail: String,
                     guild: String,
                     spec: Option[Spec]
                     )