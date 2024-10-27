# java-racingcar-precourse

## 2주차 목표

- 자동차 게임 구현 및 테스트 코드 작성
- 1주차 공통 피드백 적용
- 회고

---

## 구현할 기능 목록

- [x] 사용자
    - [x] 경주할 자동차 이름을 입력 한다.
        - 이름은 쉼표(,) 기준으로 구분한다.
    - [x] 시도할 횟수를 입력한다.
- [x] 자동차
    - [x] 이름이 주어진다.
    - [x] 전진한다.
        - 조건은 자동차에 대한 입력 값이 4이상 일 때

## 출력

- [x] 자동차 이름 입력 메시지
- [x] 시도할 횟수 입력 메시지
- [x] 실행 결과 메시지
- [x] 각 차수별 실행
    - 자동차 이름과 전진 횟수(`-`를 사용)
- [x] 우승자
    - 여러 명일 경우 쉼표(,)를 이용하여 구분

## 예외 상황

- [ ] 사용자가 입력한 값이 없는 경우
- [ ] 자동차 이름을 쉽표(,) 기준으로 구분하지 않는 경우
- [x] 자동차 이름이 5자 초과한 경우
- [x] 차동차 이름이 중복된 경우
- [ ] 시도할 횟수가 숫자가 아닐 경우
- [ ] 시도할 횟수가 0 또는 음수일 경우
