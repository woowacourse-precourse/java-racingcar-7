# java-racingcar-precourse
## 🚘 기능 목록
### 1️⃣ 게임 시작

- [x] 자동차 이름 입력 안내 문구를 보여준다.
  - [x] 안내 문구는 `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`이다.
- [ ] 자동차 이름을 입력 받는다.
  - [ ] 자동차 이름은 최소 하나 입력되어야 한다.
  - [ ] 자동차 이름은 최대 100개까지 입력할 수 있다.
  - [ ] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - [ ] 자동차 이름은 5자 이하만 가능하다.
  - [ ] 자동차 이름은 1자 이상이어야 한다.
  - [ ] 자동차 이름은 아스키 코드여야 한다.
  - [ ] 자동차 이름에 제어 문자가 포함되어서는 안 된다.
  - [ ] 자동차 이름이 빈 문자열이어서는 안 된다
  - [ ] 자동차 이름이 공백 문자로만 이루어져 있어서는 안 된다.
  - [ ] 자동차 이름은 중복되어서는 안 된다.
- [ ] 자동차 경주 시도 횟수 입력 안내 문구를 보여준다.
  - [ ] 안내 문구는 `시도할 횟수는 몇 회인가요?`이다.
- [ ] 시도 횟수를 입력 받는다.
  - [ ] 시도 횟수는 양의 정수여야 한다.
  - [ ] 입력 가능한 최대 시도 횟수는 100이다.

### 2️⃣ 게임 진행

- [ ] 각 자동차별로 0에서 9 사이의 무작위 값을 구한 후, 무작위 값이 4 이상일 경우 전진한다.
- [ ] 각 자동차의 실행 결과를 보여준다.
  - [ ] 결과는 자동차 이름 입력순으로 보여준다.
- [ ] 사용자로부터 입력된 시도 횟수 만큼 1, 2를 반복한다.

### 3️⃣ 게임 종료

- [ ] 최종 우승자를 보여준다.
  - [ ] 우승자는 한 명 이상일 수 있다.
  - [ ] 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.
