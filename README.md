# java-racingcar-precourse

## 1. 자동차 경주 게임 소개

자동차 경주 게임은 입력된 자동차 이름과 경주 횟수를 기준으로 각 자동차가 이동하며 최종 우승자를 가리는 프로그램입니다.
자동차는 0~9 사이의 Random 값을 사용해 이동 거리 조건을 충족하면 전진하고, 결과는 사용자에게 매 라운드마다 출력됩니다.
최종적으로 가장 멀리 이동한 자동차가 우승자로 선정됩니다.

## 2. 패키지 목록 (클래스 포함)

```
 src
 ├── main
 │   └── java
 │       └── racingcar
 │           ├── controller
 │           │   └── RacingGameController.java       // 게임 로직을 제어하는 컨트롤러 클래스
 │           ├── domain
 │           │   └── Car.java                        // 자동차 객체를 정의하는 도메인 클래스
 │           ├── service
 │           │   ├── RacingGameService.java          // 레이싱 게임 서비스 인터페이스
 │           │   ├── RacingGameServiceImpl.java      // 레이싱 게임 서비스 구현 클래스
 │           │   ├── MoveDistanceProvider.java       // 이동 거리 생성 인터페이스
 │           │   └── RandomMoveDistanceProvider.java // Random 값 이동 거리 제공 구현 클래스
 │           ├── util
 │           │   ├── CommonUtil.java                 // 문자열 분리 등의 유틸리티 메서드
 │           │   └── Constant.java                   // 상수 값을 관리하는 클래스
 │           ├── validation
 │           │   ├── CarNamesValidator.java          // 자동차 이름 검증 인터페이스
 │           │   ├── CarNamesValidatorImpl.java      // 자동차 이름 검증 구현 클래스
 │           │   ├── RaceCountValidator.java         // 경주 횟수 검증 인터페이스
 │           │   └── RaceCountValidatorImpl.java     // 경주 횟수 검증 구현 클래스
 │           ├── view
 │           │   ├── InputView.java                  // 사용자 입력 인터페이스
 │           │   ├── InputViewImpl.java              // 사용자 입력 구현 클래스
 │           │   ├── OutputView.java                 // 출력 인터페이스
 │           │   └── OutputViewImpl.java             // 출력 구현 클래스
 │           ├── AppConfig.java                      // 객체 생성 및 의존성 주입을 담당하는 클래스
 │           └── Application.java                    // 애플리케이션 실행 클래스
 ├── resources                                       // 메시지 프로퍼티 파일을 관리하는 디렉토리
 └── test
     └── java
         └── racingcar
             ├── controller
             │   └── RacingGameControllerTest.java   // RacingGameController 테스트 클래스
             ├── domain
             │   └── CarTest.java                    // Car 클래스의 테스트 클래스
             ├── service
             │   ├── RacingGameServiceImplTest.java  // RacingGameServiceImpl 테스트 클래스
             │   └── RandomMoveDistanceProviderTest.java // RandomMoveDistanceProvider 테스트 클래스
             └── validation
                 ├── CarNamesValidatorImplTest.java  // CarNamesValidatorImpl 테스트 클래스
                 └── RaceCountValidatorImplTest.java // RaceCountValidatorImpl 테스트 클래스
```

## 3. 기능 목록

1. **자동차 이름 입력 및 검증**
    * 사용자가 입력한 자동차 이름을 검증하여 이름이 빈 값이거나 공백일 경우 예외를 발생시킵니다.
    * 예시: `" " => 예외 발생`
2. **경주 횟수 입력 및 검증**
    * 사용자가 입력한 경주 횟수를 검증하여 빈 값이거나 1 미만일 경우 예외를 발생시킵니다.
    * 예시: `"0 => 예외 발생"`
3. **자동차 이름 중복 및 길이 제한 검증**
    * 중복된 자동차 이름 입력 시 예외 발생.
    * 이름은 5자 이하만 가능합니다.
    * 예시: `"pobi,woni,pobi => 예외 발생"`
4. **자동차 이동 거리 생성**
    * 각 라운드마다 0~9 사이의 Random 값을 생성합니다.
5. **자동차 이동 로직**
    * Random 값이 4 이상일 때만 이동하며, 자동차가 이동한 거리를 저장하고 각 라운드의 결과를 출력합니다.
6. **라운드별 레이싱 결과 출력**
    * 각 라운드가 끝날 때마다 모든 자동차의 이름과 이동 거리를 출력합니다.
7. **우승자 결정 및 출력**
    * 가장 멀리 이동한 자동차를 우승자로 결정하고 출력합니다.
    * 이동 거리가 동일한 경우 공동 우승자를 출력합니다.

## 4. 예외 상황 목록

1. **자동차 이름 관련 예외 상황**
    * 빈 값이나 공백 입력 시 예외 발생.
    * 중복된 이름 입력 시 예외 발생.
    * 이름이 5자 초과일 경우 예외 발생.
2. **경주 횟수 관련 예외 상황**
    * 경주 횟수가 빈 값이거나 1 미만일 때 예외 발생.
3. **이동 거리 생성 관련 예외 상황**
    * 이동 거리 생성 범위는 0~9로 제한되어야 함.
4. **출력 관련 예외 상황**
    * 입력값이 빈 문자열이거나 형식에 맞지 않는 경우 예외 발생.

## 5. 테스트 목록

1. **자동차 이름 검증 테스트**
    * 빈 문자열, 공백 입력, 중복 이름 입력 시 예외 발생 테스트.
2. **경주 횟수 검증 테스트**
    * 빈 값, 공백 입력 및 숫자가 아닌 값 입력 시 예외 발생.
3. **Random 값 생성 테스트**
    * 이동 거리 생성이 0~9 범위 내에서 이루어지는지 확인.
4. **자동차 이동 로직 테스트**
    * Random 값이 최소 이동값 이상일 때 자동차가 이동하는지 확인.
5. **우승자 결정 테스트**
    * 가장 멀리 이동한 자동차가 우승자로 출력되는지 확인.