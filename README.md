# java-racingcar-precourse

## 기능목록

---

### 1. 입력
- [X] 자동차 이름을 입력 받는다. - InputView#getCarName
- [X] 시도할 횟수를 입력 받는다. - InputView#getAttemptNumber
- [X] 자동차 이름의 유효성 검사 - InputValidator#isValidCarName
- [X] 시도 횟수의 유효성 검사 - InputValidator#isValidAttemptNumber

---

### 2. 자동차 게임 실행
#### 자동차
- [X] 0-9 사이의 무작위 숫자 생성 - Car#generateRandomNumber
- [X] 무작위 숫자가 4이상이라면, 1만큼 전진 - Car#forwardCar
- [X] 게임 1회 진행 - Car#startOneGame

#### 게임 실행
- [X] 자동차 이름들을 자동차 객체 리스트로 변환 - RaceGameController#convertCars
- [X] 자동차별로 게임 1회 진행 - RaceGameController#startOneGame

#### 게임 종료
- [X] 가장 많이 전진한 자동차의 전진 횟수 반환 - RaceGameController#getMaxMoveCount
- [X] 최종 우승자를 리스트로 추출 - RaceGameController#getWinner

---

### 3. 사용자 입력에 대한 유효성 검사
#### 자동차 이름
- [X] 자동차 이름 문자열을 쉼표(,)를 기준으로 분리 - InputValidator#splitCarName
- [X] 자동차 이름이 5자 이하인지 검사 - InputValidator#checkValidLength

#### 시도 횟수
- [X] 시도 횟수가 정수형 숫자인지 검사 - InputValidator#isIntegerNumber

#### 문자열
- [X] 입력 문자열이 공백이거나 빈 문자열인지 검사 - InputValidator#checkEmptyOrBlank

---

### 4. 출력
- [X] 실행 결과 출력 전, 설명 문구 출력 - OutputView#printDescription
- [X] 게임 1회를 실행한 결과 출력 - OutputView#printGameResult
- [X] 최종 우승자를 형식에 맞게 출력 (공동 우승일 경우 쉼표(,)로 구분) - OutputView#printWinner

---
