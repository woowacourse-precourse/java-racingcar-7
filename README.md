# 🏎️ 자동차 경주
## **📌 학습 목표**

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 공통 피드백을 최대한 반영한다.
   - **오류를 찾을 때 출력 함수 대신 디버거 사용하기!**

## **📌프로젝트 구조**

```
\---racingcar
    |   Application.java
    |
    +---car
    |   +---constant
    |   |       RacingLimit.java
    |   |
    |   +---controller
    |   |       CarController.java
    |   |
    |   +---domain
    |   |       Car.java
    |   |
    |   +---exception
    |   |       NoPositionException.java
    |   |       NoSeparatorException.java
    |   |
    |   +---repository
    |   |       CarRepository.java
    |   |
    |   \---service
    |       |   CarService.java
    |       |
    |       \---dto
    |               CarCreateReqDto.java
    |               CarMoveRespDto.java
    |               WinnerRespDto.java
    |
    +---constant
    |       ErrorStatus.java
    |       Separator.java
    |       View.java
    |
    \---view
            InputView.java
            OutputView.java

```

---

## **📌 프로젝트 컨벤션**

- [x]  자바 코드 컨벤션을 지켰는가?
   - 인텔리제이 Code Style 적용
- [x]  JDK 21 버전을 사용하였는가?
- [x]  프로그램 실행 시작점이 `Application.main()` 인가?
- [x]  build.gradle을 변경하지 않고, 외부 라이브러리를 사용하지 않았는가?
- [x]  프로그램 종료 시 `System.exit()` 을 호출하지 않았는가?
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않았는가?
- [x]  `camp.nextstep.edu.missionutils`에서 제공하는`Console`API를 사용하여 구현하였는가?

## **📌 구현 기능 목록**

- [x]  경주할 자동차들의 이름을 입력받는다.
   - [x]  쉼표 기준으로 구분
   - [x]  이름은 5자 이하만 가능하다.
      - [x]  6자 이상일 경우, `IllegalArgumentException` 을 발생시킨다.
   - [x]  이름이 공백일 경우, `IllegalArgumentException` 을 발생시킨다.
   - [x]  자동차는 최대 100개까지만 가능하다.
- [x]  시도할 횟수를 입력한다.
   - [x]  숫자 입력 시, 범위는 1~10000 범위로 제한한다.
      - [x]  범위 해당 안될 시, `IllegalArgumentException` 을 발생시킨다.
- [x]  자동차를 전진시키거나 유지한다.
   - [x]  0에서 9 사이의 무작위 값을 구한 후 4 이상인 경우 전진시킨다.
   - [x]  차수별 실행 결과를 출력한다.
- [x]  우승자를 출력한다.
   - [x]  단독 우승자를 출력한다.
   - [x]  공동 우승자가 존재할 경우, 쉼표를 이용하여 구분한다.

## **📌 시스템 흐름**

![img.png](img.png)

## **📌 고민한 부분**

### 책임 분리

이번 과제에서 `String → List<String> → List<Car>`로 변환할 일이 있었습니다.

`pobi,woni,jun` 에서 `pobi`, `woni`, `jun` 으로 분리한 후, 이를 각각의 `Car` 객체로 생성하였습니다. 저는 `,` 구분자를 통해 구분하는 것은 `View` 에게, `List<String>` 을 `List<Car>` 로 변환하는 것은 `Service` 에게 책임을 부여하였습니다. 이렇게 분리한 이유는 입력으로부터 도메인인 `Car` 로 변환하는 것은 비즈니스 로직이라 생각하였기 때문입니다. 혹시 저와 비슷한 로직이시라면, 어떻게 하셨는지 궁금합니다!

저는 시도 횟수를 1~9,999회 까지 가능하도록 제한하였습니다. 저는 위에서 제가 설명한 것과 비슷하게, **‘입력이 숫자인가?’**는 비즈니스 로직이 아니라 생각하여 View에게 책임을 부여하고, **‘입력이 1~9,999에 속하는가?’**는 비즈니스 로직이라 생각하여 Service에게 책임을 부여했습니다.

이 때, 콘솔 입력을 `Integer.parseInt` 를 통해 바꿔줘야 했습니다. 그런데 만약 Int 범위에서 오버플로우인 숫자가 입력으로 돌아온다면, `NumberFormatException`  예외가 던져집니다. 제가 든 고민은 **‘이 상황에서 오버플로우 체크는 비즈니스 로직인가?’** 입니다. 다른 분들은 어떻게 생각하시는지 궁금합니다!
