pluginManagement {
    repositories {
        //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        kotlin("jvm").version(extra["kotlin.version"] as String)
        kotlin("plugin.compose").version(extra["kotlin.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("app.cash.sqldelight").version(extra["sqldelight"] as String)
    }
}

rootProject.name = "Экзамен ПМ.06"
