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
- 입력 받은 경주 자동차 이름들을 매개변수로 입력해 문자열 배열로 분리해 반환하는 splitCarsName() 메서드.
- 자동차 이름들을 분리한 문자열 배열을 매개변수로 받아 RacingCar 도메인 객체 생성하해 List<RacingCar> 반환하는  createRacingCarsBySplitCarsName() 메서드.
- pickNumberInRange() 메서드를 활용해 0부터 9까지 랜덤한 한 개의 정수를 받고 4이상일 경우 해당 정수, 4보다 작으면 0을 반환하는 getRandomOrZero() 메서드.
- List<RacingCar> racingCars 반복문으로 돌면서 각 RacingCar 도메인 객체안의 리스트 advanceResults에 getRandomOrZero() 메서드 반환값을 매개수변수로 받아 반환값 만큼 ‘-’ 추가 하는 addRandomAdvanceResult() 메서드.

**`RacingCarResult.java`**
- 경주 결과와 관련된 비즈니스 로직을 처리하는 도메인 클래스입니다.

### 3. `service` 패키지

**`RacingService.java`**
- 자동차 경주와 관련된 도메인 객체들을 조합하여 비즈니스 프로세스를 수행하는 서비스 클래스입니다.
- InputView에서 입력받은 자동차 이름들 문자열을 매개변수로하여 RacingCar 도메인의 비즈니스 로직들을 호출해 경주 자동차 객체 생성하는 createRacingCars() 메서드.
- 랜덤값 또는 0만큼 자동차를 전진시키는 advanceRacingCarByRandomOrZero() 메서드.
- 각 RacingCar 도메인  객체들의 advacneResult 리스트 크기 비교해 가장 큰 값의 자동차 이름 반환하는 selectCarRacingFinalWinner() 메서드.

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