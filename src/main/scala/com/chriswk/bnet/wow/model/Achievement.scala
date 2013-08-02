package com.chriswk.bnet.wow.model

/**
 * A Wow Achievement
 */
case class Achievement(accountWide: Boolean,
                       description: String,
                       icon: String,
                       id: Long,
                       points: Long,
                       reward: String,
                       rewardItems: Option[List[RewardItem]],
                       title: String
                       )