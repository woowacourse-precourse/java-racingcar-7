# java-racingcar-precourse

## 기능 요구 사항
### 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 구현
1. 입출력 요구 사항에서 "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)"으로 입력 받음
    - ex. pobi,woni,jun
    - ","를 기준으로 이름을 나눔
    - 이름이 5자 이하만 가능하기 때문에 이에 대한 예외 처리 필요
    - 이름 중복에 대한 예외 처리 필요
2. 시도할 횟수를 입력 받음
    - ex.5
    - 숫자를 입력 받으면 되는데, 0 이상의 값을 입력 받도록 할 것
    - 음수와 숫자가 아닌 다른 문자가 입력되었다면 예외 처리
3. 입력값에 따른 모델 구현
   - MVC 구조로 로직을 구현
   - 입력값을 DTO를 이용하여 모델 객체 생성
4. 경주 로직 구현
   - 서비스에서 Car(모델) 객체 관리 및 연산 과정 수행
      - 경주 로직
      - 우승자 도출 및 출력 로직
