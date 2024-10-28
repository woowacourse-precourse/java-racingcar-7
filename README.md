# java-racingcar-precourse

## 구현할 기능 목록

### 문자열 입력 메시지 출력

- `System.out.println()`을 이용하여 자동차 이름과 시도 횟수에 대한 문자열 입력을 안내하는 문장을 출력

### 문자열 입력

- `readLine()`을 이용하여 자동차 이름과 시도 횟수에 대한 문자열을 입력받음

  > 예외 처리 사항
  >
  > - 시도 횟수에 정수가 아닌 문자열이 입력된 경우 `IllegalArgumentException` 발생
  > - 시도 횟수에 0 이하의 정수가 입력된 경우 `IllegalArgumentException` 발생

### 자동차 이름 추출

- 쉼표로 구분된 자동차 이름들을 추출

  > 예외 처리 사항
  >
  > - 자동차 이름이 5자 이상으로 입력된 경우 `IllegalArgumentException` 발생
  > - 중복된 이름이 입력된 경우 `IllegalArgumentException` 발생
  > - 자동차 이름에 아무 것도 입력이 되지 않은 경우 `IllegalArgumentException` 발생

### 자동차 전진 또는 정지 구현

- `Randoms.pickNumberInRange(0, 9);`를 이용하여 각 자동차마다 random값 생성
- 각 자동차가 생성한 random값이 4이상인지 판별하여 전진, 정지 여부를 결정
- 위의 두 과정을 사용자가 입력한 시도 횟수만큼 반복

### 우승자 판별

- 각 자동차의 전진 횟수를 비교하여 가장 많은 전진 횟수를 기록한 자동차를 판별

### 결과 출력

- 우승자 판별 결과를 양식에 맞게 출력