# java-racingcar-precourse
### 구현할 기능 목록

#### 1. 사용자 입력을 받는 기능
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용.
- `Console.readLine()` 메소드를 이용하여 사용자로부터 **자동차 이름**과 **시도 횟수**를 입력받는다.
- 자동차 이름은 쉼표(`,`)를 기준으로 구분한다.
- 시도 횟수는 숫자로 입력받는다.
- 잘못된 입력(이름 길이 초과, 숫자가 아닌 횟수 입력 등) 시 예외를 발생시키고 프로그램을 종료한다.

#### 2. 자동차 이름 검증 기능
- 자동차 이름은 5자 이하여야 한다.
- 이름이 5자를 초과할 경우 예외를 발생시키고 프로그램을 종료한다.

#### 3. 자동차 이동 기능
- 각 자동차는 랜덤하게 움직인다.
- `Randoms.pickNumberInRange(0, 9)`를 사용하여 0에서 9 사이의 수를 랜덤하게 받는다.
- 받은 수가 4 이상일 경우 자동차는 전진한다.
- 자동차의 위치(`position`)를 증가시킨다.

#### 4. 게임 진행 및 결과 출력 기능
- 입력받은 시도 횟수만큼 게임을 진행한다.
- 각 시도마다 모든 자동차의 이동 결과를 출력한다.
- 게임이 종료되면 가장 멀리 간 자동차를 우승자로 출력한다.
- 여러 대의 자동차가 공동 우승할 수 있다.

---

### Application 클래스
- `main` 함수가 위치한 클래스.
- `Racing` 클래스의 `start()` 메소드를 호출하여 게임을 시작한다.

### Racing 클래스

#### public void `start()` 메소드
- 게임을 시작하는 메소드.
- 사용자로부터 자동차 이름과 시도 횟수를 입력받는다.
- 입력받은 이름으로 `Car` 객체들을 생성한다.
- 게임을 진행하고 최종 우승자를 출력한다.

#### private String `getUserName()` 메소드
- 사용자로부터 자동차 이름을 입력받는 메소드.

#### private int `getUserAttempts()` 메소드
- 사용자로부터 시도 횟수를 입력받는 메소드.
- 입력받은 값이 숫자가 아닐 경우 예외를 발생시킨다.

#### private List<Car> `splitCarsName(String namesInput)` 메소드
- 입력받은 자동차 이름 문자열을 쉼표로 구분하여 `Car` 객체 리스트를 생성한다.

#### private void `playGame()` 메소드
- 시도 횟수만큼 게임을 진행하는 메소드.
- 각 시도마다 모든 자동차의 `move()` 메소드를 호출한다.
- 각 시도 결과를 출력한다.

#### private void `printRoundResults()` 메소드
- 각 시도마다 자동차들의 상태를 출력하는 메소드.

#### private int `getMaxPosition()` 메소드
- 가장 멀리 간 자동차의 위치를 반환하는 메소드.

#### private void `printWinners()` 메소드
- 우승한 자동차들의 이름을 출력하는 메소드.

### Car 클래스

#### public `Car(String name)` 생성자
- 자동차의 이름을 설정하는 생성자.
- 이름이 5자를 초과하면 예외를 발생시킨다.

#### public void `move()` 메소드
- 0에서 9 사이의 랜덤 숫자를 생성하여 4 이상일 경우 `position`을 증가시킨다.

#### public String `getName()` 메소드
- 자동차의 이름을 반환한다.

#### public int `getPosition()` 메소드
- 자동차의 현재 위치를 반환한다.

#### public String `toString()` 메소드
- 자동차의 이름과 현재 위치를 `-`로 표시하여 반환한다.

---

**사용 예시:**

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi, crong, honux
시도할 횟수는 몇 회인가요?
5

pobi : -
crong : 
honux : -

pobi : --
crong : -
honux : --

...

최종 우승자 : pobi, honux
```