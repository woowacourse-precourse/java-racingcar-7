# 자동차 경주

## 기능 목록

### 1. 자동차 이름과 시도할 횟수를 입력한다.

- [x] 문자열 입력
- [x] 자동차 이름 저장
    - [x] 쉼표(`,`) 기준으로 분리
    - [x] 검증
        - [x] 5자 이하만 가능
        - [x] null, 비어있거나 공백 (예외 발생)
        - [x] 중복 (예외 발생)
- [x] 시도할 횟수 저장
    - [x] 검증
        - [x] 0 또는 자연수만 가능
        - [x] null, 비어있거나 공백 (예외 발생)

### 2. 주어진 횟수 동안 n대의 자동차를 전진 또는 멈춘다.

- [x] 주어진 횟수만큼 반복하여 모든 자동차 이동
    - [x] 자동차 별 0~9 사이의 랜덤값 조회
    - [x] 4 이상이면 전진, 4 미만이면 정지
    - [x] 자동차 이름과 위치 출력

### 3. 우승자를 출력한다.

- [x] 우승자 출력
    - [x] 가장 먼 위치에 있는 자동차 위치 조회
    - [x] 우승 자동차 이름 출력
        - [x] 여러 대 일 경우 쉼표(`,`)를 이용하여 구분

### 예외 처리

- 입력한 문자열 검증 -> `IllegalArgumentException` 후 종료
- 자동차 경주 로직 -> `IllegalStateException` 후 종료

---

## 패키지 구조

### controller

- `RacingCarController`: 전체 흐름 제어

### model

#### car

- `Car`: 개별 자동차 VO
- `Cars`: 여러 자동차들의 일급 컬렉션
- `Name`: 자동차 이름 VO

#### game

- `RacingCar`: 자동차 경주의 핵심 로직
- `Position`: 자동차의 현재 위치 VO
- `Positions`: 여러 자동차의 현재 위치 일급 컬렉션
- `History`: 게임 진행 기록 저장 일급 컬렉션
- `Round`: 시도 횟수 VO
- `MovingStrategy`: 이동 전략 인터페이스
- `RacingCarMovingStrategy`: 이동 전략 구현체

### view

- `InputView`/`ConsoleInputView`: 사용자 입력 처리
- `OutputView`/`ConsoleOutputView`: 게임 결과 출력

### support

- `Splitter`: 문자열 분리 기능
- `NumberComparable`/`IntegerComparable`: 숫자 비교 연산
- `RandomNumberGenerator`/`RandomIntegerGenerator`: 난수 생성
- `StringRepeater`: 문자열 반복 출력 기능

### exception

#### car

- `InvalidNameException`: 자동차 이름 유효성 검증

#### round

- `InvalidRoundException`: 시도 횟수 유효성 검증

#### splitter

- `InvalidDelimiterException`: 문자열 구분자 유효성 검증

#### repeater

- `InvalidCountException`: 반복 횟수 유효성 검증
- `InvalidValueException`: 문자열 유효성 검증

## 설계 고민 사항

### 1. SOLID 원칙을 적용한다.

#### OCP (Open-Closed Principle)

- 전략 패턴을 도입하여 자동차의 이동 로직을 유연하게 변경할 수 있도록 설계
- `MovingStrategy` 인터페이스를 통해 새로운 이동 전략을 추가할 때 기존 코드 수정 없이 확장 가능

#### SRP (Single Responsibility Principle)

- 자동차 이동 정책의 책임을 세분화하여 분리
    - `RandomNumberGenerator`: 랜덤값 생성
    - `NumberComparable`: 숫자 비교
    - `RacingCarMovingStrategy`: 이동 여부

### 2. 객체의 불변/가변 특성을 분리한다.

- `Car` 객체를 **불변(이름, 이동 전략)** 과 **가변(위치)** 특성으로 분리
- `Position`을 가변 객체로 설계하여 상태 변경 시 객체 생성 오버헤드 방지

### 3. 메모리를 최적화한다.

- 경주 기록(`History`) 관리 시 객체 생성을 최소화
    - `Position` 객체: 차량 수만큼만 생성
    - 위치 정보: 원시 타입(`Long`)으로 저장

> `Position`의 가변 특성을 활용하여 불필요한 객체 생성 방지

## 테스트

### 테스트 메서드 명명 규칙

```
[성공/실패]_[테스트대상]_[조건(선택)]
```

### 구성요소

1. 성공/실패

    - 테스트 기대 결과

    - 예: 성공, 실패

2. 테스트대상

    - 테스트하고자 하는 기능이나 메서드명

    - 예: 생성, 계산

3. 조건(선택)

    - 특정 조건이나 시나리오 (선택사항)

    - 예: 음수, 널값, 최대값초과
