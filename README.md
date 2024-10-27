# java-racingcar-precourse

<!-- ROADMAP -->
## 기능 요구 사항
<hr>
초간단 자동차 경주 게임을 구현한다.

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있으며, 전진 시 자동자 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하이다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 한 명 이상의 우승자를 쉼표(,)로 구분하여 알려준다.
- [ ] 쉼표, 콜론 외 커스텀 구분자를 지정한다(문자열 앞부분의 "//"와 "\n"사이에 위치하는 문자)
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.

### 입출력 요구 사항
<h4>입력</h4>
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
<pre>pobi,woni,jun</pre>
- 시도할 횟수
<pre>5</pre>
<h4>출력</h4>
- 차수별 실행 결과
<pre>pobi : --
woni : ----
jun : ---</pre>
- 단독 우승자 안내 문구
<pre>최종 우승자 : pobi</pre>
- 공동 우승자 안내 문구
<pre>최종 우승자 : pobi, jun</pre>
<h4>실행 결과 예시</h4>
<pre>
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
</pre>

## 프로그래밍 요구 사항 1
<hr>

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일은 변경할 수 없다.
- [ ] 제공된 라이브러리 이외의 외부 라이브러리를 사용하지 않는다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

## 프로그래밍 요구 사항 2
<hr>

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 라이브러리
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.