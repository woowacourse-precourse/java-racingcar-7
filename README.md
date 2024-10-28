# java-racingcar-precourse

## 게임의 핵심 기능

- 사용자가 입력한 자동차 이름과 이동 횟수에 따라 자동차가 전진하는 경주 게임을 구현한다.
- 주어진 조건에 따라 각 자동차가 이동 여부를 결정하고, 경주가 끝난 후 우승자를 판별하여 알려준다.

## 예외 처리할 사항

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료한다.
  - 자동차 이름이 5자를 초과하는 경우 예외 처리
  - 자동차 이름 입력 시 구분자 사이에 빈 값이 있는 경우 예외 처리
  - 이동 횟수가 양수가 아닌 경우 예외 처리

## 기능 구현 목록

### 1. 자동차 이름 및 이동 횟수 입력 기능

- [x] 자동차 이름들을 입력받는다.
  - 사용자에게 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 요청한다.
- [x] 이동 횟수를 입력받는다.
  - 사용자에게 "시도할 횟수는 몇 회인가요?"를 요청한다.

### 2. 입력된 자동차 이름 및 이동 횟수의 유효성 검사 기능

- [x] 각 자동차 이름의 길이를 검사한다.
  - 자동차 이름이 5자를 초과할 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 자동차 이름 입력 시 구분자 사이에 빈 값이 있는지 검사한다.
  - 빈 값이 있을 경우 `IllegalArgumentException`을 발생시킨다.
- [x] 이동 횟수가 양수인지 검사한다.
  - 이동 횟수가 양수가 아닐 경우 `IllegalArgumentException`을 발생시킨다.

### 3. 자동차 경주 진행 기능

- [x] 사용자 지정 이동 횟수 동안 경주를 진행한다.
  - 각 이동에서 자동차는 무작위로 전진하거나 멈춘다.
  - 무작위 값이 0에서 9 사이에서 발생하며, 4 이상일 경우 자동차가 전진한다.

### 4. 자동차 이동 로직 구현

- [x] 무작위 값을 생성하여 각 자동차의 이동 여부를 결정한다.
- [x] 이동 여부에 따라 각 자동차의 위치를 업데이트한다.

### 5. 경주 결과 출력 기능

- [x] 각 이동 후 자동차의 현재 위치를 출력한다.
  - "[자동차 이름]: [위치]" 형식으로 출력한다.

### 6. 우승자 판별 기능

- [x] 모든 이동이 완료된 후 우승자를 판별한다.
  - 가장 멀리 이동한 자동차(들)을 우승자로 판별한다.
  - 우승자가 여러 명일 경우, 우승자들의 이름을 (`, `)로 구분하여 출력한다.
