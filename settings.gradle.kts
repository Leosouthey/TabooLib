rootProject.name = "TabooLib"
include("common", "common-5")
include("module-empty")
include("module-ai")
include("module-ui")
include("module-ui-receptacle")
include("module-nms")
include("module-nms-util")
include("module-chat")
include("module-lang")
include("module-effect")
include("module-kether")
include("module-metrics")
include("module-database")
include("module-database-mongodb")
include("module-porticus")
include("module-navigation")
include("module-configuration")
include("platform-bukkit", "platform-nukkit", "platform-bungee", /*"platform-velocity"*/)
include("platform-sponge-api7", "platform-sponge-api8")
include("platform-application")

// 临时位置，未来会被移出标准模块
include("expansion-command-helper")