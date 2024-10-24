# java-racingcar-precourse

## 구현 기능 목록

- 자동차
    - [x] 각 자동차에 이름을 부여한다.
    - [x] 초기 이동 거리를 0으로 설정한다.
    - [x] 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진한다. (자신의 위치를 +1 증가시킨다.)


- 자동차 경주
    - [x] 경주에 참가하는 자동차를 등록한다.
    - [x] 한 라운드의 경주를 진행한다.
    - [ ] 모든 라운드의 경주를 진행한다.
    - [x] 한 라운드의 경주 결과를 반환한다.
    - [x] Randoms의 pickNumberInRange()를 활용하여 자동차 이동 조건을 반환한다.
    - [ ] 게임을 완료한 후, 우승자를 선정한다. (우승자는 여러 명일 수 있다)


- 입력
    - [ ] 경주할 자동차 이름을 쉼표를 기준으로 구분하여 입력 받는다.
      (Console의 readLine()을 활용한다)
    - [ ] 경주 시도 횟수를 입력 받는다.


- 출력
    - [ ] 차수별 실행 결과를 출력한다.
    - [ ] 우승자 안내 문구를 출력한다.


- 입력값 분리
    - [ ] 입력값을 쉼표를 기준으로 분리한다.


- 예외 처리
    - [x] 자동차 이름이 5자 이하가 아닐 경우, 예외를 발생시킨다.
    - [x] 자동차 이름이 빈 문자열일 경우, 예외를 발생시킨다. (ex. "")
    - [x] 자동차 이름에 공백이 들어갈 경우, 예외를 발생시킨다.
    - [ ] 자동차 이름이 중복될 경우, 예외를 발생시킨다.
    - [ ] 참가자가 10명보다 많을 경우, 예외를 발생시킨다.
    - [ ] 경주 시도 횟수가 50회보다 많을 경우, 예외를 발생시킨다.