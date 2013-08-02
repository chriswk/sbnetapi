package com.chriswk.bnet.wow.model

/**
* A reward
*/
case class RewardItem(icon: String,
                      id: Long,
                      name: String,
                      quality: Int,
                      tooltipParams: Option[String]
                       )