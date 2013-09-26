package com.chriswk.bnet.wow.model

/**
 * A realm
 */
case class Realms(realms: List[Realm])
case class Realm(
	name: String, 
	slug: String, 
	timezone: String,
	locale: String,
	battlegroup: String
)