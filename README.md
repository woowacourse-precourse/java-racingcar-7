### 지난주 코드리뷰 피드백
- 계층형 아키텍처로 프로젝트를 구성했는데 서비스 계층에서 상태를 가지고, view에서 참조를 하는 등의 부분에서 수정했으면 한다는 피드백을 받았다. 이에 따라 계층형 아키텍처에 대해서 상세히 공부하고 어떻게 하면 SOLID 원칙을 지키며 구현할 수 있을지 고민했다.
- 상수 클래스를 만들어서 상수를 관리한 부분에 대해서는 칭찬을 받았다. 조금 더 발전시켜서 enum 클래스로 만들었다.
- 서비스 계층에 단일 클래스로 비지니스 로직을 전부 처리하다보니 많은 책임을 지고 있다는 피드백을 받았다. 단일 책임 원칙에 따라 서비스를 분리했다.
- 테스트 코드를 클래스마다 나눠서 단위 테스트를 해보는게 어떤가라는 피드백을 받았다. 지난번엔 구현 따로 테스트 따로 완성하다보니 통합 테스트만 진행하게 되었다. 이번에는 기능 하나를 완성시키면 바로 테스트를 돌릴 수 있도록 단위테스트를 만들었다.

### 구현할 기능 목록
- 입력
- 자동차 등록
    - 자동차 이름 입력
    - 자동차 이름 구분
        - 자동차 이름 검증
    - 실행할 횟수 입력
        - 입력한 횟수 검증
- 자동차 경주 결과
    - 무작위 값 구하기
    - 턴 당 이동
        - 턴 당 실행 결과 출력
- 결과 계산
- 결과 출력

### 적용해 볼 디자인 패턴 및 기능
- [x] 팩토리 패턴
- [x] 불변 객체 record 클래스
- [x] 사용자 정의 예외
- [x] 객체 equals & hashCode 오버라이드
- [x] enum 상수
- [x] 일급 컬렉션

### 파일 구조
```bash
└─racingcar
    │  Application.java
    │  RacingGame.java
    │
    ├─controller
    │      GameController.java
    │      GameControllerFactory.java
    │
    ├─exception
    │  │  EmptyInputException.java
    │  │  TheCarDoesntStartException.java
    │  │
    │  ├─carName
    │  │      DuplicateCarNameException.java
    │  │      InvalidCarNameLengthException.java
    │  │      InvalidCharacterException.java
    │  │      InvalidRegisterCarsInputLengthException.java
    │  │
    │  └─executionNumber
    │          NotNumberException.java
    │          NumberRangeException.java
    │
    ├─model
    │  │  Car.java
    │  │  Cars.java
    │  │  ExecutionNumber.java
    │  │
    │  └─factory
    │          CarFactory.java
    │
    ├─service
    │      GameService.java
    │      RaceService.java
    │      RegisterCarService.java
    │      RegisterExecutionNumberService.java
    │
    ├─util
    │  │  DataTransformUtil.java
    │  │  ValidationUtil.java
    │  │
    │  └─constant
    │          CharacterConstant.java
    │          MoveCarNumberConstant.java
    │          OutputMessageConstant.java
    │          RegisterCarNumberConstant.java
    │
    └─view
          InputView.java
          OutputView.java
```


### 메소드 시그니처
- view
  - InputView
    - input() -> String
    - registerCarInputView() -> String
    - registerExecutionNumberInputView() -> String
    - registerExecutionNumberMessage() -> void
    - registerCarMessage() -> void
  - OutputView
    - newLine() -> void
    - executionResultMessage() -> void
    - printResult(Cars) -> void
    - finalWinnerMessage(List<String>) -> void
- controller
  - GameController
    - registerCars(String) -> Cars
    - registExecutionNumber(String) -> ExecutionNumber
    - race(Cars) -> Cars
    - raceResult(Cars) -> List<String>
- service
  - GameService
    - winners(Cars) -> List<String>
    - isMoving() -> boolean
    - randomNumber() -> int
  - RaceService
    - race(Cars) -> Cars
  - RegisterCarService 
    - registerCars(String) -> Cars
    - mapToCarNames(String) -> List<String>
    - carNameRegistration(List<String>) -> Cars
    - isValidCarNameInput(String) -> boolean
  - RegisterExecutionNumberService
    - registerExecutionNumber(String) -> ExecutionNumber
    - isValidExecutionNumber(String) -> boolean
- util
  - DataTransformUtil
    - splitInput(String, String) -> List<String>
    - parseToInt(String) -> int
  - ValidationUtil
    - isValidRegisterCarsInputLength(String) -> boolean
    - isValidCarNameLength(List<String>) -> boolean
    - containsInvalidCharacter(String) -> boolean
    - isNumber(String) -> boolean
    - isValidExecutionRange(String) -> boolean
- model
  - Car
    - move() -> Car
  - Cars
    - moveOneTurn(GameService) -> Cars
    - duplicateValidation() -> boolean
    - carsToString() -> List<String>
    - carsToName() -> List<String>
    - sortCarsToDescendingOrder() -> Cars
    - findWinners() -> Cars

### 예외 목록
- DuplicateCarNameException : 중복된 자동차 이름 예외
- InvalidCarNameLengthException : 자동차 이름 길이 예외
- InvalidCharacterException : 특수문자 입력 예외
- InvalidRegisterCarsInputLengthException : 입력값 길이 예외
- NotNumberException : 시도 횟수 입력 시 문자 예외
- NumberRangeException : 숫자 범위 예외
- EmptyInputException : 빈 입력값 예외
- TheCarDoesntStartException : 모든 자동차 출발하지 않음 예외