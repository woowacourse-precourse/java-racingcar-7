# java-racingcar-precourse

## 구현 목록

### 기능

- [x] 자동차 이름을 쉼표(,)를 기준으로 구분하는 기능
- [x] 전진하는 조건인 0~9 무작위 값 구하기
- [x] 4 이상이면 전진 4 미만이면 정지 기능
- [x] 각 횟수 별로 전진 상태를 기록하는 기능
- [x] 우승자 판별 기능

### 입력

- [x] 사용자 입력 받기
    - [x] 시도할 횟수 입력 (이동 횟수)
    - [x] 경주할 자동차 이름 입력

### 출력

- [x] 경주할 자동차 이름 입력 안내 문구 출력
- [x] 시도할 횟수 입력 안내 문구 출력
- [x] 실행 결과 출력
- [x] 최종 우승자 출력

### 🫨 생각해 볼 예외사항

- [ ] 사용자의 자동차 이름 입력
    - [x] 이름이 중복되는 경우
    - [x] 이름 사이 쉼표가 아닌 다른 문자를 사용한 경우
    - [x] 쉼표를 연속 사용한 경우
    - [x] 이름을 입력하지 않은 경우 - 공백 또는 null
    - [x] 이름을 5자 초과 입력한 경우
    - [ ] 많은 이름을 입력한 경우
- [ ] 사용자의 시도할 횟수 입력
    - [x] 숫자가 아닌 다른 문자를 입력한 경우
    - [ ] 너무 큰 숫자를 입력한 경우
    - [x] 실수 입력한 경우
    - [x] 0 입력한 경우
    - [x] 음수를 입력한 경우