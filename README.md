# java-racingcar-precourse

# 🏎️ 자동차 경주

***

## 📌 프로그래밍 요구사항 1

***

- **JDK 21 버전에서 실행 가능해야 한다.**
- **프로그램 실행의 시작점은 Application의 main() 이다.**
- **build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- **프로그램 종료 시 System.exit()를 호출하지 않는다.**
- **프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.**
- **자바 코드 컨벤션을 지키면서 프로그래밍한다.**
    - **기본적으로 Java Style Guide를 원칙으로 한다.**

## 📌 프로그래밍 요구사항 2

***

* **indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다**
    - **예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.**
    - **힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.**
* **3항 연산자를 쓰지 않는다.**
* **함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.**
* **JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.**
    - **테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.**
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리

- **camp.nextstep.edu.missionutils** 에서 제공하는 **Randoms** 및 **Console** API를 사용하여 구현해야 한다
    - **Random** 값 추출은 **camp.nextstep.edu.missionutils.Randoms**의 **pickNumberInRange**()를 활용한다.
    - 사용자가 입력하는 값은 **camp.nextstep.edu.missionutils.Console**의 **readLine**()을 활용한다.

#### 사용예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```angular2html
Randoms.pickNumberInRange(0, 9);
```

***

## 🙋🏻‍♂️ 기능 요구 사항

***
초간단 자동차 경주 게임을 구현한다. <br>

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

***

#### 입력

* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

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

## 구현할 기능 목록

***

## 구현 ✅&nbsp;&nbsp;&nbsp;&nbsp; 미구현 ❎ &nbsp;&nbsp;&nbsp;&nbsp; 추가 구현 기능 ☑️

### 📦 model package

#### _**Racingcar Class**_

* ✅ getCarName() 자동차 이름 반환

#### _**RacingcarService Class**_

* ✅ movingForward() 자동차 전진
* ☑️ getInstance() 인스턴스 반환
* ☑️ startRace() 레이스 시작
* ☑️ printRoundResult() 라운드별 결과 출력
* ☑️ getMaxDashLength() 최대 대쉬 길이 반환
* ☑️ pickWinner() 우승자 반환

***

### 📦 view package

##### _**InputView Class**_

* ✅ getInstance() Input 인스턴스 반환
* ✅ getCarName() 사용자로부터 자동차 이름 입력
* ✅ getAttemptCount() 사용자로부터 시도 횟수 입력

##### _**OutputView Class**_

* ✅ getInstance() Output 인스턴스 반환
* ✅ getCarName() 자동차 이름 입력문 출력
* ✅ getAttemptCount() 시도 횟수 입력문 출력
* ✅ runResult() "실행 결과" 출력
* ✅ roundResult() 라운드별 결과 출력
* ✅ winner() 최종 우승자 출력

##### _**OutputMessage Enum**_

* ✅ getMessage() 메세지 반환
* ☑️ getFormattedMessage() 포멧 메세지 반환

***

### 📦 controller package

#### _**RacingcarController Class**_

* ✅ void run() 자동차 경주 시작

***

### 📦 exception package

#### _**InvalidInputException Class**_

* ✅ validateInput() 초기 공백 입력에 대한 예외 처리
* ✅ validateCarNames() 자동차 이름 입력에 대한 예외 처리 상위 메서드
* ✅ validateAttemptCount() 시도할 횟수 입력에 대한 예외 처리
* ☑️ validateCarNameSize() 단일 자동차 이름 입력에 대한 예외 처리
* ☑️ validateCarNameBlankInput() 자동차 이름 공백 입력에 대한 예외 처리
* ☑️ validateDuplicateName() 자동차 이름 중복 입력에 대한 예외 처리
* ☑️ validateMaxCarNameLength() 자동차 이름 최대 글자 초과에 대한 예외 처리

##### _**ExceptionMessage Enum**_

* ✅ getMessage() 메세지 반환

***

### 📦 constant package

#### _**Message Interface**_

* ✅ getMessage() 메세지 반환

***

### 📦 util package

#### _**Parsing Class**_

* ✅ splitCarName() 입력된 자동차 이름 분리
* ✅ convertStringArrToMap() 분리된 자동차 이름을 Map으로 변환
* ✅ joinWinners() 우승자가 여러 명일 경우 구분자로 구분

***

### TestCase

#### _**InvalidInputExceptionTest Class**_

* ☑️ testValidateCarNames_ValidateCarNames_ShouldNoteThrowException() 자동차 이름 정상 입력시 정상작동
* ☑️ testValidateInput_BlankInput_ShouldThrowException() 공백 입력시 예외 발생
* ☑️ testValidateInput_NullInput_ShouldThrowException() null 입력시 예외 발생
* ☑️ testValidateCarNames_SingleCarName_ShouldThrowException() 자동차 이름이 하나만 입력 됐을 때 예외 발생
* ☑️ testValidateCarNameBlankInput_BlankInput_ShouldThrowException() 자동차 이름에 공백이 입력 됐을 때 예외 발생
* ☑️ testValidateCarNameBlankInput_NullIInput_ShouldThrowException() 자동차 이름에 null이 포함 됐을 때 예외 발생
* ☑️ testValidateDuplicateName_DuplicateInput_ShouldThrowException() 자동차 이름에 중복이 있을 때 예외 발생
* ☑️ testValidateCarNames_ExceedMaxCarNameLength_ShouldThrowException 자동차 이름이 최대 글자를 초과 했을 때 예외 발생
* ☑️ testValidateAttemptCount_ZeroAttempt_ShouldThrowException() 시도 횟수로 0회 입력했을 때 예외 발생
* ☑️ testValidateAttemptCount_NegativeAttempt_ShouldThrowException() 시도 횟수로 음수 입력했을 때 예외 발생
* ☑️ testValidateAttemptCount_ValidAttempt_ShouldNotThrowException() 시도 횟수 정상 입력시 정상 작동

#### _**RacingcarServiceTest Class**_

* ☑️ testPrintRoundResult() 라운드 별 결과 출력
* ☑️ testGetMaxDashLength() 최대 전진 크기 반환
* ☑️ testPickSingleWinner() 단일 우승자 출력
* ☑️ testPickMultiWinner() 복수 우승자 출력

***
