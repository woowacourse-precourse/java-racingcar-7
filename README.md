# java-racingcar-precourse

## 기능 요구사항
### 🏎 자동차 경주 게임 구현

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 고려사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 기능 구현 목록

- [x] 자동차 이름 및 시도 횟수 입력받기
  - [x] 입력 클래스 분리
  - [x] 자동차 이름 입력받기
  - [x] 시도 횟수 입력받기
- [ ] 자동차 정보 저장
  - [x] Car 도메인 구현
- [ ] 자동차 레이싱 로직 구현
  - [ ] Racing 도메인 구현
  - [x] Progress 도메인 구현
- [ ] 랜덤 숫자 전진
  - [ ] RacingService 클래스 분리
  - [ ] 자동차별 랜덤 숫자 전진 로직 구현
- [ ] 시도별 경주 결과 출력
  - [ ] 시도별 경주 결과 출력 클래스 분리
  - [ ] 출력 클래스 분리
  - [ ] 시도마다 자동차 전진 내역 출력
- [ ] 최종 우승자 출력
  - [ ] 최종 우승자 계산 클래스 분리
  - [ ] 최종 우승자 계산 로직 구현
- [ ] 상수 처리
  - [ ] 전진 조건을 enum으로 관리
  - [ ] 랜덤 숫자 범위 enum으로 관리
- [ ] 모든 기능들을 조합하는 runner 클래스 구현
- [ ] runner 클래스를 호출하는 Application 클래스 구현
- [ ] 테스트코드 작성
