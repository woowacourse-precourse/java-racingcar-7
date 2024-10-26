# java-racingcar-precourse

## 기능 요구사항 정리

### 입력

- [ ] 자동차 문자열을 입력받는다.
- [ ] 이동 횟수를 입력 받는다.

### 출력

- [ ] 입력 안내 문구를 출력한다.
- [ ] 한 턴이 진행될 때마다 각 자동차별 이동거리를 출력한다.
- [ ] 모든 턴이 종료되면 결과를 출력한다.

### 자동차

- [x] 각 자동차는 이름을 갖고 있다.
- [x] 각 자동차의 이름은 5글자 이하여야 한다.
- [x] 각 자동차는 자신의 이름을 반환할 수 있어야 한다.
- [ ] 각 자동차가 움직이는 조건은 `0 ~ 9 사이` 무작위 숫자가 `4` 이상이 나왔을 경우이다.

### 게임 진행

- [ ] 입력 문자열을 쉼표(,) 기준으로 파싱하여 이름을 추출한다.
- [ ] 생성된 각 자동차를 입력 횟수만큼 이동시킨다.

### 예외

- [x] 자동차 이름이 5글자를 넘어가는 경우
- [ ] 이동 횟수가 양의 정수가 아닌 경우
- [ ] 이동 횟수가 정수 자료형 범위를 넘어가는 경우
- [ ] 자동차 이름이 중복되는 경우
- [x] 자동차 이름이 공백인 경우
