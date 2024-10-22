# java-racingcar-precourse


### 프로그램 기술

- JDK 21
- Code Convention: [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)
- gradle
- JUnit 5, AssertJ

### 기능 목록 단위

사용자 
- 경주할 자동차 이름을 입력한다. 
  - 이름은 쉼표(,)를 기준으로 구분한다.
  - 이름은 5자 이하만 가능하다.
- 시도할 횟수를 입력한다. 

자동차 경주 게임

- 자동차가 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - 4 미만일 경우 전진하지 못한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
  - 우승자는 한 명 이상일 수 있다. 
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 실행 결과에서 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.