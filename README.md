# java-racingcar-precourse

## 자동차 경주

- 자동차 경주 게임은 사용자가 몇 대의 자동차와 몇 번의 이동을 할 것인지를 입력으로 받아 자동차 경주 게임을 진행하고 그 결과를 출력하는 프로그램입니다.

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야한다.

## 요구되는 예외사항

- 자동차 이름은 5자 이하만 가능하다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
- 시도 횟수는 숫자여야 한다.
- 시도 횟수는 0보다 커야 한다.

## 기능 구현 목록

### 사용자 입력 기능

- 안내 메세지 띄우기
  - 경주할 자동차 이름 입력 안내 메시지 출력
  - 시도할 횟수 입력 안내 메세지 출력
- 경주할 자동차 이름 입력 기능
  - 쉼표로 구분된 이름 입력 받기
    - ex `"pobi, jun"`
  - 이름이 5자 이하인지 검증
    - 이름이 5자 초과나 빈 문자열인 경우 `IllegalArgumentException` 발생
  - 중복된 이름이 있는지 검증
    - 중복된 이름이 있는 경우 `IllegalArgumentException` 발생
- 시도할 횟수 입력 기능
  - 숫자 입력 받기
    - `0` 이하의 숫자나 문자인 경우 `IllegalArgumentException` 발생

### 게임진행

- 이동 조건 구현
  - 0~9 사이의 랜덤 값 생성
  - 값이 4 이상일 경우 자동차 전진
    - `MoveStrategy` 인터페이스와 그 구현체로 이동 로직 캡슐화
- 테스트를 위한 이동 전략 구현
  - 항상 이동하는 전략 `AlwaysMoveStrategy`
  - 항상 멈추는 전략 `AlwaysStopStrategy`
- 라운드 진행 및 결과 저장
  - 입력받은 시도 횟수만큼 게임 진행
  - 매 라운드마다 자동차들의 위치 저장
    - `List<RoundResult>`로 저장
  
### 게임 결과 출력 기능

- 각 시도별 결과 출력
  - 자동차 이름과 위치 출력 
    - ex `"pobi : --"`
- 최종 우승자 계산 및 출력
  - 가장 많이 전진한 자동차(들) 찾기
    - 동점자가 있을 경우 모두 우승자로 처리
  - 다수인 경우 쉼표와 공백으로 구분 `", "`
  - 우승자 이름 출력
    - ex `"최종 우승자 : pobi, jun"`

### 리펙토링

- 중복코드 제거
- 메소드 분리 및 네이밍 개선
- 코드 내의 숫자 값을 상수로 치환

### 추가 고려 사항

- 자동차 이름 입력 시 앞뒤 공백 제거
  - ex `" pobi, jun "` -> `"pobi, jun"`
  - why? 앞뒤 공백은 타당하다고 생각함.
- 원시 타입 래핑
  - why? 입력값은 의미를 가지고 있으므로 의미를 부여하기 위해 래핑
  - `String` 대신 `CarName` 클래스 사용
    - `CarName` 클래스는 이름 길이 검증
  - `int` 대신 `RaceCount` 클래스 사용
    - `RaceCount` 클래스는 0 이하 검증

# 도메인 설계

- Car
  - name: CarName
  - position: int
  - move(MoveStrategy moveStrategy): void

- Cars
  - cars: List<Car>
  - moveStrategy: MoveStrategy
  - moveAll(): void
  - getMaxPosition(): List<Car>
  - createCars(String carNames): List<Car>

- RaceResult
  - cars: List<Car>
  - getWinners(): List<String>

- MoveStrategy
  - isMovable(): boolean

- RandomMoveStrategy
  - isMovable(): boolean  