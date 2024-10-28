# java-racingcar-precourse

### 기능 명세

1. 입력 처리

- [x] n대의 자동차 이름을 입력받는다.
    - [x] 자동차 이름은 쉼표로 구분된다.
- [x] 몇번 이동할 것인지 입력받는다.
- [x] 입력 받은 값으로 레이싱 게임을 세팅한다.
- [x] 사용자가 설정한 이동 횟수만큼 라운드가 진행되며, 각 라운드마다 자동차는 랜덤하게 전진한다.
    - [x] 전진 조건: 0~9 사이 무자기 값을 구한 후, 그 값이 4 이상일 경우
    - [x] 각 라운드마다 실행 결과를 출력한다.
- [x] 모든 라운드를 마치면 우승자를 결정한다.
    - [x] 가장 많이 이동한 자동차가 승리한다.
- [x] 우숭자를 화면에 출력한다.
    - [x] 우승자가 1명 이상일 경우 쉼표를 이용하여 구분하여 출력한다.

2. 예외처리

- [x] 자동차 입력은 빈 문자열이거나 null일 수 없다.
- [x] 자동차 이름은 5자 이하까지만 가능하다.
- [x] 자동차 입력은 1대 이상이어야 한다.
- [x] 이동 횟수는 빈 문자열이거나 null일 수 없다.
- [x] 이동 횟수 입력은 '숫자'여야 한다.
- [x] 이동 횟수는 1회 이상이어야 한다.

3. 테스트 코드 작성

- [ ] JUnit5와 AssertJ를 이용하여, 기능 목록이 정상적으로 작동하는지 테스트 코드를 작성한다.
    - [ ] 제대로 동작하는 경우
        - [ ] 우승자가 1명인 경우
        - [ ] 공동 우승자가 있는 경우
    - [ ] 예외가 있는 경우
        - [ ] 자동차 입력이 null인 경우
        - [x] 자동차 입력이 공백인 경우
        - [ ] 자동자 이름이 5자 이상인 경우
        - [ ] 아무런 자동차도 경주에 참여하지 않은 경우
        - [ ] 라운드 입력이 null인 경우
        - [ ] 라운드 입력이 공백인 경우
        - [ ] 라운드 입력이 숫자가 아닌 경우
        - [ ] 라운드를 1회 미만으로 설정한 경우

### 요구사항에 기재되지 않아 스스로 판단한 내용

- [ ] 이동 횟수는 1회 이상이어야 한다. 1회 미만으로 입력시 IllegalArgumentException 예외를 발생시킨다.