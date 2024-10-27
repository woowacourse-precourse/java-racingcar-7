# java-racingcar-precourse

# 자동차 경주
## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력 
* 경주할 자동차 이름(이름음 쉼표(,) 기준으로 구분)
    ```
    pobi,woni,jun
    ```
* 시도할 횟수
    ```
    5
    ```
#### 출력
* 차수별 실행 결과
    ```
    pobi : --
    woni : ----
    jun : ---
    ```
* 단독 우승자 안내 문구
    ```
    최종 우승자 : pobi
    ```
* 공동 우승자 안내 문구
    ```
    최종 우승자 : pobi, jun
    ```
#### 실행 결과 예시
```
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
## 프로그래밍 요구 사항 1
* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 `Aplication`의 `main()`이다.
* `build.gradle`파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.
## 프로그래밍 요구 사항 2
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    * 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        * [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        * [AssertJ User Guide](https://assertj.github.io/doc)
        * [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        * [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리
* `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`및 `Console`API를 사용하여 구현해야 한다.
    * Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시
* 0에서 9까지의 정수 중 한 개의 정수 반환
```
Randoms.pickNumberInRange(0, 9);
```

## 구현 기능 목록
1. main()
* `readLine()`을 통해 경주할 자동차 이름 입력 받기
* `readLine()`을 통해 시도할 횟수 입력받기
* 입력 관리 메소드 사용하여 자동차 이름이 담긴 list `carNames`생성
* 시도할 횟수 만큼 for문 반복
    * 경주 게임 시뮬레이터 클래스를 활용하여 1회씩 실행, 출력
* 최종 우승자 출력

2. 입력 관리 (메소드)
* `split`을 통해서 쉼표를 기준으로 자동차 이름 구분해서 `carNames`list에 담기
  * 이름이 5자 이하가 아니라면 예외 처리
  * 이름이 빈 문자열인경우?
* `carNames`반환

3. 경주 게임 시뮬레이터 (클래스)
* 자동차 이름이 담긴 list `carNames`과 시도 횟수로 객체 생성
* 자동차 별로 전진 횟수를 담는 list `carMoves`(자동차 이름 갯수만큼의 요소를 가짐)
* 1회 실행하는 메소드
    * 자동차 이름의 개수만큼 반복
    * 무작위 값이 4이상일 경우 `carMoves`의 해당 위치 값 +1
* 차수별 실행 결과 출력하는 메소드
* 최종 우승자 출력하는 메소드
    * `carMoves`요소의 값과 시도 횟수가 같은 위치의 자동차 이름 우승자 list에 추가
    * 우승자 list 출력
    * 우승자 없다면 '우승자가 없습니다'메세지 출력

### 최종 우승자 선정 기준
* 전진 횟수와 시도 횟수가 같은 자동차
* 전진 횟수가 가장 많은 자동차


