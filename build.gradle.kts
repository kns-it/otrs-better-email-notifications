plugins {
    war
    kotlin("jvm") version "1.2.31"
    id("org.mikeneck.payara-plugin").version("0.0.2")
}

group = "de.knsit"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}

val payara_version by project
val javaee_api_version by project
val jackson_module_version by project
val swagger_ui_version by project
val swagger_jaxrs_version by project
val cors_filter_version by project

dependencies {
    compile(kotlin("stdlib"))
    providedCompile("fish.payara.extras:payara-micro:$payara_version")
    providedCompile("javax:javaee-api:$javaee_api_version")
    implementation("com.fasterxml.jackson.module:jackson-module-jsonSchema:$jackson_module_version")
    implementation("org.webjars:swagger-ui:$swagger_ui_version")
    implementation("io.swagger:swagger-jaxrs:$swagger_jaxrs_version")
    implementation("io.swagger:swagger-jersey2-jaxrs:$swagger_jaxrs_version")
    implementation("com.thetransactioncompany:cors-filter:$cors_filter_version")
}

repositories {
    jcenter()
}

war {
    webAppDirName = "src/main/webapp"
}

payara {
    httpPort = 8080
    daemon = false
}