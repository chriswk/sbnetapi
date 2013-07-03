package com.chriswk.bnet.wow

import dispatch._
import net.liftweb.json._
import Defaults._

import com.chriswk.bnet.BNet._

/**
 * Base class for WoW data, nothing in this class
 * used to restrict types sent to functions
 **/
class WowClass

/**
 * An Emblem holder
 */
case class Emblem(
	icon: Int,
	iconColor: String,
	border: Int,
	borderColor: String, backgroundColor: String
) extends WowClass

/**
 * A Wow Guild
 */
case class Guild(
	lastModified: Long,
	name: String,
	realm: String,
	battlegroup: String,
	level: Int,
	side: Int,
	achievementPoints: Int,
	emblem: Emblem
) extends WowClass

/**
 * A Wow Character
 */
case class Character(
	lastModified: Long,
	name: String
)

object WoWApi {
	def apply(region: String) {
		new WoWApi(region)
	} 
}

class WoWApi(val region: String) {
	implicit val formats = net.liftweb.json.DefaultFormats
	val wowApiUrl = apiUrl(region) / "wow"
	val guildUrl = wowApiUrl / "guild"
	val characterUrl = wowApiUrl / "character"
	val itemUrl = wowApiUrl / "item"
	val achievementUrl = wowApiUrl / "achievement"
	
	def findGuild(realm: String, name: String) = {
		val queryUrl = guildUrl / realm / name
		Http(queryUrl OK as.String)
	}
}
