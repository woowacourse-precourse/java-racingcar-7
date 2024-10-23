# 자동차 경주

---

## 프로젝트 개요

- 한 칸 씩 움직이는 자동차 경주 게임 입니다.
- 5자 이하의 이름을 쉼표를 기준으로 구분하여 참가 자동차 이름을 입력합니다.
- 총 몇 번의 이동 시도를 할지 횟수를 입력합니다.
- 0에서 9 사이의 무작위 값에서 4 이상의 숫자가 나온 경우 한 칸 이동합니다.
- 총 시도 횟수가 끝난 뒤 가장 멀리 이동한 우승자를 반환합니다.

---

## 구현 기능 목록

### 입력 기능

- InputView 구현
    - 자동차 이름 문자열 입력
    - 시도 횟수 입력

### 출력 기능

- OutputView 구현
    - 자동차 이름 입력 전 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
    - 시도 횟수 입력 전 "시도할 횟수는 몇 회인가요?" 출력
    - 시도 횟수 만큼 경주 상황 출력
    - 최종 우승자 출력

### 자동차 이름 문자열을 처리하는 기능

- CarNameValidator 구현
    - 자동차 이름을 쉼표(,)를 기준으로 구분했는지 확인
        - 만약 다른 구분자를 사용했다면 예외 처리
    - 자동차 이름이 5자 이하인지 확인
        - 만약 6자 이상이라면 예외 처리
    - 자동차 이름이 문자로 되어 있는지 확인
        - 만약 문자가 아닌 기호, 숫자 등이라면 예외 처리

### 무작위 숫자를 반환하는 기능

- RandomGenerator 구현
    - 0에서 9 사이의 무작위 값 반환

### 게임 정보를 처리하는 기능

- GameProgress 구현
    - 자동차 이름과 이동한 칸 수 저장
    - 무작위 숫자가 4 이상일 경우 이동 칸 수 1 증가

### 예외 처리 기능

- 사용자의 입력값 유효성 검사
    - 문제 발생 시 `IllegalArgumentException`를 발생시킨 후 종료

---
