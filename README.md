# java-racingcar-precourse

## 아키텍처

**MVC (Model-View-Controller)** 패턴을 따릅니다.

> - **Model**: 이벤트를 처리하고, 변경된 데이터를 View에게 전달합니다.
>- **View**: Model로부터 받은 데이터를 이용해 화면을 구성합니다.
>- **Controller**: View로부터 발생한 이벤트를 Model에게 전달하고, Model로부터 받은 데이터를 View에게 반환합니다.

---

## 고민되는 점 / 궁금한 점

프리코스를 진행하며 객체지향에 대해 공부하다 보니, 객체지향의 꽃은 `추상화`라는 말이 많네요!

2주차에서는 조금 더 역할에 대해 고민하고 싶어서 `클래스로 구현`부터 시작하지 않고, **인터페이스로 객체마다의 행동을 먼저 정의**해보았어요. 이 과정에서 몇 가지 불편한 점들이 있었는데, 다른 분들은 어떻게
인터페이스를 사용하고 있는지, 불편했던 점들에 대한 많은 의견을 듣고 싶습니다!

### 1. 구현에 따른 역할에 맞지 않는 행동

> - 객체지향에서는 **메시지로 서로 소통하며 프로그램을 만들어야 한다**고들 하죠! (TDA, Tell Don't Ask)
>- 그런데, 개발을 하다 보면 필드 값을 어쩔 수 없이 꺼내야 하는 경우가 생기곤 합니다. 그렇다고 필드 값을 꺼내는 행동을 인터페이스에 정의하자니, 이는 기존에 정의한 인터페이스가 가져야 할 책임이 아닌 것
   같더라고요.
>
>제가 내린 결론은 **추상화의 연속**이라고 생각했어요! Getter가 필요하다면, Getter에 대한 책임까지 갖고 있는 인터페이스를 **하위 인터페이스**로 추상화하면서 계속 정의해나가는 것이죠.
>
>현재 `Race` -> `RaceFind` -> `Car` (구현체)로 추상화와 구현이 되어 있는데요, `RaceFinder`라는 네이밍이 적절하지는 않지만, 승자를 찾는 의미를 나타내기 위해 `Finder`를
> 붙였습니다.
>
>서론이 길었네요..!
>
>여러분들은 **구현 과정에서 추상화에 정의되지 않은 행동이 필요한 경우 어떻게 하시나요? (특히 getter는 워낙 자주사용되는지라 어떻게 처리해야할지 고민이네요..!)**

### 2. 추상클래스와 인터페이스의 사용 기준

> `Car` 객체가 두 가지 행동을 부여받았습니다: `주사위를 던진다`, `움직인다`.
>
>- 이때 `주사위를 던진다`는 것은 굳이 외부에서 알 필요가 없는 `Car`만의 행동이라 생각해서 **private 접근 제어자**로 지정하고 싶었어요.
>- 하지만 한편으로, 주사위를 굴리는 행위가 `Car`만의 것이 아니라 `Ship`, `AirPlane` 같은 **다른 객체에서의 구현이 다를 수도** 있겠다고 생각해 **추상화**해두고 싶더라고요.
>- 그러나, 인터페이스는 private 접근 제어자가 사용 불가능하여 **추상클래스**로 추상화를 하게 되었습니다.
>
>추상클래스와 인터페이스, 둘 다 비슷한 기능을 제공하지만, 사용에 대한 기준이 모호한 것 같아요.
>
>**여러분들은 `추상클래스`와 `인터페이스` 각각 어떻게 사용하고 계신가요?**

---

## 기능 실행 플로우

1. 사용자 입력받기
    - 아무것도 안 입력되면 `IllegalArgumentException`


2. 자동차 이름 가공하기
    - `기준으로 나누기
    - 5글자 이상인 이름이 있다면 `IllegalArgumentException`


3. 몇번 게임진행되는지 입력받기
    - 음수면 `IllegalArgumentException`


4. 게임 시작


5. 주사위 굴리기


6. 이동하기


7. 우승자 구하기


8. 결과 출력하기

---

### Model

#### Race

- [X] 전체 라운드 진행
- [X] 각 라운드 진행

#### RaceFinder (Race상속)

- [X] 우승자 조회

#### Vehicle

- [X] 움직이기
- [X] 번호 굴리기

#### Decider

- [X] 움직여도 괜찮은지 결정하는 기능

---

### View

#### InputView

- [X] 사용자 입력을 받음.
    - 빈 문자열이라면 `IllegalArgumentException`

#### OutputView

- [X] 입력과 결과를 출력할 때 메시지 출력.

---

### Controller

#### GameController

- [X] 경기 시작
- [X] 입력값 가공

---

### Util

#### Splitter

- [X] 문자열을 `,` 기준으로 자르기
