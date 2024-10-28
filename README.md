# java-racingcar-precourse
# 자동차 경주 게임
![](src/main/java/resources/freepik__racing-car-game-image-with-many-car__58401.jpeg)
# UML
![](src/main/java/resources/uml_screenshot.png)
# 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
# 구현할 기능 목록
## Model
- [x] 이름을 입력할 수 있고 전진 기능이 있는 car class
- [x] car class 를 포함하는 cargroup class
  - [x] 최고점 판별하는 기능
  - [x] 우승자를 판별하는 기능
## View
- [x] 쉼표로 구분된 5자 이하의 자동차 이름 입력기능
- [x] 시도횟수 입력기능
- [x] 각 시도횟수 마다 상황을 출력하는 기능
- [x] 한 명 이상의 우승자를 출력해 쉼표로 구분하는 기능
## Controller
- [x] 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션을 종료하는 기능
  - [x] 차 이름을 입력하지 않았을 때
  - [x] 자동차 이름의 길이가 0일 때
  - [x] 시도 횟수를 0으로 입력했을 때
  - [x] 시도 횟수를 입력하지 않았을 때
  - [x] 중복된 자동차 이름이 있을 때
  - [x] CarGroup 생성 시 자동차 이름 입력값이 null일 때 
# 고려한 부분
- 일급컬렉션 사용
  - CarGroup을 일급컬렉션으로 구현해 Car 객체의 불변성과 유효성 검증에 대한 신뢰성을 보장
- Exception Handler, Exception Message Enum 사용
  - Exception Message를 별도로 관리하고 Handler를 통해 호출해 Exception 관리 편의성 적용 