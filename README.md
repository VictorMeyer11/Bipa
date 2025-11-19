# Bipa - Lightning Network Node Explorer

A modern Android application for exploring Lightning Network nodes, built with Jetpack Compose and Clean Architecture principles.

## Overview

Bipa is an Android application that displays information about Lightning Network nodes, including their connectivity rankings, capacity, channels, and location data. The app fetches real-time data from the Mempool.space API and presents it in a clean, user-friendly interface.

## Architecture

This project follows **Clean Architecture** principles with a modular structure:

- **Presentation Layer**: Jetpack Compose UI components and ViewModels
- **Domain Layer**: Business logic, use cases, and domain models
- **Data Layer**: API services, data sources, repositories, and DTOs

### Module Structure

```
Bipa/
├── app/                    # Main application module
├── core/
│   ├── activity/          # Core activity components
│   └── network/           # Network configuration and data sources
├── feature/
│   └── main/              # Main feature module (node listing)
└── ui/                    # Shared UI components and themes
```

## Tech Stack

### Core Technologies
- **Kotlin** 2.0.0
- **Android Gradle Plugin** 8.8.2
- **Gradle** 8.0+

### Libraries & Frameworks
- **Jetpack Compose** - Modern declarative UI framework
- **Material Design 3** - Material Design components
- **Hilt** - Dependency injection
- **Retrofit** - Type-safe HTTP client
- **Gson** - JSON serialization
- **Kotlin Coroutines** - Asynchronous programming
- **Lifecycle Components** - Android lifecycle-aware components

### Testing
- **JUnit 5** - Unit testing framework
- **MockK** - Mocking library for Kotlin
- **AssertK** - Fluent assertions for Kotlin
- **MockWebServer** - HTTP server for testing network calls
- **Coroutines Test** - Testing utilities for coroutines

## Requirements

- **Android Studio**: Arctic Fox or newer
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 35
- **JVM Target**: 11
- **Kotlin**: 2.0.0

## Getting Started

### Prerequisites

1. Clone the repository:
   ```bash
   git clone https://github.com/VictorMeyer11/Bipa.git
   cd Bipa
   ```

2. Ensure you have Android Studio installed with the required SDK versions.

### Setup

1. Open the project in Android Studio
2. Sync Gradle files (Android Studio will prompt you, or use `File > Sync Project with Gradle Files`)
3. Wait for Gradle to download dependencies and build the project

### Running the App

1. Connect an Android device via USB or start an Android emulator
2. Click the "Run" button in Android Studio (or press `Shift + F10`)
3. Select your target device
4. The app will build and launch on your device

### Building from Command Line

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

## Testing

### Running Unit Tests

**In Android Studio:**
1. Navigate to the test directory (`feature/main/src/test`)
2. Right-click on the test file or directory
3. Select "Run 'Tests in [test name]'"
4. Or right-click on the `test` folder and select "Run 'Tests in 'test''"

**From Command Line:**
```bash
# Run all unit tests
./gradlew test

# Run tests for a specific module
./gradlew :feature:main:test
```

### Running Instrumented Tests

```bash
# Run all instrumented tests
./gradlew connectedAndroidTest
```

## Project Structure

```
feature/main/
├── data/
│   ├── api/              # Retrofit API interfaces
│   ├── datasource/       # Data source implementations
│   ├── dto/              # Data Transfer Objects
│   ├── mapper/           # Data mappers (DTO to Domain)
│   └── repository/       # Repository implementations
├── domain/
│   ├── model/            # Domain models
│   ├── repository/       # Repository interfaces
│   └── usecase/          # Business logic use cases
└── presentation/
    ├── component/        # Reusable UI components
    ├── MainScreen.kt     # Main screen composable
    ├── MainViewModel.kt  # ViewModel
    └── MainState.kt      # UI state models
```

## Configuration

### API Configuration

The app uses the Mempool.space API. The base URL is configured in:
```
core/network/src/main/java/com/bipa/network/di/RetrofitModule.kt
```

Current base URL: `https://mempool.space/api/v1/`
