package com.chriswk.bnet.wow.model

case class Item(armor: Long, baseArmor: Long,
                bonusStats: List[StatHolder], buyPrice: Long,
                containerSlots: Long, descrription: String,
                disenchantingSkillRank: Long, displayInfoId: Long,
                equippable: Boolean, hasSockets: Boolean,
                heroicTooltip: Boolean, icon: String,
                id: Long, name: String, nameDescriptionColor: String)
