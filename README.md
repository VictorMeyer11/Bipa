# Node List - Lightning Network Node Explorer

## Build tools & versions used
- **Android Studio:** Arctic Fox or newer
- **Kotlin:** 2.0.0
- **Gradle:** 8.0
- **Minimum SDK:** 24
- **Target SDK:** 35
- **JVM Target:** 11
- **Key Libraries:**
  - Jetpack Compose for UI
  - Hilt for dependency injection
  - Retrofit for networking
  - Kotlin Coroutines for asynchronous operations
  - Material Design 3 for UI components

## Steps to run the app
1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Connect an Android device or start an emulator
5. Click the "Run" button in Android Studio

## Running Unit Tests
1. Open the project in Android Studio
2. Navigate to the test directory (feature/main/kotlin + java)
3. Right-click on the test file or directory you want to run
4. Select "Run 'Tests in [test name]'"
5. Alternatively, you can run all tests by:
   - Right-clicking on the 'test' folder
   - Selecting "Run 'Tests in 'folder name''"
   - Or using the command line: `./gradlew test`

## What areas of the app did you focus on?
- **Clean Architecture Implementation:** Structured the app with clear separation between data, domain, and presentation layers
- **UI Design:** Created an interface using Jetpack Compose and Material Design 3
- **Data Handling:** Implemented efficient data fetching and processing
- **User Experience:** Focused on responsive UI with proper error handling
- **Code Organization:** Maintained a modular structure with feature-based architecture

## What was the reason for your focus? What problems were you trying to solve?
The primary focus was on creating a user-friendly application that effectively displays the data in an accessible format. The main problems addressed include:

- **Data readability:** Making the presentation of the node information quick and simple to read
- **Reliability:** Implementing proper error handling and data validation
- **Maintainability:** Creating a codebase that follows best practices and is easy to extend

## How long did you spend on this project?
The project was developed over approximately 2-3 days, with focused work on:
- Day 1: Project setup, architecture design, and basic UI implementation
- Day 2: Data layer implementation, API integration, and core functionality
- Day 3: UI refinement, unit tests, error handling, and final testing

## Did you make any trade-offs for this project? What would you have done differently with more time?
**Trade-offs made:**
- Simplified some UI elements to focus on core functionality
- Limited error handling to focus on the main user flow

**With more time, I would have:**
- Implemented more comprehensive unit and UI tests
- Implemented offline caching for better performance

## What do you think is the weakest part of your project?
The weakest aspects of the project are:

1. **Limited Testing:** The project lacks comprehensive test coverage, which could lead to potential issues in edge cases
2. **Basic Error Handling:** While basic error handling is implemented, more robust error recovery mechanisms could be added
3. **Limited Offline Support:** The app currently requires an internet connection to function
4. **UI Refinements:** Some UI elements could benefit from more polish and attention to detail
