## 🎯 구현 기능 목록

### 📌 자동차 이름 입력

- [x]  자동차의 이름은 5자 이하만 가능하다.
   - [x]  자동차 이름은 쉼표(,)를 기준으로 구분한다.

   ```bash
   경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
   pobi,woni,jun
   ```

   - [x]  사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용


**🚫 입력 예외 처리**

- [x]  구분자로 쉼표(,)가 아닌 다른 문자가 들어올 경우`IllegalArgumentException`
- [x]  이름이 5자를 초과하는 경우`IllegalArgumentException`
- [x]  구분자 앞, 뒤에 이름이 오지 않는 경우`IllegalArgumentException`
- [x]  중복된 차량 이름이 들어올 경우`IllegalArgumentException`

---

### 📌 시도할 횟수 입력

- [x]  몇 번 이동을 할 것인지 입력

   ```bash
   시도할 횟수는 몇 회인가요?
   5
   ```

   - [x]  사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

**🚫 시도할 횟수 예외 처리**

- [x]  숫자 대신 문자가 입력된 경우`IllegalArgumentException`
- [x]  0이나 음수가 입력된 경우`IllegalArgumentException`
- [x]  null 값인 경우`IllegalArgumentException`
- [ ]  int 범위를 초과하는 큰 값인 경우`IllegalArgumentException`

---

### 📌 이동 실행 및 계산

- [x]  전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
   - [x]  Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
   - [x]  `Collection`을 활용해서 이동 거리를 저장

---

### 📌 결과 출력

- [x]  시도할 횟수만큼 이동한 뒤 결과를 출력

   ```bash
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
   ```

   - [ ]  `Collection`에 저장한 이동 거리만큼 출력
- [x]  우승자는 한 명 이상일 수 있다.

   ```bash
   최종 우승자 : pobi
   or
   최종 우승자 : pobi, jun
   ```

   - [x]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분

---

### 📌 프로그래밍 요구 사항

- [x]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
- [x]  3항 연산자를 쓰지 않는다.
- [x]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기

---

## **📃** 기능 명세서

| 기능 | 작업 | 클래스 | 구조 | 설명 |
| --- | --- | --- | --- | --- |
| 입력 | 문자열 입력 받기 | InputView | `View` | 차량 이름, 횟수 입력 받기 |
| 처리 | 전체적인 코드 흐름 관리 | RacingcarController | `Controller` | 입력, 이동 컨트롤러 통제 |
| 처리 | 입력 문자열 객체 전달 | InputController | `Controller` | 입력 문자열 처리 컨트롤러 |
|  | 메시지 상수화 | IOMessage | `enum` | 입,출력 메시지 상수화 |
|  | 메시지 상수화 | VaildatorMessage | `enum` | 예외 처리 메시지 상수화 |
| 입력 | 입력 값 저장 | Input | `Model` | 차량 이름 목록과 이동 횟수 저장 |
| 검증 | 차량 이름 문자열 파싱 | CarNameParser | `Model` | 입력된 차량 이름 문자열을 분리하여 리스트로 반환 |
| 검증 | 차량 이름 유효성 검사 | CarVaildator | `Validator` | 차량 이름이 비어 있거나 중복되지 않는지, 길이 제한을 준수하는지 확인 |
| 처리 | 시도 횟수 유효성 검사 | TryVaildator | `Validator` | 시도 횟수가 유효한 숫자인지 확인 |
| 처리 | 차량 이동 관리 | MoveController | `Controller`  | 이동 조건에 따라 차량 이동을 제어 |
| 처리 | 차량 정보 저장 및 이동 | Car | `Model` | 차량 이름과 이동 거리 상태를 저장하고, 이동 기능 제공 |
| 처리 | 이동 조건 결정 | CarMovement | `Model` | 랜덤 조건에 따라 차량 이동 가능 여부 결정 |
| 처리 | 경주 상태 관리 및 우승자 결정 | Race | `Model` | 전체 차량의 이동 상태를 관리하고, 최종 우승자를 결정 |
| 출력 | 이동 결과 및 우승자 출력 | OutputView | `View` | 차량 이동 결과와 최종 우승자를 출력 |