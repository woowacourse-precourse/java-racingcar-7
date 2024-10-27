# java-racingcar-precourse

# 🏎️ 자동차 경주

<hr>

## 📋 과제 진행 요구 사항
- 미션은 [자동차 경주 저장소](https://github.com/woowacourse-precourse/java-racingcar-7)를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

<hr>

## 🖥️ 프로그래밍 요구 사항1
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 ```Application```의 ```main()```이다.
- ```build.gradle``` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 ```System.exit()```를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 🖥️ 프로그래밍 요구 사항1
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

### 라이브러리
- ```camp.nextstep.edu.missionutils```에서 제공하는 ```Randoms``` 및 ```Console``` API를 사용하여 구현해야 한다.
  - Random 값 추출은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()```를 활용한다.
  - 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용한다.
<hr>

## ⚒️ 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 ```IllegalArgumentException```을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항
- 입력 
  - 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- 출력
  - 차수별 실행 결과
  - 단독 우승자 안내 문구
  - 공동 우승자 안내 문구
```dtd
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<hr>

## 🧐 기능 요구 사항 재정의 
**[입력]**
1. 사용자로부터 자동차 이름을 입력받는다.
2. 사용자로부터 시도할 횟수를 입력받는다.

**[레이싱]**
1. 시도 횟수만큼 레이스를 진행한다.
2. 무작위 값이 4 이상일 경우 자동차를 전진한다.
3. 자동차의 현재 위치를 출력한다.

**[우승자 선정]**
1. 경주에 참여한 자동차의 위치 중 가장 큰 값(max)을 알아낸다.
2. max값과 현재 위치가 같은 자동차들을 우승자로 선정한다.

**[출력]**
1. 레이스의 시작을 알리는 메시지("실행 결과")를 출력한다.
2. 레이스마다 각 자동차의 현재 위치를 출력한다.
3. 최종 우승자들의 이름을 출력한다.

**[예외처리]**
1. 사용자가 입력한 자동차 이름이 중복된 경우 예외 발생
2. 사용자가 입력한 자동차 이름이 공백일 경우 예외 발생
3. 사용자가 입력한 자동차 이름이 5글자를 초과한 경우 예외 발생
4. 사용자가 입력한 시도 횟수가 숫자가 아닌 경우 예외 발생
5. 사용자가 입력한 시도 횟수가 양수가 아닌 경우(음수 혹은 0인 경우) 예외 발생

<hr>

## 🏁 수행 목표

1. 클린코드를 위해 노력했습니다. 
   - 변수명, 메소드명을 축약 없이 지었습니다. 
   - 단일 역할을 수행하는 작은 메서드로 최대한 분리했습니다.
   - 메소드의 깊이가 1이 되도록 노력했습니다. 
2. MVC 패턴을 사용했습니다. 
   - controller: racing 게임의 실행을 담당합니다. 
   - model: Car 객체를 저장하고 처리합니다. 
   - view: Input과 Output을 처리합니다. 
3. 각 기능에 대한 유닛테스트를 진행했습니다. 
4. 배열 대신 컬렉션을 사용하기 위해 노력했습니다. 
6. 가독성을 기준으로 stream과 for문을 선택하여 사용했습니다. 
7. 의미있는 커밋 메시지 작성을 위해 노력했습니다.
   - 기능 목록 단위로 커밋을 추가했습니다. 
   - 
 
  