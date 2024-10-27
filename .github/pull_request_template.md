### ✋ 안녕하세요!
```
반갑습니다.
```
* 2주차 과제하시느라 다들 고생 많으셨습니다.
* 코드 리뷰해주시는 분들을 위해 작성했습니다.
* 감사합니다. 행운을 빕니다.

### 📦 패키지 구조
```
└── src
    ├── main
    │   └── java
    │       └── racingcar
    │           ├── Application.java
    │           ├── configuration
    │           │   └── AppConfig.java
    │           ├── controller
    │           │   └── RacingController.java
    │           ├── model
    │           │   ├── dto
    │           │   │   ├── CarNames.java
    │           │   │   ├── RacingProgress.java
    │           │   │   ├── RacingRecording.java
    │           │   │   └── RacingWinners.java
    │           │   └── entity
    │           │       ├── Car.java
    │           │       ├── Cars.java
    │           │       ├── RacingChance.java
    │           │       ├── RacingTurn.java
    │           │       ├── RacingTurns.java
    │           │       └── StrategiesAtCarNames.java
    │           ├── repository
    │           │   ├── MemoryRepository.java
    │           │   └── Repository.java
    │           ├── service
    │           │   ├── RacingService.java
    │           │   └── RacingServiceImpl.java
    │           ├── strategy
    │           │   └── MoveStrategy.java
    │           ├── utils
    │           │   ├── message
    │           │   │   ├── ErrorMessage.java
    │           │   │   └── IOMessage.java
    │           │   └── validator
    │           │       └── CarNamesValidator.java
    │           └── view
    │               ├── ConsoleInputView.java
    │               ├── ConsoleOutputView.java
    │               ├── InputView.java
    │               └── OutputView.java
    └── test
        └── java
            └── racingcar
                ├── ApplicationTest.java
                ├── CarNamesFormatValidateTest.java
                ├── ExceptionMessageTest.java
                └── RacingChanceFormatValidationTest.java
```
