# 2주차

| **Package** | **Class** |
| --- | --- |
| 💬 **view** | **InputView** |
|  | **OutputView** |
|  | **ConsoleInputView** |
|  | **ConsoleOutputView** |
| 💾 **domain** | **Car** |
|  | **Cars** |
|  | **RandomGenerator** |
| 🎮 **controller** | **RacingCarGame** |
| 🧹 **service** | **GameService** |

## 💬 view

### ConsoleInputView

- getInput()
  - 사용자에게 자동차 이름을 문자열로 입력 받음
  - 사용자에게 몇 번의 이동을 할 것인지 입력 받음

### ConsoleOutputView

- printStartMessage(), printTryCountMessage(), printResultMessage()
  - 사용자에게 입력 또는 결과 메시지를 출력함
- printGameRounds()
  - 라운드 각각의 진행 상태를 모두 출력함
- printOneRound()
  - 한 라운드에서 자동차들의 진행상태를 출력함
- printWinner()
  - 최종 우승자를 출력함
  - 여러명일 경우 쉼표를 이용하여 구분함

## 💾 model

### Car

- 자동차의 name과 distance를 저장
- distance를 0으로 초기화
- validateName()
  - 유효성 검사
  - 자동차 이름이 5자 이하인지 검사
- setCarDistance()
  - 넘겨 받은 랜덤값이 4이상일 때 distance 1증가함

### Cars

- setCarList()
  - 자동차 객체를 리스트에 저장함
- getWinnerList()
  - 최대 이동 거리를 측정 함
  - 최종 우승자를 반환함

### RandomGenerator

- getRandomNumber()
  - 0~9사이의 랜덤값을 추출 후 리턴함


## 🎮 Controller

### RacingCarGame

- run()
  - 입력받은 값을 Service에게 넘겨줌
  - Service로 부터 받은 게임의 진행 결과를 View로 넘겨줌

## 🧹 Service
### GameService

- startGame()
  - 게임을 시작함
  - 시도 횟수 만큼 playOneRound()를 반복함
  - 모든 라운드가 끝난 게임 진행 결과를 리턴함
- playOneRound()
  - 랜덤값을 자동차에게 넘겨줌
  - 매 라운드의 진행 상태를 저장함
