# 미션 - 자동차 경주

---
# 기능 파악

---
## 핵심 목표
- 사용자에게 자동차 경주 게임을 제공한다.
- 경주 결과와 최종 우승자를 알리는 기능 구현

## 주요 기능
- 자동차 등록: 여러 대의 자동차를 등록할 수 있어야 하며, 각각의 자동차는 고유한 이름을 가진다. 
- 경주 진행: 사용자가 지정한 횟수만큼 경주를 반복하며, 각 자동차는 무작위로 전진하거나 멈춘다. 
- 우승자 판별: 경주가 끝난 후 가장 멀리 간 자동차(들)를 최종 우승자로 표시한다.
- 결과 출력: 각 라운드 결과와 최종 우승자를 사용자에게 출력한다.

# 주요 개념 식별
- Car: 이름, 위치, 이동 로직
- GameBoard: 자동차 목록 관리, 라운드 별 자동차 이동
- RaceJudge: 자동차 위치 기준 최종 우승자 결정
- GameService: 게임 로직(게임 초기화, 진행, 종료)
- GameController: 입력 처리 출력 관리 (뷰, 서비스)
- InputView / OutputView: 사용자와 인터페이스

# 객체 간 메시지 흐름 (협력 정의)
- Controller <-> InputView
- Controller -> GameService
- GameService -> GameBoard <-> Car (create)
- GameService -> GameBoard <-> Car (move)
- GameBoard -> GameService (상태 전달)
- GameService -> Controller -> OutputView
- 반복, 종료
- GameBoard -> GameService <-> RaceJudge (우승자 결정)
- GameService -> Controller -> OutputView

# 계층 구조 설계
- config
  - ObjectFactory
- controller
  - GameController
- service
  - GameService
- domain
  - Car, GameBoard, RaceJudge
- view
  - InputView, OutputView
- util
  - RandomNumberGenerator

## 제약 사항 확인
- 자동차 이름(길이, 특수문자, 숫자, 중간공백, 중복, 빈문자열, null)
  - 특수문자, 중간공백, 숫자로 시작하는 경우를 예외로 처리함.
- 게임 횟수(정수, 음수, 실수, 빈문자열, 널)
- 0~9만 생성 확인 (10000 반복 확인)
- 자동차 위치와 출력 정상 검토
- 자동차 수, 라운드 수의 제한에 대해서
  - 자동차 100대, 라운드 500회 이하
- 우승자 각각 상황에 대해서 테스트
  - 쉼표 이용 구분 확인

---
# 목표

---
## 학습 목표
- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다. 
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다. 
- 1주 차 공통 피드백을 최대한 반영한다.

## 회고
아래 질문에 대한 중간 회고를 진행하고 소감에 구체적인 결과를 작성한다. 소감은 텍스트로 작성해야 하며 외부 링크는 허용하지 않는다.
- 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?
- 지원서에 작성한 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?
- 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?

---
# 프리코스 진행 방식

---
## :mag_right: 진행 방식
- 미션은 **과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- **기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.**

## 📮 미션 제출 방법
- [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr/)
- [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse)
- 과제를 수행하면서 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.

## 🚨 과제 제출 전 체크 리스트 - 0점 방지
- [] 기능을 올바르게 구현했더라도 **요구 사항에 명시된 출력 형식을 따르지 않으면 0점**을 받게 된다.
- [] 기능 구현을 완료한 후 아래 가이드에 따라 모든 테스트가 성공적으로 실행되는지 확인한다.
- [] **테스트가 실패하면 점수가 0점**이 되므로 제출하기 전에 반드시 확인한다.

## 테스트 실행 가이드
- [x] 터미널에서 `java -version`을 실행하여 Java 버전이 21인지 확인한다. Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 21로 실행되는지 확인한다.
- [x] 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고, Windows 사용자의 경우 `gradlew.bat clean test` 또는 `.\gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```zsh
BUILD SUCCESSFUL in 0s
```

## ✏️ 과제 진행 요구 사항

---
- [x] 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다. 
- [x] **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다. 
- [x] Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다. 
  - [x] **AngularJS Git Commit Message Conventions**을 참고해 커밋 메시지를 작성한다. 
- [x] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- [] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- [] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- [] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- [] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- [] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- [] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 입출력 요구 사항
입력
* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```zsh
pobi,woni,jun
```
* 시도할 횟수
```
5
```
출력
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
실행 결과 예시
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
## 🎯 프로그래밍 요구 사항 1

---
- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - [] 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

## 🎯 프로그래밍 요구 사항 2

---
- [] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - [] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - [x] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - [] 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    - [] [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
    - [] [AssertJ User Guide](https://assertj.github.io/doc)
    - [] [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
    - [] [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
    
## 라이브러리
- camp.nextstep.edu.`missionutils`에서 제공하는 `Randoms` 및 `Console` **API**를 사용하여 구현해야 한다.
  - **Random** 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 사용 예시
* 0에서 9까지의 정수 중 한 개의 정수 반환
```
Randoms.pickNumberInRange(0, 9);
```