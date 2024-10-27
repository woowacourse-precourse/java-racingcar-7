# java-racingcar-precourse
## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
````
pobi,woni,jun
````
- 시도할 횟수
````
5
````

### 출력

- 차수별 실행 결과

````
결과 : 6
````

- 단독 우승자 안내 문구
````
최종 우승자 : pobi
````
- 공동 우승자 안내 문구
````
최종 우승자 : pobi, jun
````

### 실행 결과 예시

````
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
````

## 기능 구현 목록
- getStringInput
    - 문자열을 입력받는다.
- isCorrectInput
    - 올바른 문자열인지 확인한다.
    - 예외 상황
      - 특수문자 사용 불가능
      - 쉼표(,)로 시작하거나 끝나는 문자열 불가능
- isTheLengthOfStringLessThanFive
    - 쉼표(,)를 기준으로 잘려진 문자열의 길이가 5 이하인지 확인한다.
- getCountInput
    - 시도할 횟수를 입력받는다.
- addCarName
    - 자동차 이름을 HashMap에 추가한다.
    - 예외 상황
      - 동일한 이름 저장 불가능
- runCarGame
    - 자동차 게임을 진행한다.
- displayGameProgress
  - 게임의 진행 상황을 출력한다.
- getWinner
  - 최종 우승자 목록을 출력한다.


## 로직

1. 문자열을 입력받는다.
2. 올바른 문자열인지 확인한다.
   - 쉼표(,)로 시작하거나 끝나지 않는다.
   - 영어와 숫자, 쉼표(,)로만 이루어져 있다.
   - 올바른 문자열이 아니라면 `IllegalArgumentException` 발생 후 종료
3. 쉼표를 기준으로 잘려진 문자열의 5 이하인지 확인한다.
    - 잘려진 문자열의 길이가 5 초과라면, `IllegalArgumentException` 발생 후 종료
4. 잘려진 문자열을 자동차의 이름을 저장하는 ArrayList에 추가한다.
5. 시도할 횟수를 입력받는다.
6. 시도할 횟수만큼 자동차 게임을 진행한다.
   1. 해당 순서의 자동차의 랜덤 수가 4 이상이라면, 전진한다.
   2. 최댓값을 해당 순서의 이동 순서와 비교한다.
   3. 모든 자동차의 이동이 끝났다면, 해당 횟수의 이동 결과를 출력한다.
7. 자동차들의 이동 거리를 저장한 배열을 순회하며, 최댓값과 이동 거리가 같다면 우승자 정보를 담고있는 ArrayList에 추가한다.
8. 우승자 정보 ArrayList의 크기가 2 이상이라면, 쉼표(,)를 추가하며 우승자를 출력한다.

## 순서도

<img width = "500" alt = "image" src="https://github.com/user-attachments/assets/dc3e5c02-44cf-46f4-bc15-b887363af775">

## 파일 구조

````
└── src
    ├── main
    │   └── java
    │       └── racingcar
    │           ├── Application.java
    │           ├── controller
    │           │   └── RacingCarController.java
    │           ├── domain
    │           │   ├── Game.java
    │           │   └── Input.java
    │           ├── exception
    │           │   └── InputException.java
    │           ├── service
    │           │   ├── GameService.java
    │           │   └── InputService.java
    │           └── view
    │               ├── GameView.java
    │               └── InputView.java
    └── test
        └── java
            └── racingcar
                ├── ApplicationTest.java
                └── Input
                    ├── CorrectInputTest.java
                    └── TheLengthOfStringLessThanFiveTest.java

````