# java-racingcar-precourse

## 패키지 및 클래스 설명

### 1. `view` 패키지

**`InputView.java`**
- **`inputCarName()`**: 사용자로부터 자동차 이름을 입력받는 메서드입니다.
- **`inputCarRacingRepeatCount()`**: 사용자로부터 경주 반복 횟수를 입력받는 메서드입니다.

**`OutView.java`**
- **`carRacingResult()`**: 각 경주 차수별 실행 결과를 출력하는 메서드입니다.
- **`carRacingFinalWinner()`**: 경주 최종 우승자를 출력하는 메서드입니다.

### 2. `domain` 패키지

**`RacingCar.java`**
- 자동차 경주 관련 비즈니스 로직을 처리하는 도메인 클래스입니다.

**`RacingCarResult.java`**
- 경주 결과와 관련된 비즈니스 로직을 처리하는 도메인 클래스입니다.

### 3. `service` 패키지

**`RacingService.java`**
- 자동차 경주와 관련된 도메인 객체들을 조합하여 비즈니스 프로세스를 수행하는 서비스 클래스입니다.

### 4. `validation` 패키지

**`CarNameValidation.java`**
- 자동차 이름 입력에 대한 검증을 처리하는 클래스입니다.

**`CarForwardConditionValidation.java`**
- 자동차 전진 조건에 대한 검증을 처리하는 클래스입니다.

### 5. `controller` 패키지

**`RacingCarController.java`**
- `InputView`로부터 받은 입력을 적절한 서비스로 전달하고, 결과를 받아서 `OutView`에 전달하는 컨트롤러 클래스입니다.
- 전체 경주 프로세스를 조율합니다.

### 6. `factory` 패키지

**`RacingCarFactory.java`**
- 객체 생성을 담당하는 팩토리 클래스입니다.
- 필요한 객체들을 하나의 팩토리 클래스에서 관리하여 일관된 방식으로 객체를 생성합니다.