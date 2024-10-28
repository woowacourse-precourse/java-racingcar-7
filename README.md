# java-racingcar-precourse

### 프리코스 2주차 [오예현]

# 🔆 자동차 경주

초간단 자동차 경주 게임을 구현한다.

## ✅ 기능 요구사항

- `n`대의 자동차는 `1칸 전진` or `정지`한다.  


- 전진하는 자동차를 출력할 때 부여한 `자동차 이름`을 같이 출력한다.  


- 자동차 이름은 쉼표 `,`를 기준으로 구분하며 이름은 `5자 이하`이다.  


- 사용자가 `시도할 횟수`를 입력해야 한다.  


- 전진하는 조건 : 0 ~ 9 사이 무작위 값 중 `4 이상`인 경우  


- 게임 완료 후 `우승자`를 출력한다. (한 명 이상 가능)  


- 우승자가 여러 명이면 쉼표 `,`를 이용하여 구분한다.  


- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.  


## ✅ 입출력 요구사항

- 입력 : `경주할 자동차 이름`(`,`로 구분), `시도할 횟수`


- 출력 : `차수별 실행 결과`, `단독 우승자 안내 문구`, `공동 우승자 안내 문구`


- 실행 결과

    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 횟수는 몇 회인가요?
    5

    실행 결과
    pobi : -
    woni :
    jun : -

    pobi : --
    woni : -
    jun : --

    pobi : ---
    woni : --
    jun : ---

    pobi : ----
    woni : ---
    jun : ----

    pobi : -----
    woni : ----
    jun : -----

    최종 우승자 : pobi, jun
    ```

## ☑️ 구현할 기능 목록
- `RacingService` 클래스  

- [X] `자동차 이름`과 `자동차 위치`를 키와 값으로 초기화 하는 함수

- [x] 랜덤 값 생성하는 함수

- [x] 랜덤 값에 따라 이동할 거리를 계산하는 함수

- [x] 자동차 위치를 업데이트하는 함수

- [x] 최대 이동 거리를 가져오는 함수

- [x] 우승자를 가져오는 함수

- [x] 한 턴 실행하는 실행하는 함수

- [x] 이동 횟수만큼 턴을 실행하는 함수


- `RacingIO` 클래스

- [x] 자동차 이름 입력을 위한 안내 문구를 출력하는 함수

- [x] 시도할 횟수 입력을 위한 안내 문구를 출력하는 함수

- [x] 입력 받는 함수

- [x] 레이스 결과를 출력하는 함수

- [x] 턴 결과를 출력하는 함수

- [x] 우승자를 출력하는 함수


- `Validator` 클래스

- [x] 자동차 이름이 고유한지 확인하는 함수

- [x] 자동차 이름의 길이가 5글자 이하인지 확인하는 함수

- [x] 자동차 이름이 공백이 아닌지 확인하는 함수

- [x] 시도할 횟수가 숫자인지 확인하는 함수

- [x] 시도할 횟수가 0 이상인지 확인하는 함수


- `Application` 클래스

- [x] 레이스 게임을 시작하는 함수

# ⭐TDD 개발 방식을 적용하기!
## 1️⃣ **질문**
1. 사용자에게 입력받은 자동차 이름 문자열에서 잘 추출하여 데이터로 보관할 수 있나?
   > 한 대, 여러 대
   
2. 랜덤 값이 올바른 범위에서 생성되나?


3. 조건에 따른 이동 거리 계산이 올바른가?
    > 전진 조건, 정지 조건
4. 자동차 위치가 올바르게 변하나?


5. 우승자를 올바르게 선정하나?
    > 한 명, 여러 명
6. 사용자에게 입력받은 시도 횟수만큼 턴이 제대로 수행되나?


7. 초기 입력이 출력 형식을 준수하나?


8. 각 턴의 실행 결과가 출력 형식을 준수하나?


9. 우승자 결과가 출력 형식을 준수하나?
    > 한 명, 여러 명
10. 자동차 이름이 유효하지 않으면 `IllegalArgumentException`이 발생되나?
    > 5글자 초과, 중복, 공백
11. 시도할 횟수가 유효하지 않으면 `IllegalArgumentException`이 발생되나?
   > 숫자 아님, 음수
## 2️⃣ **응답**
### **1. 사용자에게 입력받은 자동차 이름 문자열에서 잘 추출하여 데이터로 보관할 수 있나?**
```java
class RacingServiceTest {
  private RacingService racingService;

