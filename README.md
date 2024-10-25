# java-racingcar-precourse

## 💡 기능 구현 목록
### 1. 자동차 이름 입력 및 검증
- [X] 자동차 이름 입력받기
  - `Console.readLine()`을 통해 사용자로부터 자동차 이름 목록을 입력받는다.
- [X] 자동차 이름 파싱
  - 쉼표(`,`)를 기준으로 입력된 문자열을 분리하여 각 자동차의 이름을 파싱한다.
  - 각 이름의 앞뒤 공백을 제거한다.
- [ ] 자동차 이름 유효성 검사
  - 이름이 공백 문자열이거나 빈 문자열이면 `IllegalArgumentException`을 발생시킨다.
  - 이름 길이가 5자를 초과하면 `IllegalArgumentException`을 발생시킨다.

### 2. 시도 횟수 입력 및 검증
- [ ] 시도 횟수 입력받기
  - `Console.readLine()`을 통해 사용자로부터 시도 횟수를 입력받는다.
- [ ] 시도 횟수 유효성 검사
  - 입력된 값을 정수로 변환하고 변환할 수 없으면 `IllegalArgumentException`을 발생시킨다.
  - 시도 횟수가 0 미만일 경우 `IllegalArgumentException`을 발생시킨다.

### 3. 게임 실행
- [ ] 자동차 전진 결정
  - Randoms.pickNumberInRange(0, 9)를 호출하여 각 자동차의 전진 여부를 무작위로 결정한다.
  - 무작위 값이 4 이상일 경우 해당 자동차를 한 칸 전진시킨다.
  - 전진 결과를 점수로 반영한다.
- [ ] 차수별 실행 결과 출력
  -  각 차수 종료 후, 현재 차수 기준 모든 자동차의 전진 상태를 출력한다.

### 4. 승자 결정 및 최종 결과 출력
- [ ] 최고 점수 계산
  - 모든 자동차의 점수 중 가장 높은 점수를 계산한다.
- [ ] 우승자 결정
  - 최고 점수와 동일한 점수를 가진 모든 자동차를 우승자로 선정한다.
- [ ] 최종 우승자 출력
  - 우승자가 한 명 이상일 경우, 쉼표(`,`)로 구분하여 우승자 이름을 출력한다.
  - 최종 우승자 안내 문구를 출력 형식에 맞춰 출력한다.

