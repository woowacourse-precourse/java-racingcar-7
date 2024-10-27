# java-racingcar-precourse

## To-dos

#### Car
- [x] 자동차의 이름은 5글자 이내로만 가능하다
- [x] 자동차의 이름이 null 이거나 공백이면 예외를 반환한다
- [x] 자동차의 포지션이 음수이면 예외를 반환한다
- [x] 차가 조건에 따라 전진 혹은 정지한다
- [x] 이 차의 포지션이 우승자 포지션인지 판단한다

#### Cars
- [x] n대의 차들이 각각 전진(혹은 정지)함에 따라 포지션이 1씩 증가하거나 그대로이다
- [x] 차들의 포지션 중에서 우승자를 찾는다

#### RacingGame
- [x] 주어진 횟수 동안 n대의 자동차를 한 라운드 진행시킨다
- [x] 각 라운드마다 결과를 도출한다
  - [x] GameResult 를 통해 결과를 RacingGameOutput 에 전달한다(마치 DTO 역할)

#### RacingGameController
- [x] 자동차 경주를 진행한다

#### RacingGameInput
- [x] 참가자들을 입력받는다
- [x] 라운드 횟수를 입력받는다

#### RacingGameOutput
- [x] 경기 진행과정을 출력한다
  - [x] 각 라운드의 결과를 출력한다
- [x] 최종 우승자들을 출력한다

#### Winners
- [x] 우승자들을 찾는다
