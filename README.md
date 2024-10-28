# java-racingcar-precourse

## 1주차 회고

### 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?

~~~
1주차는 작성한 목표의 30%밖에 달성하지 못한거 같습니다.
블로그 글쓰는거에 어려움을 느끼고 있기 때문인거같습니다.
~~~

### 지원서에 작성한 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?

### 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?

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

- [ ] protected Car(String name);
    - 자동차라는 객체 정의
- [ ] private void validateName(String name);
    - 자동차 이름 조건 정의
- [ ] protected void move();
    - 자동차 한칸 움직임
- [ ] private boolean hasMoveCondition();
    - 움직일 수 있는 조건인지 확인

### RacingCar.class

- [ ] private RacingCar(String name);
    - 레이싱카 객체 정의
- [ ] public void create();
    - 정적 팩토리 메소드

### Race.class

- [ ] private Race(List<String> CarNames, int tryCount)
    - 레이스 객체 정의
- [ ] private void playRound();
    - Round 진행
- [ ] public void start();
    - 정적 팩토리 메소드
- [ ] private void validateTryCount()
    - 1회 이상
- [ ] private void printRoundResult();
    - 라운드 결과 출력
- [ ] private List<String> findWinners();
    - 우승자 찾아서 List 반환
- [ ] private void printWinners()
    - 최종우승자 출력

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
