package com.chriswk.bnet.wow.model

case class Classes(classes: List[Class])
case class Class(id: Long, mask: Long, powerType: String, name: String)
