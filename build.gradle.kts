
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath ("io.realm:realm-gradle-plugin:10.17.0")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
}