# java-racingcar-precourse

---
## 📌 패키지, 클래스 목록
- [x] controller
  - [x] Controller : InputController, RacingController 를 연결하는 게임의 전체적인 흐름을 담당합니다.
  - [x] InputController : 사용자에게 입력받고, 이를 검증 후 Cars, Car 객체를 생성하는 흐름을 담당합니다.
  - [x] RacingController : 사용자가 원하는 실행 횟수만큼 실행하는 흐름을 담당합니다.
- [x] model
  - [x] Car : 이름과 전진한 횟수를 담고 있는 경주에 참여하는 하나의 자동차입니다.
  - [x] Cars : 경주에 참여하는 모든 자동차를 담고 있는 어레이 리스트와 가장 많이 전진한 횟수, 우승자를 담고 있습니다
  - [x] UserInputHandler : 사용자에게 입력을 받고, 'split'을 하거나 형변환을 하는 클래스입니다.
- [x] randomNumber
  - [x] RandomNumber : 전진의 기준이 되는 난수를 생성합니다.
- [x] validation
  - [x] NameValidator : 사용자에게 입력받은 자동차 이름이 공백인지 5글자 이상인지 확인합니다.
  - [x] Parser : 사용자에게 입력받은 실행 횟수가 문자열인지 0 이하인지 확인합니다.
- [x] view
  - [x] ErrorMessage : Error 발생시 사용자에게 안내 메세지를 출력합니다.
  - [x] InputView : 사용자에게 입력을 요구하는 안내 메세지를 출력합니다.
  - [x] OutputView : 사용자에게 결과에 해당하는 메세지를 출력합니다.
---
## 🚴‍♂️ 기능 목록
- [x] 사용자에게 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력합니다.
- [x] 사용자로부터 자동차 이름을 입력받습니다.
- [x] 잘못된 문자열을 입력한 경우, IllegalArgumentException을 발생시킨 후 종료합니다.
    - [x] 이름에 null이 들어간 경우
    - [x] 이름이 5글자 이상인 경우
- [x] 이름을 "," 를 기준으로 분리하여 저장합니다.
- [x] 사용자에게 "시도할 횟수는 몇 회인가요?" 를 출력합니다.
- [x] 잘못된 시도 횟수를 입력한 경우, IllegalArgumentException을 발생시킨 후 종료합니다.
   - [x] 숫자가 양수가 아닌 경우.
- [x] Random 객체를 통해 난수 생성 후, 4이상이면 전진합니다.
- [x] 횟수만큼 실행 후, 우승자를 출력합니다.
---
## 💣 예외 처리
- [x] 이름에 공백이 있을 경우 - 1 ex) pobi,,wini
- [x] 이름에 공백이 있을 경우 - 2 ex) pobi,,
- [x] 시도 횟수가 양수가 아닐 경우 ex) -1, @, 0
---
## 🚀 사용 예제
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```