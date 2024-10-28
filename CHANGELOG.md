commit history


## docs
- docs(README): make a list of functional requirements
- docs(CHANGELOG): create CHANGELOG.md to track commit history
- docs(README): update feature requirements
  - correct logic description for moving forward
  - specify input operations and winner announcement
  - add and update error message for clarity
- docs(README): add input description and test cases for better clarity
- docs(README): add description for tests
  - rename GameCountValidatorTest to GameRoundValidatorTest for clarity
- docs(CHANGELOG): document commit history for project tracking

## CarGameController
- feat(CarGameController): create main controller for handling input and output
  - invoke methods from InputController and OutputView


## inputView
- feat(InputView): print input message to users
  - create inputCarNames() method to input car names
  - create inputCount() method to input game rounds

## OutputView
- feat(OutputView): print output message to users
  - get data from RaceService
  - print execution process and announce the winner of the race

## CarNameValidator
- feat(CarNameValidator): validate input car names
  - check if each car name is null or contains blanks
  - check if each car name's length is under 5
  - check if each car name includes only English letters
  - check if car names are duplicated
- fix(CarNameValidator): update error message for clarity
- fix(CarNameValidator): change input condition from isEmpty() to isBlank()
  - remove unnecessary null check in a token

## GameCountValidator -> GameRoundValidator
- feat(GameCountValidator): validate input game round number
  - check if the number is a natural number within int range

## Car
- feat(Car): create Car Class

## InputController
- feat(InputController): separate methods for input contents and return valid inputs
  - combine input and validation checks for car names into a single method
  - combine input and validation checks for game rounds into a single method

## RaceCarService
- feat(RaceCarService): create RaceCarService interface
  - add method for printing the execution process of race cars
  - add method for selecting the winner

## RaceCarServiceImpl
- feat(RaceCarServiceImpl): implement RaceCarService interface
  - use Random.pickNumberInRange(start, end) for random selection
  - announce the winners separated by commas if multiple
- refactor(RaceCarServiceImpl): replace for-statement with stream API
  - simplify iteration logic using stream API
  - enhance readability and maintainability of code



## CarNameValidatorTest
- test(CarNameValidatorTest): add tests for input validation in CarNameValidator
  - verify that car names do not contain empty or blank strings
  - ensure that each car name's length is under 5 characters
  - validate that car names only contain English letters
  - check for duplicate car names

## GameCountValidatorTest -> GameRoundValidatorTest
- test(GameCountValidatorTest): add tests for input validation in GameCountValidator
  - verify that the number is negative
  - check if the number is a prime number
  - ensure that the number is within the valid int range

## ApplicationTest
- test(ApplicationTest): add tests for moving forward and stopping conditions

### 범위가 넓어서 따로 영역 지정하지 않은 커밋 
- refactor: rename variable gameCount to gameRound for better readability across multiple classes
  - update gameCount to gameRound in CarGameController, InputController, GameRoundValidator, RaceCarServiceImpl, InputView, and GameRoundValidatorTest