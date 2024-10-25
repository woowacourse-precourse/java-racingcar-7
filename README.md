# java-racingcar-precourse

# 기능 목록

## Racingcar (Controller)

- [x] main()

  run()을 불러오는 함수

-[x] run()

  자동차 경주를 시작하는 함수

## IO

-[x] inputCars()

  자동차 이름들을 입력받는다.

-[x] inputAttempt()

  시도할 횟수를 입력받는다.

-[x] output()

  우승자를 출력한다.

## race

-[x] racing()

  자동차 경주에 대한 전반적인 과정을 담고 있다.

-[x] storeCars()

  입력된 자동차 이름들을 쉽표를 기준으로 구분하여 자동차 리스트에 저장한다.

-[x] attemptToint()

  String으로 입력받은 시도 휫수를 정수형으로 변환한다.

-[x] playRacingCar()

  무작위 값이 4 이상이면 자동차를 전진시킨다.

-[x] getRandomNum()

  무작위값을 얻는다.

-[x] printCarForward()

  각 자동차가 얼마나 전진 했는지 ‘-’를 이용해 프린트한다.

-[x] printForward()

  자동차의 전진정도를 프린트한다. printCarForward 함수 안에서 작동한다.

-[x] findWinner()

  전진한 값에 대해서 최댓값을 가지는 자동차들을 골라 우승자를 가려낸다.

-[x] checkNameOfCar()

  자동차의 이름이 5자를 넘는지 확인한다. 5자가 넘을 경우 예외처리

-[x] checkAttempt()

  시도 횟수가 0 또는 음수로 입력되었는지 확인한다. 0 또는 음수로 입력되었을 경우 예외처리

# 예외 처리

## Application

-[x] 빈 문자가 입력되었을 경우

## CheckException

-[x] checkNameOfCar() : 자동차 이름 사이에 빈문자가 들어갔을 경우
-[x] checkNameOfCar() : 자동차의 이름이 5자 이상일 경우
-[x] checkAttempt() : 시도 횟수가 0 혹은 음수일 경우
-[x] checkIsStart() : 모든 레이싱이 끝난 후 아무 자동차도 출발하지 못했을 경우