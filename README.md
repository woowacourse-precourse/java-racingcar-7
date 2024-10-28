# 프리코스 2일차

# 자동차 경주

## 과제 진행 요구 사항

- 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
    - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.


# 기능 요구 사항
#### 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


# 프로그래밍 요구 사항 1
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Java Style Guide를 원칙으로 한다.


# 프로그래밍 요구 사항 2
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - JUnit 5 User Guide
        - AssertJ User Guide
        - AssertJ Exception Assertions
        - Guide to JUnit 5 Parameterized Tests

# 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
# 사용 예시
-0에서 9까지의 정수 중 한 개의 정수 반환

    Randoms.pickNumberInRange(0, 9);

# 기능 설명 및 클래스 설명.

## 이 애플리케이션은 요구사항 기준으로 MVC (모델-뷰-컨트롤러) 아키텍처를 기반으로 설계되었습니다.


1. Application
- 기능: 애플리케이션의 진입점으로, 전체 프로그램의 흐름을 제어.

2. Car
- 기능: 자동차를 나타내는 클래스입니다. 자동차의 이름과 현재 위치를 관리한다.
- 주요 메서드:
   - move(): 자동차의 이동을 결정하고, 새로운 자동차 객체를 반환한다.

   - displayPosition(): 현재 자동차의 위치를 문자열 형식으로 반환한다.

   - validateCarName(String carName): 자동차 이름의 유효성을 검사한다.

3. CarFactory
- 기능: 자동차 객체를 생성하는 팩토리 클래스.
- 주요 메서드:
   - createCars(String[] names): 자동차 이름 배열을 받아 자동차 객체의 리스트를 생성한다.
   - validateCarName(String carName): 자동차 이름의 유효성을 검사한다.

4. InputHandler
- 기능: 사용자로부터 입력을 처리하는 클래스.
- 주요 메서드:
   - getCarNames(): 사용자에게 자동차 이름을 입력받고, 쉼표로 구분하여 리스트로 반환한다.
   - getAttemptCount(): 사용자에게 시도 횟수를 입력받고, 유효성을 검사하여 반환한다.
   - validateAttempts(int attempts): 시도 횟수의 유효성을 검사한다.

5. RacingGame
- 기능: 자동차 경주를 관리하는 클래스이며, 경주에 참여하는 자동차와 시도 횟수를 관리한다.
- 주요 메서드:
   - startRace(): 경주를 시작하고 각 라운드를 플레이한다.
   - playSingleRound(): 각 자동차를 이동시키고 라운드 결과를 출력.
   - announceWinners(): 최종 우승자를 발표한다.
   - validateCars(List<Car> raceCars): 경주에 참여하는 자동차의 유효성을 검사한다.

6. ApplicationConstants
- 기능: 애플리케이션에서 사용되는 상수들을 정의하는 클래스.
- 주요 상수:
   - INVALID_ATTEMPT_COUNT_MESSAGE: 유효하지 않은 시도 횟수에 대한 에러 메시지.
   - CAR_NAME_VALIDATION_MESSAGE: 유효하지 않은 자동차 이름에 대한 에러 메시지.
   - MOVE_THRESHOLD: 자동차 이동 여부를 결정하는 임계값.
   - MAX_NAME_LENGTH: 자동차 이름의 최대 길이를 정의.