package com.chriswk.bnet.wow

import org.specs2.mutable._

class WoWApiSpec extends Specification {
  val api = new WoWApi("eu")

  "Url to guild page" should {
    "Use correct endpoint" in {
      api.guildQuery("test", "test").url === "http://eu.battle.net/api/wow/guild/test/test"
    }
    "Auditor Fortuna Juvat is located at Aggramar (handles space)" in {
      api.guildQuery("Aggramar", "Auditor Fortuna Juvat").url === "http://eu.battle.net/api/wow/guild/Aggramar/Auditor%20Fortuna%20Juvat"
    }
  }

  "Url to character" should {
    "Konichiwah is located at Aggramar" in {
      api.charQuery("Aggramar", "Konichiwah").url === "http://eu.battle.net/api/wow/character/Aggramar/Konichiwah"
    }

    "Should escape special characters correctly" in {
      api.charQuery("Aggramar", "Sónny").url === "http://eu.battle.net/api/wow/character/Aggramar/S%F3nny"
    }
  }

  "Item"
}
