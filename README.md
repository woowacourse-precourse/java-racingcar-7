# [자동차 경주] 구현할 기능 목록

### 입력 `InputView Class`, `Car Class`

- 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용
- **자동차 이름 입력**
    - 입력 설명 : `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - 입력 조건 : 쉼표 (`,`)로 구분, 5자 이하, 중복이름 불가
    - 예외 조건 : 쉼표 2개 이상 연속 입력, 6자 이상 입력, 중복 된 이름
    - ex) `pobi,woni,jun`
- **시도할 횟수 입력**
    - 입력 설명 : `시도할 횟수는 몇 회인가요?`
    - 입력 조건 : 양수, long 범위 이내 입력
    - 예외 조건 : 0 또는 음수 입력, 0 또는 음수가 아니지만 long 변환이 불가능한 값 입력(ex 문자, 빈 값, 특수문자)
    - ex) `5`
- 예외 조건은 `IllegalArgumentException`로 에러 처리

### 자동차 경주 `CarRace Class`, `Car Class`

- 각 자동차 `LinkedHashMap`에 저장 (key: 이름, value: Car Class)
- **자동차 경주 시작**
    1. 각 자동차마다 0~9 사이의 무작위 정수 값을 구하고 4이상인 경우 1 전진

       (무작위 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 사용)
    2. 자동차 경주 진행 사항 `StringBuilder`에 저장
    3. 1,2를 시도할 횟수만큼 반복
- **자동차 경주 종료**
    - 각 자동차 중 가장 많이 전진한 자동차 이름 `StringBuilder`에 전부 저장
    - 게임 진행 순서대로 출력, 우승자 출력
- output이 너무 길어서 `OutOfMemoryError`의 경우 `출력 메모리 초과` 출력
  ```
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

### 테스트
- **입력`InputView` 테스트**
  - 자동차 이름 입력 기능 테스트
  - 자동차 이름 입력 예외 테스트
    - 이름 중복으로 입력
    - 이름을 6자 이상으로 입력
    - 쉼표만 입력
    - 아무것도 입력하지 않음
- **자동차`Car` 테스트**
  - Car의 현재 상태 출력 기능 테스트
- **통합`Applicaiton` 테스트**
  - 정상 기능 테스트
  - 입력 예외 테스트