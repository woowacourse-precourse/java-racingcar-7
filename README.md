# java-racingcar-precourse

## 과제 진행 요구 사항
- 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항
- 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록
1. InputView Class (View)
   - [X] 입력 문자열 분리
   - [X] 이동 횟수 입력
2. OutputView Class (View)
   - [X] 중간 결과 출력
   - [X] 최종 우승자 출력
3. Vehicle Class (Model)
   - [X] Set Vehicle Name
   - [X] Move Vehicle
4. Exception Class (Model)
   - [X] 이름 글자 수 Exception
   - [X] 문자열이 공백과 ,로만 이루어진 경우 Exception
5. RacingController (Controller)
   - [X] View와 Model을 이용하여 순서에 맞게 구현

## 미션 요구 사항
0.[X] 1주차 공통 피드백을 최대한 반영한다.
1.[X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
2.[X] 3항 연산자를 쓰지 않는다.
3.[X] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
4.[X] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
5.[X] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.