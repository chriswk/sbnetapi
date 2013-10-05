package com.chriswk.bnet.wow.model

case class BattlePetTypes(petTypes: List[BattlePetType])
case class BattlePetType(id: Long, key: String, name: String, typeAbilityId: Long, strongAgainstId: Long, weakAgainstId: Long)
