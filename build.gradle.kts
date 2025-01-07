@file:Suppress("GradlePackageUpdate")

val kotlinVersion: String by project

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("net.linguica.maven-settings") version "0.5"
	idea
	jacoco
}

group = "com.lingye"
version = "0.0.1-SNAPSHOT"
description = "demo"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
	all {
		exclude("org.apache.logging.log4j", "log4j-to-slf4j")
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

buildscript {
	dependencies {}
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.ai:spring-ai-bom:1.0.0-SNAPSHOT")
	}
}

dependencies {
	// spring
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.retry:spring-retry")
	implementation("org.springframework:spring-aspects")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.ai:spring-ai-openai-spring-boot-starter")

	// cache
//	implementation("org.springframework.boot:spring-boot-starter-cache")
//	implementation("org.springframework.boot:spring-boot-starter-data-redis") {
//		exclude("io.lettuce", "lettuce-core")
//	}
//	implementation("redis.clients:jedis:3.3.0")
//	implementation("com.github.ben-manes.caffeine:caffeine:2.8.8")
	implementation("com.google.guava:guava:33.2.1-jre")

	// mybatis
//	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
//	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.4")

	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
//	implementation("org.jetbrains.kotlinx:kotlinx-stdlib-jdk8")

	// 代码元信息工具
	implementation("org.reflections:reflections:0.10.2")

	// jasypt 加密工具
	implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:2.1.1")

	// druid
//	implementation("com.alibaba:druid-spring-boot-starter:1.1.23")

	// ktorm
//	implementation("org.ktorm:ktorm-core:4.1.1")
//	implementation("org.ktorm:ktorm-jackson:4.1.1")
//	implementation("org.ktorm:ktorm-support-mysql:4.1.1")

	// MQ
//	implementation("org.springframework.kafka:spring-kafka")
//	testImplementation("org.springframework.kafka:spring-kafka-test")

	// mysql
//	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//	implementation("mysql:mysql-connector-java:8.0.27")

//	runtimeOnly("com.mysql:mysql-connector-j")

	// 字节码增强
//	implementation("javassist:javassist:3.28.0.GA")

	implementation("org.springframework.boot:spring-boot-devtools")

	// logging
	implementation("org.springframework.boot:spring-boot-starter-logging")

	// lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// SpringAI
	implementation("org.springframework.ai:spring-ai-openai")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

//tasks.withType<KotlinCompile> {
//	kotlinOptions {
//		freeCompilerArgs = listOf("-Xjsr305=strict")
//		jvmTarget = "1.8"
//	}
//}

tasks.withType<Test> {
	useJUnitPlatform()
//	System.getProperty("spring.profiles.active")?.let { systemProperty("srping.profiles.active", it) }
}

