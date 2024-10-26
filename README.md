# java-racingcar-precourse

## 기능 목록
> 기능 목록은 최대한 시간 순으로 작성하였습니다. 또한, 가장 직관적으로 이해할 수 있는 범위의 기능을 단위로 설정하였습니다.


- [x] **입력**
  - [x] 자동차 이름을 공백을 제거하고, 쉼표를 기준으로 입력받는다.
  - [x] 몇번의 이동을 할 것인지 입력받는다.

- [x] **출력**
  - [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 안내를 출력한다.
  - [x] "시도할 횟수는 몇 회인가요?" 안내를 출력한다.
  - [x] 실행 결과를 출력한다.
  - [x] 최종 우승자를 출력한다.

- [x] **경기 시작 전**
  - [x] 자동차를 이름을 기준으로 생성하고, 이동거리를 0으로 설정한다.

- [x] **경기시작 후**
  - [x] 이동 횟수 1당 무작위값을 생성하고 값이 4 이상이면 자동차의 이동거리를 1 증가시킨다.
  - [x] 경주 게임을 완료한 후, 가장 높은 거리를 가지고 있는 자동차의 이름을 우승자에 추가한다.


## 리팩토링 목록
- [x] `Input`
  - [x] Console.readLin()에서 Scanner의 자원을 해제하지 않았다. 해제해보자.
  - [x] 정적 메소드로 호출하는 게 나은지, 객체 참조로 불러오는 게 나을지 생각 / 리팩토링

- [x] `View`
  - [x] 정적 메소드로 호출하는 게 나은지, 객체 참조로 불러오는 게 나을지 생각 / 리팩토링

- [x] `CarRegistry` 
  - [x] `CarRegistry`의 생성자를 String input을 그대로 받고 있는데, 이걸 `Set<String>`으로 받는 건 어떤지, 그리고 이걸 만들어주는 클래스를 생성할지, 객체화할지 고민 / 리팩토링
  - [x] `getWinnerNames()` 함수를 줄일 수 있을 것 같다. 줄여보기
  - [x] `CarRegistry`는 게임에서 한번만 사용되고, 한번만 사용되어야 하기 때문에 싱글톤으로 선언
  - [x] `CarRegistry`가 생성과 저장의 역할을 둘 다 하고 있다. 분리하자.
  - [x] 현재 싱글톤으로 리팩토링 되었는데, 확장성을 고려해보고 다시 결정하기

- [x] `Stadium`
  - [x] `StringBuilder`를 필드로 선언하여 사용하고 있는데, 이건 객체지향적인 프로그래밍이 맞는지, 검토 / 수정
  - [x] 랜덤 숫자 생성을 이 클래스에서 맡는게 맞는지, 아니라면 다른 클래스를 만들어서 사용해야 할지 검토 / 수정

- [x] **전역**
  - [x] Application.main에서 객체 생성의 책임을 지는 게 맞을 지, 따로 AppConfig를 빼야할지
  - [x] 각 클래스(객체)의 역할과 책임이 과중되진 않았는지, 객체지향적인 설계가 맞는지 검토

## 최적화

### 테스트 환경 설정
- Warm-up Iterations: 10회
- Main Test Iterations: 2,000회
- 자동차 이동 조건: 랜덤값이 4일 때 전진 (MOVING_FORWARD = 4)

### 측정 케이스
1. 기본 케이스
  - Case 1: 2대의 자동차(pobi,woni), 1라운드
  - Case 2: 3대의 자동차(pobi,woni,jun), 3라운드
  - Case 3: 4대의 자동차(car1,car2,car3,car4), 5라운드

2. 극단적인 케이스
  - 10대의 자동차
  - 30라운드
  - 최대 부하 상황 테스트

### 측정 방법
```java
long startTime = System.nanoTime();
executeTestRun(carNames, rounds, expectedCars);
long endTime = System.nanoTime();
totalElapsedTime += (endTime - startTime) / 1_000_000.0;
```
- System.nanoTime()을 사용하여 나노초 단위로 측정
- 밀리초(ms) 단위로 변환하여 결과 표시

### 최적화 리팩토링 목록
- [x] `StringBuilder` 재사용
- [x] 문자열 연산 최적화
- [x] 입력 검증 정규표현식 활용
- [x] 상수 문자열 분리

### 리팩토링 후, 최적화 전 측정
- 기본 케이스
```text
Case: pobi,woni, Rounds: 1
Average Execution time over 2000 runs: 0.57 ms

Case: pobi,woni,jun, Rounds: 3
Average Execution time over 2000 runs: 0.91 ms

Case: car1,car2,car3,car4, Rounds: 5
Average Execution time over 2000 runs: 1.80 ms
```

- 극단적인 케이스
```text
Extreme Case - Many cars and rounds
Average Execution time over 2000 runs: 31.24 ms
```