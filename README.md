# **프리코스 미션2 자동차 경주**

## **기능 요구 사항**

### **입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현**

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## **문제에 주어지지 않은 조건 확인**

- 시행횟수에 대한 조건 X
    - 시행 횟수의 최소 값
        - 1 이상의 정수라는 전제로 진행
    - 시행 횟수의 최대 값
        - 10,000회로 지정
- 자동차 이름에 관한 조건 X
    - 자동차 이름에 공백이 있을시
        - 공백을 포함되면 안된다는 전제로 진행
    - 자동차 이름으로 사용가능한 문자
        - 알파벳, 한글, 숫자로 제한
    - 입력되는 자동차 이름의 최소 개수
        - 자동차의 이름의 최소 개수는 2개로 제한한다는 전제로 진행
            - 자동차의 개수가 1개라면 경주를 할 수 없음
    - 입력되는 자동차 이름의 최대 개수
        - 자동차의 이름의 최대 개수는 100개로 제한
- 자동차의 최소 개수에 대한 조건 X
    - 자동차의 최소 개수는 2개여야 한다는 전제로 진행
        - 자동차의 개수가 1개라면 경주를 할 수 없음

## **구현 기능 목록**

- 사용자 입력 기능
    - 자동차 이름 입력
    - 시행 횟수 입력
- 결과 출력 기능
    - 자동차 이름 입력 전 안내 메시지 출력
    - 시행 횟수 입력 전 안내 메시지 출력
    - 각 시행횟수 마다 경기 정보(자동차 이름, 위치) 출력
    - 최종 우승자 출력
- 자동차 경주 기능
    - 자동차 객체 생성
    - 자동차 경주 시행
        - Random Number 생성
        - Random Number에 따라 자동차 forward, stop
        - 시행마다 각 시행의 경기 정보 저장(자동차 이름, 위치)
    - 자동차 객체의 최종 위치를 확인하여 우승자 저장
- Validation
    - 입력값 검증
        - 자동차 이름은 알파벳, 한글, 숫자로만 이루어져야 한다
        - 자동차 이름의 길이는 5자 이하여야 한다
        - 자동차 개수는 최소 2개 이상이여야 한다
        - 자동차 개수는 최대 10000개 이하여야 한다
        - 시행 횟수는 숫자로만 이루어져야 한다
        - 시행 횟수는 0보다 큰 정수여야 한다
        - 시행 횟수는 10,000 이하의 정수여야 한다

## **플로우 차트**
<img src="https://raw.githubusercontent.com/eraser502/java-racingcar-7/b4e7141eb78089ca7fcd36c9e6e1ea8c9a757a4c/Images/flowChart.svg" width="400px">

## **클래스 구조**

### **View**

- InputView
    - readline() →`camp.nextstep.edu.missionutils.Console.readLine()`을 사용하여 사용자의 입력을 받음
    - close() →`camp.nextstep.edu.missionutils.Console.close()`사용하여 자원을 해제함
- OutputView
    - `printCarNameInputMessage()` → 자동차 이름을 입력받기 전 안내 메시지 출력
    - `printTrialCountInputMessage()` → 시도할 횟수를 입력받기 전 안내 메시지 출력
    - `printRaceProcedure()` → 각 시행횟수마다 자동차의 이름, 위치(진행상황) 출력
    - `printRaceStatus()` → 각 시행횟수마다 CarDTO 리스트에서 자동차 이름, 위치 출력
    - `printWinner(String output)` → 최종 승자 출력

### **Domain**

- Car
    - `name` → 자동차의 이름
    - `location` → 차량의 현재 위치, 기본값 0
    - `trialCount` → 총 시행횟수
    - `forward()` → `location + 1`, `moveCount - 1`
    - `stop()` → `moveCount - 1`
    - `validateTrialCount()` → 이동 전에 `trialCount`가 남았는지 검증

### **DTO**

- CarDTO(record) → 자동차의 이름과 위치정보를 갖는 DTO
- RaceResultDTO(record) → 레이스의 승자 리스트와 각 시행횟수마다의 자동차의 이름, 위치 상태를 포함한`Map`을 갖는 `DTO`

### **Controller**

- RacingController
    - `run()` → 입력값 검증, 자동차 경기에 관련된 비즈니스 로직 호출
    - `splitCarNames()` → 입력값을 ‘,’ 기준으로 분리한 문자열 리스트 반환
    - `getCarsName()`→ 자동차 이름 입력
    - `getTrialCount()` → 총 시행 횟수 입력
    - `validateInput()` → 입력값 검증
    - `startRace()` → 자동차 경기 시작 로직
    - `printRaceResults()` → 최종 결과 출력

### **Service**

- RacingService
    - `startRace()` → 자동차 경주 핵심 로직
    - `createCars()` → `Car` 객체 리스트 생성
    - `getRaceProcedure()` -> 각 시행 횟수 별 경기 정보 반환
    - `getRaceWinners()` → 우승자 리스트 반환
    - `createCarDTOs()` → `Car` 객체 리스트를 받아 `CarDTO` 리스트로 변환하여 반환
    - `isMovingForward()` →`camp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()`을 이용하여 0 ~ 9 사이의 랜덤값을 뽑아, 그 랜덤값이 4 이상이면`true`, 이외의 경우에는`false`를 반환
    - `runRace()` → 시행 횟수만큼 자동차 경기 진행 및 출력

### **Validator**

- InputValidator
    - `validateCarName()` → 자동차 이름 입력값에 대한 검증
    - `validateCarNameLength()` → 자동차 이름 길이에 대한 검증
    - `validateCarNameContainsNotAllowedCharacter()` → 자동차 이름에 허용되지 않는 문자가 포함되었는지 검증
    - `validateCarNameCount()` → 입력된 자동차 이름의 개수가 2개 이상인지 검증
    - `validateCarNameDuplication()` → 자동차 이름 리스트에 중복이 있는지 검증
    - `validateTrialCount()` → 시행 횟수 입력값에 대한 검증
    - `validateTrialCountInputType()` → 시행 횟수 입력값이 숫자로 입력되었는지 검증
    - `validateTrialCountRange()` → 시행 횟수가 1 이상의 값으로 입력되었는지 검증