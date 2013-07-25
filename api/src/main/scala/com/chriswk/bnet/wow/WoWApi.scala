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
	val wowApiUrl = apiUrl(region) / "wow"
	val guildUrl = wowApiUrl / "guild"
	val charUrl = wowApiUrl / "character"
	val itemUrl = wowApiUrl / "item"
	val achievementUrl = wowApiUrl / "achievement"
	
	def guildQuery(realm: String, name: String) = guildUrl / realm / name
	def charQuery(realm: String, name: String) = charUrl / realm / name
	def itemQuery(id: Int) = itemUrl / id
	
	def findGuild(realm: String, name: String): scala.concurrent.Future[Guild] = {
		val f = guildQuery(realm, name)
		println(f.build())
		val p = Http(guildQuery(realm, name) OK as.lift.Json) 
		for (g <- p)
			yield g.extract[Guild]
	}
	
	def findPlayer(realm: String, name: String): scala.concurrent.Future[Character] = {
		val f = charQuery(realm, name)
		println(f.build())
		val p = Http(f OK as.lift.Json)
		for (c <- p)
			yield c.extract[Character]
	}
	
	def findItem(id: Int) = {
		val p = itemQuery(id)
		println(p.build())
		val item = Http(p OK as.lift.Json)
		for (i <- item)
			yield i
	}
	
	def resolveImage(path: String) = s"http://${region}.battle.net/static-render/${region}/${path}"
	
}
