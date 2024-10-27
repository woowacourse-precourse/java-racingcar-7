# java-racingcar-precourse


# 자동차 경주 게임


---
## 기능 요구 사항

- 초간단 자동차 경주 게임을 구현합니다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있습니다.
- 각 자동차에 이름을 부여할 수 있습니다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력합니다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 합니다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우입니다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려줍니다. 우승자는 한 명 이상일 수 있습니다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분합니다.
- 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시키고 애플리케이션은 종료되어야 합니다.

---

## 입출력 요구 사항

### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
  - 예: `pobi,woni,jun`
- 시도할 횟수
  - 예: `5`

### 출력
- 차수별 실행 결과
  - 예시: 
    ```
    pobi : --
    woni : ----
    jun : ---
    ```
- 단독 우승자 안내 문구
  - 예: `최종 우승자 : pobi`
- 공동 우승자 안내 문구
  - 예: `최종 우승자 : pobi, jun`

---

## 구현 기능 목록

### 1. 입력 기능
- [ ] 경주할 자동차 이름을 쉼표(,) 기준으로 입력받는다.
  - [ ] 각 자동차의 이름은 5자 이하로 제한한다.
  - [ ] 잘못된 입력(5자 초과 이름) 시 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
- [ ] 사용자로부터 시도 횟수를 입력받는다.
  - [ ] 시도 횟수는 정수여야 하며, 정수가 아닌 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
- [ ] `camp.nextstep.edu.missionutils`의 `Randoms.pickNumberInRange()`를 사용하여 무작위 값 추출
- [ ] `camp.nextstep.edu.missionutils.Console.readLine()`을 사용하여 사용자 입력 처리

### 2. 자동차 경주 기능
- [ ] 주어진 시도 횟수 동안 모든 자동차가 전진 또는 멈춤을 결정한다.
  - [ ] 0에서 9 사이의 무작위 값을 생성하여 4 이상인 경우에만 자동차가 전진한다.
  - [ ] 각 자동차의 진행 상태를 출력할 때 자동차의 이름도 함께 출력한다.

### 3. 우승자 판별 기능
- [ ] 게임이 종료된 후 가장 많이 전진한 자동차를 우승자로 판별한다.
- [ ] 우승자가 여러 명일 경우, 우승자 이름을 쉼표로 구분하여 표시한다.

### 4. 결과 출력 기능
- [ ] 매 시도마다 각 자동차의 이름과 전진 상태를 출력한다.
- [ ] 최종 우승자를 출력한다.
  - [ ] 단독 우승자의 경우 "최종 우승자 : [우승자]" 형식으로 출력한다.
  - [ ] 공동 우승자가 있을 경우 "최종 우승자 : [우승자1, 우승자2]" 형식으로 출력한다.

### 5. 예외 처리
- [ ] 잘못된 입력이 발생한 경우 `IllegalArgumentException`을 발생시키고, 적절한 오류 메시지를 출력한다.
- [ ] `System.exit()`를 사용하지 않고 예외 처리를 통해 프로그램을 안전하게 종료한다.

---
