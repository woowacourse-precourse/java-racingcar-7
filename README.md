# java-racingcar-precourse

## 기능 구현 목록

---

### 입력 (Input)
- [ ] **자동차 이름 입력**
    - [ ] 쉼표(,)로 구분된 자동차 이름을 입력받기
    - [ ] `camp.nextstep.edu.missionutils.Console.readLine()`을 활용하여 입력 받기
- [ ] **횟수 입력**
    - [ ] 사용자로부터 시도할 횟수 입력받기
    - [ ] `camp.nextstep.edu.missionutils.Console.readLine()`을 활용하여 입력 받기

### 출력 (Output)
- [ ] **과정 출력**
    - [ ] 각 차수별로 자동차의 이름과 전진한 횟수를 '-'로 출력
    - [ ] 진행 상황을 `List<String>` 형태로 저장하여 이후 출력할 수 있도록 구성
- [ ] **최종 우승자 출력**
    - [ ] 단독 우승자 출력: 우승자가 한 명일 경우
    - [ ] 공동 우승자 출력: 우승자가 여러 명일 경우, 쉼표로 구분하여 출력

### 랜덤 숫자 뽑기
- [ ] **랜덤 숫자 생성**
    - [ ] `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)` 사용하여 0~9 사이의 정수 생성
    - [ ] 생성된 숫자가 4 이상이면 전진, 3 이하이면 정지

### 전진 판단 및 결과 저장
- [ ] **전진 판단**
    - [ ] 랜덤 숫자가 4 이상일 경우 해당 자동차가 전진
    - [ ] 랜덤 숫자가 3 이하일 경우 해당 자동차가 정지
    - [ ] 전진 시 해당 자동차의 이름 옆에 '-'가 하나씩 추가됨
- [ ] **전진 결과 저장**
    - [ ] 자동차 이름과 전진 횟수를 `Car 객체` 내부에서 관리
    - [ ] `List<Car>` 형태로 각 차수에서 전진 결과를 추적
    - [ ] Car 객체의 `move()` 메서드를 호출하여 전진 상태를 관리
    - [ ] 게임 종료 후 각 자동차의 전진 상태 출력

### 우승자 계산
- [ ] **최종 전진 거리 계산**
    - [ ] 각 자동차의 최종 전진 거리를 계산
    - [ ] 가장 멀리 간 자동차가 우승자로 선정
    - [ ] 공동 우승자 여부 확인: 동일한 전진 거리를 가진 자동차가 여러 대일 경우 공동 우승자 처리
- [ ] **우승자 출력 로직**
    - [ ] 단독 우승자가 있을 경우 해당 우승자의 이름을 출력
    - [ ] 공동 우승자가 있을 경우 쉼표로 구분하여 이름 출력

### 검증 (Validation)
- [ ] **자동차 이름 검증**
    - [ ] 자동차 이름이 5자 초과이거나 빈 값이 들어왔는지 검증
    - [ ] 특수문자나 공백이 포함되었는지 검증
    - [ ] 이름 중복 여부 검증
- [ ] **횟수 입력 검증**
    - [ ] 횟수가 음수이거나 0인지 여부 검증
    - [ ] 숫자가 아닌 값이 입력되었는지 검증
- [ ] **랜덤 숫자 검증**
    - [ ] 랜덤 숫자가 4 이상인데도 정지하거나, 3 이하인데 전진하는 오류를 방지하는 검증 로직
    - [ ] 추가적인 예외 발생 가능성 검증

### 예외 처리 (Exception Handling)
- [ ] **자동차 이름 예외 처리**
    - [ ] 자동차 이름이 5자 초과이거나 빈 값이 들어왔을 때 `IllegalArgumentException` 발생
    - [ ] 특수문자나 공백이 포함된 경우 예외 처리
- [ ] **횟수 입력 예외 처리**
    - [ ] 횟수가 음수이거나 0일 경우 예외 발생
    - [ ] 숫자가 아닌 값이 입력될 경우 예외 발생
- [ ] **랜덤 숫자 처리 예외**
    - [ ] 랜덤 숫자가 4 이상인데도 정지하거나, 3 이하인데 전진하는 논리적 오류가 발생하지 않도록 예외 처리
    - [ ] **추가 고려사항**: 랜덤 숫자가 정상적으로 생성되지 않았을 경우의 디버깅용 예외 처리

### 테스트 코드 작성
- [ ] **입력 테스트**
    - [ ] 자동차 이름 입력에 대한 테스트 (빈 값, 중복 이름, 5자 초과, 특수문자 포함 등)
    - [ ] 횟수 입력에 대한 테스트 (음수, 0, 숫자가 아닌 값 등)
    - [ ] 입력값이 잘못된 경우 IllegalArgumentException이 발생하는지 검증
- [ ] **랜덤 숫자 테스트**
    - [ ] 랜덤 숫자가 올바르게 생성되고, 전진/정지 여부가 맞는지 테스트
    - [ ] 랜덤 숫자의 범위가 0~9 사이에서 정상적으로 생성되는지 검증
- [ ] **전진 결과 테스트**
    - [ ] 각 차수에서 전진 여부가 올바르게 반영되는지 테스트 (`Car 객체` 상태 확인
    - [ ] `Car 객체`의 전진 상태와 결과가 일치하는지 테스트
- [ ] **우승자 계산 테스트**
    - [ ] 단독 우승자와 공동 우승자를 계산하는 로직이 올바르게 작동하는지 테스트
    - [ ] 우승자가 동일한 거리만큼 이동한 경우 공동 우승자가 제대로 출력되는지 테스트
    - [ ] 우승자 결정 후 최종 결과 출력이 올바르게 작동하는지 테스트  
- [ ] **통합 테스트**
    - [ ] 게임이 시작부터 종료까지 정상적으로 진행되고 결과가 올바르게 출력되는지 테스트
    - [ ] 여러 차수 동안 전진/정지 여부와 최종 우승자를 일관성 있게 출력하는지 확인
- [ ] **예외 처리 테스트**
    - [ ] 잘못된 입력 및 잘못된 동작이 있을 경우 예외가 발생하는지 테스트
    - [ ] 예외 발생 시 적적할 메시지가 출력되는지 테스트