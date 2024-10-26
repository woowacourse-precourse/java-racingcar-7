# [Precourse Week2] Racing Car 🏁

## 📑 구현 기능 목록

---
## 🏎️ controller
### ✅ RacingCarController 클래스

- 🟡 RacingCarController(RacingCarService service) 생성자
    - RacingCarService 생성자 주입

- 🟡 start() 메서드
    - 자동차 경주를 시작한다

---

## 🏎️ service
### ✅ RacingCarService 클래스

- 🟡 RacingCarService(RacingCarModel model) 생성자
    - RacingCarModel 생성자 주입

- 🟡 inputRacingCarName() 메서드
    - 자동차 이름을 입력받는 기능을 한다

- 🟡 inputRacingAttemptsCount() 메서드
    - 자동차 경주 횟수를 입력받는 기능을 한다

- 🟡 populateRacingCarModel() 메서드
    - racingCarModel에 필요한 데이터(차량 이름, 경주 횟수)를 채워넣는 기능을 한다

- 🟡 createRacingResult() 메서드
    - 각 자동차 경주의 결과를 보여주는 문자열을 생성하는 기능을 한다

- 🟡 createWinnerResult() 메서드
    - 자동차 경주의 최종 우승자를 보여주는 문자열을 생성하는 기능을 한다

- 🟡 startRacing() 메서드
    - 자동차 경주 로직을 실행한다


---

## 🏎️ view
### ✅ InputView 클래스
- 🟡 inputCarNameString() 메서드
    - 자동차 이름을 입력받는다

- 🟡 inputRacingAttempts() 메서드
    - 경주할 횟수를 입력받는다

<br>

### ✅ OutputView 클래스
- 🟡 printRacingResult() 메서드
    - 각 경기의 결과를 출력한다

- 🟡 printWinner() 메서드
    - 최종 우승자를 출력한다

---

## 🏎️ validator
### ✅ CarRacingValidator 클래스
- 🟡 isValidCarName() 메서드
    - 이름의 길이가 빈값이 아니고 5 이하인지 확인한다
    - 조건을 만족하지 않으면 예외를 발생시킨다

- 🟡 canForward() 메서드
    - 입력받은 난수가 4 이상인지, 즉 앞으로 전전할 수 있는지 확인한다
    - 반환타입은 boolean이다

---

## 🏎️ model
### ✅ RacingCarModel 클래스
- 🟡 splitCarNameString() 메서드
    - 파라미터로 받은 자동차 이름 정보를 담은 문자열을 ',' 기준으로 쪼갠다
    - split된 자동차 이름이 적절한 형식인지 검사하고 Hashmap의 key로 넣는다
    - 이때 value는 전부 0으로 초기화한다

- 🟡 createCarNameList() 메서드
    - 자동차 이름을 담은 배열을 리스트로 변환한다

- 🟡 updateCarMap() 메서드
    - 경주가 진행될 때마다 조건에 맞춰 Hashmap의 value를 업데이트한다

---

## 🏎️ util
### ✅ RandomNumber 클래스
- 🟡 createRandomNumber() 메서드
    - 0과 9사이의 난수를 생성한다

<br>

### ✅ ExceptionMessages 클래스
- 🟡 enum 클래스
    - 발생 가능한 예외 메시지를 상수로 정의한다





    