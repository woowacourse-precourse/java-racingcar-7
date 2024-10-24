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

### 예외사항

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- 쉼표가 아닌 다른 구분자로 이름을 입력하면 예외가 발생한다.
- 이름에 빈 값이나 null이 들어오면 예외가 발생한다.
- 이름은 숫자 혹은 영문자로만 구성될 수 있다.
- 이름의 길이가 5자를 초과하면 예외가 발생한다.
- 시도할 횟수에 숫자가 아닌 다른 값을 입력하면 예외가 발생한다.
- 시도할 횟수는 최소 1회이다.

### 커밋 규칙

- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#allowed-type)을 참고한다.
- 형식 : Type(Scope): Subject

Type
- feat (기능 구현)
- fix (버그 수정)
- docs (문서화)
- style (포맷팅, 형식 수정)
- refactor (리팩터링)
- test (테스트 작성)
- chore (그 외 설정)

Scope
- 클래스(.class) 혹은 객체의 큰 범위로 작성한다.

Subject
- 현재형과 명령어로 내용을 작성한다.