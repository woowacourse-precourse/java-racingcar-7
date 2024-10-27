# 🚀 프리코스 2주차 미션 - 자동차 경주

---

우아한 테크코스 프리코스 2주차 미션 자동차 경주를 구현한 저장소입니다.

![woowacourse](https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff71cbdcd-b763-41af-9bbb-42abdb18bd6a%2F8725996b-9c63-4691-927f-2989a2f47ca8%2Fcover-22x.png&blockId=8705deab-d8f2-476b-9892-98b37b020779&width=2400)

## 💡 목차

---

- [시작하기](#-시작하기)
- [Commit convention](#-commit-convention)
- [Flow](#-flow)
    - [실행 결과 예시](#실행-결과-예시)
- [용어 정의](#-용어-정의)
    - [Model](#model)
    - [Strategy](#strategy)
    - [Service](#service)
    - [Controller](#controller)
    - [Util](#util)
    - [Validation](#validation)
    - [View](#view)
    - [Exception](#exception)
- [구현 리스트](#-구현-리스트)
    - [기능 구현 리스트](#기능-구현-리스트)
    - [입출력 구현 리스트](#입출력-구현-리스트)
    - [예외 처리 구현 리스트](#예외-처리-구현-리스트)

<br>

## 🚀 시작하기

---

레포지토리를 Clone한 뒤 IDE에서 어플리케이션을 실행합니다.

```
git clone https://github.com/woowacourse-precourse/java-calculator-7.git
```

브런치를 생성한 뒤 구현을 시작합니다.

```
git branch -b {branch name}
```

기능 구현 후 add, commit 명령을 사용해 로컬 저장소에 변경된 부분을 반영합니다.

```
git status // 변경된 파일 확인
git add -A(또는 .) // 변경된 전체 파일을 한번에 반영
git commit -m "message" // 작업한 내용을 메시지에 기록
```

모든 기능 구현을 마친 후, 원격 저장소에 commit을 반영하기 위해 branch를 push합니다.

```
git push origin {branch name}
```

<br>

## 📡 Commit Convention

```
<type> : <subject> 

<body> 

<footer>
```

```
git commit -m "<type> : <subject>" -m "" -m "<body>" -m "" -m "<footer>"
```

- ### Type
    - feat(feature) : 새로운 기능 추가
    - fix(bug fix) : 버그 수정
    - docs(documentation) : 문서 수정
    - style(formatting) : 코드 스타일 변경
    - refactor : 코드 리팩토링(기능 변경 X)
    - test(when adding missing tests) : 테스트 코드 추가, 수정
    - chore(maintain) : 빌드 관련 작업, 설정 수정
- ### Subject : 한 줄 요약
    - 명령형
    - 현재 시제 사용
    - 첫 글자 대문자 금지
    - 문장 끝에 마침표(.) 금지
- ### Message Body(선택 사항) : 변경 사항에 대한 상세 설명
    - 현재 시제 사용
    - 변경 이유 포함
    - 이전 동작과 대조
- ### Message footer(선택 사항)
    - Breaking changes
        - 변경 사항, 주의해야할 부분, 관련 이슈에 대한 설명과 함께 모든 변경 사항을 하단에 언급
    - Referencing issues
        - 이슈가 닫힌 경우(버그 해결) 사용
        - `Closed #keyword`
        - keyword : issue number

### Commit Message Example

```
feat: 사용자 로그인 기능 추가

사용자가 이메일과 비밀번호로 로그인할 수 있는 기능을 추가했습니다.
JWT 토큰을 사용하여 인증 절차를 구현하였으며, 로그인 실패 시의 오류 처리를 강화했습니다.

BREAKING CHANGE: 기존의 인증 방식이 JWT로 변경되었습니다.
Related to: #123
```

More : [Commit Message convention](https://gist.github.com/9941e89d80e2bc58a153.git)

<br>

## ⏳ Flow

---

- (1) 사용자로부터 자동차 이름을 입력받는다.
- (2) 입력받은 문자열을 쉼표(,)를 기준으로 구분한다.
- (3) 이름의 양쪽 공백을 제거한다.
- (4) 자동차 객체에 이름을 저장한다.
- (5) 자동차 객체의 모드(전략)를 선택한다.
    - 자동차 모드를 입력받지 않으므로 main에서 RacingCar로 설정한다.
- (6) 사용자로부터 시도할 횟수를 입력받는다.
- (7) 시도할 횟수만큼 자동차를 움직인다(또는 움직이지 않는다).
- (8) 횟수 한 번마다 각 자동차의 움직인 결과를 출력한다.
- (9) 시도할 횟수만큼 움직인 후 가장 많이 움직인 자동차(또는 자동차들)를 계산해 출력한다.

![FlowDiagram](https://github.com/user-attachments/assets/ca8cf2a7-a570-4d52-befe-b6a255a1f518)

### 실행 결과 예시

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

<br>

## 🏷️ 용어 정의

---

- 자동차 `Car` : 자동차 객체(전략), 움직이는 대상이다.
- 자동차 경주 `Racing` : 각 자동차가 이동 시도 횟수만큼 동작하는 모든 과정을 의미한다.
- 자동차 경주 라운드 `RacingRound` : 각 자동차가 이동 시도하는 과정 하나를 의미한다.
- 자동차 이동 `TryMoving` : 자동차가 한 라운드에 이동하는 것을 의미한다.
- 자동차 이름 분리 `SplitCarName` : 문자열에서 쉼표(,)를 기준으로 자동차 이름을 분리하는 것을 의미한다.
- 자동차 이동 판단 `IsNotRandomNumberLessThanCriterion` : 라운드에서 자동차가 움직일 지, 움직이지 않을 지 판단하는 것을 의미한다.
- 자동차 이동 `Go` : 자동차가 이동해도 된다고 판단되었을 때, 한 칸 전진하는 것을 의미한다.
- 자동차 모드 `Mode` : 자동차의 모드(전략)를 의미한다.

![MethodDiagram](https://github.com/user-attachments/assets/50a16521-85a6-4aa1-ab3f-8eacd7808776)

### Model

- `Car` : 전략을 가지는 객체, 자동차 모드 설정, 자동차 이동

### Strategy

- `Mode` : 전략을 정의한 인터페이스
- `ModeType` : 전략 목록, 사용자의 전략 선택에 따른 전략 생성
- `PracticeCar` : 사용자가 전략을 선택하지 않을 경우 설정되는 기본 전략, 무작위 값이 8이상일 때 전진
- `RacingCar` : 전략, 무작위 값이 4이상일 때 전진
- `SportCar` : 전략, 무작위 값이 6이상일 때 전진

### Service

- `Racing` : 자동차 경주 로직 수행(자동차 생성, 모드 설정, 이동, 결과 계산)

### Controller

- `RacingController` : 자동차 경주 수행, 자동차 모드 설정, 자동차 경주 결과 반환

### Util

- `CarNameSeparator` : 자동차 이름을 분리해 양 옆 공백을 제거한 문자열 배열 생성
- `CarsCreator` : 문자열 배열을 자동차 객체 배열로 변환
- `RacingResultCalculator` : 자동차 경주 우승자 기록 계산, 자동차 경주 우승자 배열 생성

### Validation

- `CarNameValidation` : 자동차 이름 길이 검증
- `CarValidation` : 자동차 이름 구분자 검증, 자동차 이름 중복 검증, 존재하지 않는 자동차 이름 검증
- `RacingRoundValidation` : 자동차 이동 시도 횟수가 1이상인지, 숫자인지 검증

### View

- `InputView` : 사용자 입력 정의
- `OutputView` : 출력 정의
- `PrintMessage` : 출력 메시지 정의

### Exception

- `IllegalArgumentException` 클래스 상속받아 예외 메시지 정의
    - `CarNameDuplicationException` : 자동차 이름이 중복되었을 경우 예외
    - `CarNameEmptyException` : 자동차 이름이 존재하지 않을 경우 예외
    - `CarNameLengthException` : 자동차 이름이 5자 초과일 경우 예외
    - `CarNameSeparatorException` : 자동차 이름 구분자가 쉼표가 아닐 경우 예외
    - `RoundNumberRangeException` : 입력이 1 미만일 경우의 예외
    - `RoundTypeException` : 입력이 숫자가 아닐 경우의 예외
- `CarException` : 자동차 이름 길이 예외 처리
- `RacingException` : 자동차 이름 분리자, 존재하지 않는 이름, 이름 중복 예외 처리
- `TotalRacingRoundException` : 자동차 이동 시도 횟수가 1이상 양수가 아닐 경우 예외 처리
- `ExceptionMessage` : 예외 메시지 정의

<br>

## 📃 구현 리스트

---

### 기능 구현 리스트

- 자동차 이름
    - [x] 자동차 이름을 쉼표(,)를 기준으로 분리한다.
    - [x] 자동차 이름의 양 옆 공백을 제거한다.(`trim()`)
    - [x] 자동차 이름이 5자 이하인지 검증한다.

- 자동차 이동 시도 횟수
    - [x] 자동차 이동 시도 횟수가 1이상 양수인지 검증한다.
    - [x] 자동차 이동 시도 횟수만큼 라운드를 반복한다.

- 경주
    - [x] 무작위 값을 생성한다.
    - [x] 무작위 값이 4 이상일 경우 자동차를 전진 시킨다.
    - [x] 라운드마다 자동차 이동을 시도한다.

- 경기 종료
    - [x] 가장 많이 움직인 자동차(또는 자동차들)를 판단한다.
    - [x] 경주가 끝난 후 우승자(또는 우승자들)를 출력한다.

### 입출력 구현 리스트

- 입력
    - [x] 사용자로부터 자동차 이름 문자열을 입력받는다.
    - [x] 사용자로부터 자동차 이동 시도 횟수를 입력받는다.

- 츨력
    - [x] 자동차 이름 문자열 입력 문구를 출력한다. `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - [x] 자동차 이동 시도 횟수 문구를 출력한다. `시도할 횟수는 몇 회인가요?`
    - [x] 자동차 실행 결과 문구를 출력한다. `실행 결과`
    - [x] 라운드마다 자동차 이름과 이동 횟수 `'-'`를 출력한다. `pobi : -`
    - [x] 최종 우승자 문구를 출력한다. `최종 우승자 :`
    - [x] 최종 우승자 자동차 이름(또는 이름들)을 출력한다. `pobi, jun`

### 예외 처리 구현 리스트

- [x] 구분자가 쉼표가 아닐 경우 예외 처리 `[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 합니다. 자동차 경주는 두 대 이상 가능합니다.`
- [x] 자동차 이름이 5자 이하가 아닐 경우 예외 처리 `[ERROR] 자동차 이름은 5자 이하만 가능합니다.`
- [x] 자동차 이름이 `""` 또는 `null`일 경우 예외 처리 `[ERROR] 자동차 이름이 존재하지 않습니다. 자동차 경주는 두 대 이상 가능합니다.`
- [x] 자동차 이름이 중복될 경우 예외 처리 `[ERROR] 자동차 이름은 중복되지 않아야 합니다.`
- [x] 자동차 이동 시도 횟수가 숫자가 아닐 경우, 숫자 범위를 벗어날 경우 예외
  처리 `[ERROR] 자동차 이동 시도 횟수는 숫자로만 이루어져야 하며, Integer 범위 내(1~2,147,483,647)의 수여야 합니다.`
- [x] 자동차 이동 시도 횟수가 1이상 양수가 아닐 경우 예외 처리 `[ERROR] 자동차 이동 시도 횟수는 1이상 양수여야 합니다.`