# 자동차 경주

## `Application` 클래스
- **`main(String[] args)`**: UserInput 인스턴스를 통해 사용자 입력을 받고, ResultOutput을 통해 자동차 경주 결과를 출력
<br>

## `Car` 클래스
자동차 객체를 정의하는 기능

- **`Car(String name)`**: 자동차의 이름을 설정하고, `movingCount`를 0으로 초기화
- **`String getName()`**: 자동차의 이름을 반환
- **`int getMovingCount()`**: 자동차가 이동한 횟수를 반환
- **`void move()`**: 무작위 값이 4 이상일 경우 `movingCount`를 1 증가시켜 자동차를 이동
<br>

## `UserInput` 클래스
사용자로부터 입력을 받고, 입력값을 검증하여 프로그램에 전달하는 기능

- **`void setCarNames()`**: 
  - 콘솔에서 경주할 자동차 이름을 입력받는 기능
  - 여러개의 자동차 이름을 쉼표(,)를 구분자로 나누기
  - 자동차 이름이 5글자 이하인 것만 `cars` 리스트에 추가하고 `isValidCarNames`를 `true`로 설정
  - 자동차 이름이 6글자 이상이면 `isValidCarNames`를 `false`로 설정
- **`void setAttempts()`**
  - 콘솔에서 시도 횟수를 입력받는 기능 
  - 시도 횟수가 정수이면 `isIntegerAttempts`를 `true`로 설정
  - 시도 횟수가 양수이면 `isPositiveAttempts`를 `true`로 설정
- **`void isValidInput()`**
  - 유효한 사용자 입력인지 검증하는 기능
  - `isValidCarNames`, `isPositiveAttempts`, `isIntegerAttempts`가 모두 `true`인지 확인
  - 세 가지 플래그 중 하나라도 `false`일 경우 `IllegalArgumentException`을 발생시킴
- **`int getAttempts()`**: 입력받은 시도 횟수를 반환
- **`List<Car> getCarList()`**: 입력받은 자동차 객체 리스트를 반환
<br>

## `ResultOutput` 클래스
각 라운드 별 결과와 최종 결과를 출력하는 기능

- **`static void printRoundStatus(List<Car> cars)`**
  - 각 라운드에서 각 자동차의 이동 횟수를 `-`의 개수로 표현하여 출력하는 기능
- **`static void declareWinner(List<Car> cars)`**
  - 모든 라운드가 끝난 후 이동 횟수가 가장 많은 최종 우승자를 출력하는 기능
  - `cars` 리스트를 각 이동 횟수에 따라 내림차순 정렬
  - 가장 많은 이동 횟수를 가진 자동차의 이름을 출력
