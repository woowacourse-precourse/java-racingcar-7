# java-racingcar-precourse

## 기능 목록

- 경주할 자동차 이름을 입력 받는다.
    - [x] 예외처리 : 빈 값이 입력된 경우
    - [x] 예외처리 : 쉼표로 구분되지 않은 경우
    - [x] 예외처리 : 이름이 5자를 초과하는 경우

- 시도할 횟수를 입력 받는다.
    - [x] 예외처리 : 빈 값이 입력된 경우
    - [x] 예외처리 : 정수가 아닌 경우
    - [x] 예외처리 : 음수인 경우

- 입력된 횟수만큼 이동한다.
    - [x] 0 ~ 9 사이 무작위 숫자를 뽑는다.
    - [x] 4 이상일 경우 전진시킨다.
    - [x] 3 이하일 경우 움직이지 않는다.

- 실행 결과를 출력한다.
    - [x] ${이름} : --- 와 같은 형식으로 출력한다.
    - [x] 이동 문자는 - 로 한다.
    - [x] 이름이 입력된 순서대로 실행 결과를 출력한다.

- 우승자를 확정 후 출력한다.
    - [x] 최종적으로 가장 많이 전진한 자동차(들)를 우승자로 확정한다.
    - [x] 최종 우승자 : ${이름} 형태로 출력한다.
    - [x] 우승자가 여러 명일 경우 쉼표와 띄어쓰기를 이용해 구분한다.(ex) 최종 우승자 : pobi, jun

- 테스트 코드를 작성한다.
    - [ ] 자동차 이름 입력값 테스트
    - [ ] 시도할 횟수 입력값 테스트
    - [ ] 입력값 토큰화 테스트
    - [ ] 자동차 위치 변화 테스트
    - [ ] 우승자 출력 테스트
