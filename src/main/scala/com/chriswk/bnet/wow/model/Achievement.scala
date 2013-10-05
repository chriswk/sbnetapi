package com.chriswk.bnet.wow.model

/**
 * A Wow Achievement
 */
case class Achievements(achievements: List[AchievementCategory])
case class AchievementCategory(id: Long, categories: Option[List[AchievementCategory]], achievements: Option[List[Achievement]], name: String)
case class Achievement(id: Long, title: String, points: Long, description: String, reward: Option[String], icon: String, criteria: Option[List[Criteria]], accountWide: Boolean, factionId: Long)
