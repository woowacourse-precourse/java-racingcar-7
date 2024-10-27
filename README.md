# java-racingcar-precourse

# 자동차 경주

## 기능 목록

### Controller

- [x] 입력받은 횟수만큼 게임을 반복하여 진행
- [x] 게임의 전체적인 흐름 제어

### Car

- [x] 자동차의 이름과 전진횟수 관리
- 앞으로 한 칸 전진하는 기능

### CarFactory

- [x] 자동차의 이름들을 바탕으로 Car객체들을 만드는 기능

### RacingGameService

- [x] 랜덤 숫자를 생성하여 결과에 따라 차를 이동하는 기능
    - [x] 자동차가 무작위 값에 따라 이동하는지 확인 체크
- [x] 최종 우승자를 찾는 기능
    - [x] 최종 우승자 판별 기능 체크
- [x] 우승자의 전진횟수를 찾는 기능

### Message

- [x] 게임 내 안내 메시지 관리

### RandomGenerator

- [x] 최솟값부터 최댓값 사이에서 랜덤 숫자를 만드는 기능
    - [x] 랜덤 값이 0과 9 사이에 있는지 체크

### Validator

- [x] 차 이름들이 유효한지 판단하는 기능
    - [x] 자동차 이름이 5자 초과할 경우 예외 발생 체크
    - [x] 자동차 이름이 중복될 경우 예외 발생 체크
- [x] 시도횟수가 유효한지 판단하는 기능
    - [x] 유효하지 않은 라운드 수(음수)가 입력될 경우 예외 발생 체크

### InputView

- [x] 자동차 이름을 입력받는 기능
- [x] 시도횟수를 입력받는 기능

### OutputView

- [x] '실행결과'를 출력하는 기능
- [x] 현재 라운드 결과를 출력하는 기능
- [x] 최종 라운드 결과를 출력하는 기능