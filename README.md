# java-racingcar-precourse

## 요구 사항 ##

### 입력 ###
- 경주할 자동차 조건
  - <b>쉼표(,)</b>로 자동차를 구분
  - 구분된 자동차는 각각 <b>5자 이하</b>
- 횟수 조건
  - N >= 0
- 공통 조건
  - 잘못된 입력 <code>IllegalArgumentException</code> 발생

### 자동차 경주 ###
- 각각의 자동차는 매 횟수마다 <b>무작위 값(0~9)을 구하고, 4 이상</b>일 경우 전진
- 횟수마다 경주의 <b>진행 상황(자동차 이름, 전진단계)을 출력</b>
- N번의 경주가 끝나면 가장 많이 전진한 자동차가 우승
- 최종적으로 우승자를 출력 
- 우승자가 여러 대일 경우, 쉼표(,)로 구분

---

## 구현할 기능 목록 ##
- 자동차 그룹 입력
- 횟수 입력
- 무작위 값 생성
- 자동차 전진
- 진행 상황 출력
- 우승자 출력

<br />

## 책임에 따른 기능 목록 (Commit 단위) ##

### 입출력 ###

- 자동차 문자열 <code>inputCars</code> 을 입력받는다.
- 횟수 <code>n</code>을 입력받는다.
- 경주<code>race</code>를 <code>n</code>번 진행한다.
- 경주<code>race</code>를 종료한다.

### 문자열 분리기 ###

- <b>문자열 분리기 (Separator)</b>
  - 문자열<code>target</code>을 구분자<code>delimiter</code>로 분리<code>separate</code>할 수 있다.

### 자동차 ###

- <b>자동차 검증기 (CarValidator)</b>
  - 자동차의 이름<code>name</code>은 공백 포함 5자 이하이다.
  - 자동차의 이름<code>name</code>이 비어있거나 빈 칸으로 채워져 있다면, <code>IllegalArgumentException</code>을 발생시킨다.

- <b>자동차 (Car)</b>
  - 이름<code>name</code>을 가진다.
  - 전진<code>move</code>할 수 있다.
  - 위치<code>position</code>를 가진다

- <b>경주 자동차 (RacingCar)</b>
  - 전진<code>move</code>할 시, <code>position</code>이 1 증가한다.

### 경주 ###

- <b>경주 (Race)</b>
  - 참여중인 자동차<code>cars</code>를 포함한다.
  - 자동차의 전진 전략<code>RaceMoveStrategy</code>을 포함한다.
  - 참여중인 자동차의 위치<code>position</code>들의 진행 상황을 출력<code>print</code>할 수 있다.
  - 전략<code>RaceMoveStrategy</code>에 맞게 경주를 진행하면서, 조건이 충족하면 참여중인 자동차를 <code>move</code>시킨다.
  - 경주를 완료<code>complete</code>하여 우승자를 정할 수 있다.

### 경주 전진 전략 ###

- <b>랜덤 경주 전략 (RandomRaceMoveStrategy)</b>
  - 무작위 값을 사용해서 <code>move</code>여부를 결정<code>go</code>할 수 있다.
