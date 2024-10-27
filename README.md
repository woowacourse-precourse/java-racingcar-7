# ✅ 기능 구현 목록 - 자동차 경주

## 🗂 Model

### `Car`

- [x] 생성 시, `입력 받은 이름`을 검증한다.
  - [x] `이름이 5자 이하가 아닐 경우`, 예외를 발생시킨다.
  - [x] `이름이 공백이거나 null일 경우`, 예외를 발생시킨다.
- [x] 전진할 수 있다.
  - [x] `전진할 경우`, `위치 값`에 `1`을 더한다.

### `Cars` (일급 컬렉션)

- [x] `Car`의 동작을 관리한다.
  - [x] `전진 요청이 들어온 경우`, 담고 있는 각 `Car` 객체에 아래를 수행한다. 
    - [x] `랜덤 값 생성기`에 `무작위 값`을 요청한다.
    - [x] `값이 4 이상일 경우`, 해당 `Car`를 전진시킨다.
- [x] 차수 별 `실행 결과`를 반환한다.
- [ ] `우승자`를 포함한 `최종 결과`를 반환한다.
  - [ ] `우승자`는 `가장 멀리 전진한 자동차`의 `이름`이다. 
  - [ ] `우승자가 여러 명일 경우`, `쉼표(,)로 구분`하여 반환한다.

### `AttemptCount` (시도 횟수)

- [ ] `입력 받은 시도 횟수 값`을 검증한다.
  - [ ] `숫자가 아닐 경우`, 예외를 발생시킨다.
- [ ] `남은 시도 횟수가 0인지 확인`한다.
  - [ ] `남은 시도 횟수가 0일 경우`, True를 반환한다.
- [ ] `횟수 차감 요청이 들어온 경우`, 횟수를 1 차감한다.

### `ExecutionResult` (실행 결과)

- [x] `실행 결과`를 반환한다.
  - [x] `움직인 거리`를 시각화한다.
  - [x] `자동차 이름`과 시각화한 `움직인 거리`를 합친 `문자열`을 반환한다.
- [ ] `Car`를 인자로 생성할 수 있다.
  - [ ] 생성 시 `Car`의 `자동차 이름`과 `움직인 거리`를 주입한다.

### `RandomValueGenerator` (랜덤 값 생성기)
- [x] `무작위 값`을 반환한다.
  - [x] `0에서 9 사이`에서 `무작위 값`을 구한다. 
  - [x] `구한 무작위 값`을 반환한다.

---

## 💻 View

### `InputView`

- [x] `경주할 자동차 이름`을 입력받는다.
  - [x] `입력 요청 문구`를 출력한다.
  - [x] 입력 받은 `문자열`을 `,`로 구분한다.
  - [x] 분리한 `문자열`을 반환한다.
- [x] `시도할 횟수`를 입력받는다.
  - [x] `횟수 입력 요청 문구`를 출력한다.
  - [x] 입력 받은 `문자열`을 반환한다.

### `OutputView`

- [ ] `차수별 실행 결과`를 출력한다.
  - [ ] `자동차 이름`과 `이동한 거리`를 같이 출력한다. 
- [ ] `우승자 안내 문구`를 출력한다.
  - [ ] `단독 우승자 안내 문구`를 출력한다.
  - [ ] `공동 우승자 안내 문구`를 출력한다.

---

## 🗼 Controller

### `RacingController`

- [ ] `InputView`에 `경주할 자동차 이름 입력`을 요청한다.
- [ ] `자동차 이름` 값을 담아 `Cars` 객체를 생성한다.
- [ ] `InputView`에 `시도할 횟수 입력`을 요청한다.
- [ ] `AttemptCount`에 `시도할 횟수` 값을 담는다.
- [ ] `Cars`에 `시도할 횟수만큼 전진`을 요청한다.
  - [ ] `False를 반환받을 때`까지 아래를 반복한다.
    - [ ] `AttemptCount`에 `횟수 차감`을 요청한다.
    - [ ] `Cars`는 각 `Car`에 `전진`을 요청한다.
    - [ ] 반환 받은 `실행 결과`를 `OutputView`에 전달하여 `차수별 실행 결과 출력`을 요청한다.
- [ ] `Cars`에 `우승자 정보`를 요청한다.
- [ ] `OutputView`에 `우승자 정보 출력`을 요청한다.