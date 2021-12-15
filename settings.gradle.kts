
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

include (":app")

include(":platform:domain")
include(":platform:foundation:common")
include(":platform:foundation:design")
include(":platform:foundation:networking")
include(":platform:testing")

include(":features:home")
rootProject.name = "bootstrap"