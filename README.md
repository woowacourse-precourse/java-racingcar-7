# java-racingcar-precourse

## 도메인 (Car, Road, Winner로 구분)

 ### Car

- [ ] 차의 정보를 저장하는 Car 객체
  - Car 객체 안에 Road 객체가 있음


- [ ] 차의 이름을 검증하는 CarNameValidator
  - 차의 이름이 5자 초과이면 exception 발생 

 ### Road

- [ ] 각각의 차마다 간 거리를 저장하는 Road 객체
  - 거리를 추가 시키는 addRoad 함수가 있음


- [ ] 차가 갈 거리를 만드는 RoadCreator 인터페이스
  - addRandomRoad 함수가 있음


- [ ] 차가 거리를 랜덤하게 만드는 RandomRoadCreator 객체
  - 이 부분은 RoadCreator에 의존성을 주입하여 생성
  - 랜덤하게 수를 만들고 4이상인 경우에만 Road객체의 addRoad함수 사용


- [ ] 거리를 더할 때나 초기화할 때 사용하는 Length Enum
  - 앞으로 갈 때 FORWARD, 처음 초기화할 때 INITIALIZE


- [ ] 레이싱에서 현재 거리를 출력하는 RoadPrinter 객체

 ### Winner

- [ ] 레이싱의 승자를 출력하는 WinnerPrinter 객체
  - StringBuilder를 사용


- [ ] 우승자를 저장하는 Winner 객체
  - List로 우승한 Car들을 저장하고 있음


- [ ] 우승자를 계산하는 WinnerCalculator 객체
  - 최대 거리를 찾으면 Winner 객체에 저장


 ### Racing

- [ ] 직접 경기를 진행해주는 CarRacing 객체
  -  Car객체들을 생성해주는 createCar 메서드
  -  몇 단계에 걸쳐 레이스를 진행 할 지 step변수에 저장
  - racing 메서드는 본격적으로 레이스를 진행하는 메서드
 

## Test 코드
  - CarNameValidatorTest


  - RoadPrinterTest


  - WinnerCalculatorTest


  - WinnerPrinterTest