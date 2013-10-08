package com.chriswk.bnet.wow

import org.specs2.mutable._
import com.chriswk.Betamax
import com.chriswk.Betamax._
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}

class WoWApiSpec extends Specification {
  val api = new WoWApi

  "Correct region is used" should {
    "Use eu as default" in {
      val eu = new WoWApi
      eu.wowApiUrl.url === "http://eu.battle.net/api/wow"
    }
    "Support switching to us" in {
      val us = new WoWApi("us")
      us.wowApiUrl.url === "http://us.battle.net/api/wow"
    }
	"Support switching to kr" in {
		val kr = new WoWApi("kr")
		kr.wowApiUrl.url === "http://kr.battle.net/api/wow"
	}
	"Support switching to tw" in {
		val kr = new WoWApi("tw")
		kr.wowApiUrl.url === "http://tw.battle.net/api/wow"
	}
  }

  "Url to guild page" should {
    "Base guild url" in {
      api.guildUrl.url === "http://eu.battle.net/api/wow/guild"
    }
    "Use correct endpoint" in {
      api.guildQuery("test", "test").url === "http://eu.battle.net/api/wow/guild/test/test"
    }
    "handles space" in {
      api.guildQuery("Aggramar", "Auditor Fortuna Juvat").url === "http://eu.battle.net/api/wow/guild/Aggramar/Auditor%20Fortuna%20Juvat"
    }
  }

  "Url to character" should {
    "Base Character url" in {
      api.charUrl.url === "http://eu.battle.net/api/wow/character"
    }
    "locate Konichiwah at Aggramar" in {
      api.charQuery("Aggramar", "Konichiwah").url === "http://eu.battle.net/api/wow/character/Aggramar/Konichiwah"
    }

    "escapes special characters correctly" in {
      api.charQuery("Aggramar", "Sónny").url === "http://eu.battle.net/api/wow/character/Aggramar/S%F3nny"
    }
  }

  "Realm url" should {
    "have Status url" in {
      api.realmUrl.url === "http://eu.battle.net/api/wow/realm/status"
    }
  }

  "Guild query" should {
	"find Auditor Fortuna Juvat, Aggramar" in Betamax("guild query") {
		val guild = api.findGuild("Aggramar", "Auditor Fortuna Juvat")
		Await.result(guild, Duration(2000, "millis"))
		guild.isCompleted
		guild.value.get.get.name === "Auditor Fortuna Juvat"
	}

   }
}
