# java-racingcar-precourse

## ✅ 기능 목록

### 1️⃣ 사용자 입력
- [x] 경주할 자동차 이름을 입력받는다.
- [x] 시도할 횟수를 입력받는다.

### 2️⃣ 사용자 입력 검증 및 변환

#### 1. 경주할 자동차 이름 `carNamesInput`
- [ ] 문자열의 길이를 제한한다.
- [x] 자동차의 이름은 겹치면 안된다.
- [x] 쉼표를 기준으로 자른다.
- [x] 쉼표가 없을 수도 있다.
  ```
  pobiwonijun
  ```
- [x] 쉼표가 여러 개일 수 있다.
  ```
  pobi,,woni,,,,,jun
    ```  
- [x] 공백을 허용한다.
    ```
  pobi,       woni, jun
    ```
#### 2. 시도할  횟수 `raceCountInput`
- [ ] 문자열의 길이를 제한한다.
- [x] 숫자로 변환한다.
- [x] int 타입으로 변환될 수 있어야 한다.
- [x] `NumberFormatException` 발생 시 커스텀 예외를 던진다.


### 3️⃣ 자동차 경주 시작
- [x] 0~9 사이 무작위 값을 구한다.
- [x] 무작위 값이 4 이상이면 자동차가 전진한다.
- [x] 자동차 마다 위의 두 가지 작업을 반복한다.
- [x] 시도할 횟수만큼 위의 세 가지 작업을 반복한다. 


### 4️⃣우승자 구하기
- [x] 제일 앞서 있는 자동차가 최종 우승자이다. 
- [x] 최종 우승자는 여러 자동차일 수 있다. 

### 5️⃣ 출력하기
- [x] 우승자를 출력한다.

## 검증

### 자동차
- [x] 자동차가 전진할 때 position 이 int 범위를 넘지 않도록 값을 검증한다. 
- [x] 자동차 이름은 비어있거나 5글자를 넘어서는 안된다.

## 주요 도메인 객체

### 🚗 자동차 `Car`

- [x] 자동차는 이름을 가진다. `name`
- [x] 자동차는 위치를 가진다. `position`
- [x] 자동차는 전진할 수 있다. `forward()`

### 🔢 랜덤 숫자 생성기 `RandomNumberGenerator`

- [x] 0~9 사이의 무작위 값을 생성한다.

### 🏭 자동차 공장 `CarFactory`

- [x] 자동차를 만든다.


# 💭 고민

#### 1. 사용자로부터 입력받은 데이터가 계층을 지나며 어떠한 값 또는 객체로 존재하면 좋을까? 이때 타입 간 변환(Mapping)은 어디서 처리할까? 어떠한 객체가 필요할까?

- interfaces `CarsResponse`, `WinnerResponse` 
- domain  `Cars` , `Car` 
- 계층간 변환은 저수준 객체에서 담당
   - `Cars` → `CarsResponse` 변환은 `CarsResponse`에서 담당
   - interfaces 계층의 CarsResponse가 도메인의 Cars에 의존하도록 한다.
   - 정적 팩토리 메서드 사용
        
        ```java
        public record CarsResponse(
                List<CarResponse> carResponses
        ) {
            public static CarsResponse from(Cars cars) {
                return new CarsResponse(cars.getCars().stream()
                        .map(CarResponse::from)
                        .toList());
            }
        }
        ```
        
#### 2. 자동차와 랜덤 숫자 생성 사이의 의존성

- 자동차가 전진하기 위해 랜덤 숫자가 4 이상이어야 한다. 그럼 자동차 객체 내부에서 랜덤 숫자를 생성해야 하는가? 
- 아니라고 판단한 이유: 자동차가 랜덤 숫자 생성에 대해 의존성을 갖게 되면, 전진하는 조건이 바뀌었을 때 자동차에도 그 영향을 미치게 된다. 자동차는 자동차 경주 시스템의 중요한 핵심 도메인이다. 따라서 자동차는 “전진한다”는 행위만 갖도록 하고, 전진할지 여부는 바깥에서 해결하도록 한다.
- 결론: 자동차와 랜덤 숫자 생성 사이의 의존성을 제거하는 리팩토링

#### 3. 경주 전략이 여러 개가 될 수도 있지 않을까? 

