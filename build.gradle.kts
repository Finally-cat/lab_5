plugins {
    id("java")
}

group = "ru.itmo.sigma"
version = "1.3-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")
}
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ru.itmo.sigma.Main"
    }
}

