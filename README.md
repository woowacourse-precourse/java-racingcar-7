# Java Racing Car

## 요구 사항
- 각 자동차는 이름과 위치를 저장
- 자동차 이름은 최대 5자 이하로 제한
- 난수를 이용하여 자동차의 이동 조건을 설정 후 조건이 충족되면 자동차가 전진

## 클래스 구조

### Car
- 자동차의 이름과 위치를 저장
- **메서드**: `move(int randomValue)` - 난수에 따라 자동차 전진

### Race
- 각 라운드마다 각 자동차 이동 후 기록
- **메서드**:
  - `start(int rounds)` - 레이스 시작
  - `getWinners()` - 종료 후 최종 우승자를 결정

### GameController
- 사용자 입력 및 출력
- 이름과 이동 횟수 입력
- **메서드**:
  - `getCarNames()` - 이름 입력
  - `getRounds()` - 횟수 입력
  - `startRace()` - 레이스 시작
  - `displayRaceStatus()` - 현재 레이스 상태 출력
  - `displayWinners()` - 우승자 출력

### Validation
- 예외처리를 위한 클래스
- **예외처리 메서드**:
  - `validateCarName(String name)` - 자동차 이름 빈칸인지, 5자가 넘는지
  - `validateRounds(int rounds)` - 이동 횟수가 1회 이상인지
  - `validateCarNamesList(List<String> carNames)` - 자동차 이름이 하나 이상 입력이 됐는지
  - `checkForDuplicateNames(List<String> carNames)` - 중복된 자동차 이름이 있는지
  - `validateRoundsIsInteger(String input)` - 이동 횟수가 자연수인지

## 테스트
- 실행이 잘 되는지 테스트
- 예외처리 메서드가 잘 동작하는지 테스트
- 동시우승자 발생 테스트

## 주의사항
- 들여쓰기 깊이(depth)는 최대 2까지만
- 3항 연산자 사용 금지
- 메서드는 최대한 한 가지 역할만 수행
