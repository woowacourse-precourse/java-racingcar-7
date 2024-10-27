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
#### 게임 1회 실행
- [ ] 0-9 사이의 무작위 숫자 생성
- [ ] 무작위 숫자가 4이상이라면, 1 전진
- [ ] 게임 1회를 진행한 후, 자동차의 실시간 상태 출력

#### 게임 종료
- [ ] 종료 조건 검사
- [ ] 가장 많이 전진한 자동차를 리스트로 추출
- [ ] 최종 우승 자동차들을 형식에 맞게 출력 (공동 우승일 경우 쉼표로 구분)

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
- [ ] 최종 우승자를 형식에 맞게 출력

---

