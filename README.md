
| **Package** | **Class** |
| --- | --- |
| 💬 **view** | **InputView** |
|  | **OutputView** |
| 💾 **domain** | **Car** |
|  | **Cars** |
|  | **Number** |
| 🎮 **Controller** | **RacingCarGame** |

## 💬 view

### **InputView**

- getInput()
    - 사용자에게 자동차 이름을 문자열로 입력 받음
    - 사용자에게 몇 번의 이동을 할 것인지 입력 받음

### **OutputView**

- 사용자에게 입력 또는 결과 메시지를 출력함
- printCarDistance()
    - 자동차 distance를 출력함
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

### Number

- getRandomNumber()
    - 0~9사이의 랜덤값을 추출 후 리턴함

## 🎮 Controller

### RacingCarGame

- initGame()
    - 사용자의 입력을 받고 필드 값을 초기화
    - 자동차 이름 문자열을 넘겨줌
- startRacingGame()
    - 게임을 시작함
    - 시도 횟수 만큼 playOneRound()를 반복함
    - 모든 라운드가 끝난 다음 최종 우승자를 outputView로 넘겨줌
- playOneRound()
    - 랜덤값을 자동차에게 넘겨줌
    - 진행 결과를 출력함
