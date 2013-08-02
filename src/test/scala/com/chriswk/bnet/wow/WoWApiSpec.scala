package com.chriswk.bnet.wow

import org.specs2.mutable._

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

  "Item url" should {
    "Base item url" in {
      api.itemUrl.url === "http://eu.battle.net/api/wow/item"
    }
  }
}
