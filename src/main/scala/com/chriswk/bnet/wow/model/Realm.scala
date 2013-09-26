package com.chriswk.bnet.wow.model

/**
 * A realm
 */
case class Realm(
	name: String, 
	slug: String, 
	timezone: String, 
	locale: String, 
	type: String, 
	battlegroup: String
)