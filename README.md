# java-racingcar-precourse
## ✅ View 클래스 - RacingView
### ✔️ getCarNames() : 경주할 자동차의 이름들을 입력받고 리스트에 담아 반환
### ✔️ getTryCount() : 경주할 라운드의 횟수를 입력받아 정수로 반환
### ✔️ printRoundResult() : 각 라운드의 결과를 출력
### ✔️ printWinner() : 우승자를 찾은 값을 입력받아 출력

## ✅ Model 클래스 - Car
### ✔️ validateName() : 자동차의 이름이 1글자 이상인지 확인
### ✔️ Car() : Car 객체 생성자, 생성될때 이름을 validateName()을 통해 학인한다
### ✔️ move() : 랜덤 값이 4이상이면 이동
### ✔️ getCarName() : 객체의 자동차 이름을 리턴
### ✔️ getPosition() : 자동차의 이동 위치를 리턴

## ✅ Controller 클래스 - RacingController
### ✔️ createCars() : View.getCarNames()를 통해 받은 참가 자동차 명단을 통해 자동차 리스트 생성
### ✔️ RacingController() : 자동차 리스트, 레이싱 라운드 횟수로 컨트롤러 객체 생성자
### ✔️ playRace() : 입력받은 횟수만큼 라운드 반복 실행 후 우승자 출력
### ✔️ playRaceRound() : 리스트에 있는 자동차들의 move() 호출
### ✔️ findWinner() : 자동차 객체의 position값을 비교해 우승자를 검색 후 문자열 리스트로 반환

