# java-racingcar-precourse

## 기능 요구 사항

### 1. RequestView

- [ ] inputCarsNames: 자동차 이름 입력 메서드
- [ ] inputTryCount: 시도 횟수 입력 메서드

### 2. StringToNumberUtils

> 인터페이스로 제공 (Integer, Long 과 같이 다양한 숫자를 제공)
> StringToIntegerUtils, StringToLongUtils

- [ ] validateNumber - 입력 받은 문자열이 숫자인지 검증 메서드 (숫자로 변환하지 못할 시 예외 발생)
- [ ] toNumber - 문자열을 숫자로 형 변환 메서드

### 3. Car

- [ ] 자동차 도메인 작성
    - name: String - 자동차의 이름
    - moveCount: int - 자동차가 움직인 횟수
- [ ] 생성자
    - [ ] validateName - 자동차의 이름은 5글자 이하 검증 메서드 (5글자 초과시 예외 발생)
- [ ] canMove - 자동차가 움직일 수 있는가 판별 후 이동하는 메서드
- [ ] move - 자동차가 한 칸 이동하는 메서드
- [ ] print - 자동차의 현재 상태를 출력하는 메서드

### 3. CarRepository

> 자동차를 관리하는 저장소
> `Java`의 `Map`을 사용하여 관리 및 저장

- [ ] save - 자동차 저장 메서드
- [ ] findAll - 자동차를 전체 조회하는 메서드
- [ ] findByWinner - 우승한 자동차를 조회하는 메서드

### 4. RacingService

- [ ] saveAll - 입력 받은 문자열을 가지고 자동차를 모두 저장하는 메서드
- [ ] race - 레이스 진행
- [ ] result - 레이스 결과 조회하는 메서드
- [ ] getWinnerNames - 우승한 사용자의 이름을 가져오는 메서드

### 5. ResponseView

- [ ] printRaceResult - 레이스 결과 출력 메서드
- [ ] printWinnerNames - 우승한 사용자의 이름 출력 메서드