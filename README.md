# java-racingcar-precourse
## 자동차 경주
초간단 자동차 경주 게임을 구현한다.

### 기능 구현
1. 입력
    - 경주할 자동차 이름을 입력 받는다. 이름은 쉼표(,) 기준으로 구분한다.
    - 시도할 횟수(몇 번의 이동을 할 것인지)를 입력 받는다.


2. 전진 시도(시도할 횟수만큼 반복)
    - 0 ~ 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우에 전진한다.
    - 실행 결과를 출력한다. 입력 받은 이름 순서대로 결과를 "-" 로 출력한다.


3. 우승자 출력
    - 우승자를 출력한다. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
   

4. 예외처리
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료한다.