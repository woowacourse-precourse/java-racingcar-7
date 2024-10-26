# java-racingcar-precourse

## 1주차 피드백 반영

---
> 1주차 과제를 진행하면서 코드리뷰를 통해 많은 피드백을 받았습니다. (도와주신 모든 분들 감사합니다!!)
> 2주차 과제에서 해당 피드백들을 최대한 반영하려고 합니다. 아래는 피드백 내용입니다!

- [x] 상수는 상수 클래스를 별도로 관리한다.
- [x] 원시배열이 아닌 컬렉션을 사용한다.
- [x] 에러 메시지를 구체적으로 작성한다.
- [x] 서비스 클래스로 분리한다.
- [x] 입력받는 부분을 분리한다.

## 요구사항 정리

---

> **학습목표**
>
> - [x] 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
> - [x] 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 동작하는지 테스트한다.
> - [x] 1주차 공통 피드백을 **최대한** 반영한다. (1주차에서 반영 안된 사항)
  >   - [x] Java에서 제공하는 API를 적극 활용한다.
> - [x] 배열 대신 컬렉션을 사용한다.

### 기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.
> - [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
> - [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
> - [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
> - [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
> - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
> - [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
> - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
> - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항
- 입력
    - 경주할 자동차 이름(이름은 쉼표 기준으로 구분)
      ```text
      pobi,woni,jun
      ```
    - 시도할 회수
      ```text
      5
      ```

<br>

- 출력
    - 차수별 실행 결과
      ```text
      pobi : --
      woni : ----
      jun : ---
      ```
    - 단독 우승자 안내 문구
      ```text
      최종 우승자 : pobi
      ```

    - 공동 우승자 안내 문구
      ```text
      최종 우승자 : pobi, jun
      ```

### 프로그래밍 요구 사항
- indent depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


## 과제 분석

---
> 1주차 과제는 `왜?`라는 질문으로 문제에 대해 필요한 요소들을 하나하나씩 확인해서 정리했습니다.
> 이번 과제에서는 사용자의 관점, 개발자의 관점에을 나눠서 과제를 분석했습니다.

### 사용자 관점
- 프로그램 동작 과정
    1. 게임을 시작한다.
    2. 사용자는 경주할 자동차를 입력한다.
    3. 사용자는 시도할 횟수를 입력한다.
    4. 차수별 실행 결과를 출력한다.
    5. 최종 우승자를 출력한다.
    6. 게임을 종료한다.


### 개발자 관점
- 프로그램 동작 과정
    1. 사용자가 입력한 자동차의 이름들을 저장한다.
       - 입력값에 대한 검증을 진행한다.
    2. 사용자가 입력한 횟수를 저장한다.
       - 입력값에 대한 검증을 진행한다.
    3. 횟수만큼 게임을 진행한다.
        - 각 차수마다 자동차들은 랜덤으로 이동한다.
        - 이동 결과를 화면에 출력한다.
    4. 마지막 차수에서 가장 많이 전진한 자동차를 우승자로 정한다.
        - 우승자는 한 명 이상일 수 있다.
    5. 최종 우승자를 화면에 출력한다.


## 고민 사항

---

### 1. 데이터를 어디에 저장할까?
> 1주차 과제에서는 데이터를 원시 배열에 저장하였다. 2주차 과제에선 컬렉션을 사용한다.
- `Car`
  - `name`
  - `moveCount`


- `Game`
  - `gameCount`
  - `car List`
  - `winner List`

    
### 2. 사용자에게 어떻게 보여줄까?
> 1주차의 피드백을 반영하여 고정된 문자열, 숫자는 상수화를 한다. 또한 일반 사용자가 봐도
> 이게 무슨 역할인지 쉽게 알수 있도록 view라는 디렉토리로 구분해서 만든다.

- `constant`
  - `InputConstant`
  - `OutputConstant`


- `view`
  - `InputView`
  - `OutputView`

### 3. 자동차는 어떤 기준으로 움직일까?
> 문제 요구 사항을 보면 "전진하는 조건은 0에서 9 사이에 무작위 값을 구한 후 무작위 값이 4 이상일 경우"
> 라고 나와있다. 따라서 전체 틀을 잡기 전에 명확한 요구 사항이 있는 움직임의 조건 부터 만든다.

- `constant`
  - `NumberConstant`

- `util`
  - `RandomUtil`

### 4. 자동차와 게임의 역할 분리
> 1주차의 피드백을 반영하여 서비스 클래스를 분리한다. 게임 모델과 자동차 모델의 역할을 명확히 분리한다.

- `GameService`
    - 각 차수마다 자동차들의 동작 기능
    - 우승자를 결정하는 기능

- `CarService`
  - 자동차 이름 리스트에서 자동차 생성으로 이동하는 기능
  - 자동차 객체를 생성하는 기능

### 5. 예외처리
> 코드 피드백하는 과정에서 예외처리를 아주 깔끔하게 하신 분을 보고 참고하여 이번에는 예외처리 메서드를 만들려고 한다.

- 입력값
  - 자동차 이름 입력
      - 입력한 이름이 공백일 경우
      - 입력한 이름이 중복일 경우
      - 입력한 이름이 5자 초과할 경우
      - 입력한 문자열에 구분자가 없는 경우
      - 자동차가 하나인 경우
  - 게임 횟수 입력
    - 입력한 횟수가 0 이하일 경우
    - 입력한 횟수가 숫자가 아닌 경우
    - 입력한 횟수가 INT_MAX인 경우

### 6. 테스트코드
> 1주차 과제에선 테스트코드를 적용하지 않아서 이번 과제에서 적용하려고 한다.
> 
> 중복되는 테스트코드를 최대한 제외하고 진행했다.

- `model`
  - `CarTest`
  - `GameTest`
- `input`
  - `InputCarNameTest`
  - `InputCountTest`
- `service`
  - `GameServiceTest`


## 설계 구조

---

```text
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── config
│           │   ├── constant
│           │   │   ├── NumberConstant.java
│           │   │   ├── error
│           │   │   │   ├── ErrorCountConstant.java
│           │   │   │   └── ErrorNameConstant.java
│           │   │   └── io
│           │   │       ├── InputConstant.java
│           │   │       └── OutputConstant.java
│           │   └── exception
│           │       └── input
│           │           ├── count
│           │           │   ├── LessCountException.java
│           │           │   ├── MoreCountException.java
│           │           │   └── TypeMissCountException.java
│           │           └── name
│           │               ├── DelimiterNameException.java
│           │               ├── DuplicateNameException.java
│           │               ├── EmptyNameException.java
│           │               ├── LengthNameException.java
│           │               └── MultipleNameException.java
│           ├── controller
│           │   └── GameController.java
│           ├── helper
│           │   ├── util
│           │   │   ├── InputUtil.java
│           │   │   └── RandomUtil.java
│           │   └── validation
│           │       ├── InputCountValid.java
│           │       ├── InputNameValid.java
│           │       └── ProcessValid.java
│           ├── model
│           │   ├── Car.java
│           │   └── Game.java
│           ├── service
│           │   ├── CarService.java
│           │   └── GameService.java
│           └── view
│               ├── InputView.java
│               └── OutputView.java
└── test
    └── java
        └── racingcar
            ├── ApplicationTest.java
            ├── input
            │   ├── InputCarNameTest.java
            │   └── InputCountTest.java
            ├── model
            │   ├── CarTest.java
            │   └── GameTest.java
            └── service
                └── GameServiceTest.java
```
### GameController
- 프로그램의 흐름을 제어하는 컨트롤러 클래스이다.
- 입력, 게임 진행, 결과 처리를 관리한다.

### Car
- 자동차의 이름과 이동 횟수를 저장하고 관리하는 엔티티 클래스이다.

### Game
- 전체 게임 정보를 관리하는 엔티티 클래스이다.
- 게임 횟수, 자동차 리스트, 우승자 리스트를 저장하고 관리한다.

### CarService
- 사용자 입력으로 생성된 차량 목록을 등록한다.

### GameService
- 게임의 핵심 로직을 수행하는 클래스이다.
- 자동차 이동, 우승자 결정 등 게임의 주요 기능을 처리한다.

### InputUtil
- 입력과 관련된 유틸리티 기능을 제공하는 클래스이다.
- 입력 값을 파싱하거나 구분자로 나누는 작업을 수행한다.

### RandomUtil
- 게임에서 랜덤한 숫자를 생성하기 위한 유틸리티 클래스이다.
- 생성된 숫자는 자동차의 이동 여부를 결정하는데 사용한다.

### InputNameValid & InputCountValid
- 입력된 이름과 횟수의 유효성을 검증하는 클래스이다.

### ProcessValid
- 게임 로직에서 특정 조건이 충족되는지 확인하는 클래스이다.

### OutputView & InputView
- 사용자와의 입출력 문구를 보여준다.

### Exception
- 특정 오류 상황에서 발생하는 커스텀 예외 클래스이다.