# java-racingcar-precourse

## 구현 세부 사항

### 입력 처리
프로그램은 두 가지 입력을 요구합니다:

1. **`carNames`**: 자동차 이름 목록(쉼표 `,`로 구분).
   - 각 자동차 이름은 최대 5자 이내여야 합니다.

2. **`N`**: 게임 라운드 수.
   - 각 라운드에서 0부터 9 사이의 무작위 정수를 생성합니다.
   - 해당 값이 4 이상일 경우 자동차가 전진합니다.
   - 경주가 종료되면 우승한 자동차들을 출력합니다. 공동 우승자가 있을 수 있습니다.

### 출력 메시지

#### `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
`carNames` 입력을 요청하는 메시지입니다.  
입력이 유효하지 않은 경우 `IllegalArgumentException`을 발생시킵니다.
   - 아무 입력을 못 받았을때
   - 입력 값이 5글자를 넘어갈때
   - 중복된 이름이 있을때
#### `시도할 횟수는 몇 회인가요?`
`N` 입력을 요청하는 메시지입니다.  
입력이 유효하지 않은 경우 `IllegalArgumentException`을 발생시킵니다.
   - 정수가 아닐때
   - 입력값이 0이거나 음수일때
#### `실행 결과`
각 라운드 `i` (0부터 `N`까지)에서 각 자동차의 상태를 출력합니다.

#### `최종 우승자 :`
경주가 끝난 후, 우승한 자동차의 이름을 출력합니다. 여러 대의 자동차가 공동 우승할 수 있습니다.

### 프로젝트 구조
```
racingcar/
│
├── Application.java              
│
├── controller/                    
│   └── RacingCarController.java
│
├── dto/                           
│   ├── GameRoundInputHandler.java
│   └── CarNamesInputHandler.java
│
├── message/                       
│   └── Message.java
│
├── model/                        
│   ├── RacingCar.java
│   ├── RacingCars.java
│   └── Score.java
│
├── validator/                    
│   ├── GameRoundValidator.java
│   └── CarNamesValidator.java
│
└── view/                         
    ├── InputView.java
    └── OutputView.java

```
### 객체

#### `controller/`
`Application`의 흐름을 제어하는 컨트롤러가 포함된 패키지입니다.
   - `RacingCarController.java` : RacingCars의 로직을 처리합니다.
#### `dto/`
단일 책임 원칙(Single Responsibility Principle)을 준수하기 위해 입력 처리를 위한 별도의 클래스를 만들었습니다.
   - `CarNamesInputHandler.java` : 자동차 이름 입력을 처리합니다.
   - `GameRoundInputHandler.java` : 게임 라운드 입력을 처리합니다.
#### `message/`
문자열 상수를 저장합니다.
   - `Message.java` : 오류 메세지나 사용자 프롬프트 문자열을 관리합니다.
#### `model/`
비즈니스 로직을 처리하는 모델 객체들이 포함됩니다.
   - `RacingCar.java` : 레이스에 참가하는 개별 자동차
   - `RacingCars.java` : 여러 자동차를 관리
   - `Score.java` : 점수 관련 로직 담당
#### `validator/`
입력 값의 유효성을 검사하는 검사기가 포함됩니다.
   - `CarNamesValidator.java` : 입력된 자동차 이름이 조건을 충족하는지 검증합니다.
   - `GameRoundValidator.java` : 입력된 게임 라운드 값이 조건을 충족하는지 검증합니다.
#### `view/`
사용자 인터페이스를 담당하는 클래스들이 포함됩니다.
   -  `InputView.java` : 사용자로부터 입력을 받습니다.
   -  `OutputView.java` : 결과를 출력합니다.
