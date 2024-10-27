# java-racingcar-precourse

## 구현할 기능 목록 정의
--- ---
### 경주할 자동차 이름
- [ ] 각 자동차의 이름은 5글자 이하여야 한다.  
  - [ ] **[예외 처리]** 해당 조건을 만족하지 못할 시 IllegalArgumentException 발생시킨 후 프로그램을 종료한다
- [ ] 각 자동차의 이름은 쉼표(,)를 기준으로 구분한다.

### 시도 횟수
- [ ] 사용자에게 시도 횟수를 입력 받는다.
- [ ] 입력 받은 시도 횟수 만큼 자동차의 이동을 시도한다.

### 자동차 경주 게임
- [ ] 각 시도 횟수마다 무작위 값을 구해 각 자동차의 전진 혹은 정지를 결정한다.
    - [ ] 이 때 0에서 9사이에서 무작위 값을 구해, 이 값이 4 이상일 경우에 1회 전진한디.
    - [ ] 무작위 값이 4 미만일 경우 정지한다.
- [ ] 시도 횟수가 끝났을 시 우승자를 결정해야 한다.
    - [ ] 우승자는 1명 이상일 수 있다.
    - [ ] 우승자가 1명 이상일 경우 모든 우승자를 출력한다.
    - [ ] 우승자는 이동거리가 가장 많은 자동차이다.

### 입력
- [X] **[예외 처리]** 모든 입력 값이 빈 값일 시 IllegalArgumentExecption을 발생시킨다.
- [X] 자동차 이름을 입력 받는다
    - [X] 입력 받기 전 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"을 출력한다.
- [X] 시도 횟수를 입력받는다
    - [X] 입력 받기 전 "시도할 횟수는 몇 회인가요?"를 출력한다.
    - [ ] **[예외 처리]** 입력 받은 횟수가 0 이하이면 IllegalArgumentException을 발생시킨 후 프로그램을 종료한다.  
          - 시도 횟수가 0이면 게임이 진행되지 않은 것이고, 음수이면 시도할 수 없기 때문이다.
    - [ ] **[예외 처리]** 입력 받은 값이 숫자가 아니면 IllegalArgumentException을 발생시킨 후 프로그램을 종료한다.
### 출력
- [ ] 각 차수별 각 자동차의 이동 현황을 출력해야 한다.
    - [ ] 각 차수 별 이동 결과를 출력 전 "실행 결과" 문구를 출력한다.
    - [ ] 자동차 이름과 이동 횟수를 표시한다.
        - [ ] 이동 횟수는 누적 전진 횟수를 모두 표시한다. 이때 1회 전진 당 '-'을 하나 표시한다.
        - [ ] 출력 형식은 다음과 같다
            ```
            자동차1_이름 : (자동차1_이동횟수 * '-')  
            자동차2_이름 : (자동차2_이동횟수 * '-')  
            자동차3_이름 : (자동차3_이동횟수 * '-')
            ```
- [ ] 우승자 출력
    - [ ] 우승자로 정해진 자동차를 출력한다.
    - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    - [ ] 출력 형식은 다음과 같다.
      ```
      (단독 우승 시) 최종 우승자 : 우승_자동차1, 
      (공동 우승 시) 최종 우승자 : 우승_자동차1,우승_자동차2,...
      ```