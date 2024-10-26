# java-racingcar-precourse

## 구현할 기능 목록

</br>

### Application

* RacingCar Main

> - [x] 각 Factory 객체 생성
> - [x] Factory를 주입하여 Controller 생성
> - [x] Controller 실행 지시

</br>

### Factory

* 객체 생성 package

> #### ViewFactory
> - [x] Type에 맞는 View 객체 생성

> #### ValidatorFactory
> - [x] Type에 맞는 Validator 객체 생성

</br>

### View

* 안내 메시지 출력 역할 package

> #### InputView
> - [x] 사용자에게 입력 안내 메시지 출력
> - [x] 사용자 입력을 받아 RacingController로 전달

> #### OutputView
> - [x] 사용자에게 결과 안내 메시지 출력
> - [x] RacingController로부터 결과를 전달 받아 출력

</br>

### Controller

* view와 model 사이 상호작용 역할 package

> #### RacingCarController
> - [x] InputView로부터 받은 사용자 입력을 Race에게 전달
> - [x] 옵저버 패턴을 적용하여 Subject(Race)에 Observer(RuntimeView) 등록
> - [x] Race로부터 전달받은 값을 OutputView에게 전달

</br>

### Validator

* 사용자가 입력 값 유효성 검사 package

> #### CarNameValidator
> - [x] 사용자가 입력한 CarName 유효성 검사
    >
- 각 차량 이름의 길이가 5를 초과하였는지 검사

> #### AttemptCountValidator
> - [x] 사용자가 입력한 AttemptCount 유효성 검사
    >
- 시도 횟수가 음수인지 검사

</br>

### Model

* 데이터 구조 정의, RacingCar 로직 역할 package

> #### Car
> - [x] 이름
> - [x] 사용자 시도 횟수
> - [x] 전진 시도 기능

> #### Race
> - [x] 사용자 시도 횟수만큼 Car에게 전진 시도를 지시
> - [x] Observer(RuntimeView)에게 Car 객체 변화 알림
> - [x] 우승자 리스트를 선정하여 RacingController에게 전달

</br>

### Observer

* Subject 상태 변화 통지를 감지하여 갱신하는 package

> #### RuntimeView
> - [x] Car 전진 상태 int → 문자열 변환
> - [x] 시도 횟수 별 Car 전진 상태 출력
