# java-racingcar-precourse

## 자동차 경주 게임

- MVC 패턴을 적용해 구현한 자동차 경주 게임

## 구현 기능 목록

### Main

* Application
    * 자동차 경주 게임을 실행합니다.

### model

* `Car`
    * 자동차 객체를 관리합니다.
    * 자동차의 움직임을 처리합니다.
    * 자동차의 이동거리 상태를 보유합니다.
* `Cars`
    * `Car` 객체를 list로 관리합니다.
* `Race`
    * 레이싱게임의 우승자를 판별합니다.
    * 레이싱게임을 시작합니다.

### controller

* `RaceController`
    * 자동차 게임의 흐름을 제어합니다.
    * 입력받은 자동차에 대한 검증을 처리합니다.

### view

* `InputView`
    * 경주에 참가하는 자동차를 `,`로 구분지어 입력받습니다.
    * 경주의 시도 횟수를 입력받습니다.

* `OutputView`
    * 경주 결과를 출력합니다.
    * 우승자를 출력합니다.

### utils
* `RandomNumberGenerator`
    * 난수를 생성합니다.
* `MoveDecider`
  * 자동차의 움직임을 난수를 통해 판별합니다.
* #### Validator
    * `CarNameValidator`
        * 자동차 입력에 대한 검증을 처리합니다.
    * `TryNumberValidator`
        * 자동차 경주 게임 시도 횟수 입력에 대한 검증을 처리합니다.

### exception
* `ErrorMessage`
    * 예외 발생시에 출력할 문구를 관리합니다.
* `RacingGameVaildator`
    * 예외 발생 조건과 메세지 내용을 구체화하여 관리합니다. 

### dto
* `CarDto`
  * 자동차의 게임 결과 상태를 옮기는 dto입니다.