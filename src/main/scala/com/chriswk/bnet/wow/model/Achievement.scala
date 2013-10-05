package com.chriswk.bnet.wow.model

/**
 * A Wow Achievement
 */
case class Achievements(achievements: List[AchievementType])
case class AchievementType(id: Long, achievements: List[Achievement], name: String)
case class Achievement(id: Long, title: String, points: Long, description: String, reward: Option[String], icon: String, criteria: Option[List[Criteria]], accountWide: Boolean, factionId: Long)
