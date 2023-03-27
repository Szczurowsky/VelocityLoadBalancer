plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.kyori.blossom") version "1.3.1"
}

group = "pl.szczurowsky.velocityloadbalancer"
version = "1.0"

repositories {

    mavenLocal()

    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.1.1")
    annotationProcessor("com.velocitypowered:velocity-api:3.1.1")
}

blossom {
    replaceTokenIn("src/main/java/net/mineworld/sectors/proxy/VelocityBootstrapPlugin.java")
    replaceToken("@version@", project.version)
}

tasks.withType <com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("VelocityLoadBalancer v${project.version}.jar")

    exclude("org/intellij/lang/annotations/**")
    exclude("org/jetbrains/annotations/**")
    exclude("META-INF/**")
    exclude("javax/**")


    mergeServiceFiles()
}