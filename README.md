# java-racingcar-precourse

자동차 경주 게임

## 기능 목록

1. **자동차 이름 입력 처리 기능**
    - `InputView.inputCarNames`에서 사용자가 경주할 자동차의 이름을 쉼표(`,`)로 구분하여 입력받아 자동차 객체 리스트로 반환합니다.
    - 이름은 각 자동차마다 5자 이하의 문자열만 허용되며, 이를 벗어나면 `IllegalArgumentException`을 발생시킵니다.

2. **이동 횟수 입력 처리 기능**
    - `InputView.inputAttempts`에서 이동 횟수를 입력받아 정수로 반환합니다.
    - 잘못된 입력 시 `Integer.parseInt`에서 예외가 발생합니다.

3. **자동차 전진 조건 설정**
    - `Race.moveCars`에서 0부터 9 사이의 난수를 생성하고, 값이 4 이상일 때 전진합니다.

4. **경주 실행 및 결과 출력 기능**
    - `Race.start`에서 주어진 횟수 동안 자동차의 전진 여부를 결정하고 `OutputView.printRaceStatus`로 상태를 출력합니다.

5. **우승자 결정 및 출력 기능**
    - `Race.getWinners`에서 가장 멀리 전진한 자동차를 우승자로 선정하며, 공동 우승자는 쉼표로 구분하여 출력합니다.

6. **예외 처리 기능**
    - 자동차 이름의 길이, 이름이 비어있는 경우에 대해 `IllegalArgumentException`이 발생합니다.

## 실행 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

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

최종 우승자 : pobi, jun
```
