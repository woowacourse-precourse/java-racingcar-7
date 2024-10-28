# 자동차 경주 게임

## 기능 목록

1. **자동차 생성 및 이동 기능**
    - 사용자가 경주할 자동차 이름을 쉼표(`,`)로 구분하여 입력할 수 있다.
    - 자동차 이름은 최대 5자 이하만 허용된다.
    - 잘못된 이름 입력 시 `IllegalArgumentException`이 발생한다.

2. **시도 횟수 입력 기능**
    - 사용자가 시도할 횟수를 입력할 수 있다.
    - 숫자가 아닌 입력 시 `IllegalArgumentException`이 발생한다.

3. **자동차 전진 여부 결정 기능**
    - 각 자동차는 매 턴마다 0에서 9 사이의 무작위 값을 받는다.
    - 무작위 값이 4 이상일 경우 자동차가 전진한다.

4. **경주 실행 기능**
    - 입력된 시도 횟수만큼 경주를 진행한다.
    - 각 차수마다 자동차의 전진 상태를 출력한다.

5. **우승자 판별 기능**
    - 경주가 끝난 후 가장 멀리 이동한 자동차를 우승자로 결정하여 출력한다.
    - 여러 명의 우승자가 있을 경우 쉼표로 구분하여 출력합니다.

6. **게임 결과 출력 기능**
    - 매 차수의 진행 상태 및 최종 우승자를 출력한다.
