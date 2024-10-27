# Java Racing Car Precourse

## 요구 사항

### 1. 자동차 조건

- **이름**: 5자 이하 (구분자: `,`)
- **무작위 값**: 0~9 사이의 숫자
    - **멈춤**: 무작위 값이 3 이하일 경우
    - **전진**: 무작위 값이 4 이상일 경우

### 2. 입력 요구사항

- **자동차 이름**: 쉼표(`,`)로 구분된 이름 리스트
- **시도 횟수**: 정수로 입력
- **잘못된 입력 처리**
    - 자동차 이름이 0자 이하이거나 6자 이상일 경우
    - 시도 횟수가 0 이하일 경우
    - 위 조건에 해당하면 `IllegalArgumentException`을 던지고 프로그램 종료

### 3. 출력 요구사항

- 각 자동차의 이름과 전진한 횟수 출력
- 최종 우승자의 이름 출력 (동점일 경우 쉼표(`,`)로 구분)

### 4. 제약 조건

- 코드의 depth는 2까지만 허용
- 3항 연산자 사용 금지
- SRP (Single Responsibility Principle) 원칙 준수
- 구현 기능에 대한 테스트 코드 작성 (Junit 5, AssertJ 사용)
- `System.exit()` 사용 금지
- **Random 값 추출**: `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()` 사용
- **사용자 입력**: `camp.nextstep.edu.missionutils.Console.readLine()` 사용

---

## 구현 기능 목록

### 1. **자동차 클래스 (`Car`)**

- **생성자**: 자동차 이름을 매개변수로 받아 초기화하고, 초기 위치를 0으로 설정
- **필드**:
    - `name` (자동차 이름)
    - `position` (자동차 위치)
- **메서드**:
    - `move()`: 전진 조건을 만족할 때 호출되어 자동차의 위치를 증가시킴
    - `getName()`: 자동차 이름을 반환
    - `getPosition()`: 자동차 위치를 반환

### 2. **입력 클래스 (`ConsoleInputManager`)**

- **메서드**:
    - `getCars()`: 사용자로부터 자동차 이름 목록을 입력받고, 쉼표(`,`)로 구분하여 각 이름의 공백을 제거한 후, 유효성 검사를 통해 `Car` 객체 리스트로 변환
    - `getAttemptCount()`: 사용자로부터 시도 횟수를 입력받고, 유효성 검사를 거쳐 반환

### 3. **출력 클래스 (`ConsoleOutputManager`)**

- **메서드**:
    - `displayProgress(List<Car>)`: 각 자동차의 이름과 현재 위치를 화면에 표시
    - `displayWinners(List<Car>)`: 우승자로 선정된 자동차 이름을 쉼표(`,`)로 구분하여 출력
    - `displayMessage(String)`: 에러 메시지를 출력

### 4. **경주 컨트롤러 클래스 (`RacingController`)**

- **메서드**:
    - `setupGame()`: 입력 클래스를 통해 자동차 목록을 생성
    - `startRace()`: 사용자가 입력한 시도 횟수만큼 각 자동차의 전진 여부를 결정하고, 매 라운드마다 진행 상황을 출력
    - `displayWinners()`: 경주 종료 후 최종 우승자를 출력
    - `proceedRace()`: 각 자동차의 전진 여부를 결정하는 단일 경주 라운드를 수행

### 5. **검증 클래스**

- **`NameValidator`**: 자동차 이름의 유효성을 검사하는 정적 클래스
    - `validate(List<String>)`: 전체 자동차 이름의 유효성을 검사하며, 각 이름이 1자 이상 5자 이하인지 확인
- **`AttemptCountValidator`**: 시도 횟수의 유효성을 검사하는 정적 클래스
    - `validate(int count)`: 시도 횟수가 1 이상인지 확인

### 6. **에러 코드 클래스 (`ErrorCode`)**

- **기능**: 유효성 검사 실패 시 사용할 에러 메시지와 기본 메시지 형식을 정의
- **상수**:
    - `INVALID_ATTEMPT_COUNT`: 시도 횟수 유효성 검사 실패 메시지 ("시도 횟수는 %d회 이상이어야 합니다.")
    - `INVALID_CAR_NAME`: 자동차 이름 유효성 검사 실패 메시지 ("자동차 이름은 %d자 이상 %d자 이하이어야 합니다.")
- **메서드**:
    - `getMessage(Object... args)`: 기본 메시지에 동적으로 값을 삽입하여 형식화된 메시지를 반환
