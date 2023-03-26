plugins {
    id("java")
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