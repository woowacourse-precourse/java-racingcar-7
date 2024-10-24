# java-racingcar-precourse

## 프로그래밍 요구사항
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

## 구현 기능
- [x] InputParser를 통하여 게임 참가자, 게임 횟수를 입력 받는다.
- [x] RacingCar 도메인을 정의하여 게임을 진행하고, 진행상태를 관리한다.
- [x] 레이싱앱을 시작하는 RacingStarter를 presentation layer로 둔다.
- [x] RacingService를 통하여 도메인인 RacingCar를 경주시킨다. 이후 결과까지 출력하는 로직추가.
- [x] RacingStarter가 InputParser 유틸을 이용하여 RacingService 인스턴스를 만들어 레이싱 진행 로직 추가.