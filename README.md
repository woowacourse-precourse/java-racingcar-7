# java-racingcar-precourse

<br>

## Requirements

---

### 1. User

- 경주할 자동차 이름을 입력할 수 있다.
    - 1개 이상
    - 구분은 쉼표(,)로 한다.
    - 이름은 5자 이하만 입력할 수 있다.
- 이동 횟수를 입력할 수 있다.

<br>

### 2. System

- 자동차에는 이름을 부여할 수 있다.
    - 이름의 길이는 5자 이하
- 자동차는 두 가지 상태를 가진다.
    - 멈춤 / 전진
- 무작위 값을 뽑을 수 있다.
    - 0 ~ 9 사이
    - 4이상인 경우 자동차는 전진할 수 있다.
    - 자동차 마다 매번 할당한다.
- 실행 결과를 매번 출력해야 한다.
- 경주가 끝나면 우승자를 알려줘야 한다.
    - 우승자는 1명 이상일 수 있다.
    - 여러명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 애플리케이션은 종료되어야 한다.
    - 이때 IllegalArgumentException 발생한다.

<br>
<br>

## Exception Check-List

---

### 1. 자동차 이름 입력

- [ ] 자동차 이름을 하나도 입력하지 않은 경우
- [ ] 구분자가 쉼표(,)가 아닌 경우
- [ ] 글자 사이에 공백이 들어간 경우
- [ ] 이름이 6자 이상인 경우
- [ ] 중복된 이름이 있는 경우

<br>

### 2. 시도할 횟수 입력

- [ ] 0 이하의 값을 입력하는 경우
- [ ] 소수점있는 값을 입력하는 경우
- [ ] 숫자 이외의 문자가 들어가는 경우

<br>

### 3. 우승자 출력

- [ ] 우승자가 0명인 경우
- [ ] ~~[Don’t care]공동 우승일 때 출력 순서~~

<br>
<br>

## Domain Logic

---

### 1. Car

| Method          | Parameter | Return Type | Implementation |
|-----------------|-----------|-------------|----------------|
| completedAllLap | -         | boolean     | DONE ✅         |
| myProgress      | -         | String      | DONE ✅         |
| updateProgress  | -         | void        | DONE ✅         |

<br>

### 2. Cars

| Method           | Parameter | Return Type  | Implementation |
|------------------|-----------|--------------|----------------|
| move             | -         | void         | DONE ✅         |
| currentPositions | -         | List<String> | DONE ✅         |

<br>

### 3. MovementCondition : Enum

| Method      | Parameter | Return Type | Implementation |
|-------------|-----------|-------------|----------------|
| getDistance | -         | int         | Done ✅         |

<br>

### 4. MyProgress

| Method             | Parameter | Return Type | Implementation |
|--------------------|-----------|-------------|----------------|
| completedAllLap    | -         | boolean     | Done ✅         |
| toString           | -         | toString    | Done ✅         |
| updateRemainingLap | -         | void        | Done ✅         |
| updatePositionBy   | int       | void        | Done ✅         |

<br>

### 5. Lap

| Method | Parameter | Return Type | Exception                 | Implementation |
|--------|-----------|-------------|---------------------------|----------------|
| minus  | int       | void        | ShouldNotBeMinusException | Done ✅         |

<br>

### 6. Position

| Method               | Parameter | Return Type | Implementation |
|----------------------|-----------|-------------|----------------|
| add                  | int       | void        | Done ✅         |
| generateNextPosition | int       | void        | Done ✅         |

<br>

### 7. Race

| Method        | Parameter | Return Type | Exception                 | Implementation |
|---------------|-----------|-------------|---------------------------|----------------|
| isUnderway    | -         | boolean     |                           | Done ✅         |
| moveToNextLap | -         | void        | ShouldNotBeMinusException | Done ✅         |

<br>

### 8. DashBoard

| Method        | Parameter | Return Type | Implementation |
|---------------|-----------|-------------|----------------|
| showLapCharts | -         | String      | Done ✅         |
| showWinners   | -         | String      | Done ✅         |

<br>

### 9. LapCharts

> 개발 과정에서 추가

| Method | Parameter | Return Type | Implementation |
|--------|-----------|-------------|----------------|
| offer  | String    | void        | Done ✅         |

<br>
<br>

## Domain Logic

---

### 1. RaceService

| Method       | Parameter      | Return Type | Implementation |
|--------------|----------------|-------------|----------------|
| registerCars | String, String | Cars        | Done ✅         |
| startRace    | Lap, Cars      | DashBoard   | Done ✅         |
