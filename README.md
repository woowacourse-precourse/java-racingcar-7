# java-racingcar-precourse
## 기능 요구 사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 예시
### 입력
* 경주할 자동차 이름(이름은 쉼표 `,` 기준으로 구분)
> pobi,woni,jun
* 시도할 횟수
>5

### 출력
* 차수별 실행 결과
> pobi : --\
> woni : ----\
> jun : ---

* 단독 우승자 안내 문구
> 최종 우승자 : pobi

* 공동 우승자 안내 문구
> 최종 우승자 : pobi, jun


## 구현할 기능 목록
### 1. 입력 처리 - InputHandler 클래스
* **자동차 이름 입력 받기**
  * 쉼표로 구분된 이름을 입력 받는다.
  * 이름이 유효한지(5자 이하인지) 검증한다.
  * 잘못된 입력일 경우 `IllegalArgumentException` 발생시킨 후 종료

* **이동 횟수 입력 받기**
    * 시도할 횟수를 입력받는다.
    * 입력 값이 숫자(1~1000 사이)인지 확인한다.
        * 이동 횟수의 범위는 임의로 설정하였다.  
    * 잘못된 입력일 경우 `IllegalArgumentException` 발생시킨 후 종료

* 메서드
    * `List<String> getCarNames()` : 자동차 이름을 입력 받음
    * `List<String> parseCarNames(String input)` : 쉼표로 구분된 문자열을 자동차 이름 배열로 반환
    * `int getMoveCount()` : 이동 횟수를 입력 받음
    * `boolean areAllCarNameLengthsValid(List<String> carNames)` : 이름 유효성(5자 이하) 검사
    * `boolean isValidMoveCount(int moveCount)` : 이동 횟수 유효성 검사
    * 예외 처리 : 유효성 검사 후, 잘못된 입력일 경우 `IllegalArgumentException` 발생

### 구현할 예외 처리 목록
### 자동차 이름 입력
* 자동차의 이름은 최대 5자 (기능 요구 사항)
* ` ` 과 같은 공백 입력 불가
* `,,,`과 같이 구분자로만 이루어진 입력 불가
* `,pobi,`와 같이 구분자 사이에 문자가 없는 입력도 불가
### 이동 횟수 입력
  * 이동 횟수는 1회에서 1000 사이의 수만 가능
  * 수를 입력해야 함. `abc` 같은 문자 입력 불가

### 2. 자동차 클래스 생성 - Car 클래스
* 필드
    * `carName` : 자동차 이름
    * `currentDistance` : 현재 위치(진행한 거리) 

* 생성자
    * `Car(String name)` : 자동차 이름을 초기화  

* 메서드 
    * `boolean canMove()` : 무작위 값에 따라 4 이상이면 true 반환
    * `void move()` : 자동자가 전진할지 멈출지를 결정하는 메서드
        *  `canMove()`가 참이라면 전진 
    * `String getStatus()` : 자동차 이름과 현재위치를 문자열로 반환
    * `int getPosition()` : 현재 자동차의 위치 반환

### 3. 게임 진행 관리 - RacingGame 클래스
* 생성자
    * `RacingGame(List<Car> cars, int moveCount)`

* 메서드
    * `void playTurn()` : 각 자동차의 `move()`를 호출 후 `String getStatus()`로 결과 출력
    * `void playGame()` : `playTurn()`을  `moveCount`번 호출

### 4. 우승자 판별 - WinnerManager 클래스
* RacingGame 클래스에 의존성 주입(DI) 적용하여 구현

* 메서드
    * `List<Car> determineWinners()` : 우승자(또는 공동 우승자) 목록 반환
      * `int getMaxDistance(List<Car> winners)` : 자동차 중 거리의 최댓값 반환 (우승자 결정을 위해 필요함)
    * `boolean isSingleWinner(List<Car> winners)` : 우승자가 한 명인지 여부를 반환
    * `String getWinnerNames(List<Car> winners)` : 단일 우승자이면 이름만 출력, 공동 우승자이면 쉼표로 구분하여 문자열 반환


