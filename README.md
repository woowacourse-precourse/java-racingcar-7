# java-racingcar-precourse

## 기능 목록

- 입력을 받는 기능
  - [x] 자동차의 이름을 쉼표를 구분자로 사용하여 나눠받는다.
  - [x] 자동차가 움직임을 시도할 횟수를 입력받는다.
- 자동차 클래스의 기능
  - [x] 자동차 클래스를 생성할 때, 이름을 설정해준다.
  - [x] 파라미터로 받은 값이 4 이상이면 자동차가 앞으로 1칸 전진한다.
  - [x] 현재 자동차의 위치를 반환한다.
  - [x] 현재 자동차의 이름을 반환한다.
- 게임 클래스의 기능
  - [x] 현재 턴을 진행한다.
  - [x] 현재 턴에서의 진행상황을 출력한다.
  - [x] 랜덤 값을 정하고, 자동차에게 값을 넘겨준다.
  - [ ] 모든 턴을 진행한 뒤, 우승자를 배열에 담는다.
  - [ ] 우승자 배열을 가지고 우승자를 출력해준다.
- 예외처리
  - [x] 자동차 이름에 중복이 있으면 `IllegalArgumentException`을 발생시킨다.
  - [x] 자동차 이름이 5자를 넘으면 `IllegalArgumentException`을 발생시킨다.
  - [x] 자동차 이름이 빈칸이면 `IllegalArgumentException`을 발생시킨다.
  - [x] 입력에 ',', 영어, 숫자, 한글 이외에 다른 입력이 들어오면 `IllegalArgumentException`을 발생시킨다.
  - [x] 자동차 갯수가 2대 미만이면 `IllegalArgumentException`을 발생시킨다.
  - [x] 시도 횟수가 1 미만이면 `IllegalArgumentException`을 발생시킨다.
  - [x] 시도 횟수가 숫자가 아니면 `IllegalArgumentException`을 발생시킨다.