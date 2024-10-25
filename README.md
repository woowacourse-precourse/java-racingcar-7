# java-racingcar-precourse

## 구현 기능 목록
___
### 입력
- 각 자동차에 이름을 부여할 수 있다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - "시도할 횟수는 몇 회인가요?" 출력
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 실행
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        - Random 값 추출은 `camp.nextstep.edu.missionutils.Random`s의 `pickNumberInRange()`를 활용한다.

### 출력
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    - 실행 시마다 실행 결과를 출력한다.
    - 전진은 -으로 출력한다.
    - "실행 결과" 출력
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    - "최종 우승자" 출력