# java-racingcar-precourse

# 기능 목록

## Racingcar (Controller)

- [ ] application()

  racingCar()을 불러오는 함수

-[ ] racingCar()

  자동차 경주를 시작하는 함수

## Service

-[ ] inputCarNames()

  자동차 이름들을 입력받는다.

-[ ] inputAttempt()

  시도할 횟수를 입력받는다.

-[ ] output()

  우승자를 출력한다.

-[ ] Racing()

  자동차 경주에 대한 전반적인 과정을 담고 있다.

-[ ] storeCars()

  입력된 자동차 이름들을 쉽표를 기준으로 구분하여 자동차 리스트에 저장한다.

-[ ] getRandomNum()

  무작위값을 입력받아서 그 값이 4 이상인 경우 해당 자동차를 하나 진전시킨다.

-[ ] printCarForward()

  자동차가 얼마나 전진 했는지 ‘-’를 이용해 프린트한다.

-[ ] findWinner()

  전진한 값에 대해서 최댓값을 가지는 자동차들을 골라 우승자를 가려낸다.

-[ ] checkNameOfCar()

  자동차의 이름이 5자를 넘는지 확인한다. 5자가 넘을 경우 예외처리

## 예외 처리

- 빈 문자가 입력되었을 경우
- 자동차의 이름이 5자 이상일 경우