# java-racingcar-precourse

## 중간 회고

### 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?

~~~
1주차는 작성한 목표의 30%밖에 달성하지 못한거 같습니다. 블로그 글쓰는거에 어려움을 느끼고 있기 때문인거같습니다. 하지만 과제 구현에 있어서는 객체지향적 설계를 위해 노력했고, 각 클래스의 역할을 명확히 분리하여 구현했다는 점에서 작은 성과가 있었습니다. 특히 정적 팩토리 메서드를 활용하고 validation 로직을 분리하는 등 코드의 품질을 고려하며 작업했습니다.
~~~

### 지원서에 작성한 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?

```
현재의 목표를 조금 더 과제 중심적으로 변경하고 싶습니다. 블로그 작성보다는 코드 품질과 객체지향적 설계에 더 집중하고 싶습니다. 특히 이번 과제를 진행하면서 클래스 설계와 역할 분담의 중요성을 깨달았습니다. 앞으로는 다음과 같은 부분에 더 집중하고자 합니다:

클래스간 책임과 역할의 명확한 분리
재사용 가능하고 확장성 있는 코드 설계
예외 처리와 validation의 체계적인 구현
```

### 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?

```
자동차 경주 게임을 구현하면서 가장 크게 깨달은 점은 '설계의 중요성'입니다. 처음에는 단순히 기능 구현에만 집중했지만, 점차 각 클래스의 역할과 책임을 고민하게 되었습니다. Car, RacingCar, Race 클래스로 나누어 구현하면서 객체지향적 설계가 코드의 가독성과 유지보수성에 얼마나 큰 영향을 미치는지 체감했습니다. 또한 정적 팩토리 메서드를 사용하면서 객체 생성에 대한 새로운 시각을 얻을 수 있었습니다
```

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 정의

### Car.class

- [X] protected Car(String name);
    - 자동차라는 객체 정의
- [x] private void validateName(String name);
    - 자동차 이름 조건 정의
- [x] public void move();
    - 자동차 한칸 움직임
- [x] private boolean hasMoveCondition();
    - 움직일 수 있는 조건인지 확인

### RacingCar.class

- [X] private RacingCar(String name);
    - 레이싱카 객체 정의
- [X] public void create();
    - 정적 팩토리 메소드

### Race.class

- [X] private Race(List<String> CarNames, int tryCount)
    - 레이스 객체 정의
- [X] private void playRound();
    - Round 진행
- [X] public void start();
    - 정적 팩토리 메소드
- [X] private void validateTryCount()
    - 1회 이상
- [X] private void printRoundResult();
    - 라운드 결과 출력
- [X] private List<String> findWinners();
    - 우승자 찾아서 List 반환
- [X] private void printWinners()
    - 최종우승자 출력

### Application.class

- [x] public static void main(String[] args);
    - 자동차 경주 게임 실행
- [x] private static List<String> setCarNames();
    - 자동차 이름들 입력
- [x] private static int setTryCount();
    - 시도 횟수 입력

## 입출력 요구 사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
```

### 출력

- 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

### 실행 결과 예시

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
