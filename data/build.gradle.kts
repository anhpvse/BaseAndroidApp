import java.util.Properties

plugins {
	alias(libs.plugins.androidLibrary)
	alias(libs.plugins.jetbrainsKotlinAndroid)
	alias(libs.plugins.kotlin.serialization)
}

class BConfig {
	var commonProperties: Properties = Properties()
}
val config = BConfig()
val basePath = "${rootDir.absolutePath}/config/"

android {
	namespace = "base.android.data"
	
	defaultConfig {
		compileSdk = libs.versions.android.compileSdk.get().toInt()
		minSdk = libs.versions.android.minSdk.get().toInt()
		multiDexEnabled = true
	}
	
	buildFeatures {
		buildConfig = true
	}
	
	buildTypes {
		debug {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
			buildConfigField("String", "BASE_URL", "\"${config.commonProperties["base_url"]}\"")
			buildConfigField("String", "TOKEN", "\"${config.commonProperties["token"]}\"")
		}
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
			buildConfigField("String", "BASE_URL", "\"${config.commonProperties["base_url"]}\"")
			buildConfigField("String", "TOKEN", "\"${config.commonProperties["token"]}\"")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
}

dependencies {
	
	implementation(libs.ktor.client.android)
	implementation(libs.ktor.client.contentNegotiation)
	implementation(libs.ktor.client.logging)
	implementation(libs.ktor.client.core)
	
	implementation(libs.androidx.multidex)
	
	api(project(":domain"))
	
}