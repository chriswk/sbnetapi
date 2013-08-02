package com.chriswk.bnet.wow

import dispatch._
import dispatch.as.lift._
import net.liftweb.json._
import Defaults._

import com.chriswk.bnet.BNet._
import com.chriswk.bnet.wow.model._


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
	
	def guildQuery(realm: String, name: String):Req = guildUrl / realm / name
	def charQuery(realm: String, name: String):Req = charUrl / realm / name
	def itemQuery(id: Int):Req = itemUrl / id
	
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
