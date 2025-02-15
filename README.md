# java-racingcar-precourse
## 프리코스 2주 차 - 자동차 경주

## 구현할 기능 목록

- [x] 사용자 입력
    - [x] 자동차 이름
    - [x] 시도할 횟수
    - [x] 이름 예외 처리(5자 초과하는 경우, 공백은 제외하고 계산)
    - [x] 횟수 입력 예외 처리(숫자가 아닐 경우, 0인 경우)
- [x] 자동차 게임
    - [x] 무작위 값 뽑기
    - [x] 무작위 값에 따른 자동차 전진
- [x] 출력
    - [x] 실행 결과 출력
    - [x] 우승자 출력

## 프로그램 동작 순서

![image](https://github.com/user-attachments/assets/e18bc12b-2566-4510-8360-79c946e50105)

## 프로그램 설명
### Car
- 게임을 진행하는 데 필요한 이름과 이동 거리를 Car 클래스의 멤버 변수로 선언하였다.
- move 메서드를 통해 랜덤값을 매개 변수로 받아 만약 `MIN_MOVE_CONDITION` 이상일 경우 `distance`가 1씩 증가하도록 구현
- 이를 통해 랜덤 함수와 분리해 테스트를 진행할 수 있었다.

### RacingGame
- `start`: 게임과 관련한 메서드를 호출한다.
- `nameCheck`: 이름을 하나씩 확인하여 null인 경우, 공백인 경우, 길이가 5를 초과하는 경우 예외를 발생시킨다.
- `countCheck`: 입력받은 횟수가 1보다 작거나 문자인 경우 예외를 발생시킨다.
- `findMoving`: 리스트의 객체마다 `randomNumberPick`을 호출하고 이를 `car.move`에 전달한다. 이 결과를 리스트로 반환한다.
- `randomNumberPick`: 랜덤 함수 호출 코드를 함수로 분리하여 랜덤값을 반환하도록 했다.
- `printGameResult`: 각 게임의 실행 결과를 출력한다.
- `printWinner`: 가장 높은 점수를 가진 차량을 `winner`에 저장하여 이를 바탕으로 동일한 점수를 가진 차량을 리스트에 저장한다. 이후 최종 우승자를 출력한다.

## 실행 결과
![image](https://github.com/user-attachments/assets/572d9990-7f49-4438-a5b1-0a58ad06963f)