  @BeforeEach
  void setUp() {
    racingService = new RacingService("a,b,c", "4");
  }

  @Test
  @DisplayName("입력받은 여러 자동차가 LinkedHashMap으로 올바르게 생성되는지 확인")
  void 자동차_추출_테스트1() {
    racingService.setCarNameInput("aa,bb,cc");
    assertThat(racingService.getCarPositions()).hasSize(3);
    assertThat(racingService.getCarPositions().keySet()).contains("cc");
  }

  @Test
  @DisplayName("입력받은 한 자동차가 LinkedHashMap으로 올바르게 생성되는지 확인")
  void 자동차_추출_테스트2() {
    racingService.setCarNameInput("aa");
    assertThat(racingService.getCarPositions()).hasSize(1);
    assertThat(racingService.getCarPositions().keySet()).contains("aa");
  }
}
```
`RacingService 생성자`와 `setCarNameInput`, `getCarPositions` 를 찾을 수 없어 테스트에 실패하게 된다.  

=> `RacingService` 클래스에 테스트를 위해 임의로 `carNameInput`을 설정하는 ` setCarNameInput`와 각각의 자동차 이름과 위치를 담는 `carPositions`를 가져오는 `getCarPositions`를 만들어주어 해당 테스트가 `green`을 띄도록 해준다.  
```java
public class RacingService {
  private final HashMap<String, Integer> carPositions = new HashMap<>();
  private static final String CAR_INPUT_DELIMITER = ",";
  private static final int INITIAL_POSITION = 0;

  private final int maxTurn;

  public RacingService(String carNameInput, String maxTurnInput) {
    initializeCars(carNameInput);
    this.maxTurn = Integer.parseInt(maxTurnInput);
  }

  private void initializeCars(String carNameInput) {
    for (String carName : carNameInput.split(CAR_INPUT_DELIMITER)) {
      carPositions.put(carName, INITIAL_POSITION);
    }
  }

  public void setCarNameInput(String carNameInput) {
    carPositions.clear();
    initializeCars(carNameInput);
  }

  public HashMap<String, Integer> getCarPositions() {
    return new HashMap<>(carPositions);
  }
}
```
생성자를 통해 `carNameInput`과 `maxTurnInput`을 입력받는다.  

`carNameInput`을 `split` 해서 `carName`과 `carPosition`을 키와 값으로 `LinkedHashMap`에 담아주는 `initializeCars` 메서드를 생성하여 생성자 안에서 호출한다.  
> **_[🔥짚고 넘어갈 부분!!]_**
>
> _-`HashMap`을 선택한 이유_  
> _키와 값을 쌍으로 저장하기 위하여 `HashMap`으로 정하였다. 근데 추후에 `LinkedHashMap`으로 변경된다._  
> _(`HashMap`은 저장을 하며 순서를 기억하지 않아 순서가 임의로 바뀔 수도 있다. 나중에 우승자 출력이 여러 명일 때, 입력받은 순서를 기억하여 그 순서대로 출력하기 위해 `LinkedHashMap`로 변경하게 되었다.)_
>
> _-`getCarPositions`에서 새로운 `HashMap` 반환하는 이유_  
> _`carPositions`를 그대로 return하게 되면, 주소값이 전달되므로 불변성에 문제가 생길 수 있다. 따라서 새로운 객체를 반환하여 불변성을 유지하였다._  
### **2. 랜덤 값이 올바른 범위에서 생성되나?**
```java
class RacingServiceTest {
...
  @Test
  @DisplayName("랜덤 값이 올바른 범위(0-9)에 있는지 확인")
  void 랜덤_값_테스트() {
    int result = racingService.createRandomValue();
    assertThat(result).isBetween(0, 9);
  }
}
```
`createRandomValue`를 찾을 수 없어 테스트에 실패하게 된다.  

=> `RacingService` 클래스에 랜덤 값을 생성하는 `createRandomValue`를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingService {
...
  private static final int RANDOM_MIN = 0;
  private static final int RANDOM_MAX = 9;

  public int createRandomValue() {
    return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
  }
}
```
`RANDOM_MIN`과 `RANDOM_MAX` 사이 랜덤 값을 생성해 주어 반환한다.
### **3. 조건에 따른 이동 거리 계산이 올바른가?**
```java
class RacingServiceTest {
...
  @Test
  @DisplayName("전진 조건에 따른 이동 거리 계산이 올바른지 확인")
  void 이동_거리_테스트1() {
    int result = racingService.calculateMoveDistance(5);
    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("정지 조건에 따른 이동 거리 계산이 올바른지 확인")
  void 이동_거리_테스트2() {
    int result = racingService.calculateMoveDistance(1);
    assertThat(result).isEqualTo(0);
  }
}
```
`calculateMoveDistance`를 찾을 수 없어 테스트에 실패하게 된다.  

