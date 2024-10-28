# 🏎 🛣 자동차 경주

***

## ⭐️ 핵심 기능

### ✅ 입력 기능

- [x] 경주할 자동차 이름 입력(이름은 쉼표(,) 기준으로 구분, 5자 이하만 가능)
- [x] 시도할 횟수 입력

### ✅ 자동차 이름 추출 기능

- [x] 입력된 문자열을 구분자(쉼표)로 구분해 분리
- [x] 이름 앞뒤의 공백 제거

### ✅ 전진할 자동차 선정 기능

- [x] 0에서 9 사이의 무작위 값 구하기
- [x] 무작위 값이 4 이상인 경우 전진

### ✅ 우승자 계산 기능

- [x] 전진한 횟수가 가장 많은 자동차 채택

### ✅ 출력 기능

- [x] 차수별 실행 결과 출력
- [x] 우승자 안내 문구

### ✅ 예외 처리 기능

- 자동차 이름 입력 시
    - [x] 이름이 5자를 초과하는 경우
    - [x] 쉼표가 없는 경우(자동차 이름을 1개만 입력한 경우)
    - [x] 쉼표와 쉼표 사이에 이름을 입력하지 않은 경우
    - [x] 입력값이 없는 경우
    - [x] 중복이 존재하는 경우


- 시도할 횟수 입력 시
    - [x] 숫자가 아닌 경우
    - [x] 1 미만인 경우
    - [x] 100 초과인 경우
    - [x] 입력값이 없는 경우

***

## 📦 역할별 패키지 분리

### 📁 [domain]

#### - RacingCars

#### - Winning

### 📁 [controller]

#### - RacingCarController

### 📁 [service]

#### - RacingCarService

### 📁 [view]

#### - InputView

#### - OutputView

### 📁 [exception]

#### - CarNameOverLengthLimitException

#### - EmptyCarNameBetweenCommaException

#### - NonNumericException

#### - SingleCarNameException

#### - TryCountException

### 📁 [validator]

#### - Validator

### 📁 [util]

#### - Utility

#### - Delimiter

***

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [x] JDK-21 사용
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`
- [x] `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [x] [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [x] 프로그램 종료 시`System.exit()`를 호출 X
- [x] 프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현(2까지만 허용)
- [x] 3항 연산자 사용 X
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인

### 라이브러리 요구 사항

- [x] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
