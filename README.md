# java-racingcar-precourse

## 클래스 설명

### Controller

**RacingController**
- `run()`: 프로그램 실행
- `create()`: Controller와 필요한 객체들을 초기화하여 생성

### Model

**Car**
- `moveForward()`: 자동차의 위치를 한 칸 전진
- `getName()`: 자동차 이름 반환
- `getPosition()`: 자동차 현재 위치 반환

### Service

**CarService**
- `playRounds(String playersName, int moveCount)`: 플레이어 이름과 이동 횟수를 입력받아 자동차 경주를 진행하고 승자 반환

### View

**InputView**
- `getPlayer()`: 콘솔에서 플레이어 이름을 입력받아 반환
- `getMoveCount()`: 콘솔에서 이동 횟수를 입력받아 반환, 유효하지 않은 값 입력 시 예외 발생

**OutputView**
- `printInputCarName()`: 자동차 이름 입력 메시지 출력
- `printInputMoveCount()`: 이동 횟수 입력 메시지 출력
- `printResult()`: 결과 메시지 출력
- `printWinners(List<Car> winners)`: 승자 이름 출력

### Util

**Constants**
- `INPUT_CAR_NAME`: 자동차 이름 입력 메시지
- `INPUT_MOVE_COUNT`: 이동 횟수 입력 메시지
- `OUTPUT_RESULT`: 결과 메시지
- `OUTPUT_WINNER`: 최종 우승자 메시지
- `MAX_NAME_LENGTH`: 최대 이름 길이 제한 (5자)

**ErrorMessages**
- `ERROR_EMPTY_NAME`: 빈 이름 오류 메시지
- `ERROR_LENGTH_LIMIT_NAME`: 이름 길이 초과 오류 메시지
- `ERROR_INVALID_MOVE_COUNT`: 유효하지 않은 이동 횟수 입력 오류 메시지
- `ERROR_NEGATIVE_MOVE_COUNT`: 음수 이동 횟수 오류 메시지

**CarFactory**
- `carGenerator(List<String> names)`: 입력된 이름 리스트로 `Car` 객체 생성 리스트 반환

**PlayerNameParser**
- `splitByComma(String input)`: 쉼표 기준으로 문자열을 분리하여 리스트 반환

**RaceExecutor**
- `raceStart(List<Car> cars, int moveCount)`: 레이스 시작, 이동 횟수만큼 자동차 이동 및 상태 출력
- `race(List<Car> cars)`: 자동차 리스트 이동 실행
- `printCarsPositionStatus(List<Car> cars)`: 자동차 위치 상태 출력
- `tryMoveForward(Car car)`: 특정 조건 충족 시 자동차 이동
- `canMove()`: 자동차가 이동 가능한지 여부 결정

**WinnerSelector**
- `getWinners(List<Car> cars)`: 최고 위치에 있는 자동차를 찾아 승자 리스트 반환

**MoveCountValidator**
- `validateMoveCount(int moveCount)`: 이동 횟수 유효성 검사, 음수일 경우 예외 발생

**PlayerNameValidator**
- `validateName(List<String> names)`: 이름 유효성 검사, 빈 값 또는 길이 초과 시 예외 발생

## 테스트 코드

**ApplicationTest**
- `기능_테스트()`: 랜덤 숫자에 따른 자동차 이동 및 최종 우승자를 검증
- `예외_테스트()`: 유효하지 않은 입력값에 대해 `IllegalArgumentException` 발생 검증
- `이름에_대한_예외_처리()`: 유효하지 않은 이름 입력 시 예외 발생 검증
- `이름에_대한_예외_처리_다섯자_이상()`: 이름이 5자 이상인 경우 예외 발생 검증
- `이름에_대한_예외_처리_쉼표_없음()`: 쉼표로 구분되지 않은 이름 입력 시 예외 발생 검증
- `이름에_대한_예외_처리_쉼표_여러개()`: 여러 개의 쉼표가 포함된 경우 예외 발생 검증
- `시도_횟수에_대한_예외_처리_빈_값()`: 빈 값 입력 시 예외 발생 검증
- `시도_횟수에_대한_예외_처리_문자열_입력()`: 숫자가 아닌 문자열 입력 시 예외 발생 검증
- `시도_횟수에_대한_예외_처리_문자열과_숫자()`: 문자열과 숫자가 혼합된 경우 예외 발생 검증
- `시도_횟수에_대한_예외_처리_음수()`: 음수 입력 시 예외 발생 검증
- `runMain()`: `Application.main()` 실행

**CarTest**
- `carNameSuccessTest(String name)`: 유효한 이름을 가진 자동차 객체 생성 성공 테스트
- `carNameFailTest(String name)`: 유효하지 않은 이름을 가진 자동차 객체 생성 시 예외 발생 테스트

**ForwardTest**
- `notMoveTest()`: 자동차가 움직이지 않았을 때 위치 값이 0인지 확인
- `moveOneTest()`: 자동차가 한 번 전진했을 때 위치 값이 1인지 확인
- `differentPositionTest()`: 자동차가 두 번 전진했을 때 위치 값이 1이 아님을 확인

**WinnerTest**
- `getSingleWinnerTest()`: 우승자가 1명일 때 리스트에 1명만 포함되는지 테스트
- `getDoubleWinnerTest()`: 우승자가 2명일 때 리스트에 2명만 포함되는지 테스트
- `getTripleWinnerTest()`: 우승자가 3명일 때 리스트에 3명만 포함되는지 테스트

## 기능 목록

1. [x] 자동차 이름 입력
   - [x] 빈 값일 경우 예외처리
   - [x] 쉼표 기준으로 구분
   - [x] 5자 이하일 경우 예외처리
2. [x] 객체 생성
   - [x] 플레이어 객체를 담을 List 생성 
   - [x] 플레이어 수만큼 이름을 담은 객체 생성 후 List에 담음
3. [x] 이동 횟수 입력
   - [x] 문자열이나 빈 값 들어올 시 예외처리 
4. [x] 게임 시작
   - [x] 플레이어마다 무작위 값을 구함.
   - [x] 4 이상이라면 position 값 1 추가.
   - [x] 1회 이동시마다 각 플레이어의 position 값 만큼 `-` 출력
   - [x] 이동이 끝나면 우승자 출력
   - [x] 여러 명일 경우 쉼표로 구분해 출력