# java-racingcar-precourse

# 기능 정리

## Model

### Car 

&emsp; 🔸 Car : 생성자

&emsp; 🔸move : 입력된 랜덤 값이 4 이상이면 1칸 이동

&emsp; 🔸getDistance : 현재 자동차의 이동거리 반환

&emsp; 🔸getName : 자동차의 이름 반환

### Race

&emsp; 🔸Race : 생성자. 입력받은 이름 리스트를 이용해 각 자동차 초기화

&emsp; 🔸playRound : 모든 자동차에 대해 랜덤 값 생성, move 메서드 호출

&emsp; 🔸getCars : 현재 레이스에 참가 중인 자동차 리스트 반환

&emsp; 🔸getWinners : 최대 거리를 이동한 자동차(들) 반환

## View

### InputView

&emsp; 🔸getCarNames : 사용자로부터 자동차 이름을 입력받아 리스트로 변환

&emsp;&emsp; ➡️ 입력값이 잘못된 경우 예외 발생

&emsp; 🔸getNumberOfRounds : 시도 횟수를 입력받아 반환

&emsp;&emsp; ➡️ 정수가 아닌 값이 입력될 경우 예외 발생

### ResultView 

&emsp; 🔸printRoundResult : 각 자동차들의 이름과 이동 거리 출력

&emsp; 🔸printWinners : 우승자 이름 출력 (두 명 이상일 경우 쉼표로 구분)

## Controller

### GameController 

&emsp; 🔸게임의 전반적인 흐름 제어   
