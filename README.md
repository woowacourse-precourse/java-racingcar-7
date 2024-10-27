# java-racingcar-precourse

# Racing Car Game

## Project Description
This project is a simple console-based racing car game. Users can input car names separated by commas to set up the cars, and each car will race with the result displayed, including the winner.

## Features Implemented
### 1. Input Parsing (Comma-separated names)
- The user input string is split by commas (`,`) to set the names of each car.

### 2. `Car` Class Implementation
- The `Car` class defines each car object.
  - `drive()`: Moves the car forward by one step if if the random value is 4 or greater.
  - `printDistance()`: Displays the current distance traveled by the car visually (e.g., `Car : ---`).

### 3. Car List Setup
- The list of `Car` objects is created using the input names.

### 4. Race Execution and Result Display
- The user inputs the number of attempts, and each car moves forward randomly that many times.
- On each attempt, a random number is generated. If the number is 4 or greater, the car moves forward by one step.
- After all attempts, the race results are displayed, showing how far each car has traveled.

### 5. Winner Display
- After the race ends, the car that traveled the furthest is selected as the winner and displayed.
