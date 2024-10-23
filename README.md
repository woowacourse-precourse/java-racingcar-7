# java-racingcar-precourse

# 자동차 경주

## 기능소개

- 주어진 횟수안에서 확률에 따라 전진하는 자동차 경주 게임

## 패키지구조

- domain
    - Car

- view
    - InputView
    - OutputView

## 기능목록

- [ ] 자동차 전진시키기
- [ ] 우승자 구하기

### 입력

- [ ] 쉼표로 구분된 경주할 자동차 이름 입력
    - [x] 문자열이 null이거나 비어있는 경우 예외처리 - InputHandler#checkEmpty()
    - [x] 중복된 이름이 있으면 예외처리 - InputHandler#validateUniqueNames()
    - [x] 이름이 없거나 5자초과이면 예외처리 - Car#checkNameLength()
    - [ ] 알파벳, 숫자 이외의 문자가 입력되면 예외처리
- [ ] 시도할 횟수 입력
    - [ ] 숫자가 입력되지 않은 경우 예외처리
    - [ ] 1미만의 숫자가 입력되면 예외처리

### 출력

- [ ] 실행 결과 출력
- [ ] 우승자 출력

