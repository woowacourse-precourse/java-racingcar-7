# 기능 목록
## 핵심 기능
- [x] 각 자동차에 이름을 부여한다.
- [x] 자동차는 전진 또는 멈출 수 있다.
- [ ] 자동차 경주 게임 우승자를 결정한다.
- [ ] 게임을 시작한다.

## 객체 도출
핵심 기능으로부터 객체를 도출한다.
- 각 자동차에 이름을 부여한다.
  - CarGenerator
- 자동차는 전진 또는 멈출 수 있다.
  - Car
- 자동차 경주 게임 우승자를 결정한다.
  - WinnerDecider
- 게임을 시작한다.
  - Game

## 추가 기능
- [x] 자동차 이름을 입력한다.
- [ ] 자동차 이름을 출력한다.
- [x] 자동차 이름을 쉼표를 기준으로 구분한다.
- [x] 자동차 이름을 검증한다.
- [x] 몇 번의 이동을 할 것인지 입력한다(시도할 횟수 입력).
- [x] 0에서 9 사이에서 무작위 값을 구한다.
- [x] 전진할지 판단한다.
- [ ] 라운드별 진행 상황을 출력한다(차수별 실행 결과).
- [ ] 우승자를 출력한다(단독 우승자 안내).
- [ ] 우승자가 여러 명일 경우 쉼표를 이용하여 구분한다(공동 우승자 안내).

## 추가 객체 도출
핵심 기능 외 추가적인 기능을 도출한다.
- 자동차 이름을 입력한다.
- 자동차 이름을 쉼표를 기준으로 구분한다.
- 몇 번의 이동을 할 것인지 입력한다.
  - InputView
- 자동차 이름을 출력한다.
- 라운드별 진행 상황을 출력한다.
- 우승자를 출력한다.
- 우승자가 여러 명일 경우 쉼표를 이용하여 구분한다.
  - OutputView
- 자동차 이름을 검증한다.
  - InputValidator
- 0에서 9 사이에서 무작위 값을 구한다.
  - RandomNumberGenerator
- 전진할지 판단한다.
  - Game

## 객체 및 메서드
- CarGenerator
  - generateCars()
- Car
  - name
  - position
  - move()
  - getPosition()
  - getName()
- WinnerDecider
  - decideWinner()
- Game
  - run()
  - runRound()
  - isMovable()
- InputView
  - inputCarNames()
  - inputRoundCount()
  - parseCarNames()
- OutputView
  - printRoundResult()
  - printWinners()
- RandomNumberGenerator
  - generate()
- InputValidator
  - validateCarNames()
  - validateRoundCount()
  - validateCarNameLength()
  - validateCarNameNotEmpty()
  - validateDuplicateNames()

## 예외 처리
- 자동차 이름이 5자 초과일 때
- 자동차 이름이 중복일 때
- 자동차 이름이 공백일 때
- 시도할 횟수가 0 이하일 때
- 시도할 횟수가 문자일 때