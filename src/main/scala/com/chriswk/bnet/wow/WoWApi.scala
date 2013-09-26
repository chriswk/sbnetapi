package com.chriswk.bnet.wow

import dispatch._
import Defaults._

import com.chriswk.bnet.BNet._
import com.chriswk.bnet.wow.model._


object WoWApi {
  def apply(region: String): WoWApi = {
		new WoWApi(region)
	}
  def apply() = new WoWApi("eu")
}

class WoWApi(val region: String = "eu") {
	implicit val formats = net.liftweb.json.DefaultFormats
	val wowApiUrl = apiUrl(region) / "wow"
	val guildUrl = wowApiUrl / "guild"
	val charUrl = wowApiUrl / "character"
	val itemUrl = wowApiUrl / "item"
	val achievementUrl = wowApiUrl / "achievement"
	val realmUrl = wowApiUrl / "realm" / "status"
	def guildQuery(realm: String, name: String):Req = guildUrl / realm / name
	def charQuery(realm: String, name: String):Req = charUrl / realm / name
	def itemQuery(id: Int):Req = itemUrl / id
	
	def findGuild(realm: String, name: String): scala.concurrent.Future[Guild] = {
		val p = Http(guildQuery(realm, name) OK as.lift.Json) 
		for (g <- p)
			yield g.extract[Guild]
	}
	
	def findPlayer(realm: String, name: String): scala.concurrent.Future[Character] = {
		val p = Http(charQuery(realm, name) OK as.lift.Json)
		for (c <- p)
			yield c.extract[Character]
	}
	
	def findAllRealms(): scala.concurrent.Future[List[Realm]] = {
		val realmReq = Http(realmUrl OK as.lift.Json)
		for {
      realmRoot <- realmReq
    } yield realmRoot.extract[Realms].realms
	}
	def findItem(id: Int) = {
		val p = itemQuery(id)
		val item = Http(p OK as.lift.Json)
		for (i <- item)
			i
	}
	
	def resolveImage(path: String) = s"http://${region}.battle.net/static-render/${region}/${path}"
	
}
