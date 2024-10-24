# java-racingcar-precourse

# 요구사항 명세서

## 기능 요구 사항

사용자가 입력한 횟수 동안 n대의 자동차가 전진 또는 멈출 수 있는 초간단 자동차 경주 게임을 구현한다.

1. **사용자 입력**
    - [x] 사용자가 경주 진행 횟수 n을 입력한다.
      - 단, 이때 반드시 양수를 입력해야하며, 0 ~ 2,147,483,647 범위의 값을 입력받을 수 있다.
    - [x] 각 자동차에는 영문자, 한글, 숫자로만 이루어진 이름을 부여할 수 있다.
      - 자동차 이름은 쉼표(,)를 기준으로 구분하며, 이름은 5자 이하만 가능하다.

2. **자동차 이동**
    - [x] 입력한 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
      - 자동차가 전진하는 조건은 0에서 9 사이의 무작위 정수값을 구한 후, 해당 값이 4 이상(4~9)일 경우이다.
      - 자동차가 정지하는 조건은 0에서 9 사이의 무작위 정수값을 구한 후, 해당 값이 3 이하(0~3)일 경우이다.
    - [x] 전진하는 자동차를 출력할 때 자동차 이름도 함께 출력한다.
      - 전진하는 자동차를 출력하는 순서는 사용자가 입력한 순서대로 출력한다.

3. **우승자 안내**
    - [ ] 자동차 경주 게임이 완료된 후, 누가 우승했는지를 알려준다.
      - 우승자는 한 명 이상일 수 있으며, 여러 명일 경우 쉼표(,)로 구분한다.

4. **예외 처리**
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
      - [x] 자동차의 이름에 영문자, 한글, 숫자를 제외한 다른 문자가 포함될 경우
      - [x] 자동차의 이름이 5자를 초과할 경우
      - [x] 사용자가 입력하는 경주 진행 횟수가 0 ~ 2,147,483,647 범위를 초과할 경우
      - [x] 사용자가 입력하는 경주 진행 횟수가 정수가 아닌 실수일 경우
    - 애플리케이션은 종료되어야 한다.

## 입출력 예시

### 입력
- **자동차 이름**
    - 형식: `pobi,woni,jun`

- **시도할 횟수**
    - 형식: `5`

### 출력
- **차수별 실행 결과**
    - 예시:
      ```
      pobi : --
      woni : ----
      jun : ---
      ```

- **단독 우승자 안내 문구**
    - 예시: `최종 우승자 : pobi`

- **공동 우승자 안내 문구**
    - 예시: `최종 우승자 : pobi, jun`

### 실행 결과 예시

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