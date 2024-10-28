# java-racingcar-precourse

### 요구사항
1. indent의 depth는 3 이하
2. 3항 연산자 사용 X
3. 메서드는 한 가지 일만 하도록 최대한 작게 구현
4. JUnit 5와 AssertJ를 이용하여 테스트 코드 작성
5. Random 값과 입력은 주어진 라이브러리 활용

### 기능 구현

- main 메서드에서 크게 초기화, 실행, 출력으로 파트 구분
  - 초기화 : init, calculateTimes
  - 실행 : run
  - 출력 : printWinners

- init은 사용자의 입력을 통해 자동차의 이름을 key, 전진 횟수를 value로 하는 LinkedHashMap을 활용하여 초기화
- calculateTimes는 사용자의 입력을 통해 이동 횟수를 초기화
- run은 이동 파트와 출력 파트로 나누어지며 moveCars와 printCars가 이를 구현하고 getWinners 메서드로 승자를 반환
  - moveCars는 canMove가 true 시 이동을 담당하며 canMove는 0 ~ 9 사이의 랜덤한 숫자를 뽑아 4 이상이면 true 반환
  - printCars는 출력 포맷에 맞춰 StringBuilder와 repeat을 활용하여 출력
  - getWinners는 getMaxValue로 LinkedHashMap에서 value의 최댓값을 찾고 이 값과 동일한 key의 List를 반환
- printWinners는 파라미터의 winners 리스트를 출력 포맷에 맞춰 출력

### 테스트

- 자동차의 이름이 5자 이하인지에 대한 유효성 검사를 assertThrow로 체크
