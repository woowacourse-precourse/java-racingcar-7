# java-racingcar-precourse

## 자동차 경주

### 기능 요구 사항
#### 주요 클래스 구조:
##### 🗂️Model
- `RacingRequest` : 자동차 경주 인풋 데이터 캡슐화
- `Car` : 개별 자동차의 상태와 동작
- `Racing` : 경주 상태와 진행 관리
- `RacingResponse` : 자동차 경주 결과 데이터 캡슐화
##### 🖥️View
- `InputVIew` : 사용자 입력 처리
- `OutputView`: 결과 출력
##### 🕹️Controller
- `RacingCarController` : 자동차 경주 로직 제어
##### 🚚Service
- `RacingService` : 경주 로직 실행
  - `RacingFactory` : `Racing` 객체 생성 및 상태 관리
    - `RacingStrategy` : `Racing` 생성 유효성 검사 전략 정의
- `CarService` : `Car` 객체 생성 및 상태 관리
  - `CarFactory` : `Car` 객체 생성 전담
    - `CarStrategy` : `Car` 생성 유효성 검사 전략 정의

##### 🃏Exception
- `GlobalException` : 전역 예외처리
- `InputException` : 사용자 입력 관련 예외 처리
- `CarException` : 자동차 객체 생성 및 조작 관련 예외 처리
- `RacingException` : 경주 생성 중 발생하는 예외 처리

#### 단계별 구현
GlobalException
- 전역 예외처리

InputException
- 사용자 입력 관련 예외 처리

InputView
- 경주할 자동차 이름 입력 받기
- 경주 시도할 횟수 입력 받기
- 문자열 간단 유효성 검사

RacingRequest
- 자동차 이름 리스트와 시도 횟수 필드 생성

CarException
-  자동차 객체 생성 및 조작 관련 예외 처리

Car
- `Comparable` 인터페이스
- 이름과 위치 필드 생성
- 이동 메서드 구현 (랜덤 값이 4이상일 때 전진)

Cars
- `List<Car>` 일급 컬렉션
- 우승자 결정 메서드 구현

CarStrategy
- 자동차 이름 입력값 유효성 검사

CarFactory
- `Car` 객체 생성

RacingException
- 경주 생성 중 발생하는 예외 처리

Racing
- `Cars`와 시도 횟수 필드 생성
- 경주 진행 메서드 구현
- 우승자 결정 메서드 구현

RacingStrategy
- 시도할 횟수 입력값 유효성 검사

RacingFactory
- `Racing` 객체 생성

RacingResponse
- 최종 우승 자동차 이름 리스트 생성

OutputView
- 라운드 별 결과 출력 정적 메서드 구현
- 경주 결과 출력 정적 메서드 구현