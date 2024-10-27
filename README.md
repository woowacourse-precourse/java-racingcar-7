# java-racingcar-precourse

## 기능 목록

---

### Game
- __Game__
    - 각 시도 마다 전체 자동차를 대상으로 전진 여부를 파악하고 자동차 객체의 상태를 업데이트한다.
      - 전진 여부는 0 ~ 9 사이의 무작위 값을 구한 후 무작위 값이 4 이상이면 전진한다.
    - 각 시도 마다 진행 사항을 출력한다.
    - 가장 멀리 간 자동차를 파악하고 우승자를 찾아 출력한다 우승자는 여러 명일 수 있다.

### Input
  - 사용자의 입력값을 통해 게임에 참여할 자동차와 시도할 회수를 파싱한다.
      - 입력값을 Validator.java의 메서드를 호출하여 유효성을 파악한다.
      - 잘못된 값을 입력할 경우 __IllegalArgumentException__ 을 발생시킨다.

### Validation
  - 사용자의 입력 값이 유효한지 파악한다.
      - 자동차 이름은 한 줄의 문자열 입력으로 각 자동차 이름은 쉼표(,)로 구분한다.
      - 빈 문자열을 허용하지 않는다.
      - 각 자동차 이름은 5자 이하로만 입력할 수 있다.
      - 시도할 횟수는 양수의 자연수로 한다.
  - __Validator.java__ 의 메서드는 상태 변화가 없이 유효값 판정만을 진행하므로 static 메서드로 구현한다.


## 프로젝트 구조

---

~~~
src
  main/
  Application.java
  model/
    Game.java
    Car.java
  view/
    GameView.java
  util/
    Validator.java