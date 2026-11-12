# Tetris

A Java implementation of the classic Tetris game, developed as part of the **Software Design and Testing Laboratory** course at the Faculty of Engineering of the University of Porto (FEUP).

The project recreates the classic block-stacking experience, featuring multiple game modes, score tracking, level progression, sound effects, and a terminal-based graphical interface.

## Features

- **Classic Tetris gameplay** – Move and rotate falling pieces to complete horizontal lines.
- **Seven tetromino types** – Supports the classic I, J, L, O, S, T, and Z pieces.
- **Multiple game modes:**
  - Default – Classic gameplay.
  - Marathon – Progress through levels up to level 15.
  - 40 Lines – Complete 40 lines.
  - Ultra – Play against a three-minute timer.
- **Scoring system** – Earn points by clearing lines, with different rewards depending on the number of lines cleared simultaneously.
- **Level progression** – Increase the game speed as you advance.
- **Ghost piece** – Preview where the current piece will land.
- **Sound effects and background music** – Audio feedback for gameplay events.
- **Menus and settings** – Navigate the main menu, instructions, and game mode selection.
- **Automated testing** – Includes unit tests and property-based testing.

## Technologies

- **Java**
- **Gradle** – Build and dependency management.
- **Lanterna 3.1.1** – Terminal-based graphical interface.
- **JUnit 5** – Unit testing.
- **Mockito** – Mocking framework.
- **jqwik** – Property-based testing.
- **PIT** – Mutation testing.

## Project Structure

```text
Tetris/
├── src/
│   ├── main/
│   │   ├── java/com/aor/tetris/
│   │   │   ├── controllers/    # Game and menu controllers
│   │   │   ├── gui/            # Terminal interface
│   │   │   ├── model/          # Game logic and data models
│   │   │   ├── states/         # Game states and transitions
│   │   │   ├── viewer/         # Rendering components
│   │   │   └── Game.java       # Application entry point
│   │   └── resources/
│   │       ├── fonts/          # Custom fonts
│   │       └── sounds/         # Music and sound effects
│   └── test/                   # Automated tests
├── build.gradle
├── settings.gradle
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Gradle

### Installation

1. Clone the repository

2. Build the project:

   ```bash
   gradle build
   ```

3. Run the application:

   ```bash
   gradle run
   ```

> **Configuration note:** Before running the application, ensure that the `application.mainClass` setting in `build.gradle` points to `com.aor.tetris.Game`, which contains the project's `main` method.

## Testing

Run the automated tests with:

```bash
gradle test
```

The project also includes PIT configuration for mutation testing.

## Gameplay

The objective is to arrange falling tetrominoes to complete horizontal lines. Completed lines disappear and increase the player's score. The game ends when the pieces can no longer be placed within the board.

## Academic Context

Developed as a group project for the **Software Design and Testing Laboratory** course at FEUP.

