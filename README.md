# 자동차 경주 구현

## 프로그래밍 요구 사항

* java -version 을 실행하여 Java 버전이 21인지 확인한다.
* 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* ./gradlew clean test 명령을 실행하고 BUILD SUCCESSFUL in 0s 터미널 창이 뜨는지 확인한다.
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

## 🚀 기능 요구 사항

### ❗️초 간단 경주게임을 구현한다

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ❗️입출력 요구사항

### 입력

* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```java
pobi,woni,jun
```

* 시도할 횟수
```java
5
```

### 출럭

* 차수별 실행 결과
```java
pobi : --
woni : ----
jun : ---
```

* 단독 우승자 안내 문구
```java
최종 우승자 : pobi
```

* 공동 우승자 안내 문구
```java
최종 우승자 : pobi, jun
```
* 실행 결과 예시
```java
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


## 🚗 구현 기능 목록

- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력

- [x] 입력값 받기
    - [x] 인풋이 빈값이 들어갈경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.

- [x] 자동차 이름 목록을 문자열 리스트로 저장하기
    - [x] 이름의 길이가 0일경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - [ ] 자동차 이름의 길이가 5자가 넘는경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.

- [x] "시도할 횟수는 몇 회인가요?" 출력

- [x] 시도 횟수 받기
    - [ ] 시도 횟수가 음수일경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - [ ] 시도 횟수가 숫자가 아닌경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.

- [x] 자동차 생성
    - [x] 자동차 이름 생성하기
    - [x] 자동차 이동거리 생성하기
    - [x] 자동차 전진기능 만들기
        - [x] 0 - 9 의 사이에 무작위 값을 구하기 (Randoms.pickNumberInRange(0, 9); 으로 랜덤만들기)
        - [x] 무작위 값이 4 이상일경우 이동거리 +1 증가.

- [ ] 자동차 여러대 생성하기
    - [ ] 자동차 목록 생성하기
    - [ ] 자동차 목록에 자동차를 추가하기
    - [ ] 모든 자동차 라운드 결과 알려주는 기능구현
    - [ ] 우승자 목록 알려주는 기능구현

- [ ] 레이싱 게임
    - [ ] 경주에 참여하는 자동차 생성
    - [ ] 경주에 참여하는 자동차들 생성
    - [ ] 경주에 참여하는 자동차들 전진
    - [ ] 차들의 실행 결과 출력
    - [ ] 우승자 목록 생성
    - [ ] 우승자가 한명일 경우 그대로 출력 혹은 우승자가 여려명일 경우 쉼표를 이용하여 출력
    




