package com.chriswk.bnet.wow

import dispatch._
import Defaults._

import com.chriswk.bnet.BNet._
import com.chriswk.bnet.wow.model._
import net.liftweb.json.Extraction


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
  val racesUrl = wowApiUrl / "data" / "character" / "races"
  val classesUrl = wowApiUrl / "data" / "character" / "classes"
	def guildQuery(realm: String, name: String):Req = guildUrl / realm / name
	def charQuery(realm: String, name: String):Req = charUrl / realm / name
	def itemQuery(id: Int):Req = itemUrl / id

  /**
   * Finds a guild, if guild cannot be found swallows exception and returns None
   * {{{
   *   import com.chriswk.bnet.wow.WoWApi
   *   val guild = WoWApi().findGuild("Aggramar", "Auditor Fortuna Juvat")
   * }}}
   * @param realm - Realm the guild is on
   * @param name - Name of guild, dispatch will escape it for you
   * @return Guild - A Case class for the guild
   */

  def findGuild(realm: String, name: String, extraFields: List[String] = List()): scala.concurrent.Future[Guild] = {
		val p = guildQuery(realm, name).addQueryParameter("fields", extraFields.mkString(","))
		for (g <- Http(p OK as.lift.Json))
      yield g.extract[Guild]
	}

  /**
   * Finds character
   * @param realm - Realm the character is on
   * @param name - Name of the character
   * @return Character - A case class for the
   */
	def findCharacter(realm: String, name: String): scala.concurrent.Future[Character] = {
		val p = Http(charQuery(realm, name) OK as.lift.Json)
		for (c <- p)
			yield c.extract[Character]
	}

  /**
   * Finds all realms
   * @return
   */
	def findAllRealms(): scala.concurrent.Future[List[Realm]] = {
		val realmReq = Http(realmUrl OK as.lift.Json)
		for {
      realmRoot <- realmReq
    } yield realmRoot.extract[Realms].realms
	}

  def getRaces = {
    for(races <- Http(racesUrl OK as.lift.Json)) yield races.extract[Races]
  }

	def resolveImage(path: String) = s"http://${region}.battle.net/static-render/${region}/${path}"


}
