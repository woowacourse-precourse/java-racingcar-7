# java-racingcar-precourse

## ✍ 기능 목록 정리

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - Car는 forward의 행위를 한다.
    -  stop은 행위로 표현하지 않는다. (forward를 하지 않으면, stop이기 때문)
- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    - 출력 요구사항에 맞게 "이름 : - X (distance)"으로 출력한다.
- [x] 자동차 이름은 5자 이하만 가능하다.
    - 공백 이름은 허용하지 않는다.
- [x] 입력받은 값은 쉼표(,)를 기준으로 자동차 이름을 구분한다.
  - 입력 값은 `Console.readLine()`을 활용한다.
  - ,를 기준으로 구분한다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - Car가 전달받은 값이 4 이상일 때만 전진하도록 한다.
  - 무작위 값 추출은 `Randoms.pickNumberInRange()`를 활용한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [x] 자동차 게임이 한 턴 진행될 때마다, 자동차 이름과 이동거리를 출력한다.
- [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ❌ 예외 케이스

### 자동차 이름 입력
- [x] 이름이 0자 미만이거나 5자 초과일 때
- [x] 이름이 공백일 때
- [x] 중복된 이름이 존재할 때
- [x] 이름에 숫자만 존재할 때

### 경주 횟수 입력
- [ ] 1 미만의 값을 입력했을 때 (최소 1번은 진행한다고 가정)
