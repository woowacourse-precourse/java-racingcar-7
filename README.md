# 자동차 경주
## 과제 진행 요구 사항
- 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Git Commit Message Conventions](https://apply.techcourse.co.kr/assignment/14/mission/46#:~:text=AngularJS%20Git%20Commit%20Message%20Conventions)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://apply.techcourse.co.kr/assignment/14/mission/46#:~:text=%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9C%BC%EB%A1%9C-,Java%20Style%20Guide,-%EB%A5%BC%20%EC%9B%90%EC%B9%99%EC%9C%BC%EB%A1%9C%20%ED%95%9C%EB%8B%A4)를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    - [JUnit 5 User Guide](https://apply.techcourse.co.kr/assignment/14/mission/46#:~:text=%ED%9B%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A5%BC%20%EA%B5%AC%ED%98%84%ED%95%9C%EB%8B%A4.-,JUnit%205%20User%20Guide,-AssertJ%20User%20Guide)
    - [AssertJ User Guide](https://apply.techcourse.co.kr/assignment/14/mission/46#:~:text=5%20User%20Guide-,AssertJ%20User%20Guide,-AssertJ%20Exception%20Assertions)
    - [AssertJ Exception Assertions](https://apply.techcourse.co.kr/assignment/14/mission/46#:~:text=AssertJ%20Exception%20Assertions)
    - [Guide to JUnit 5 Parameterized Tests](https://apply.techcourse.co.kr/assignment/14/mission/46#:~:text=Guide%20to%20JUnit%205%20Parameterized%20Tests)
### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 기능
- **입력 처리**
  - 자동차 이름을 쉼표로 구분하여 입력받는다.
  - 자동차 이름은 최대 5글자로 제한되고, 이를 어길 경우 예외를 발생시킨다.
  - 시도할 횟수를 정수로 입력받고, 정수가 아닌 경우 예외를 발생시킨다.
- **자동차 생성 및 관리**
  - 입력된 자동차 이름을 통해 각 자동차 객체를 생성하고 컬렉션에 저장한다.
- **자동차 전진 기능 구현**
  - 전진 조건은 무작위로 생성된 값이 4 이상일 때 자동차가 전진시킨다.
- **레이스 기능 구현**
  - 게임은 정해진 횟수만큼 진행되며, 각 라운드에서 모든 자동차를 조건에 따라 전진시킨다.
  - 각 라운드의 결과를 출력하며, 자동차 이름과 이동 거리를 출력한다.
- **우승자 판별**
  - 게임을 완료한 후 가장 먼 거리를 이동한 자동차를 우승자로 판별한다.
  - 우승자가 여러 명일 경우 쉼표로 구분하여 출력한다.
- **출력 처리** 
  - 게임의 각 라운드 결과와 최종 우승자를 콘솔에 출력한다.
  - 예외 상황 발생 시 에러 메시지를 출력한다.
- **예외 처리**
  - 입력이 올바르지 않을 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료한다.

## 테스트 코드
-[ ] **자동차 이름 길이 제한에 대한 예외 처리 테스트**
-[ ] **시도할 횟수를 정수가 아닐 경우 예외 처리 테스트**
-[ ] **4 이상일 때만 전진하는 조건 테스트**
-[ ] **우승자 판별 테스트**





