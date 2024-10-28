# java-racingcar-precourse

## 패키지 및 클래스 설명

### 1. `view` 패키지

**`InputView.java`**
- **`inputCarsName()`**: 사용자로부터 경주할 자동차 이름을 입력받는 메서드입니다.
- **`inputCarRacingRepeatCount()`**: 사용자로부터 경주 반복 횟수를 입력받는 메서드입니다.

**`OutputView.java`**
- **`printCarRacingResult(String carName, String advanceResult)`**: 각 경주 차수별 자동차의 전진 결과를 출력하는 메서드입니다.
- **`printCarRacingWinner(String carRacingWinners)`**: 경주 최종 우승자를 출력하는 메서드입니다.
- **`printLineSpace()`**: 출력 결과 사이에 공백 라인을 추가하는 메서드입니다.

### 2. `domain` 패키지

**`RacingCar.java`**
- 자동차 경주 관련 비즈니스 로직을 처리하는 도메인 클래스입니다.
- 자동차 이름과 전진 결과를 관리합니다.
- **`shouldAdvance()`**: 랜덤한 숫자를 생성하여 자동차가 전진할지 여부를 결정하는 메서드입니다.
- **`addAdvanceResult()`**: 자동차의 전진 결과 리스트에 `'-'`을 추가하는 메서드입니다.

### 3. `service` 패키지

**`RacingCarService.java`**
- 자동차 경주와 관련된 도메인 객체들을 관리하고 비즈니스 로직을 수행하는 서비스 클래스입니다.
- **`createRacingCars(String inputCarsName)`**: 입력받은 자동차 이름 문자열을 분리하여 `RacingCar` 객체들을 생성하는 메서드입니다.
- **`advanceRacingCars()`**: 모든 자동차를 전진시킬지 여부를 판단하고 결과를 반영하는 메서드입니다.
- **`getCarNamesAndAdvanceResults()`**: 각 자동차의 이름과 전진 결과를 리스트로 반환하는 메서드입니다.
- **`selectCarRacingWinners()`**: 가장 많이 전진한 자동차를 우승자로 선정하는 메서드입니다.

### 4. `validator` 패키지

**`CarNameValidator.java`**
- 자동차 이름 입력에 대한 검증을 처리하는 클래스입니다.
- **`validateCarNameLength(String carName)`**: 자동차 이름의 길이가 5자를 초과하지 않는지 검증합니다.
- **`validateCarNameIsEmpty(String inputCarsName)`**: 자동차 이름이 비어있지 않은지 검증합니다.

**`CarRacingRepeatCountValidator.java`**
- 자동차 전진 횟수 입력에 대한 검증을 처리하는 클래스입니다.
- **`validateRepeatCountNumberFormat(String inputCarRacingRepeatCount)`**: 입력된 전진 횟수가 양의 정수인지 검증합니다.

### 5. `constants` 패키지

**`ValidationConstants.java`**
- 검증 관련 상수를 정의한 클래스입니다.

### 6. `factory` 패키지

**`RacingCarFactory.java`**
- RacingCarController와 그에 필요한 의존성 객체들을 생성하고 조립합니다.

### 7. `controller` 패키지

**`RacingCarController.java`**
- InputView로부터 받은 입력을 적절한 서비스로 전달하고, 결과를 받아서 OutputView에 전달하는 컨트롤러 클래스입니다.
- **`run()`**: 전체 경주 프로세스를 실행하는 메서드입니다.
- **`createCars()`**: 사용자로부터 입력받은 자동차 이름을 기반으로 자동차 객체를 생성합니다.
- **`getRaceCount()`**: 사용자로부터 입력받은 경주 횟수를 검증하고 반환합니다.
- **`performRaces(int raceCount)`**: 지정된 횟수만큼 경주를 진행하고, 각 경주 결과를 출력합니다.
- **`printRaceResults(List<String[]> results)`**: 각 자동차의 전진 결과를 출력합니다.
- **`printWinners()`**: 최종 우승자를 출력합니다.

 