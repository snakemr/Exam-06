plugins {
    kotlin("jvm")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
    id("app.cash.sqldelight")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-sensitive-resolution")
    }
}

group = "ru.lrmk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

val sqldelight: String by project
val icons: String by project

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation("org.jetbrains.compose.material:material-icons-core:$icons")
    implementation("app.cash.sqldelight:sqlite-driver:$sqldelight")
    implementation("app.cash.sqldelight:coroutines-extensions:$sqldelight")
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("database")
        }
    }
}
