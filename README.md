# java-racingcar-precourse

## 과제 진행 요구 사항

- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를 작성한다.

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

#### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```autohotkey
pobi,woni,jun
```

- 시도할 횟수

```undefined
5
```

#### 출력

- 차수별 실행 결과

```ada
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```ada
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```ada
최종 우승자 : pobi, jun
```

#### 실행 결과 예시

```ada
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

## 폴더 구조

```bash
└── racingCar 
    ├── Controller
    │ └── RacingRaceController.java
    ├── Model
    │ └── Car.java
    │ └── Race.java
    │ └── RaceResult.java
    ├── Service
    │ ├── UserInputService.java
    ├── Utils 
    │ └── InputValidator.java
    ├── View
    │ └── RacingCarView.java
    └── Application.java
```

- RacingRaceController.java : Model과 View에 있는 메서드를 호출하여 계산하고 최종
  결과를 출력합니다.
- Car.java : 자동차의 이름과 위치 데이터 정보를 가지고 있습니다.
- Race.java : 자동차 경주를 진행하는 과정의 로직을 구현하였습니다.
- RaceResult.java : Race에서 데이터를 업뎃하여 보내면 최대 거리를 구하여 우승자를 구하는
  객체입니다.
- UserInputService.java : InputValidator 객체에 생성된 메서드를 필요할 때마다 사용하기 위해서 만들었습니다.
- InputValidator.java : 예외 처리 메서드를 모아뒀습니다.
- RacingCarView.java : 입력과 출력 기능을 담당합니다.
- Application.java : 프로그램을 실행합니다.

## 기능 구현 목록

1. 입력 메시지

- 자동차 경주에 참가할 자동차 입력
- 차수별 시도 횟수 입력

2. 출력 메시지

- 자동차 경주 진행 사항을 출력
- 단독 우승자 출력 or 공동 우승자 출력

3. 레이싱 경기

- 레이싱 경기에 참여할 자동차를 선별합니다.
- 차수별 시도 횟수에 따라 레이싱 진행

4. 레이싱 카

- 0 ~ 9까지 랜덤한 값을 반환하는 기능
- 자동차 멈춤 : 무작위 값이 0 ~ 3일 경우
- 자동차 전진 : 무작위 값이 4 ~ 9일 경우

5. 우승자 구하기

- 자동차 최대거리 구하기
- 우승자 1명과 우승자 2명 이상인 경우를 구하기

6. 예외 처리

- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자가 잘못된 값을 입력할 경우IllegalArgumentException을 발생
- 차수별 시도 횟수 입력 시 숫자가 아니면 예외를 발생시킨다.
- 자동차 이름이 문자, 숫자 이외의 것들이 들어갈 시 예외 발생
- 문자열이 null 또는 빈 문자열인지 확인하는 메서드
- 자동차를 2대 이상 입력했는 지 테스트
- 자동차 이름 중복 시 예외 발생

7. 데이터 관리

- 자동차 데이터
- 레이싱 경주 데이터
- 우승자 데이터

8. 단위 테스트

- 문자열 정상 입력 테스트
- 각 예외 발생 확인 테스트


