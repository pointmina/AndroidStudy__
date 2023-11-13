pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidStudy"
include(":app")
include(":lab08")
include(":lab09")
include(":lab10")
include(":lab11")
include(":lab12")
include(":lab13")
