# 프리코스 2주차 과제

## ✏️ 구현 기능 목록

### ✔️ 정상 입력 처리

#### 입력

- 자동차 이름을 입력받는다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 이름 양끝에 공백이 포함된 경우, 공백을 제거한다.
- 자동차 이름에 대해 유효성 검증을 수행한다.
    - 자동차 이름은 5글자 이하여야 한다.
    - 자동차 이름은 중복될 수 없다.
    - 자동차 이름은 비어있을 수 없다.
    - 자동차 이름에 공백이 포함될 수 없다.
    - 자동차는 2대 이상이어야 한다.
- 시도할 횟수를 입력받는다.
- 시도할 횟수를 문자열에서 숫자로 변환한다.
- 시도할 횟수에 대해 유효성 검증을 수행한다.
    - 시도할 횟수는 1 이상이어야 한다.
    - 시도할 횟수는 숫자여야 한다.

#### 출력

- 각 차수마다 자동차 이름과 이동 거리를 출력한다.
- 우승자가 한 명일 경우, 단독 우승자를 출력한다.
- 우승자가 여러 명일 경우, 쉼표(,)로 구분하여 공동 우승자를 출력한다.

#### 기능

- 입력받은 자동차 이름을 기반으로 자동차 객체를 생성한다.
- 0에서 9 사이의 무작위 값을 생성한다.
- 무작위 숫자가 4 이상일 경우 true, 그렇지 않을 경우 false를 반환한다.
- 각 시도마다 전진 조건을 만족하는 자동차는 1칸 전진한다.
- 경주가 끝난 후, 가장 많이 이동한 자동차를 찾아 우승자를 판별한다.

### ⚠️ 예외

IllegalArgumentException을 발생시킨다.

- 자동차 이름이 5글자를 초과하는 경우
- 자동차 이름이 중복되는 경우
- 자동차 이름이 비어있을 경우
- 자동차가 1대 이하일 경우
- 시도할 횟수가 1 미만인 경우
- 시도할 횟수가 숫자가 아닌 경우

<br>

## 📌 최종 기능 명세

| Class           | Method                    | Input                  | Output          | Description                     |
|-----------------|---------------------------|------------------------|-----------------|---------------------------------|
| Car	            | getCarName                | 		                     | String          | 	자동차 이름을 반환                     |
|                 | getCurrentDistance        | 	                      | int             | 	현재 이동 거리를 반환                   |
|                 | moveConditionally	        |                        |                 | 조건에 따라 자동차를 이동                  |
| Cars	           | getCarsReadOnly	          | 	                      | List\<Car>	     | 읽기 전용 자동차 리스트 반환                |
|                 | raceOnce	                 | 	                      | 	               | 모든 자동차를 한 번씩 이동                 |
|                 | determineWinners	         | 	                      | List\<String>	  | 최대 거리 이동한 자동차들의 이름 리스트 반환       |
| Parser	         | parseCarNames             | 	String                | 	List\<String>	 | 자동차 이름을 파싱하고 리스트로 반환            |
|                 | convertStringToBigInteger | 	String	               | BigInteger	     | 문자열 입력을 BigInteger로 변환          |
|                 | joinWithJoiner            | 	List\<String>, String | 	String         | 	리스트를 지정된 구분자로 합쳐서 반환           |
| Validator       | validateCarNames	         | List\<String>          | 	               | 	자동차 이름 유효성 검증                  |
|                 | validateAttemptCount	     | BigInteger             | 		              | 시도할 횟수 유효성 검증                   |
| InputView       | 	getCarNamesInput         |                        | String	         | 자동차 이름을 입력 받음                   |
|                 | getAttemptCountInput	     | 	                      | String	         | 시도할 횟수을 입력 받음                   |
| OutputView      | 	printStartMessage        | 		                     | 	               | 경주 시작 메시지를 출력                   |
|                 | printRaceProgress         | 	Cars                  | 	               | 	각 자동차의 경주 진행 상황을 출력            |
|                 | printWinners              | 	String                | 		              | 최종 우승자를 출력                      |
| RaceController  | 	runRace	                 | Cars, BigInteger       | 	               | 	경주를 실행하고 각 라운드 진행 상황과 우승자를 출력  |
| InputController | 	getValidatedCarNames	    | 	                      | Cars	           | 자동차 이름 입력을 검증 및 파싱 후 Cars 객체 반환 |
|                 | getValidatedAttemptCount  | 	                      | 	BigInteger	    | 시도할 횟수를 검증하고 파싱하여 반환            |
| Constant        | 	                         |                        | 상수              | 	프로그램 전반에서 사용하는 상수들을 정의         |

<br>

## 💻 커밋 컨벤션

> [**AngularJS 커밋 컨벤션**](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고

| Type     | Description      |
|----------|------------------|
| feat     | 새로운 기능 추가        |
| fix      | 버그 수정            |
| docs     | 문서 변경            |
| style    | 코드 포맷 변경         |
| refactor | 코드 리팩토링          |
| test     | 테스트 추가 및 수정      |
| chore    | 빌드 작업 및 도구 관련 변경 |

<br>

## ✅ 체크 리스트

### 과제 진행 요구 사항

- [x] 자동차 경주 저장소를 포크하고 클론한다.
- [x] 기능을 구현하기 전에 README.md에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋은 README.md에 정리된 기능 목록 단위로 나눈다. (AngularJS Git Commit Message Conventions 참고)

### 기능 요구 사항

- [x] 주어진 횟수 동안 n대의 자동차는 전진하거나 멈출 수 있다.
- [x] 각 자동차에 이름을 부여할 수 있다.
- [x] 전진하는 자동차를 출력할 때, 해당 자동차의 이름도 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며, 이름은 최대 5자까지만 가능하다.
- [x] 사용자는 자동차가 몇 번 이동할지 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이의 무작위 값을 구한 후, 해당 값이 4 이상일 경우이다.
- [x] 경주가 끝난 후 우승자를 출력한다. 우승자는 한 명 이상일 수 있다.
- [x] 우승자가 여러 명일 경우, 쉼표(,)로 구분하여 출력한다.
- [x] 잘못된 입력 값이 주어질 경우, IllegalArgumentException을 발생시키고 애플리케이션을 종료한다.

### 입출력 요구 사항

#### 입력

- [x] 경주할 자동차 이름(이름은 쉼표(,)로 구분)
- [x] 시도할 횟수

#### 출력

- [x] 각 차수별 경주 결과
- [x] 단독 우승자 안내 문구
- [x] 공동 우승자 안내 문구

### 프로그래밍 요구 사항

- [x] JDK 21에서 실행 가능해야 한다.
- [x] 프로그램의 시작점은 Application의 main()이다.
- [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리만 사용해야 한다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 별도의 지시가 없는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 준수하여 프로그래밍한다. 기본적으로 Google Java Style Guide를 따른다.
- [x] Indent(인덴트, 들여쓰기) depth는 최대 2까지만 허용한다. (메서드를 분리하는 것을 추천)
- [x] 3항 연산자를 사용하지 않는다.
- [x] 메서드는 한 가지 일만 하도록 최대한 작게 만든다.
- [x] JUnit 5와 AssertJ를 사용하여 테스트 코드를 작성한다.
- [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용한다.
    - [x] 사용자의 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 사용한다.