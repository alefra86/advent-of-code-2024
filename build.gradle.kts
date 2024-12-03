plugins {
    kotlin("jvm") version "2.1.0"
    id("com.diffplug.spotless") version "6.25.0" apply (true)
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

spotless { kotlin { ktfmt("0.53").kotlinlangStyle() } }

tasks {
    wrapper {
        gradleVersion = "8.11.1"
    }
}
