package com.chriswk.bnet.wow.model

case class Perks(perks: List[Perk])
case class Perk(guildLevel: Long, spell: Spell)
