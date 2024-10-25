# [자동차 경주] 우아한테크코스(pre) 2주차

<details>
<summary> 프로젝트 구조 </summary>

Application
- RacingGame.run()

UserView()
- readCarName()
- readAttempNum()
- printResultGuide()
- printCarNameGuide()
- printWinner()
- printAttempResult()

RacingGame()
- run()
  - Car.set()
  - setAttempNum()
  - UserView.printResultGuide()
  - for{
  goOrStop()
  UserView.printAttempResult()
  }
  - findWinner()
  - UserView.printWinner()
- setAttempNum()
  - UserView.readAttempNum()
  - checkAttempNum()
- checkAttempNum()
- goOrStop()
- findWinner()

Car()
- set()
  - UserView.readCarName()
  - separateName()
- get()
- separateName()
  - checkBlank()
  - checkDuplication()
  - checkCount()
- checkCount()
- checkDuplication()
- checkBlank()
- putCarMap()
</details>

___
## 🐜 학습 목표
- 여러 역할을 수행하는 **큰 함수**를 단일 역할을 수행하는 **작은 함수로 분리**한다.
- **테스트 도구**를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- **1주차 공통 피드백**을 최대한 반영한다.
  - `System.out.println()` 대신 디버거 사용.
  - 이름 축약하지 않기.
  - 스페이스와 탭 혼용하지 않기(Pull Request 확인).
  - 코드 포매팅(Ctrl+Alt+L)
  - Java에서 제공하는 API 적극 활용.
---
## 🎯 기능 요구 사항
### 초간단 자동차 경주 게임 구현.
#### 기본 기능
- 주어진 횟수 동안 n대의 자동차는 **전진** 또는 **멈출 수 있다**.
- 각 자동차에 **이름**을 부여할 수 있다. 전진하는 자동차는 출력할 때 이름을 같이 출력한다.
- 자동차 이름은 **쉼표(,)** 를 기준으로 구분하며 이름은 **5자 이하**만 가능하다.
- 사용자는 **몇 번의 이동**을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 **무작위 값**을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. **우승자는 한 명 이상**일 수 있다.
- 우승자가 여러 명일 경우 **쉼표(,)** 를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
#### 추가 세부 사항
- 자동차는 최대 5대까지 입력 가능하다.
- 자동차 이름
  - 중복될 수 없다.
  - 공백은 포함될 수 없다.
  - 쉼표(,) 외의 특수문자는 허용한다.
- 최대 시도 횟수는 10이며 1 이상의 양의 정수만 허용한다.

### 입출력 요구 사항
#### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
jyu,yeong,jeongha
```
- 시도할 횟수
```
5
```
#### 출력
- 차수별 실행 결과
```
jyu : --
yeong : ----
jeongha : ---
```
- 단독 우승자 안내 문구
```
최종 우승자 : jyu
```
- 공동 우승자 안내 문구
```
최종 우승자 : jyu, yeong
```
#### 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
jyu,yeong,jeongha
시도할 횟수는 몇 회인가요?
5

실행 결과
jyu : -
yeong : 
jeongha : -

jyu : --
yeong : -
jeongha : --

jyu : ---
yeong : --
jeongha : ---

jyu : ----
yeong : ---
jeongha : ----

jyu : -----
yeong : ----
jeongha : -----

최종 우승자 : jyu, jeongha
```
---
## 🎸 프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다. 
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다. 
- 3항 연산자를 쓰지 않는다. 
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 사용 예시
  - 0에서 9까지의 정수 중 한 개의 정수 반환
```
Randoms.pickNumberInRange(0, 9);
```
---
## 🐌 과제 진행 요구 사항
- [woowacourse-precourse/java-racingcar-7](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 fork한다.
- fork한 저장소 [33jyu33/java-racingcar-7](https://github.com/33jyu33/java-racingcar-7)를 clone한다.
- 기능 구현 전, `README.md`에 구현할 기능 목록을 정리한다.
- Git의 commit 단위는 `README.md`에 정리한 기능 목록 단위로 추가한다.
- Commit Message Conventions를 준수하여 commit message를 작성한다.
- 이외 내용은 아래 프리코스 가이드를 참고한다.
---
## 📖 프리코스 가이드
### 진행 방식
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.
- 매주 진행할 미션은 화요일 오후 3시부터 확인할 수 있으며, 다음 주 월요일까지 구현을 완료하여 제출해야 한다.
    + 제출은 일요일 오후 3시부터 가능하다.
    + 정해진 시간을 지키지 않을 경우, 미션을 제출하지 않은 것으로 간주한다.
    + 종료 일시 이후에는 추가 푸시를 허용하지 않는다.

### 미션 제출 방법
- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다._[(프리코스 과제 제출 문서 참고)](https://github.com/woowacourse/woowacourse-docs/tree/main/precourse)_
- GitHub에 미션을 제출한 후 __우아한테크코스 지원 플랫폼에 PR 링크를 포함하여 최종 제출한다.___[(제출 가이드 참고)](https://github.com/woowacourse/woowacourse-docs/tree/main/precourse#%EC%A0%9C%EC%B6%9C-%EA%B0%80%EC%9D%B4%EB%93%9C)_
- 과제를 수행하면서 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.

### 과제 제출 전 체크 리스트
- 기능을 올바르게 구현했더라도 요구 사항에 명시된 **출력 형식**을 따르지 않으면 0점을 받게 된다.
- 기능 구현을 완료한 후 **실행 가이드에 따라 모든 테스트가 성공적으로 실행**되는지 확인한다.
- 테스트가 실패하면 점수가 0점이 되므로 제출하기 전에 반드시 확인한다.

### 테스트 실행 가이드
- 터미널에서 java -version을 실행하여 Java 버전이 21인지 확인한다. Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 21로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고, Windows 사용자의 경우 `gradlew.bat clean test` 또는 `.\gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
```
BUILD SUCCESSFUL in 0s
```