# java-racingcar-precourse

## **📚 초간단 자동차 경주 게임**

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

## **과제 진행 요구 사항**

1. **저장소 포크 및 클론**
    - 미션은 자동차 경주 저장소를 **포크**하고 **클론**하는 것으로 시작한다.

2. **기능 구현 전 준비**
    - 기능을 구현하기 전, **README.md**에 구현할 기능 목록을 정리하여 추가한다.

3. **커밋 단위**
    - Git의 커밋 단위는 앞 단계에서 **README.md**에 정리한 기능 목록 단위로 추가한다.

4. **커밋 메시지 작성 규칙**
    - **AngularJS Git Commit Message Conventions**을 참고하여 커밋 메시지를 작성한다.
        - 예시:
            - `feat: 자동차 경주 기능 구현`
            - `fix: 자동차 이름 중복 예외 처리 수정`

5. **과제 진행 방법 참고**
    - 자세한 과제 진행 방법은 **프리코스 진행 가이드 문서**를 참고한다.

-----

## **구현할 기능 목록 정리**

- [x] 
    1. **입력기 (InputView)**

    - **역할**: 사용자에게 자동차 이름과 시도 횟수를 메시지로 보여주고, 입력을 받습니다. 콘솔을 통해 입력 및 출력을 관리합니다.
    - **구현 기능**:
        - `inputCarNames`: 사용자에게 자동차 이름 입력을 요청하고, 쉼표(,)로 구분하여 이름을 입력받음
        - `inputTryCount`: 입력받은 시도 횟수를 반환
        - `close`: `Console` 자원을 해제하여 입력 스트림을 종료
        - **예시 메시지**
            - 경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)
            - 시도할 횟수는 몇 회인가요?
    - **ViewMessage 열거형**
        - `INPUT_CAR_NAMES`: 자동차 이름 입력 메시지 ("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
        - `INPUT_TRY_COUNT`: 시도 횟수 입력 메시지 ("시도할 횟수는 몇 회인가요?")
        - `RESULT_HEADER`: 실행 결과 출력 메시지 ("실행 결과")
        - `FINAL_WINNER`: 최종 우승자 출력 메시지 ("최종 우승자 : ")

- [x] 
    2. **검증기 (Validator)**

    - **역할**: 입력값에 대한 검증 처리.
    - **구현 기능**:
        - `CarNameDuplicateValidator`: 자동차 이름에 중복이 있는 경우 검증하여, 중복 시 `IllegalArgumentException` 발생
            - **입력값 예시**: `pobi, woni, pobi`
            - **예외 메시지**: `자동차 이름은 중복될 수 없습니다.`

        - `CarNameListNotEmptyValidator`: 목록에 빈 자동차 이름이 포함된 경우 검증하여, 비어 있는 경우 `IllegalArgumentException` 발생
            - **입력값 예시**: `, , ,`
            - **예외 메시지**: `자동차 이름은 비어 있을 수 없으며, 쉼표(,)로 구분되어야 합니다.`

        - `CarNameNotEmptyValidator`: 입력된 자동차 이름이 빈 경우를 검증하여, 비어 있는 경우 `IllegalArgumentException` 발생
            - **입력값 예시**: 빈 문자열
            - **예외 메시지**: `자동차 이름은 비어 있을 수 없습니다.`

        - `CarNameTrailingCommaValidator`: 자동차 이름 목록 끝에 불필요한 쉼표가 있는지 검증하여, 쉼표가 있을 경우 `IllegalArgumentException` 발생
            - **입력값 예시**: `pobi, woni, `
            - **예외 메시지**: `자동차 이름 끝에 불필요한 쉼표가 포함될 수 없습니다.`

        - `CarNameMaxLengthValidator`: 자동차 이름이 5자를 초과하는 경우 검증하여, 초과 시 `IllegalArgumentException` 발생
            - **입력값 예시**: `Ferrari, Lamborghini`
            - **예외 메시지**: `자동차 이름은 5자를 초과할 수 없습니다.`

        - `CarMinimumCountValidator`: 자동차 이름이 1대 이하인 경우 검증하여, 부족 시 `IllegalArgumentException` 발생
            - **입력값 예시**: `pobi`
            - **예외 메시지**: `경주할 자동차는 최소 2대 이상이어야 합니다.`

        - `TryCountPositiveIntegerValidator`: 시도 횟수가 음수이거나 숫자가 아닌 경우 검증하여, 잘못된 입력 시 `IllegalArgumentException` 발생
            - **입력값 예시 1**: `-3`
            - **입력값 예시 2**: `abc`
            - **예외 메시지**: `시도 횟수는 양의 정수여야 합니다.`

        - `TryCountNotNullOrEmptyValidator`: 시도 횟수가 비어 있는 경우 `IllegalArgumentException` 발생
            - **입력값 예시**: 시도 횟수 입력 없음 (빈 문자열)
            - **예외 메시지**: `시도 횟수는 비어 있을 수 없습니다.`
        - `TryCountMaximumValidator`: 시도 횟수가 1000번을 넘어가는지 검증하여, 초과 시 `IllegalArgumentException` 발생
            - **입력값 예시**: `1001`
            - **예외 메시지**: `시도 횟수는 최대 1000회 이하로 입력해 주세요.`
            - **적용 이유**:
            - 시도 횟수를 설정하여 비효율적인 게임 진행을 방지
            - 시스템 자원을 효율적으로 관리할 수 있도록 도움

- [x] 
    3. **Service (RacingGameService)**

    - **역할**: 경주의 비즈니스 로직을 관리하고 경주의 전체 흐름을 제어합니다.

    - **구현 기능**:
        - **자동차 리스트 초기화**:
            - 입력받은 자동차 이름을 기반으로 `RacingCar` 객체 리스트를 생성하여 불변 리스트로 저장합니다.
            - `initializeCars` 메서드를 통해 이름 리스트를 받아 `RacingCar` 인스턴스로 초기화합니다.

        - **경주 진행**:
            - `startRace`: 입력받은 횟수만큼 경주를 반복 진행합니다. 각 라운드마다 `executeSingleRaceRound` 메서드를 호출하여 자동차들의 전진 여부를 결정하고 결과를
              출력합니다.
            - `raceOnce`: 모든 자동차에 대해 무작위 값을 생성하여 전진 가능 여부를 결정하며, 이동 가능한 경우 해당 자동차를 전진시킵니다.
            - **전진 조건**: 무작위로 생성된 숫자가 `RacingGameConstants.MOVE_THRESHOLD` 이상의 값을 가지면 `RacingCar` 객체의 `advance` 메서드를
              호출하여 전진합니다.

        - **라운드 결과 기록 및 우승자 결정**:
            - 각 라운드에서 `OutputView`를 사용해 자동차들의 전진 상태를 기록 및 출력합니다.
            - `findWinners`: 전체 경주가 종료된 후, 가장 먼 거리에 있는 자동차(최고 위치)를 기준으로 우승자를 결정하여 반환합니다.
            - `findMaxPosition`: 경주가 끝난 후 가장 멀리 전진한 위치를 찾기 위해 모든 자동차의 위치를 비교합니다.

        - **보조 기능**:
            - `getRacingCars`: 현재 `racingCars` 리스트를 반환하여 외부에서 자동차 목록 및 상태를 확인할 수 있도록 합니다.
            - 테스트에 활용

- [x] 
    4. **Model (RacingCar)**

    - **역할**: 자동차의 상태(이름, 위치)를 관리하고 전진을 처리합니다.

    - **구현 기능**:
        - **자동차 이름 저장**:
            - 생성자에서 전달받은 자동차 이름을 `name` 필드에 저장합니다.

        - **초기 위치 설정**:
            - 자동차의 위치는 `RacingGameConstants.INITIAL_POSITION`의 값으로 초기화됩니다.

        - **전진 로직**:
            - `advance` 메서드를 호출하면 위치(`position`)가 1 증가하여 자동차가 전진합니다.

        - **현재 위치 반환**:
            - `getPosition` 메서드를 통해 자동차의 현재 위치를 반환합니다.

        - **자동차 이름 반환**:
            - `getName` 메서드를 통해 자동차의 이름을 반환합니다.

- [x] 
    5. **출력기 (OutputView)**

    - **역할**: 게임의 진행 상황 및 최종 결과를 출력합니다.

    - **구현 기능**:
        - **경주 시작 메시지 출력**:
            - `printResultHeader` 메서드를 통해 게임의 결과 출력을 시작할 때 `"실행 결과"` 메시지를 출력합니다.

        - **각 라운드 결과 출력**:
            - `printRaceResults` 메서드를 사용하여 각 라운드마다 각 자동차의 이름과 전진 상태를 출력합니다.
            - `printCarPosition` 메서드를 통해 특정 자동차의 현재 위치를 `"-"`로 표시하여 출력합니다.

        - **최종 우승자 출력**:
            - `printWinners` 메서드를 사용하여 최종 우승자(들)의 이름을 출력합니다.
            - 여러 명의 우승자가 있을 경우, 우승자 이름을 쉼표로 구분하여 출력합니다.

        - **출력 메시지**:
            - `ViewMessage` 열거형을 사용하여 출력에 필요한 고정 메시지(`RESULT_HEADER`와 `FINAL_WINNER`)를 관리합니다.

- [x] 
    6. **Controller (RacingGameController)**

    - **역할**: 사용자의 입력을 받아 서비스로 전달하고 게임의 전체 흐름을 제어합니다.

    - **구현 기능**:
        - **사용자 입력 처리 및 검증**:
            - `getCarNames` 메서드를 통해 `InputView`로부터 자동차 이름을 입력받고, `CarNameValidator`를 사용해 검증 후 쉼표로 구분하여 리스트로 반환합니다.
            - `getTryCount` 메서드를 통해 `InputView`로부터 시도 횟수를 입력받고, `TryCountValidator`를 사용해 검증 후 정수로 변환하여 반환합니다.

        - **경주 초기화**:
            - `initializeGame` 메서드를 통해 `RacingGameService` 인스턴스를 생성하여 자동차를 초기화하고, `OutputView`를 통해 경주 시작
              메시지(`RESULT_HEADER`)를 출력합니다.

        - **경주 실행**:
            - `runAllRaces` 메서드를 통해 지정된 횟수만큼 경주를 반복 실행하며, 각 라운드마다 `RacingGameService`를 통해 레이스 결과를 `OutputView`에 출력합니다.

        - **우승자 결정 및 출력**:
            - `printFinalWinners` 메서드를 호출하여 `RacingGameService`에서 우승자를 계산한 후, `OutputView`를 통해 우승자를 출력합니다.

        - **자원 해제**:
            - `inputView.close` 메서드를 호출하여 콘솔 자원을 해제하고 입력 스트림을 종료합니다.

----

## **프로그래밍 요구 사항**

1. **인덴트(Indent) depth 제한**
    - `indent(인덴트, 들여쓰기) depth`는 3을 넘지 않도록 구현한다. 최대 2까지만 허용.
    - 예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.
    - **힌트**: 들여쓰기 depth를 줄이는 좋은 방법은 **함수(또는 메서드)를 분리**하는 것이다.

2. **3항 연산자를 사용하지 않는다.**
    - 코드의 명확성을 위해 3항 연산자 사용을 지양하고, 조건문을 풀어서 작성할 것.

3. **함수(또는 메서드)가 한 가지 일만 하도록 구현**
    - 한 함수가 **단일 책임 원칙(Single Responsibility Principle)**을 준수하도록 최대한 작은 단위로 분리하여 작성.

4. **테스트 코드 작성**
    - **JUnit 5**와 **AssertJ**를 사용하여 기능 목록이 정상적으로 작동하는지 테스트 코드를 작성한다.

5. **라이브러리 사용**
    - **camp.nextstep.edu.missionutils**에서 제공하는 **Randoms** 및 **Console API**를 사용하여 구현해야 한다.
        - **Random 값 추출**은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
        - **사용자가 입력하는 값**은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
