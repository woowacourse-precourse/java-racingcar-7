# java-racingcar-precourse

### 1. 사용자 입력 기능
**자동차 이름 입력**: 경주에 참여할 자동차의 이름을 쉼표(,)로 구분하여 입력
  - **제약 사항**: 자동차 이름은 5자 이하, 각 이름은 쉼표로 구분
  - **예외 처리**:
    - 이름이 5자를 초과하는 경우 `IllegalArgumentException`
    - 이름이 비어 있거나 쉼표로 구분되지 않은 경우 `IllegalArgumentException`

**시도 횟수 입력**: 자동차가 이동할 횟수를 입력
  - **제약 사항**: 시도 횟수는 1 이상의 정수
  - **예외 처리**:
    - 입력이 숫자가 아닌 경우 `IllegalArgumentException`
    - 시도 횟수가 1 미만인 경우 `IllegalArgumentException`

### 2. 자동차 이동 기능
  **자동차 전진**: 0～9의 무작위 값을 생성하여 4 이상일 경우、 자동차가 한 칸 전진
  **무작위 값 생성**: `Randoms.pickNumberInRange(0, 9)`로 0에서 9까지의 무작위 값 생성

### 3. 게임 진행 기능
  **라운드 진행**: 입력된 시도 횟수만큼 라운드를 반복하여 모든 자동차를 이동
  **라운드별 출력**: 각 라운드마다 각 자동차의 이름과 현재 위치를 `-`로 표시하여 출력

### 4. 게임 결과 출력 기능
  **우승자 결정**: 시도 횟수 종료 후 가장 멀리 간 자동차(들)를 우승자로 출력
  **우승자 출력 형식**: 단독 우승자는 한 명의 이름, 공동 우승자는 이름을 쉼표(,)로 출력
