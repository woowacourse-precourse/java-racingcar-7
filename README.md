# java-racingcar-precourse

## 📝 기능 목록
1. 경주할 자동차 이름 입력 받기
    - **예외처리**: 입력된 자동차 이름이 1개일 경우 
    - **예외처리**: 이름이 6자 이상일 경우  
    - **예외처리**: 중복된 이름이 있을 경우
    - **예외처리**: 이름이 빈 문자열일 경우  
    - **예외처리**: 이름이 null일 경우  
    - **예외처리**: 이름이 숫자로만 구성되어 있을 경우  
    - **예외처리**: 이름이 특수 기호를 포함하고 있을 경우
2. 시도할 횟수 입력 받기  
    - **예외처리**: 시도 획수가 자연수가 아닐 경우  
3. 경기 결과 출력  
4. 최종 우승자 이름 출력

## Use Case 시나리오
### 기본 흐름

| **단계** | **자동차 경주 애플리케이션**                            |
|---------|------------------------------------|
| 1       | 시스템이 자동차 이름 입력 받기 위한 텍스트를 디스플레이한다. |
| 2       | 사용자가 이름을 입력한다. |
| 3       | 시스템이 시도할 횟수를 입력 받기 위해 텍스트를 디스플레이한다. |
| 4       | 사용자가 시도 횟수를 입력한다. |
| 5       | 시스템이 이제부터 경주 결과를 출력하겠다는 텍스트를 디스플레이한다. |
| 6       | 시스템이 전진 조건을 실행하고 확인한다. |
| 7       | 시스템이 저동차를 전진 또는 멈춘다. |
| 3       | 시스템이 한 회차의 경기 결과를 디스플레이한다. |
| 8       | 시스템이 남은 시도 횟수를 확인한다. (남은 횟수가 있다면 다시 6 단계부터 실행한다)|
| 9       | 시스템이 최종 우승자를 계산한다.|
| 10       | 시스템이 최종 우승자를 디스플레이한다. |

### 대체 흐름 및 예외 흐름

| **조건**                   | **시스템 반응**                                       |
|--------------------------|-----------------------------------------------------|
| 이름이 6자 이상일 경우   | 애플리케이션을 종료시킨다.   |
| 중복된 이름이 있을 경우   | 애플리케이션을 종료시킨다.    |
| 이름이 빈 문자열일 경우   | 애플리케이션을 종료시킨다.    |
| 이름이 null일 경우  | 애플리케이션을 종료시킨다.    |
| 이름이 숫자로만 구성되어 있을 경우 | 애플리케이션을 종료시킨다.    |
| 이름이 특수 기호를 포함하고 있을 경우 | 애플리케이션을 종료시킨다.    |
| 자동차 이름이 1개만 입력됐을 경우 | 애플리케이션을 종료시킨다.    |
| 시도 획수가 자연수가 아닐 경우 | 애플리케이션을 종료시킨다.    |

## Use Case  다이어그램
<img src="https://github.com/user-attachments/assets/fabbaef2-c0d1-4793-89c6-47cb552cb388" alt="미션2_유스케이스_다이어그램" width="400"/>

## MVC
🔵 **Model**

### RacingRule 👉 레이싱 룰을 확장할 수 있도록 정의된 인터페이스

**- 메서드**  
`goOrStop`: 자동차가 전진할지 멈출지 결정하는 조건 확인  
`pickWinner`: 최종 우승자를 선별하는 로직  

### Car 👉 자동차 클래스

**- 필드**  
`String name`: 자동차 이름  
`int location`: 자동차 위치  
`String NAME_AND_LOCATION_DELIMITER`: 출력 메세지를 위한 이름과 위치 구분자 변수    

**- 생성자**  
`Car(String name)`: 이름을 받아 자동차 객체 생성하기  

**- 메서드**  
`goFront()`: 자동차의 위치를 1만큼 증가하가  
`nameWithLocationToString()`: 자동차 이름과 위치를 문자열로 변환하기  
`compareLocation(int maxNumber)`: 현재 위치와 최고 위치를 비교하기  
`addWinnerName(ArrayList<String> winner)`: 우승자 이름을 리스트에 추가하기  
`updateWinnerLocation(int winnerLocation)`: 최고 위치를 업데이트  

### Racing 👉 자동차 경주 진행을 위한 클래스

**- 필드**  
`ArrayList<Car> cars`: 경기에 참여할 자동차 객체들  

**- 생성자**  
`Racing(ArrayList<Car> cars)`: 자동차 리스트를 받아 경주를 시작하는 객체 생성하기  

**- 메서드**  
`runRound()`: 한 라운드를 진행하기  
`goOrStop()`: 자동차가 전진할지 여부를 무작위로 결정하기  
`resultOfRound()`: 한 라운드의 결과를 문자열로 반환하기  
`pickWinner()`: 최종 우승자를 선별하기  

---

🟡 **View**

### InputView 👉 사용자 입력을 처리하는 클래스

