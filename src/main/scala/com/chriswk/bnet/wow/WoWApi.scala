package com.chriswk.bnet.wow

import dispatch._
import dispatch.as.lift._
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
	name: String,
	achievementPoints: Int,
	battlegroup: String,
	calcClass: String,
	`class`: Int,
	level: Int,
	race: Int,
	realm: String,
	thumbnail: String
) extends WowClass
/**
 * A Wow Achievement
 */
case class Achievement(
	accountWide: Boolean,
	description: String,
	icon: String,
	id: Long,
	points: Long,
	reward: String,
	rewardItems: Option[List[RewardItem]],
	title: String
) extends WowClass
/**
 * A reward
 */
case class RewardItem(
	icon: String,
	id: Long,
	name: String,
	quality: Int,
	tooltipParams: Option[String]
) extends WowClass
/**
 * Criteria for achievement
 */
case class Criteria(
	description: String,
	id: Long,
	max: Long,
	orderIndex: Long
)

object WoWApi {
	def apply(region: String = "eu") {
		new WoWApi(region)
	} 
}

class WoWApi(val region: String) {
	implicit val formats = net.liftweb.json.DefaultFormats
	def wowApiUrl() = apiUrl(region) / "wow"
	def guildUrl() = wowApiUrl / "guild"
	def guildQuery(realm: String, name: String) = guildUrl / realm / name
	def charUrl() = wowApiUrl / "character"
	def charQuery(realm: String, name: String) = charUrl / realm / name
	def itemUrl() = wowApiUrl / "item"
	def itemQuery(id: Int) = itemUrl / id
	def achievementUrl() = wowApiUrl / "achievement"
	
	def findGuild(realm: String, name: String) = {
		val f = guildQuery(realm, name)
		println(f.build())
		val p = Http(guildQuery(realm, name) OK as.String) 
		for (g <- p)
			yield parse(g).extract[Guild]
	}
	
	def findPlayer(realm: String, name: String) = {
		val f = charQuery(realm, name)
		println(f.build())
		val p = Http(f OK as.String)
		for (c <- p)
			yield parse(c).extract[Character]
	}
	
	def resolveImage(path: String) = s"http://${region}.battle.net/static-render/${region}/${path}"
	
}
