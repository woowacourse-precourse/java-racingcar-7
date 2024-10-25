# java-racingcar-precourse

<br>

# 🚀 미션 간단 설명
2주차 미션은 n대의 자동차가 주어진 횟수 동안 4 이상일 때 전진하는 조건으로 경주를 진행하며, 게임 종료 후 가장 멀리 간 우승자를 출력하는 프로그램을 구현하는 미션입니다.

<br>

## 🔒 제약사항 (1)
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 🔒 제약사항 (2)
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 💡 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
      
<br>

# 🛠 구현할 기능 목록
- 입력 받는 기능
  -  이름을 입력받는 기능
    - 빈 문자열인지 검사하는 기능
    - 5글자 이상인지 검사하는 기능
  - 시도할 횟수를 입력받는 기능
    - 정수형인지 검사하는 기능
- 출력 하는 기능
  - 턴 마다 출력하는 기능
  - 최종 우승자를 출력하는 기능
- 자동차 경주 진행 기능
  - 시도횟수만큼 진행하는 기능
  - 한 턴을 진행하는 기능
  - 우승자를 선정하는 기능
  - 랜덤값을 뽑아 4이상인지 확인하는 기능

<br>

## 📋 구현 체크
- [x] Car 클래스
  - [x] 이름과 위치를 속성으로 갖는다
  - [x] 생성자를 통해 이름과 위치를 초기화한다
  - [x] 위치를 증가시키는 메서드
  - [x] toString 메서드를 오버라이드해 (이름) : ---- 을 출력하도록
- [x] Input 클래스
  - [x] 자동차 이름을 입력받는 함수
  - [x] 올바른 입력인지 검증하는 함수
    - [x] 빈 문자열인지 검사하는 함수
    - [x] 이름이 5글자 초과인지 검사하는 함수
    - [x] 시도 횟수가 정수인지 검사하는 함수
  - [x] 시도할 횟수를 입력받는 함수
- [x] Output 클래스
  - [x] 매 턴마다 진행상황 출력하는 함수
  - [x] 최종 우승자를 출력하는 함수
- [x] Racing 클래스
  - [x] Car 객체를 갖는 리스트를 속성으로 갖는다
  - [x] 생성자를 통해 리스트를 초기화한다
  - [x] 입력받은 횟수 만큼 게임을 진행하는 함수
  - [x] 매 턴을 진행하는 함수
  - [x] 우승자를 선정하여 이름을 List 로 리턴하는 함수
  - [x] 랜덤값을 뽑아 4 이상인지 판별하는 함수
- [ ] 모든 테스트 케이스가 성공하는지?
- [ ] 자바 코드 컨벤션(Java Style Guide)을 지켰는지?
