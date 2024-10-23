# java-racingcar-precourse

# 미션 - 자동차 경주

## 🚀 기능 요구 목록
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 🚀 기능 구현
- [X] 입력 문자열 검증
- [X] 자동차 이름 분리
- [X] 랜덤값 검증
- [X] 자동차 전진 여부 확인
- [X] 우승자 계산
- [X] 우승자 출력

## 🚀 구조 설계
racingcar
├── controller
\
│   └── RacingController.java
\
├── model
\
│   ├── dto
\
│   │   ├── Car.java (자동차 객체)
\
│   │   └── RacingResult.java (회당 결과 객체)
\
│   ├── exception
\
│   │   ├── CarNameLengthExceededException.java (이름 5초과 예외)
\
│   │   ├── InvalidAttemptCountException.java (유효하지 않은 횟수 값 예외)
\
│   │   └── MissingInputValueException.java (빈 문자열 예외)
\
│   └── service
\
│       ├── InputService.java (input 값 검증, 예외처리, 문자열 변환)
\
│       └── RacingService.java (racingGame 실행, 결과값 반환, 랜덤 로직)
\
├── view
\
│   ├── InputView.java
\
│   └── OutputView.java
\
└── Application.java

## 🚀 예외 처리
- 잘못된 값 입력되었을 때 IllegalArgumentException을 발생시킨다.
- 빈 문자열일 경우
    - MissingInputValueException(“입력값이 누락되었습니다.”)
- 자동차 이름이 5자보다 클 경우
    - CarNameLengthExceededException(“자동차 이름의 입력값은 최대 5자입니다.”)
- 횟수 입력값 0일때
    - InvalidAttemptCountException("시도할 횟수는 0일 수 없습니다.")
- 자동차가 1개일때
    - InvalidCarCountException("자동차는 1개 일 수 없습니다.")
- 횟수가 숫자가 아닐때
    - InvalidAttemptCountException("시도할 횟수는 숫자여야합니다.")
- 자동차 이름이 중복일 경우
  - DuplicateCarNameException("자동차 이름이 중복될 수 없습니다.")