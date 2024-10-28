# java-racingcar-precourse

### 구현할 기능 목록
- [x] 사용자에게 입력을 받는다.
  - [x] 각 자동차의 이름을 입력 받는다.
    -  [x] 자동차 이름을 쉼표(,)를 기준으로 구분한다.
  - [x] 몇번의 이동(시도할 횟수)을 할 것인지 입력받는다.
  - [x] 예외 처리
    - [x] 입력된 자동차의 이름이 5자를 넘으면 `IllegalArgumentException`을 발생시킨다.
      - [x] 시도할 횟수가 양수가 아니면 `IllegalArgumentException`을 발생시킨다.

- [x] 경기에 대한 시뮬레이션을 구현한다.
  - [x] 자동차를 조건에 따라 전진시킨다.
    - [x] 무작위 값(0~9)을 구한 후 4 이상이면 전진한다.
    - [x] 모든 자동차에 대해 진행한다.
    
  - [x] 경기 진행을 출력한다.
    - [x] 각 자동차의 이름을 포함하여 전진한 상태를 출력한다.
    - [x] 입력 받은 (시도할 횟수)만큼 진행하면 우승자를 출력하고 종료한다.


### 학습할 목록
- [x] 테스트 코드 API 학습: https://jolly-restaurant-d2f.notion.site/Java-Test-JUnit-AssertJ-12ab51098aa0809e84eada3624f1ed47?pvs=4
- [x] 디버깅 학습 (feat/IntelliJ): https://jolly-restaurant-d2f.notion.site/Debug-Intellij-12db51098aa080d19fb0f43f9f9f7776?pvs=4