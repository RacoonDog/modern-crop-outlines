pluginManagement {
	repositories {
		maven("https://maven.fabricmc.net/") {
			name = "Fabric"
		}
		maven("https://repo.legacyfabric.net/repository/legacyfabric/") {
			name = "legacy-fabric"
		}
		gradlePluginPortal()
	}
}
