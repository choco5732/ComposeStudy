pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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



rootProject.name = "ComposePractice"
include(":app")
include(":text")
include(":button")
include(":modifier")
include(":surface")
include(":box")
include(":row")
include(":column")
include(":boxwithconstraints")
include(":image")
include(":networkimage")
include(":checkbox")
include(":textfiled")
include(":slotapi")
include(":scaffold")
include(":catalog")
include(":topappbar")
include(":constraintlayout")
include(":constraintset")
include(":constraintlayout_chain_barrier")
include(":advancedconstraintlayout")
include(":constraintlayout_advanced")
include(":canvas")
include(":dialog")
include(":dialog_custom")
include(":dropdownmenu")
include(":snackbar")
include(":bottomappbar")
include(":state_statehoisting")
include(":animation1")
include(":animation2")
include(":side_effect")
include(":todo")
include(":viewmodel")
