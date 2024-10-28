# java-racingcar-precourse

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.  
다음과 같이 정리할 수 있다.

### 입력 처리(InputManager class)
- [ ] `inputCars()` : 자동차 이름을 쉼표(,)를 기준으로 구분한 문자열을 입력받는다.
- [ ] `inputMoveCount()` : 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

### 입력 유효 검사(InputValidator class)
- [ ] `checkInputValidate()` : 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다. 
  - [ ] `validateCarName()` : 자동차 이름은 5자 이하만 가능하고, 비워져있거나 null일 수 없다.
  - [ ] `validateMoveCount()` : 이동 횟수는 음수일 수 없다.

### 자동차 정보(Car class)
* 레이싱을 참여하는 자동차의 정보를 가지고 있게 구현한다.
* `자동차의 이름`, `현재 위치`
* toString() : 자동차 이름과 현재 위치에 맞는 출력

### 레이싱 진행(RacingProgress class)
- [ ] `startRace()` : 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] `canMoveForward()` : 전진하는 조건은 `0에서 9 사이에서 무작위 값`을 구한 후 무작위 값이 `4 이상`일 경우이다. 
- [ ] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

### 결과 도출(ResultManager class)
- [ ] `getWinningCarsList()` : 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] `getWinners()` : 우승자가 여려 명일 경우 `쉼표(,)`를 이용하여 구분한다.


# 프로그래밍 요구 사항 1
기능을 모두 구현한 후, 다음과 같은 프로그래밍 요구 사항을 준수했는지 검사한다.

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램의 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일은 변경할 수 없으며, __제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.__
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍 한다.

# 프로그래밍 요구 사항 2
기능을 모두 구현한 후, 다음과 같은 프로그래밍 요구 사항을 준수했는지 검사한다.

- [ ] indent(들여쓰기) depth를 3이 넘지 않도록 구현한다.
  - [ ] while문 안에 if문이 있으면 들여쓰기는 2이다.
  - [ ] indent(들여쓰기) depth를 줄이는 좋은 방법은 함수를 분리하면 된다.

- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라
- [ ] JUnit 5와 AssertU를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 라이브러리
- `camp.nextstep.edu.mussionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 'pickNumberInRange()'를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionuilts.Console`의 `readLine()`을 사용한다.
