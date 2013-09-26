sbnetapi - Scala Battle.net api
========
Using dispatch and lift-json to create a Scala Battle.net wrapper for Blizzards community API
http://blizzard.github.io/api-wow-docs/


Plans for version 0.1

Support
* Initialize via val api = WowApi(region: String)
* api.findAllRealms() : Future[List[Realm]
* api.findGuild(name:String, realm: String)) : Future[Guild]
* api.findChar(name:String, realm: String)) : Future[Character]


Future plans
Get achievements, extend guild and char fetchers to support additional parameters available
