# 자동차 경주 게임

자동차 경주 게임은 사용자가 입력한 자동차들이 정해진 횟수만큼 경주를 하고, 가장 멀리 이동한 자동차가 우승하는 게임입니다.

## 📁 패키지 목록

```markdown
├── java/
│   ├── racingcar/
│   │   ├── view/
│   │   │   ├── input/
│   │   │   ├── InputView.java
│   │   │   ├── TryCountInput.java
│   │   │   └── RacingGameInput.java
│   │   │   ├── output/
│   │   │   ├── RoundView.java
│   │   │   ├── OutputView.java
│   │   │   ├── RacingRoundView.java
│   │   │   └── RacingGameOutPutView.java
│   │   ├── domain/
│   │   │   ├── car/
│   │   │   ├── Car.java
│   │   │   └── Cars.java
│   │   │   ├── game/
│   │   │   ├── Game.java
│   │   │   ├── RacingGame.java
│   │   │   ├── RacingGameCount.java
│   │   │   └── RacingGameState.java
│   │   ├── controller/
│   │   └── RacingGameController.java
│   └── Application.java

```

## 🚀 기능 구현 목록

**FLOW** : 참가 선수 등록 → 경주 횟수 설정 → 실제 경주 진행 → 우승자 발표

### 1단계: 참가 선수 등록

- [x] 자동차 이름 입력 받기
- [x] 자동차 이름 유효성 검증
    - [x] 자동차 이름이 5자 이하인지 검증
    - [x] 자동차 이름이 공백이 아닌지 검증
    - [x] 자동차 이름이 중복되지 않는지 검증

### 2단계: 경주 횟수 설정

- [x] 경주 시도할 횟수 입력 받기
- [x] 경주 시도 횟수 유효성 검증
    - [x] 시도 횟수가 양의 정수인지 검증
    - [x] 시도 횟수의 숫자 형식이 맞는지 검증

### 3단계: 경주 진행

- [x] 0-9 사이의 무작위 값 생성
- [x] 무작위 값이 4 이상일 경우 전진
- [x] 각 자동차별 이동 거리 기록

### 4단계: 결과 발표

- [x] 각 자동차 실행 결과 출력
    - [x] 자동차 이름과 이동 거리('-' 문자 사용) 표시
- [x] 최종 우승자 선정
    - [x] 가장 멀리 이동한 자동차 찾기
    - [x] 공동 우승자 있을 경우 쉼표(,)로 구분하여 표시

### 5. 예외 처리

- [x] 잘못된 입력에 대한 IllegalArgumentException 처리
    - [x] 자동차 이름 형식 오류
    - [x] 시도 횟수 형식 오류

## 🎯 프로그래밍 요구사항

### 프로그래밍 제약사항

- JDK 21 사용
- 프로그램 실행의 시작점은 Application의 main()
- 제공된 라이브러리만 사용 가능
- System.exit() 사용 금지
- 파일/패키지 이름 변경 및 이동 금지
- Java 코드 컨벤션 준수

### 코드 작성 규칙

1. indent depth는 최대 2까지만 허용
2. 3항 연산자 사용 금지
3. 메서드가 한 가지 일만 수행하도록 구현
4. JUnit 5와 AssertJ를 사용한 테스트 코드 작성

### 사용할 라이브러리

- camp.nextstep.edu.missionutils의 **Randoms**
    - pickNumberInRange(0, 9) 사용하여 무작위 값 생성
- camp.nextstep.edu.missionutils의 **Console**
    - readLine() 사용하여 사용자 입력 받기

## 📋 실행 결과 예시

```markdown
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
yoon, yoo, biny, woo, tech
시도할 횟수는 몇 회인가요?
3

실행 결과
yoon : -
yoo : 
biny : 
woo : -
tech : -


실행 결과
yoon : -
yoo : -
biny : -
woo : --
tech : --


실행 결과
yoon : -
yoo : -
biny : --
woo : ---
tech : --


최종 우승자 :  woo

```