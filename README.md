# java-racingcar-precourse
# **자동차 경주**

## 구현 기능 목록

### 차량 이름 입력

- [X]  각 차량의 이름이 5자 이하인지 확인하는 기능 구현
    - 예: “john, max, jonathan” → `IllegalArgumentException` 발생
- [ ]  쉼표(,)를 기준으로 구분하여 경주에 포함시키는 기능 구현
- [ ]  지원하지 않는 이름이나 상황이 포함된 경우 예외 처리 
    - [ ]  차량 이름에 중복이 발생한 경우
    - [ ]  숫자나 특수문자가 포함된 이름인 경우
    - [ ]  공백이 포함된 이름인 경우
    - [ ]  차량이 하나뿐인 경우

### 경주 횟수 입력 및 검증

- [ ]  사용자가 이동 횟수를 입력할 수 있도록 구현
- [ ]  입력된 이동 횟수가 정수형인지 확인하고, 정수형이 아닌 경우 예외 발생
- [ ]  이동 횟수가 1 이상이어야 하며, 1 미만의 값이 입력된 경우 예외 발생

### 경주 진행 및 차량 전진

- [ ]  각 차량에 대해 0에서 9 사이의 무작위 숫자를 추출하는 기능 구현
  (`Randoms.pickNumberInRange(0, 9)` 사용)
- [ ]  추출한 값이 4 이상일 때 자동차가 전진하고, 3 이하일 때 정지하는 로직 구현
- [ ]  각 이동 시 차량의 이름과 위치를 출력하는 기능 구현
    - 예: `pobi : --`, `woni : -`

### 우승자 결정 및 출력

- [ ]  경주 종료 후, 각 자동차의 이동 결과를 출력하는 기능 구현
- [ ]  최종 우승자를 결정하는 로직 구현
    - **우승 조건**: 이동 거리 기준으로 가장 멀리 이동한(’-’의 개수가 가장 많은) 차량(들)이 우승자로 결정
- [ ]  우승자가 한 명일 경우, 단독 우승자로 표시
    - 예: `최종 우승자 : pobi`
- [ ]  우승자가 여러 명일 경우, 공동 우승자로 표시
    - 예: `최종 우승자 : pobi, jun`