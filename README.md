# [Precourse Week2] Racing Car 🏁

## 📑 구현 기능 목록

---
## 🏎️ controller
### ✅ RacingCarController 클래스

- 🟡 RacingCarController(RacingCarService service) 생성자
    - RacingCarService 객체를 생성자 주입

- 🟡 startCarRacingContest() 메서드
    - 자동차 경주 대회를 시작한다
    - RacingCarService의 비즈니스 로직들을 호출하여 전체 기능의 작동을 컨트롤한다

---

## 🏎️ factory
### ✅ RacingCarFactory 클래스

- 🟡 createController 메서드
  - 컨트롤러에서 필요한 여러 객체를 생성하고 생성자 주입을 처리하는 생성로직을 수행한다

---

## 🏎️ service
### ✅ RacingCarService 클래스

- 🟡 RacingCarService 생성자
    - RacingCarModel와 ResultGeneratorService 객체를 생성자 주입

- 🟡 startRacing() 메서드
  - 한 번의 자동차 경주를 실행하는 로직을 담고있다
  - 각 자동차는 받아온 랜덤값에 따라 정지하거나 전진한다
  - 한 번의 경주 결과를 출력하도록 한다

- 🟡 getRandomNumber() 메서드
  - 생성된 난수를 받아 반환한다

- 🟡 inputRacingCarName 메서드
    - 자동차 이름을 담은 문자열을 입력받고 반환하는 기능을 한다

- 🟡 inputRacingAttemptsCount 메서드
    - 자동차 경주 횟수 담은 문자열을 입력받고 setRacingAttemptCount 메서드로 넘긴다

- 🟡 setRacingAttemptCount 메서드
  - 파라미터로 받은 문자열에 대한 검증 로직을 수행하고 racingAttemptCount 값을 초기화한다

- 🟡 getRacingAttemptsCount 메서드
  - racingAttemptCount을 반환한다

- 🟡 initializeCarHashMap 메서드
  - Model 클래스의 carHashMap을 초기화하는 로직을 수행하도록 한다

- 🟡 updateCarNameListInModel 메서드
    - 자동차 이름 문자열을 넘겨 Model 클래스에 있는 carNameList를 업데이트한다
    - setCarNameList를 실행한다

- 🟡 setCarNameList 메서드
  - Model클래스에서 반환받은 리스트로 carNameList를 초기화한다

- 🟡 getRacingResult 메서드
  - 자동차 이름 리스트를 순회하여 전체 경주 결과 문자열을 반환하는 기능을 수행한다
  - 각 자동차의 경주 결과 문자열은 ResultGeneratorService 클래스로 생성한다

- 🟡 printRacingResult 메서드
    - 각 자동차 경주의 결과를 보여주는 출력하는 로직을 수행한다

- 🟡 setWinnerList 메서드
  - Model 클래스에서 얻은 우승자 리스트로 winnerList를 초기화한다

- 🟡 printWinnerResult 메서드
    - 자동차 경주의 최종 우승자 문자열을 출력하는 기능을 수행한다
    - 우승자 문자열은 ResultGeneratorService 클래스로 생성한다

  
<br>

### ✅ ResultGeneratorService 클래스

- 🟡 generateRacingResult 메서드
  - 각 자동차의 경주 결과 String을 생성하고 반환하는 기능을 한다

- 🟡 generateWinnerResult 메서드
  - 최종 우승자 결과 String을 생성하고 반환하는 기능을 한다



---

## 🏎️ view
### ✅ InputView 클래스
- 🟡 inputCarNameString 메서드
    - 자동차 이름들 정보를 담은 문자열을 입력받는다

- 🟡 inputRacingAttempts 메서드
    - 경주할 횟수를 담은 문자열을 입력받는다

<br>

### ✅ OutputView 클래스

- 🟡 printRacingResult 메서드
    - 각 경기의 결과를 출력한다

- 🟡 printWinner 메서드
    - 최종 우승자를 출력한다

---

## 🏎️ validator
### ✅ CarRacingValidator 클래스

- 🟡 isValidCarName 메서드
    - 이름이 빈값이 아니고 길이가 5 이하인지 확인한다
    - 조건을 만족하지 않으면 예외를 발생시킨다

- 🟡 canForward 메서드
    - 입력받은 난수가 4 이상인지, 즉 앞으로 전전할 수 있는지 확인한다
    - 반환타입은 boolean이다

- 🟡 validateRacingAttemptCount 메서드
  - 경주 횟수를 담은 문자열을 검증한다
  - 입력받은 값이 정수인지 확인하고 validatePositiveNumber로 양의 정수인지도 확인한다
  - 불만족 시 예외를 발생시키고 만족한다면 값을 정수형태로 반환한다

- 🟡 validatePositiveNumber 메서드
  - 값이 양의 정수가 아니면 예외를 발생시킨다

---

## 🏎️ model
### ✅ RacingCarModel 클래스

- 🟡 setCarHashMap 메서드
  - 자동차 이름을 key, 전진 횟수를 value로 가지고 있는 LinkedHashMap을 초기화한다
  - 처음 초기화하는 전진 횟수는 0이다

- 🟡 setCarNameList 메서드
    - 파라미터로 받은 자동차 이름 정보를 담은 문자열을 ',' 기준으로 쪼갠다
    - split된 문자열의 양 끝의 공백이 있다면 제거하고 검증기로 검증한다
    - 검증에 통과하면 carNameList에 추가한다

- 🟡 getCarNameList 메서드
  - carNameList을 반환한다

- 🟡 addRacingCar 메서드
    - 파라미터 값들을 통해 carHashMap에 요소를 추가하는 기능을 한다
    - 처음 carHashMap을 초기화할 때 사용하는 메서드이다

- 🟡 updateCarMap 메서드
    - 자동차가 전진할 때 Hashmap의 value 1씩 증가시킨다

- 🟡 getForwardCount 메서드
  - 파라미터로 들어온 자동차의 전진 횟수를 반환한다

- 🟡 setWinnerList 메서드
  - 우승자 리스트에 값을 추가하는 기능을 한다
  - 전진 횟수가 최대값을 가지고 있는 자동차의 이름을 리스트에 저장한다

- 🟡 getWinnerList 메서드
  - 우승자 리스트를 반환받는다

---

## 🏎️ util
### ✅ RandomNumber 클래스
- 🟡 createRandomNumber() 메서드
    - 0과 9사이의 난수를 생성한다

<br>

### ✅ ExceptionMessages 클래스
- 🟡 enum 클래스
    - 발생 가능한 예외 메시지를 상수로 정의한다





    