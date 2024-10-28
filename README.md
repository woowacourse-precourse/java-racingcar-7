# java-racingcar-precourse

# 🚗 RacingCar

## 디렉토리 구조

```
📦racingcar
┃
┣-📂controller
┃ ┃
┃ ┗-📜CarController.java
┃ 
┣-📂service
┃ ┃
┃ ┗-📜RacingService.java
┃
┣-📂model
┃ ┃
┃ ┣-📜Car.java
┃ ┃
┃ ┣-📜CarNames.java
┃ ┃
┃ ┗-📜Cars.java
┃
┣-📂factory
┃ ┃
┃ ┣-📜CarFactory.java
┃ ┃
┃ ┗-📜CarsFactory.java
┃
┣-📂generator
┃ ┃
┃ ┣-📜Generator.java
┃ ┃
┃ ┗-📜IntegerGenerator.java
┃
┣-📂strategy
┃ ┃
┃ ┣-📜MoveStrategy.java
┃ ┃
┃ ┗-📜CarMoveStrategy.java
┃
┣-📂util
┃ ┃
┃ ┗-📜InputSplitter.java
┃ 
┣-📂validator
┃ ┃
┃ ┣-📜Validator.java
┃ ┃
┃ ┣-📜CarNameValidator.java
┃ ┃
┃ ┣-📜CarCountValidator.java
┃ ┃
┃ ┣-📜RoundValidator.java
┃ ┃
┃ ┣-📜ValidatorFacade.java
┃ ┃
┃ ┣-📜ErrorMessages.java
┃ ┃
┃ ┗-📂exception
┃   ┃
┃   ┣-📜InvalidCarCountException.java
┃   ┃
┃   ┣-📜InvalidCarNameException.java
┃   ┃
┃   ┗-📜InvalidRoundException.java
┃ 
┣-📂view
┃ ┃
┃ ┣-📜InputView.java
┃ ┃
┃ ┣-📜OutputView.java
┃ ┃
┃ ┗-📜ViewFacade.java
┃ 
┗-📜Application.java
```

---

## 기능 구현

### ⌨️ 입력

- [x]  자동차 이름 입력
    - [x]  사용자로부터 쉼표로 구분된 자동차 이름 입력
    - [x]  이름이 5자를 초과할 시 예외처리
    - [x]  이름이 공백일 시 예외처리
    - [x]  이름이 중복될 시 예외처리
    - [x]  이름, 즉 차량 개수가 1개 이하일 시 예외처리
- [x]  시도 횟수 입력
    - [x]  사용자로부터 시도 횟수 입력
    - [x]  정수가 아닌 문자를 입력하면 예외처리
    - [x]  입력값이 1 미만의 정수라면 예외처리
    - [x]  입력값이 int의 범위를 초과하는 정수일 시 예외처리

### 🔄 로직

- [x]  자동차 전진 조건
    - [x]  난수 생성기를 통해 0~9 사이의 값 생성
    - [x]  난수가 4 이상인 경우 자동차 전진
- [x]  라운드 진행
    - [x]  라운드마다 각 차마다 난수 생성
    - [x]  라운드마다 난수 결과에 따른 각 자동차의 위치 상태 업데이트
- [x]  우승자
    - [x]  가장 멀리 이동한 차는 우승자
    - [x]  우승자는 둘 이상일 수 있음

### 🖥️ 출력

- [x]  라운드 결과 출력
    - [x]  각 라운드가 끝날 때마다 자동차의 이름과 위치 출력
- [x]  최종 우승자 출력
    - [x]  모든 라운드가 종료되면 최종 우승자 출력
    - [x]  우승자가 여러명일 경우 쉼표로 구분하여 출력

---

## 📊 신경 쓴 부분

1. **인터페이스 사용** (`Validator`, `Generator`, `MoveStrategy`)
    - 인터페이스와 의존성 주입을 통해 확장 가능성을 확보하고자 하였습니다.
    - 제네릭과 인터페이스의 통합을 통해 다양한 형태의 구현체를 유연하게 생성할 수 있도록 하였습니다.


2. **MVC 구조**
    - MVC 패턴을 통해 애플리케이션을 **Model**, **View**, **Controller**로 구분하여 각 책임을 분리하고자 하였으며, **Service**를 추가하여 비즈니스 로직을 집중적으로
      처리했습니다.
    - **구성요소**:
        - **Controller** (`CarController`): 전체 경주 흐름을 제어하며, 사용자로부터 입력을 받고, 결과를 출력하는 중심 역할을 수행합니다.
        - **Service** (`RacingService`): 경주 게임의 비즈니스 로직을 담당하며, 자동차 초기화 및 라운드별 이동 로직을 처리합니다.
        - **View** (`InputView`, `OutputView`, `ViewFacade`): 사용자 입력 및 결과 출력을 담당하며, `ViewFacade`를 통해 입력과 출력을
          통합하여 `Controller`에서 간편히 접근할 수 있도록 하였습니다.
        - **Model**: 데이터 구조와 상태를 정의하며 `Car`, `Cars`, `CarNames` 등으로 구성되어 있습니다.


3. **팩토리 패턴 사용** (`CarFactory`, `CarsFactory`)
    - 객체 생성 로직을 팩토리로 분리하여 각 클래스가 자신의 역할에 집중할 수 있도록 했습니다. 초기에는 `Service`에서 객체 생성의 책임을 가졌으나, 팩토리 도입으로 책임을 분리하여 코드의 응집도를
      높였습니다.
    - **적용 예**:
        - **CarFactory**: 단일 `Car` 객체를 생성할 때 `CarFactory`를 통해 생성하여 코드의 일관성을 유지합니다.
        - **CarsFactory**: 여러 개의 `Car` 객체를 `CarNames`를 바탕으로 일괄 생성할 때 `CarsFactory`를 사용하여 `Cars` 객체로 초기화합니다.


4. **Facade 패턴 사용** (`ValidatorFacade`, `ViewFacade`)
    - 여러 컴포넌트를 사용하는 복잡한 로직을 간단히 처리할 수 있도록 **Facade 패턴**을 적용하여 코드 가독성을 높이고, **Service**나 **Controller**에 과도한 의존성 주입을
      방지했습니다.
    - **적용 예**:
        - **ValidatorFacade**: 유효성 검사 로직을 통합하여 `CarController`는 `ValidatorFacade`만
          호출함으로써 `CarNameValidator`, `RoundValidator`, `CarCountValidator`를 통해 유효성 검사를 일괄 수행할 수 있습니다.
        - **ViewFacade**: 입력 및 출력 클래스를 통합하여 `CarController`에서 `InputView`와 `OutputView`를 직접 참조하지 않고 `ViewFacade`를 통해
          접근하도록 함으로써 View 관련 의존성을 줄였습니다.