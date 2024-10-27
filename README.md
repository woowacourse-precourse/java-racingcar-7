# java-racingcar-precourse

### 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
  - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 기능 목록
- 자동차 이름과 횟수를 받는 기능
- 잘못된 이름 형식이 들어왔을 때 예외를 터트리는 기능
- 잘못된 이동 횟수 형식이 들어왔을 때 예외를 터트리는 기능
- 자동차 경주를 시작하고 중간결과들을 종합하여 게임 지속여부를 결정하는 기능
- 자동차가 앞으로 이동할지 멈춰있을지 결정하는 기능
- 경기 중간 결과를 출력하는 기능
- 경기 우승 결과를 출력하는 기능

### 클래스 설계
- InputView
  - 자동차 이름과 횟수를 입력 받습니다.
  - 잘못된 이름 형식이 들어오면 예외를 터트립니다.
  - 잘못된 이동 횟수 형식이 들어오면 예외를 터트립니다.
- CarList
  - 자동차 이름 리스트를 입력받고 자동차List를 생성합니다.
- Racing
  - 경주를 시작합니다.
  - 매 회차마다 끝까지 도달한 자동차가 있는지 확인합니다.
  - 매 회차마다 이동 결과를 취합합니다.
- Car
  - 앞으로 전진할지 멈춰있을지 결정합니다.
  - 현재 위치를 기록합니다.
- OutputView
  - 중간 이동 결과를 출력합니다.
  - 우승 결과를 출력합니다.

### 예외상황
- 빈 값이 들어왔을 때