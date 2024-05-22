import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version "1.9.20"
    id("com.vanniktech.maven.publish") version "0.28.0"
//    `maven-publish`
}

group = "com.x12q"
version = "1.0.0-alpha.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}

mavenPublishing {

    group = "com.x12q"
    version = "1.0.0-alpha.1"
    val libId =  "test-support"


    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
    coordinates(group.toString(), libId, version.toString())

    pom{
        name.set("test-support")
        description.set("A test support library")
        inceptionYear.set("2024")
        url.set("https://github.com/x12q/test-support")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("x12q")
                name.set("The-Phong Pham")
                url.set("x12q.com")
            }
        }
        scm {
            url.set("https://github.com/x12q/test-support")
            connection.set("scm:git:git://github.com/x12q/test-support.git")
            developerConnection.set("scm:git:ssh://git@github.com/x12q/test-support.git")
        }
        issueManagement {
            system.set("GitHub Issues")
            url.set("https://github.com/x12q/test-support/issues")
        }
    }
}

//publishing {
//    /**
//     * This is for local publishing
//     */
//    publications {
//        create<MavenPublication>("maven") {
//            groupId = group.toString()
//            artifactId = "test-support"
//            version = version
//            from(components["java"])
//        }
//    }
//}
