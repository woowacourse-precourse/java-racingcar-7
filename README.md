# java-racingcar-precourse

## 자동차 경주

### 🧱클래스 다이어그램
---
```mermaid
 classDiagram
    class CarStrategy {
        <<interface>>
        +validateNames(List<String>) void
        +splitNames(String) List<String>
    }
    class CarBasicStrategy {
        -DELIMITER: String
        -MAXIMUM_NAME_LENGTH: int
        +splitNames(String) List<String>
        +validateNames(List<String>) void
        -validateUniqueName(String, Set<String>) void
        -validateNameLength(String) void
        -validateSingleName(String, Set<String>) void
    }
    class CarsStrategy {
        +getDefaultCollection() Function<List<Car>, Cars>
        +getCollection(CarsType) Function<List<Car>, Cars>
    }
    class CarFactory {
        <<interface>>
        +createCar(String) Car
        +getDefaultCollection() Function<List<Car>, Cars>
        +getCollection(CarsType) Function<List<Car>, Cars>
        +createList(List<String>) List<Car>
        +validateNames(List<String>) void
        +splitCarNames(String) List<String>
        +getListFromRawCarNames(String) List<Car>
        +createCars(String, CarsType) Cars
        +createDefaultCars(String) Cars
    }
    class CarBasicFactory {
        -CarStrategy carStrategy
        -CarsStrategy carsStrategy
        +CarBasicFactory(CarStrategy, CarsStrategy)
    }

    class RacingService {
        +open(Cars, int) Racing
        +retrieveWinners(Racing) List<Car>
        +executeRound(Racing) RacingRoundResult
    }
    class Racing {
        -Cars cars
        -int roundCount
        +from(Cars, int) Racing
        +retrieveWinners() List<Car>
        +executeRound() RacingRoundResult
    }
    class CarService {
        -CarFactory carFactory
        +CarService(CarFactory)
        +createParticipants(String) Cars
    }
    class Car {
        -String name
        -int position
        -RandomNumberGenerator randomNumberGenerator
        -Car(String)
        +from(String) Car$
        +getName() String
        +getPosition() int
        -canMove() boolean
        +move() void
        +moveOrStay() HasCarMoved
        +compareTo(Car) int
    }
    class Cars {
        <<interface>>
        +findCarsByPosition(int) List<Car>
        +findMaxPosition() int
        +getWinners() List<Car>
        +getList() List<Car>
        +moveOrStayAll() RacingRoundResult
    }
    class CarsList {
        -List<Car> cars
        -CarsList(List<Car>)
        +from(List<Car>) CarsList$
        +findCarsByPosition(int) List<Car>
        +findMaxPosition() int
        +getWinners() List<Car>
        +getList() List<Car>
        +moveOrStayAll() RacingRoundResult
    }
    class RacingCarController {
        -RacingService racingService
        -CarService carService
        +RacingCarController(RacingService, CarService)
        +run(RacingRequest) RacingResponse
    }
    class DependencyInjectionContainer {
        -Map container
        +DependencyInjectionContainer()
        -createRacingCarController()
        +get(Class) Class
    }
    class InputView {
        -ASK_CAR_NAMES: String
        -ASK_ROUND_COUNT: String
        -promptCarNames() String
        -promptRoundCount() String
        +promptRacingRequest() RacingRequest
    }
    
    class RacingRequest {
        <<record>>
        -String carNames
        -int roundCount
        -hasWhiteSpace(String) boolean
        -validateRoundCount(String) int
        -validateCarNames(String) void
        +from(String, String) RacingRequest
    }
    
    class OutputView {
        -EXECUTE_RESULT: String
        -WINNER_PREFIX: String
        -WINNER_DELIMITER: String
        -SEPARATOR: String
        -POSITION_COUNTER: String
        +printExecuteResult()
        -printCarStatus(Car)
        +printRoundResult(List<Car>)
        +printRoundResult(Map<String, Car>, List<String>)
        +printRacingResult(RacingResponse)
    }
    class RacingResponse {
        <<record>>
        -List<String> winners
        +from(List<Car>) RacingResponse
    }
    class Application {
        +main(String[] args)
    }
    Application --> InputView
    Application --> DependencyInjectionContainer
    Application --> RacingCarController
    Application --> OutputView
    DependencyInjectionContainer ..> RacingCarController : creates
    CarStrategy <|-- CarBasicStrategy
    CarFactory <|-- CarBasicFactory
    CarBasicFactory --> CarStrategy
    CarBasicFactory --> CarsStrategy
    CarService --> CarFactory
    RacingCarController --> RacingService
    RacingCarController --> CarService
    RacingCarController <.. RacingRequest : used
    RacingCarController ..> RacingResponse : creates
    InputView ..> RacingRequest : creates
    CarFactory ..> Cars : creates
    RacingService ..> Racing : creates
    Cars <|-- CarsList
    CarsList o-- Car
    OutputView <.. Car : used
    OutputView <.. RacingResponse : used
```

### 🧾기능 요구 사항
---
#### 주요 클래스 구조:
##### Model
- `RacingRequest` : 자동차 경주 인풋 데이터 캡슐화
- `Car` : 개별 자동차의 상태와 동작
- `Cars` : 자동차 콜렉션의 상태와 동작
- `Racing` : 경주 상태와 진행 관리
- `RacingResponse` : 자동차 경주 결과 데이터 캡슐화
##### ️View
- `InputVIew` : 사용자 입력 처리
- `OutputView`: 결과 출력
##### Controller
- `RacingCarController` : 자동차 경주 로직 제어
##### Service
- `RacingService` : 경주 로직 실행
- `CarService` : `Car` 객체 생성 및 상태 관리
  - `CarFactory` : `Car` 객체 생성 전담
    - `CarStrategy` : `Car` 생성 유효성 검사 전략 정의

##### Exception
- `GlobalException` : 전역 예외처리
- `InputException` : 사용자 입력 관련 예외 처리
- `CarException` : 자동차 객체 생성 및 조작 관련 예외 처리
- `RacingException` : 경주 생성 중 발생하는 예외 처리

#### 단계별 구현
GlobalException
-[x] 전역 예외처리

InputException
-[x] 사용자 입력 관련 예외 처리

InputView
-[x] 경주할 자동차 이름 입력 받기
-[x] 경주 시도할 횟수 입력 받기

RacingRequest
-[x] 자동차 이름 리스트와 시도 횟수 필드 생성
-[x] 문자열 간단 유효성 검사

CarException
-[x]  자동차 객체 생성 및 조작 관련 예외 처리

Car
-[ ] `Comparable` 인터페이스
-[x] 이름과 위치 필드 생성
-[x] 이동 메서드 구현 (랜덤 값이 4이상일 때 전진)

Cars
-[x] `List<Car>` 일급 컬렉션
-[x] 우승자 결정 메서드 구현

CarStrategy
-[x] 자동차 이름 입력값 유효성 검사

CarFactory
-[x] `Car` 객체 생성

RacingException
-[x] 경주 생성 중 발생하는 예외 처리

Racing
-[x] `Cars`와 시도 횟수 필드 생성
-[x] 경주 진행 메서드 구현
-[x] 우승자 결정 메서드 구현

RacingResponse
-[x] 최종 우승 자동차 이름 리스트 생성

OutputView
-[x] 라운드 별 결과 출력 정적 메서드 구현
-[x] 경주 결과 출력 정적 메서드 구현