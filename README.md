# 🎯 자동차 경주 [ 기능 구현 목록 ]

----

### ✅ 입력 기능
- [x] 자동차 이름들을 입력받는다.
    - [x] **[예외]** 공백인 경우 예외처리를 한다.
    - [x] **[예외]**,가 아닌 다른 특수문자가 들어온 경우 예외처리를 한다. `ex) pobi|woni*jun`
    - [x] **[예외]** 마지막 문자열에 ,가 들어온 경우 예외처리를 한다. `ex) pobi,woni,jun,`
- [x] 레이싱 시도 횟수를 입력받는다.
    - [x] **[예외]** 공백인 경우 예외처리를 한다.
    - [x] **[예외]** 정수가 아닌 경우 예외처리를 한다. `ex) A`
    - [x] **[예외]** `0` 으로 시작하는 숫자일 경우 예외처리를 한다. `ex) 02`

### ✅ 출력 기능
- [x] 한번의 레이싱 결과를 출력한다.
    - [x] 레이싱 결과는 `{이름} : {이동거리}` 와 같이 출력한다. (이동 거리는 `-` 로 나타낸다.)
- [x] 우승 차량 이름을 출력한다.

### ✅ 자동차 기능
- [x] 자동차를 생성한다.
    - [x] **[예외]** 자동차 이름 길이가 `1이상 5이하`가 아닐 경우 예외처리를 한다.
    - [ ] **[예외]** 자동차 이름이 중복될 경우 예외처리를 한다.
    - [ ] **[예외]** 자동차가 1개 미만일 경우 예외처리를 한다.
- [x] 자동차가 이동한다.
    - [ ] 무작위 값이 `4` 이상일 경우 이동한다.
    - [x] 자동차가 이동 가능한지 판별한다.

### ✅ 레이싱 기능
- [x] 레이싱 시도 횟수를 가진다.
    - [ ] **[예외]** 시도 횟수 초기값이 `0` 일경우 예외처리를 한다.
- [x] 레이싱을 실행한다.
    - [x] 레이싱이 실행되면 시도 횟수가 `1` 줄어든다.
- [x] 현재 자동차 위치를 조회한다.
- [ ] 레이싱이 진행 가능한 상태인지 판별한다.
- [ ] 우승자 이름을 조회한다.