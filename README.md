# java-racingcar-precourse
# 자동차 경주
## 🧰 기능 요구 사항

### 자동차 이름 입력
- 자동차 이름이 쉼표로 구분 되어서 입력됨 (✔️)
- 시도할 횟수가 입력됨 (✔️)
- 자동차 이름은 5자 이하만 가능

### 자동차 전진
- 0에서 9 사이의 무작위 값에서 4 이상일 경우 전진 (✔️)
- 시도 횟수만큼 전진 또는 정지를 반복 (✔️)

### 출력 요구 사항
- 매 시도 종료 후 현재 자동차 스코어를 화면에 출력
- 가장 많이 이동한 자동차가 우승
- 우승자가 여러 명일 경우 쉼표로 구분

### 예외 처리 (에러 발생 후 종료)
- 자동차 이름이 5자를 초과할 경우 예외 처리
- 자동차 이름이 공백일 경우 예외 처리
- 자동차 이름이 중복일 경우 예외 처리
- 자동차의 수가 2대 미만일 경우 예외 처리
- 시도할 횟수가 숫자가 아닐 경우 예외 처리
- 시도할 횟수가 0 또는 음수일 경우 예외 처리

---
## 👨‍💻 프로그래밍 요구 사항
### 코드 요구 사항
- indent(depth)를 2까지 허용
- 3항 연산자 사용 X
- 메서드가 한 가지 일만 하도록 작성

### 테스트 요구 사항
- 정리한 기능 목록이 정상적으로 작동하는지 테스트 작성