=> `RacingService` 클래스에 이동 거리를 계산하는 `calculateMoveDistance`를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingService {
...
  private static final int MOVE_THRESHOLD = 4;
  private static final int MOVE_STEP = 1;
  private static final int STOP_STEP = 0;

  public int calculateMoveDistance(int randomValue) {
    if (randomValue >= MOVE_THRESHOLD) {
      return MOVE_STEP;
    }
    return STOP_STEP;
  }
}
```
`randomValue`를 받아 `4`이상이면 `1`(전진할 거리), `4` 미만이면 `0`(전진할 거리) 을 반환한다.
### **4. 자동차 위치가 올바르게 변하나?**
```java
class RacingServiceTest {
...
  @Test
  @DisplayName("자동차의 위치가 올바르게 변하는지 확인")
  void 자동차_위치_테스트() {
    int beforePosition = racingService.getCarPositions().get("a");
    racingService.moveCar("a", 4);

    assertThat(racingService.getCarPositions().get("a")).isGreaterThan(beforePosition);
  }
}
```
`moveCar`를 찾을 수 없어 테스트에 실패하게 된다.

=> `RacingService` 클래스에 `carName`과 `randomValue`를 받아 해당하는 거리만큼 이동하는 `moveCar`를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingService {
...
  public void moveCar(String carName, int randomValue) {
    int moveDistance = calculateMoveDistance(randomValue);
    carPositions.put(carName, carPositions.get(carName) + moveDistance);
  }
}
```
`calculateMoveDistance`를 통해 `randomValue`로부터 이동할 거리를 받고, `carName`에 이동할 거리를 더해준다.
> **_[🔥짚고 넘어갈 부분!!]_**
>
> _-`carPositions`에 `put`해도 되나?_  
> _`hashMap`은 중복된 키를 가질 수 없으므로 `carName`과 `carPosition` 데이터를 넣어도 `hashMap`에 추가되는 것이 아닌, 기존의 `carName` 값에서 새로운 값으로 업데이트된다._
### **5. 우승자를 올바르게 선정하나?**

```java
class RacingServiceTest {
...
  @Test
  @DisplayName("최대 이동 거리를 가진 한 명의 사람을 우승자로 올바르게 반환하는지 확인")
  void 한_명의_우승자_테스트() {
    racingService.moveCar("a", 4);
    racingService.moveCar("b", 2);
    racingService.moveCar("c", 1);

    String[] result = racingService.getWinners();
    assertThat(result).containsExactly("a");
  }

  @Test
  @DisplayName("최대 이동 거리를 가진 여러 명의 사람을 우승자로 올바르게 반환하는지 확인")
  void 여러_명의_우승자_테스트() {
    racingService.moveCar("a", 4);
    racingService.moveCar("b", 8);
    racingService.moveCar("c", 1);

    String[] result = racingService.getWinners();
    assertThat(result).containsExactly("a", "b");
  }
}
```
`getWinners`를 찾을 수 없어 테스트에 실패하게 된다.