**- 메서드**  
`readCarsName()`: 사용자로부터 자동차 이름을 입력받기  
`readTurnCount()`: 사용자로부터 시도 횟수를 입력받기  

### OutputView 👉 결과 출력 클래스

**- 필드**  
`String WINNERS_DELIMITER`: 우승자를 위한 구분자 변수  

**- 메서드**  
`printGameResultMessage()`: 경주 결과 출력을 시작하는 메세지 출력하기  
`printResultOfTurn(String gameResult)`: 한 라운드의 결과를 출력하기  
`printWinner(ArrayList<String> winner)`: 최종 우승자를 출력하기  

---

🟢 **Controller**

### RacingController 👉 사용자 입력을 받고 모델과 상호작용하여 경주를 진행하는 컨트롤러

**- 필드**  
`Racing racing`: Racing 객체  

**- 메서드**  
`startGame()`: 게임을 시작하기  
`readCarsName()`: 자동차 이름을 입력받고 유효성을 검사하기  
`readTurnCount()`: 시도 횟수를 입력받고 유효성을 검사하기  
`initializeRacing(List<String> carsName)`: Racing 객체 생성하기  
`startRacing(List<String> carsName, int turnCount)`: 입력받은 자동차로 경주를 시작하기  
`playRound()`: 한 라운드를 진행하기  
`displayRoundResult()`: 한 라운드의 결과를 출력하기  
`printFinalWinner()`: 최종 우승자를 출력하기  
`printGameResultMessage()`: 경주 결과 출력을 위한 메세지 출력하기  

---

🔴 **Validation**

### CarValidator 👉 자동차 입력값의 유효성을 검사하는 클래스

**- 메서드**  
`validateCarNumber(List<String> splittedNames)`: 자동차 수량 유효성 검사하기  
`validateDuplicateCarName(List<String> splittedNames)`: 중복된 자동차 이름 유효성 검사하기  
`validateCarName(String name)`: 자동차 이름의 유효성 검사하기  

### TurnCountValidator 👉 시도 횟수 입력값의 유효성을 검사하는 클래스

**- 메서드**  
`validateTurnCount(String turnCount)`: 시도 횟수의 유효성 검사하기  

---

🟣 **Enum**

### SystemMessage 👉 시스템 메세지를 관리하는 인터페이스

**- 메서드**  
`getMessage`: 시스템 메세지 반환하기  

### ErrorMessage 👉 시스템 에러 메세지를 관리하는 enum

**- 상수 필드**  
`INVALID_DUPLICATE_CAR_NAME`: "중복된 자동차 이름 있습니다."  
`INVALID_CAR_NAME_EMPTY`: "비어있는 자동차 이름이 존재합니다."  
`INVALID_CAR_NAME_LENGTH`: "자동차 이름은 5자 이하만 가능합니다."  
`INVALID_CAR_NAME_NUMERIC_ONLY`: "자동차 이름이 숫자로만 구성될 수 없습니다."  
`INVALID_CAR_NAME_INCLUDE_SPECIAL_CHAR`: "자동차 이름에 특수문자가 포함될 수 없습니다."  
`INVALID_CAR_NUMBER`: "경기에 최소 2대 자동차가 참여할 수 있습니다."  
`INVALID_TURN_NUMBER`: "자연수가 아닌 숫자입니다."  
`String ERROR_LOG_LEVEL`: error 로그 레벨을 위한 변수  
`String message`: 메세지를 위한 변수   

**- 메서드**  
`getMessage`: 에러 메세지를 반환하기  

### IOMessage 👉 시스템 입출력 메세지를 관리하는 enum

**- 상수 필드**  
`INPUT_CARS_NAME`: "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"  
`INPUT_TURN_COUNT`: "시도할 횟수는 몇 회인가요?"  
`PRINT_GAME_RESULT`: "실행 결과"  
`PRINT_GAME_WINNER`: "최종 우승자 : "  
`String message`: 메세지를 위한 변수  

**- 메서드**  
`getMessage`: 입출력 메세지를 반환하기  

---

🟤 **Utilities**

### Splitter 👉 자동차 이름을 분할하는 클래스

**- 메서드**  
`splitNames(String carNames)`: ','를 기준으로 이름 문자열을 분할하기  

### Random 👉 무작위 숫자를 생성하는 클래스

**- 메서드**  
`generateRandomNumber()`: 무작위 숫자를 생성하기  

### NumberParser 👉 문자열을 숫자로 변환하는 클래스

**- 메서드**  
`parseToInt(String value)`: 문자열을 정수로 변환하기  

---

## 확장 가능성 고려
1. 승리 조건 변경 또는 추가
2. 전진/멈춤 조건 변겅 또는 추가

## 클래스 다이어그램
<img width="950" alt="2주차 미션 클래스 다이어그램" src="https://github.com/user-attachments/assets/d8de7c52-462a-43c5-8ad1-71d4582eb548">
