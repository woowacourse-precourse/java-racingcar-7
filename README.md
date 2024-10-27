# java-racingcar-precourse


# 자동차 경주 미션

Java로 구현하는 자동차 경주 게임 프로젝트입니다. 이 프로젝트는 다양한 기능을 메서드 단위로 나누어 설계하며, 함수 분리와 테스트를 통해 코드 품질을 개선하는 것을 목표로 합니다.

## 프로젝트 목표
- 여러 역할을 수행하는 함수를 단일 역할을 수행하는 작은 함수로 분리하여 구현합니다.
- 테스트 코드 작성을 통해 프로그램의 정확성을 확인하고, 커밋 메시지와 README 파일을 통해 프로젝트를 문서화합니다.

## 메서드 단위 기능 목록

### 1. 사용자 입력 처리 메서드
- `getCarNames()`
    - [x] 콘솔에서 경주할 자동차 이름을 쉼표로 구분하여 입력받는다.
    - [x] 입력된 이름이 5자를 초과할 경우 예외를 발생시킨다.
    - [x] 유효하지 않은 입력이 있을 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

- `getRaceAttemptCount()`
    - [x] 콘솔에서 시도할 횟수를 입력받는다.
    - [ ] 유효하지 않은 숫자 입력 시 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

### 2. 자동차 경주 준비 메서드
- `initializeCars(List<String> carNames)`
    - [x] 입력받은 자동차 이름 리스트를 통해 각 자동차 객체를 초기화한다.
    - [x] 각 자동차는 초기 위치를 0으로 설정한다.

### 3. 자동차 전진 조건 설정 메서드
- `generateRandomNumber()`
    - [x] 0~9 사이의 랜덤 숫자를 생성한다.

- `canMove(int randomNumber)`
    - [x] 랜덤 숫자가 4 이상일 경우 `true`를 반환하여 자동차가 전진할 수 있음을 나타낸다.
    - [x] 랜덤 숫자가 3 이하일 경우 `false`를 반환하여 자동차가 멈춘다.

### 4. 자동차 이동 메서드
- `moveCar(Car car, int randomNumber)`
    - [x] `canMove()`의 결과가 `true`일 경우, 자동차의 위치를 한 칸 전진시킨다.

### 5. 경주 진행 및 결과 출력 메서드
- `playRound(List<Car> cars)`
    - [x] 모든 자동차에 대해 이동 여부를 판단하고, 각 자동차의 현재 위치를 저장한다.
    - [x] 각 라운드의 결과를 출력 형식에 맞춰 출력한다.

- `getWinners(List<Car> cars)`
    - [x] 모든 자동차의 위치를 비교하여 가장 많이 전진한 자동차를 우승자로 선정한다.
    - [x] 여러 우승자가 있을 경우, 우승자 목록을 쉼표로 구분하여 출력한다.

- `printWinners(List<Car> winners)`
    - [x] 우승자 목록을 출력 형식에 맞춰 출력한다.
    - 예: `최종 우승자 : pobi, jun`

### 6. 예외 처리 메서드
- `validateCarName(String carName)`
    - [x] 자동차 이름이 5자 이하인지 확인하고, 초과할 경우 `IllegalArgumentException`을 발생시킨다.

- `validateAttemptCount(String attemptCount)`
  -