# java-racingcar-precourse

## 자동차 경주 게임 구현

## 기능 요구 사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. -> List를 통해 객체 리스트를 생성
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. -> Car 클래스의 carNAme
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. -> RacingCar에서 splite을 통해 입력
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. -> number로 입력받음
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. -> 주어진 라이브러리 camp.nextstep.edu.missionutils.Randoms 사용
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. -> finalWinner()로 구현
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. -> finalWinner() 구현에 조건문으로 구현
8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다. -> Car 클래스의 checkLength()로 구현


## 라이브러리
    camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange()
    camp.nextstep.edu.missionutils.Console 의 readLine()

