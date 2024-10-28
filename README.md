## Controller
### RaceController
👉 자동차 경주 게임의 흐름을 관리한다.

**게임 시작**
- [x] 사용자로부터 자동차 이름을 입력받는다.
- [x] 사용자로부터 횟수를 입력받는다.
- [x] 자동차를 등록한다.

**게임 진행**
- [x] 실행 결과 안내 메시지를 출력한다.
- [x] 사용자가 입력한 횟수동안 게임을 실행한다.
- [x] 매 라운드마다 자동차의 전진 여부를 결정한다.
- [x] 매 라운드마다 자동차의 위치를 출력한다.

**결과 처리**
- [x] 우승 자동차를 찾는다.
- [x] 우승 자동차를 출력한다.

---
## Model
### RaceTrack
👉 자동차 경주 게임에 참가하는 자동차들을 관리한다.
- [x] 자동차를 생성한다.
- [x] 자동차의 전진을 요청한다.
- [x] 가장 전진을 많이 한 자동차를 우승자로 계산한다.

### Car
👉 자동차의 상태와 동작을 관리한다.
- [ ] 0부터 9사이의 랜덤 정수값을 추출한다.
- [ ] 전진 조건을 만족하는지 확인한다.
- [ ] 전진 조건을 만족하면, 전진한다.

### RacePolicy
👉 자동차 경주 게임의 정책을 관리한다.
- [ ] 랜덤 정수값이 4 이상인지 확인한다.

---
## View
### InputView
👉 사용자로부터 입력을 받는다.
- [x] 사용자로부터 자동차 이름을 입력받는다.
  - [ ] 입력값이 null 이거나 빈 문자열일 때 
- [x] 사용자로부터 횟수를 입력받는다.
  - [ ] 입력값이 null 이거나 빈 문자열일 때
  - [ ] 0이하의 정수일 때
  - [ ] 숫자(0~9)가 아닌 문자가 포함되어있을 때
  - [ ] Integer 의 범위를 초과했을 때

### OutputView
👉 게임 진행 상황과 결과를 사용자에게 보여준다.
- [x] 이름 입력 안내 메세지를 출력한다. `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- [x] 게임 횟수 입력 안내 메세지를 출력한다. `시도할 횟수는 몇 회인가요”`
- [x] 실행 전 메세지를 출력한다. `실행 결과`
- [x] 자동차의 현재 위치를 출력한다.
- [x] 우승자 자동차 이름을 출력한다.
