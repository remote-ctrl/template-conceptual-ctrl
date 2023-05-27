group = "co.remotectrl.myevent"
version = "1.0"

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${co.remotectrl.kotlin.build.Versions.Dependencies.kotlin}")
    }
}



