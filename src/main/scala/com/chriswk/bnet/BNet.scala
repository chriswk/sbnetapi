package com.chriswk.bnet

import dispatch._

object BNet {
	def apiUrl(region: String = "eu") = host(s"${region}.battle.net") / "api"
}