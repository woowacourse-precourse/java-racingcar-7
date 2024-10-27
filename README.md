# 2주차 프리코스

## java-racingcar-precourse

### 기능 요구사항 
    1.  주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
        .split(,)을 사용하여 구분, Car Name 길이는 1~5까지 
    4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        - Randoms.pickNumberInRange(0, 9);
    6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 추가 요구 사항
    1. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    2. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    3. 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
    4. 3항 연산자를 쓰지 않는다.
    5. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
    6. JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    7. 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    8. JUnit 5 User Guide
    9. AssertJ User Guide
    10. AssertJ Exception Assertions
    11. Guide to JUnit 5 Parameterized Tests
# 구현 예정 기능

## 패키지 구조
- `racingcar.controller`: 게임의 흐름을 제어하는 클래스
- `racingcar.controller.validator`: 사용자 입력 검증 클래스
- `racingcar.model`: 게임 로직 및 데이터 구조를 포함하는 클래스
- `racingcar.model.dto`: 데이터 전송 객체(DTO) 클래스
- `racingcar.view`: 사용자 입력 및 출력 관련 클래스
- `racingcar`: 애플리케이션 진입점 클래스

## 주요 클래스 및 기능

### 1. UserInputValidator
- **목적**: 사용자 입력의 유효성을 검증합니다.
- **기능**:
    - `validateRoundCount`: 이동 횟수가 0 이상인지 확인합니다.
    - `validateCarNames`: 자동차 이름 목록의 유효성을 확인합니다.
    - `validateNumberUnderZero`: 숫자가 0 미만인지 확인합니다.
    - `validateCarNamesFormat`: 자동차 이름의 형식을 확인합니다.
    - `validateCarNamesLength`: 자동차 이름의 길이가 5자 이하인지 확인합니다.

### 2. RaceController
- **목적**: 게임의 흐름을 제어합니다.
- **기능**:
    - `playGame`: 게임을 실행합니다.
    - `initializeGame`: 게임 초기 설정을 합니다.
    - `getRoundCount`: 이동 횟수를 입력받아 검증합니다.
    - `getCarNames`: 자동차 이름을 입력받아 검증합니다.

### 3. RoundResult
- **목적**: 각 라운드의 결과를 저장합니다.
- **기능**:
    - `getCarInfos`: 경주에 참가한 자동차 정보를 반환합니다.

### 4. Winners
- **목적**: 최종 우승자 정보를 저장합니다.
- **기능**:
    - `getWinnerList`: 우승자 목록을 반환합니다.

### 5. CarInfo
- **목적**: 각 자동차의 정보를 관리합니다.
- **기능**:
    - `getCarName`: 자동차 이름을 반환합니다.
    - `getCurrentPosition`: 현재 위치를 반환합니다.
    - `proceed`: 자동차의 위치를 한 칸 앞으로 이동시킵니다.

### 6. RoundInfo
- **목적**: 라운드 정보를 관리합니다.
- **기능**:
    - `finishRound`: 현재 라운드를 종료하고 다음 라운드로 이동합니다.
    - `getCurrentRound`: 현재 라운드 번호를 반환합니다.
    - `getMaxRound`: 최대 라운드 수를 반환합니다.

### 7. GameService
- **목적**: 게임 로직을 처리합니다.
- **기능**:
    - `executeRound`: 각 자동차의 이동을 처리하고 라운드를 종료합니다.
    - `findWinners`: 우승자를 찾습니다.
    - `isGameOver`: 게임 종료 여부를 확인합니다.

### 8. InputView
- **목적**: 사용자 입력을 받습니다.
- **기능**:
    - `getCarNames`: 자동차 이름을 입력받습니다.
    - `getRoundCount`: 이동 횟수를 입력받습니다.

### 9. OutputView
- **목적**: 게임 결과를 출력합니다.
- **기능**:
    - `printSeparator`: 결과 출력 구분선을 출력합니다.
    - `printRoundResult`: 각 라운드의 결과를 출력합니다.
    - `printWinner`: 최종 우승자를 출력합니다.

### 10. Application
- **목적**: 애플리케이션의 진입점입니다.
- **기능**:
    - `main`: 프로그램을 실행하고, 필요한 객체를 초기화합니다.