=> `RacingService` 클래스에 우승자를 반환하는 `getWinners`를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingService {
...
  public String[] getWinners() {
    int maxPosition = getMaxPosition();

    Set<String> winners = new HashSet<>();
    for (Map.Entry<String, Integer> carPosition : carPositions.entrySet()) {
      if (carPosition.getValue() == maxPosition) {
        winners.add(carPosition.getKey());
      }
    }
    return winners.toArray(new String[0]);
  }

  private int getMaxPosition() {
    int maxPosition = INITIAL_POSITION;

    for (Integer curPosition : carPositions.values()) {
      if (curPosition > maxPosition) {
        maxPosition = curPosition;
      }
    }
    return maxPosition;
  }
}
```
`carPositions`를 통해 `maxPosition`을 알려주는 `getMaxPosition` 메서드를 생성한다.

`winners`를 담는 `HashSet`을 생성하여 각 `carPosition`이 `maxPosition`인 `carName`을 담아 배열로 변환하여 반환한다.
> **_[🔥짚고 넘어갈 부분!!]_**
>
> _-`HashSet`을 선택한 이유_  
> _키를 저장하고 탐색하기 쉽게 하기 위하여 `HashSet`으로 정하였다. 근데 추후에 `LinkedList`으로 변경된다.  
> (`HashSet`은 저장을 하며 순서를 기억하지 않아 순서가 임의로 바뀔 수도 있다. 나중에 우승자 출력이 여러 명일 때, 입력받은 순서를 기억하여 그 순서대로 출력하기 위해 `LinkedList`로 변경하게 되었다.)_
### **6. 사용자에게 입력받은 시도 횟수만큼 턴이 제대로 수행되나?**
```java
class RacingServiceTest {
...
  @Test
  @DisplayName("입력받은 시도 횟수만큼 턴이 수행되는지 확인")
  void 시도_횟수_확인_테스트() {
    racingService.startRace();
    int result = racingService.currentTurn;

    assertThat(result).isEqualTo(4);
  }
}
```
`startRace`와 `currentTurn`을 찾을 수 없어 테스트에 실패하게 된다.

=> `RacingService` 클래스에 랜덤 값을 생성하는 시도할 횟수만큼 턴이 실행되는 레이스를 시작하는 `startRace`과 현재 턴 횟수를 담는 `currentTurn` 변수를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingService {
...
  private final LinkedList<HashMap<String, Integer>> raceResult = new LinkedList<>();
  public int currentTurn = 0;

  public void startRace() {
    while (currentTurn < maxTurn) {
      raceResult.add(executeTurn());
      currentTurn++;
    }
  }

  private HashMap<String, Integer> executeTurn() {
    for (String carName : carPositions.keySet()) {
      int randomValue = createRandomValue();
      moveCar(carName, randomValue);
    }
    return new HashMap<>(carPositions);
  }
}
```
한 턴동안 모든 자동차의 위치가 업데이트된 `carPosotions`를 반환하는 `executeTurn` 메서드를 생성한다.

`startRace`는 `LinkedList`로 만든 `raceResult`에 각각의 실행 결과인 `executeTurn` 결과를 넣어준다.
### **7. 초기 입력이 출력 형식을 준수하나?**
```java
public class RacingIOTest {
  private RacingService racingService;

  private ByteArrayOutputStream outputStreamCaptor;
  private PrintStream standardOut;

  @BeforeEach
  void setUp() {
    racingService = new RacingService("a,b,c", "4");

    standardOut = System.out;
    outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  void restoresStreams() {
    System.setOut(standardOut);
    System.out.println(getOutput());
  }

  protected String getOutput() {
    return outputStreamCaptor.toString();
  }
}
```
우선 터미널에 출력되는 결과를 확인하기 위해 위의 코드를 작성해 준다.  

(대충 터미널에 입력되는 결과를 중간에 가로채 테스트 코드에서 확인하고, 다 실행한 후에 다시 원래대로 바꿔주는 내용이다.)
```java
public class RacingIOTest {
...
  @Test
  @DisplayName("초기 입력 프롬프트가 출력 형식을 준수하는지 확인")
  void 초기_입력_프롬프트_테스트() {
    RacingIO.promptCarNameInput();
    RacingIO.promptMaxTurnInput();

    assertThat(getOutput()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    assertThat(getOutput()).contains("시도할 횟수는 몇 회인가요?");
  }
}
```
`RacingIO`클래스와 `promptCarNameInput`, `promptMaxTurnInput`을 찾을 수 없어 테스트에 실패하게 된다.