- 지금은 랜덤 숫자를 생성해 4 이상이면 자동차가 전진한다.
- 경주 전략이 만약 여러 개로 늘어난다면? 지금은 자동차가 전진하기 위한 조건만 있지만, 후진하기 위한 조건도 추가될 수가 있다. 또 랜덤 숫자로 판단하는 것이 아닌 다른 조건이 추가될 수 있다.
- 이를 위해 경주 전략을 인터페이스로 선언하고, 랜덤 숫자 생성을 통해 자동차의 전진 여부를 결정하는 구현체를 만들었다.
- RacingStrategy ← RandomRacingStrategy

#### 4. 성능 테스트

- 자동차 1대 기준, raceCount 75000~79000 번 사이에서 메모리 부족으로 실패        
- 자동차 10만대 생성, raceCount 1000번 → 실패
- 자동차 7만대 생성, raceCount 100번 → 성공
- 자동차 5000대 생성, raceCount 5000번 → 실패
- 자동차 5000대 생성, raceCount 1000번 → 실패
- (미해결) 그렇다면, 적절한 raceCount, 자동차 개수는 몇개로 설정해야 할까?


#### 5. Controller의 책임
- Controller가 너무 많은 의존성을 갖고 있는가?
- 서비스를 추상화시키기에는 아직 프로젝트의 규모가 판단해 구체 클래스에 의존하도록 했다.
- (미해결) Input&Output handler, Service에 대한 의존성을 모두 컨트롤러가 갖는 것이 적절한가? 만약 아니라면, 이를 어떻게 개선할 수 있는가?
   
#### 6. Static 메서드 사용에 대한 고민
- 이와 관련하여 고민한 내용을 글로 작성했습니다. 
- https://velog.io/@carol_ly/static-%EB%A9%94%EC%84%9C%EB%93%9C%EB%8A%94-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%95%BC-%ED%95%A0%EA%B9%8C


<br>


# 계층별 클래스에 대한 간략한 소개

<img width="768" alt="image" src="https://github.com/user-attachments/assets/9305335f-6f62-4003-be7b-3b6411478506">

* 모든 의존성을 표시하지는 않았습니다. 리턴 타입이나, 파라미터에 정의되어 발생하는 의존관계는 명시하지 않았습니다.
* 컨트롤러의 의존성은 패키지 사이의 의존성으로 대체했습니다.

## Domain

### 1. 🚗 자동차 `Car`

- 상태
   - 이름 `carName` → 불변 (final로 선언 후 setter 성격의 메서드를 두지 않음으로써 불변성을 보장)
   - 자동차 위치 `carPosition` → 행위에 따라 상태 변화 가능

- 행위
   - 앞으로 전진 `forward()`
   - 특이사항
        - equals & hashCode 를 오버라이딩한 이유
            - 두 가지 메서드를 재정의하지 않는다면, 자동차 객체는 물리적인 비교만 가능하다. 즉, 객체의 주소로 비교된다.
            - 다만, 요구사항을 분석하며 자동차는 이름으로 구분되어야 한다고 판단했다. 따라서 자동차는 고유한 이름을 가지며, 이름으로 비교되어야 한다.
            - 논리적 비교를 하기 위해 equals & hashCode를 재정의했다. 이를 통해 두 자동차의 이름이 같다면, 같은 자동차로 동등성이 보장된다.

### 2. 🚘 자동차 일급 컬렉션 `Cars`

- 상태
   - 자동차 리스트 `List<Car>`
- 행위
   - 자동차 등록 `registerCar(Car car)`
   - 자동차를 등록할 때 동일한 이름을 가진 자동차는 등록할 수 없다.
        
### 3. 🏭 자동차 공장 `CarFactory`

- 자동차를 만든다.
- 여러 대의 자동차를 만든다.
    
### 4. 🐎 경주 전략 `RacingStrategy` `<<interface>>`

- `determineCarToForward()` : 자동차가 전진할지 여부를 결정한다.

### 5. 🚚 서비스

- CarService: 자동차를 만든다.
- RacingService: 자동차들이 경주를 한다.
- JudgeService: 우승자를 판정한다.

## Infrastructures

- 경주 전략 구현체 - 랜덤 숫자 생성 `RandomRacingStrategy`
    - 0~9 사이 랜덤 숫자를 생성해 4 이상인지 여부를 확인해 반환한다.

## Interfaces

### 1. 사용자 입출력

- InputHandler
- OutputHandler
  
### 2. 데이터 운반용 자료구조

- CarResponse
- CarsResponse
- WinnerResponse
  
### 3. 자동차 경주 컨트롤러 `RacingController`

CarService, RacingService, JudgeService 등에 의존하며 서비스의 흐름을 제어한다.
