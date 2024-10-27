# java-racingcar-precourse

# 자동차 경주 게임

## 기능 목록

### 1. 자동차 이름 입력 받기
- 사용자가 경주할 자동차의 이름을 입력할 수 있는 기능
- 자동차 이름은 쉼표(,)로 구분되며, 이름은 5자 이하로 제한
- 유효하지 않은 이름이 입력되면 `IllegalArgumentException`을 발생
- 동일한 이름의 자동차가 있을 경우 `IllegalArgumentException`을 발생
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

### 2. 이동 횟수 입력 받기
- 사용자가 자동차가 이동할 횟수를 입력할 수 있는 기능
- 유효하지 않은 숫자가 입력될 경우 `IllegalArgumentException`을 발생
- 음수나 숫자가 아닌 값이 들어올 경우 `IllegalArgumentException`을 발생
- 정수 범위를 초과하면 `IllegalArgumentException`을 발생
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

### 3. 무작위 이동 결정
- 각 자동차가 매 이동 시 무작위로 0에서 9 사이의 값을 생성
- 생성된 값이 4 이상일 경우 해당 자동차 전진
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

### 4. 이동 결과 출력
- 각 자동차의 이동 결과를 차수별로 출력하는 기능
- 전진한 자동차는 이름과 함께 `-` 기호로 표현되며 이동 횟수에 따라 `-`의 개수가 증가

### 5. 최종 우승자 확인
- 경주가 종료된 후 가장 많은 거리를 이동한 자동차를 우승자로 결정
- 우승자는 한 명 이상
- 우승자가 여러 명일 경우 해당 자동차 이름을 쉼표(,)로 구분하여 출력

### 6. 예외 처리
- 자동차 이름 입력 시
    - 유효하지 않은 이름이 입력되면 `IllegalArgumentException`을 발생
    - 동일한 이름의 자동차가 있을 경우 `IllegalArgumentException`을 발생
- 이동 횟수 입력 시
    - 유효하지 않은 숫자가 입력될 경우 `IllegalArgumentException`을 발생
    - 음수나 숫자가 아닌 값이 들어올 경우 `IllegalArgumentException`을 발생
    - 정수 범위를 초과하면 `IllegalArgumentException`을 발생
- 프로그램 종료 시 `System.exit()` 호출은 사용하지 않음

### 7. 테스트 코드 작성
- JUnit 5와 AssertJ를 이용하여 각 기능에 대한 테스트 코드 작성
- 모든 기능이 요구 사항에 맞게 정상적으로 작동하는지 확인

## 프로그래밍 요구 사항

### 1. 코드 스타일 및 규칙 준수
- 자바 코드 컨벤션을 준수하며 함수(또는 메서드)는 한 가지 일만 하도록 구현한다.
- indent(인덴트) depth를 2 이하로 유지하며 3항 연산자는 사용하지 않는다.

## 추가 사항
- `build.gradle` 파일은 변경하지 않으며 제공된 라이브러리 이외의 외부 라이브러리를 사용하지 않는다.
- 프로그램의 시작점은 `Application`의 `main()` 메서드이다.
