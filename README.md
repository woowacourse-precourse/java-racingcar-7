# 🚗 프리코스 2주차 <자동차 경주>

## ⚙️ 기능 목록

### 📌 자동차 이름 입력 : `getCarNames()`

- `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 문구를 출력합니다.
- 이후, `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 **사용자로부터 자동차 이름**을 입력 받습니다.
    - 자동차 이름은 **5자 이하**만 가능합니다.
- 입력 받은 문자열을 문자열 변수 `carNameInput`에 넣어둡니다.

### 📌 자동차 이름 문자열에서 공백 제거 : `removeBlank()`

- `replaceAll()` 함수를 이용해 앞서 입력 받은 문자열에서 공백을 제거합니다.

### 📌 자동차 이름 추출 : `extractCarNames()`

- `split()` 함수를 이용해 쉽표를 기준으로 자동차 이름을 추출합니다.
- 반환값인 `String` 배열을 `Array.asList`를 사용해 `List`로 변형합니다.

### 📌 시도할 횟수 입력 : `getTryCount()`

- `시도할 횟수는 몇 회인가요?` 문구를 출력합니다.
- 이후, `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 **사용자로부터 시도할 횟수**를 입력 받습니다.
- `readLine()`으로 입력 받은 문자열을 `int`형으로 변환합니다.

### 📌 경주 현황 보드 생성 : `makeRaceStatus()`

- `HashMap<>`을 이용해 `자동차 이름(key) : 전진 횟수(value)` 형식으로 경주 현황을 기록합니다.
- 전진 횟수는 `0`으로 초기화합니다.

### 📌 경주 현황 갱신 : `updateRaceStatus()`

- 각 자동차의 이동 현황을 회차 단위로 갱신합니다.

### 📌 자동차 전진 : `moveCar()`

- 자동차는 전진 또는 정지할 수 있습니다.
- 0에서 9 사이의 난수가 4 이상일 경우, `HashMap<>`의 `전진 횟수(value)`를 1 상승시킵니다.
    - 난수는 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용해 구합니다.

### 📌 전진 로그 기록 : `makeResultLog()`

- 전진 횟수에 맞춰 전진 로그인 `-`를 기록합니다.

### 📌 결과값 출력 문자열 생성 : `makeResultString()`

- 결과값 출력 형식에 맞춰 문자열을 생성합니다.

### 📌 경주 시작 : `startRace()`

- 입력한 시도 횟수에 맞게 경주를 진행합니다.

### 📌 최종 이동 횟수 반환 : `getMoveResult()`

- 자동차들의 최종 이동 횟수를 반환합니다.

### 📌 최대 이동 횟수 구하기 : `checkMaxMoveCount()`

- 자동차들의 최종 이동 횟수를 비교해 가장 큰 값을 구합니다.

### 📌 승자 리스트 생성 : `makeWinnerList`

- 가장 많이 이동한 자동차 이름을 `List`에 담습니다.

### 📌 승자 문자열 반환 : `checkWinner()`

- 승리한 자동차 이름이 담겨있는 `List`의 요소값을 `, `을 사용해 하나의 문자열로 묶어냅니다.

### 📌 승자 출력 : `printWinner()`

- 경주의 결과값으로 승자를 출력합니다.

### 📌 잘못된 입력값 예외처리 : `catchError()`

- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료합니다.
- 잘못된 입력값
  - 자동차 이름이 5자를 초과한 경우
  - 자동차 이름에 빈 문자열을 입력한 경우
  - 자동차 이름이 겹친 경우
  - 시도할 횟수에 숫자 이외의 문자가 포함된 경우