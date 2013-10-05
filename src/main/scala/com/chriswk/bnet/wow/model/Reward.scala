package com.chriswk.bnet.wow.model

case class Rewards(rewards: List[Reward])
case class Reward(minGuildLevel: Long, minGuildRepLevel: Long,
                  races: List[Long], achievement: Option[Achievement],
                  item: Option[Item])