=> `RacingIO` 클래스에 `carName`을 입력받고, 문구를 출력하는 `promptCarNameInput`와 `maxTurn`을 입력 받고, 문구를 출력하는`promptMaxTurnInput` 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingIO {
    private enum Messages {
        CAR_NAME_INPUT_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        MAX_TURN_INPUT_PROMPT("시도할 횟수는 몇 회인가요?"),

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    
    public static void promptCarNameInput() {
        System.out.println(Messages.CAR_NAME_INPUT_PROMPT.getMessage());
    }

    public static void promptMaxTurnInput() {
        System.out.println(Messages.MAX_TURN_INPUT_PROMPT.getMessage());
    }    
}
```
초기 입력에 필요한 문구들을 `enum`을 사용하여 상수로 만들고, 이를 각각 출력한다.
### **8. 각 턴의 실행 결과가 출력 형식을 준수하나?**
```java
public class RacingIOTest {
...
  @Test
  @DisplayName("각 턴의 실행 결과가 출력 형식을 준수하는지 확인")
  void 실행_결과_출력_형식_테스트() {
    LinkedList<HashMap<String, Integer>> raceResult = new LinkedList<>();

    updateAndRecordMovement("a", 4, raceResult);
    updateAndRecordMovement("a", 4, raceResult);
    updateAndRecordMovement("b", 4, raceResult);
    updateAndRecordMovement("c", 1, raceResult);

    RacingIO.printRaceResult(raceResult);

    assertThat(getOutput()).contains("실행 결과");
    assertThat(getOutput()).contains("a : -");
    assertThat(getOutput()).contains("a : --");
    assertThat(getOutput()).contains("b : -");
    assertThat(getOutput()).contains("c : ");
  }

  private void updateAndRecordMovement(String carName, int randomValue, LinkedList<HashMap<String, Integer>> raceResult) {
    racingService.moveCar(carName, randomValue);
    raceResult.add(new HashMap<>(racingService.getCarPositions()));
  }
}
```
`printRaceResult`를 찾을 수 없어 테스트에 실패하게 된다.

=> `RacingIO` 클래스에 `raceResult`를 출력 형식에 맞게 출력하는 `printRaceResult`를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingIO {
  private enum Messages {
    CAR_NAME_INPUT_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MAX_TURN_INPUT_PROMPT("시도할 횟수는 몇 회인가요?"),
    TURN_RESULT_PROMPT("실행 결과");
        ...
  }

  public static void printRaceResult(LinkedList<HashMap<String, Integer>> raceResult) {
    System.out.println();
    System.out.println(Messages.TURN_RESULT_PROMPT.getMessage());

    for (HashMap<String, Integer> turnResult : raceResult) {
      printTurnResult(turnResult);
      System.out.println();
    }
  }

  private static void printTurnResult(HashMap<String, Integer> turnResult) {
    turnResult.forEach((carName, carPosition) ->
            System.out.println(carName + " : " + "-".repeat(carPosition))
    );
    System.out.println();
  }
}
```
`enum`에 `TURN_RESULT_PROMPT`를 추가해 준다.

각 턴을 담는 `raceResult`를 순회하며, 턴 결과를 `이름 : --` 형식으로 출력해 주는 `printTurnResult`를 호출하는 `printRaceResult`를 생성한다.
### **9. 우승자 결과가 출력 형식을 준수하나?**
```java
public class RacingIOTest {
...
  @Test
  @DisplayName("우승자 결과가 출력 형식을 준수하는지 확인")
  void 우승자_출력_형식_테스트() {
    LinkedList<HashMap<String, Integer>> raceResult = new LinkedList<>();

    updateAndRecordMovement("a", 4, raceResult);
    updateAndRecordMovement("b", 4, raceResult);

    RacingIO.promptWinner(racingService.getWinners());

    assertThat(getOutput()).contains("최종 우승자 : a, b");
  }

  @Test
  @DisplayName("우승자가 여러 명일 때 우승자 입력 순서대로 출력하는지 확인")
  void 우승자_출력_순서_테스트() {
    racingService.setCarNameInput("a,aa,aaa");
    LinkedList<HashMap<String, Integer>> raceResult = new LinkedList<>();

    updateAndRecordMovement("a", 4, raceResult);
    updateAndRecordMovement("aa", 4, raceResult);
    updateAndRecordMovement("aaa", 4, raceResult);

    RacingIO.promptWinner(racingService.getWinners());

    assertThat(getOutput()).contains("최종 우승자 : a, aa, aaa");
  }
}
```
`promptWinner`를 찾을 수 없어 테스트에 실패하게 된다.

=> `RacingIO` 클래스에 우승자를 출력 형식대로 출력하는 `promptWinner`를 생성하여 해당 테스트가 `green`을 띄도록 해준다.
```java
public class RacingIO {
  private static final String WINNER_DELIMITER = ", ";

  private enum Messages {
    CAR_NAME_INPUT_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MAX_TURN_INPUT_PROMPT("시도할 횟수는 몇 회인가요?"),
    TURN_RESULT_PROMPT("실행 결과"),
    WINNER_PROMPT("최종 우승자 : ");
        ...
  }

  public static void promptWinner(String[] winners) {
    String joinedWinners = String.join(WINNER_DELIMITER, winners);
    System.out.println(Messages.WINNER_PROMPT.getMessage() + joinedWinners);
  }
}
```
`enum`에 `WINNER_PROMPT`를 추가해 준다.

우승자를 담는 배열 `winners`에 `WINNER_DELEMITER`로 `join`하여 출력해 준다.
> **_[🔥짚고 넘어갈 부분!!]_**
>
> _-`HashMap`과  `HashSet`으로 저장하면 안 됐다!!!_  
> _만약에 자동차 이름이 `a`, `aa`, `aaa`이고 모두 우승자라면 `최종 우승자 : a, aa, aaa`로 출력되지 않고 `최종 우승자 : aa, aaa, a`로 출력되는 것을 확인했다._  
> _찾아보니 `HashMap`과 `HashSet`은 저장을 하며 순서를 기억하지 않아 순서가 임의로 바뀌어 저장될 수도 있었다는 것을 알게 되었다._  
> _예시를 보면 공동 우승자가 발생하면 입력한 순서대로 출력을 하기 때문에, 입력받은 순서를 기억하여 그 순서대로 출력해야 해서 `LinkedHashMap`과 `LinkedList`로 데이터 저장 방식을 바꿔주어 순서를 기억하도록 하였다._
### **10. 자동차 이름이 유효하지 않으면 `IllegalArgumentException`이 발생되나?**
```java
public class ValidatorTest {
  private RacingService racingService;

  @Test
  @DisplayName("자동차 이름이 5글자 초과인 경우")
  void 자동차_이름_유효성_테스트1() {
    assertThatThrownBy(() -> {
      racingService = new RacingService("aaaaaaa,bbbbbbb,ccccccc,ddddddd", "4");
      racingService.startRace();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName(" 자동차 이름이 중복된 경우")
  void 자동차_이름_유효성_테스트2() {
    assertThatThrownBy(() -> {
      racingService = new RacingService("a,a,b,c,d", "4");
      racingService.startRace();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("자동차 이름이 공백인 경우")
  void 자동차_이름_유효성_테스트3() {
    assertThatThrownBy(() -> {
      racingService = new RacingService("a,,,b,,,", "4");
      racingService.startRace();
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
```
발생하는 예외가 `IllegalArgumentException`가 아니어서 테스트에 실패하게 된다.

=> `Validator` 클래스에 자동차 이름을 검사하는 `validateCarName`를 생성하여 `IllegalArgumentException`을 발생시켜 해당 테스트가 `green`을 띄도록 해준다.
```java
public class Validator {
  private static final int MAX_LENGTH = 5;

  private enum ErrorMessage {
    MUST_BE_5_CHARACTERS_OR_LESS("자동차 이름이 5글자 이하여야 합니다."),
    MUST_BE_UNIQUE("자동차 이름이 중복되지 않아야 합니다."),
    MUST_BE_FILLED("자동차 이름이 공백이지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
  }

  public static void validateCarName(LinkedHashMap<String, Integer> carPositions, String carName) {
    validateNotEmpty(carName);
    validateLength(carName);
    validateUnique(carPositions, carName);
  }

  public static void validateMaxTurn(String maxTurn) {
    validateIsNumber(maxTurn);
  }

  private static void validateUnique(LinkedHashMap<String, Integer> carPositions, String carName) {
    if (carPositions.containsKey(carName)) {
      throw new IllegalArgumentException(ErrorMessage.MUST_BE_UNIQUE.getMessage());
    }
  }

  private static void validateLength(String carName) {
    if (carName.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(ErrorMessage.MUST_BE_5_CHARACTERS_OR_LESS.getMessage());
    }
  }
}
```
발생하는 에러 메시지를 `enum`으로 만들어 주고, 각각 조건을 설정하여 유효하지 않으면 `IllegalArgumentException`을 설정한 에러 메시지와 함께 출력하도록 하였다.
```java
public class RacingService {
...
    private void initializeCars(String carNameInput) {
        for (String carName : carNameInput.split(CAR_INPUT_DELIMITER, -1)) {
            Validator.validateCarName(carPositions, carName);
            carPositions.put(carName, INITIAL_POSITION);
        }
    }
}
```
그리고 `RacingService` 클래스에 초기화하는 함수에서 `carName`을 `validateCarName`를 통해 유효성 검사를 하도록 추가해 주었다.

또한 자동차 이름 입력값을 `split`할 때 빈 문자열이면 배열에 포함되지 않아 `split`의 두 번째 인자에 `-1`을 넣어 빈 문자열도 배열에 담기도록 하였다.
### **11. 시도할 횟수가 유효하지 않으면 `IllegalArgumentException`이 발생되나?**
```java
public class ValidatorTest {
...
  @Test
  @DisplayName("시도할 횟수가 숫자가 아닌 경우")
  void 시도할_횟수_유효성_테스트1() {
    assertThatThrownBy(() -> {
      racingService = new RacingService("a,b,c", "a");
      racingService.startRace();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("시도할 횟수가 음수인 경우")
  void 시도할_횟수_유효성_테스트1() {
    assertThatThrownBy(() -> {
      racingService = new RacingService("a,b,c", "-1");
      racingService.startRace();
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
```
발생하는 예외가 `IllegalArgumentException`가 아니어서 테스트에 실패하게 된다.

=> `Validator` 클래스에 시도할 횟수를 검사하는 `validateMaxTurn`를 생성하여 `IllegalArgumentException`을 발생시켜 해당 테스트가 `green`을 띄도록 해준다.
```java
public class Validator {
  private static final int MAX_LENGTH = 5;

  private enum ErrorMessage {
    MUST_BE_5_CHARACTERS_OR_LESS("자동차 이름이 5글자 이하여야 합니다."),
    MUST_BE_UNIQUE("자동차 이름이 중복되지 않아야 합니다."),
    MUST_BE_FILLED("자동차 이름이 공백이지 않아야 합니다."),
    MUST_BE_NUMBER("시도할 횟수가 숫자여야 합니다."),
    MUST_BE_ZERO_OR_MORE("시도할 횟수가 0 이상이어야 합니다.");
    ...
  }

  public static void validateMaxTurn(String maxTurn) {
    validateIsNumber(maxTurn);
  }

  private static void validateIsNumber(String maxTurn) {
    try {
      int maxTurnToInt = Integer.parseInt(maxTurn);
      validateNotNegative(maxTurnToInt);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage());
    }
  }

  private static void validateNotNegative(int maxTurn) {
    if (maxTurn < 0) {
      throw new IllegalArgumentException(ErrorMessage.MUST_BE_ZERO_OR_MORE.getMessage());
    }
  }
}
```
발생하는 에러 메시지를 `enum`으로 만들어 주고, 각각 조건을 설정하여 유효하지 않으면 `IllegalArgumentException`을 설정한 에러 메시지와 함께 출력하도록 하였다.
> **_[🔥짚고 넘어갈 부분!!]_**
>
> _-`try 문` 안에서 error를 `NumberFormatException`이라고 한 이유?_  
> _`validateIsNumber`에서 catch 할 에러에 `Exception e`라고 적고, `validateNotNegative`에서 에러가 발생한다고 하자._
> _그러면 catch가 모든 error를 잡아내므로 `validateNotNegative`에서 발생한 에러를 catch 하여 `MUST_BE_ZERO_OR_MORE` 메시지가 아닌 `MUST_BE_NUMBER` 메시지로 전달될 것이다._   
> _따라서 `NumberFormatException`이라고 명시해 주면 `Integer.parseInt(maxTurn)`으로 발생한 에러만 잡고, `validateNotNegative`에서 던지는 `IllegalArgumentException`은 잡지 못하게 된다._
```java
public class RacingService {
...
    public RacingService(String carNameInput, String maxTurnInput) {
        initializeCars(carNameInput);
        Validator.validateMaxTurn(maxTurnInput);
        this.maxTurn = Integer.parseInt(maxTurnInput);
    }
    ...
}
```
그리고 `RacingService` 클래스의 생성자 함수에서 `maxTurn`을 `validateMaxTurn`를 통해 유효성 검사를 하도록 추가해 주었다.
## 3️⃣ **정제**
```java
public class ValidatorTest {
...
    @ParameterizedTest(name = "{1}")
    @CsvSource({
            "'aaaaaaa,bbbbbbb,ccccccc,ddddddd', 자동차 이름이 5글자 초과인 경우",
            "'a,a,b,c,d', 자동차 이름이 중복된 경우",
            "'a,,,b,,,', 자동차 이름이 공백인 경우"
    })
    void 자동차_이름_유효성_테스트(String carNameInput, String description) {
        assertThatThrownBy(() -> {
            racingService = new RacingService(carNameInput, "4");
            racingService.startRace();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{1}")
    @CsvSource({
            "'a', 시도할 횟수가 숫자가 아닌 경우",
            "'-1', 시도할 횟수가 음수인 경우"
    })
    void 시도할_횟수_유효성_테스트(String maxTurnInput, String description) {
        assertThatThrownBy(() -> {
            racingService = new RacingService("a,b,c", maxTurnInput);
            racingService.startRace();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
```
```java
class RacingServiceTest {
...
    @ParameterizedTest(name = "{3}")
    @CsvSource({
            "'aa,bb,cc', 3, 'cc', 입력받은 여러 자동차를 LinkedHashMap 으로 생성",
            "'aa', 1, 'aa', 입력받은 한 대의 자동차를 LinkedHashMap 으로 생성"
    })
    @DisplayName("자동차 이름 입력에 따라 LinkedHashMap이 올바르게 생성되는지 확인")
    void 자동차_추출_테스트(String carNameInput, int size, String carName, String description) {
        racingService.setCarNameInput(carNameInput);
        assertThat(racingService.getCarPositions()).hasSize(size);
        assertThat(racingService.getCarPositions().keySet()).contains(carName);
    }
...
    @ParameterizedTest(name = "{2}")
    @CsvSource({
            "5, 1, 전진 조건에 따른 이동해야 할 거리 확인",
            "1, 0, 정지 조건에 따른 이동해야 할 거리 확인"
    })
    @DisplayName("전진 및 정지 조건에 따른 이동 거리 계산이 올바른지 확인")
    void 이동_거리_테스트(int randomValue, int expected, String description) {
        int result = racingService.calculateMoveDistance(randomValue);
        assertThat(result).isEqualTo(expected);
    }
...
}
```
`JUnit5`의 `ParameterizedTest`를 사용하여 중복된 패턴을 제거하고 유사한 테스트를 그룹화하였다. 

---
![스크린샷 2024-10-28 212800](https://github.com/user-attachments/assets/f4c31891-2ba2-4449-9be4-8688afc1f666)

모든 테스트케이스를 통과하였다~~~~!!