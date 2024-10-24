# java-racingcar-precourse

## Implementation Breakdown

### Input Handler
The program requires two inputs:

1. **`carNames`**: A list of car names separated by commas (`,`).
   - Each car name must be at most 5 characters long.

2. **`N`**: The number of game rounds.
   - In each round, a random integer between 0 and 9 is generated.
   - The car moves forward if the value is 4 or greater.
   - After the race ends, print the names of all cars that tied for first place. There may be multiple winners.

### Output Messages

1. `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
   - This message prompts the user to enter `carNames`.  
   - If the input is invalid, throw an `IllegalArgumentException`.

2. `시도할 횟수는 몇 회인가요?`
   - This message prompts the user to enter `N`.  
   - If the input is invalid, throw an `IllegalArgumentException`.

3. `실행 결과`
   - For each round `i` (from `0` to `N`), print the status of each car.

4. `최종 우승자 :`
   - After the race concludes, print the names of the winning cars. Multiple cars can share the winning position.

### Objects

#### RacingCar
- Each car object holds its name and current score.

### Enums

#### Movement Enums
The movement of a car is determined by a randomly generated integer.
- If the integer is 4 or greater, the car moves **FORWARD**.
- Otherwise, the car **STOPS**.

#### **FORWARD**
Indicates that the car move.

#### **STOP**
Indicates that the car does not move.
