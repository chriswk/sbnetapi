package com.chriswk.bnet.wow.model

case class Races(races: List[Race])
case class Race(
   id: Long,
  mask: Long,
  side: String,
  name: String
)
