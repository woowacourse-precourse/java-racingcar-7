# java-racingcar-precourse

구현할 기능 목록을 정리

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

Application: 프로그램의 진입점
RaceGame: 게임을 제어하는 클래스입니다. 입력을 받고, 게임을 초기화하고, 실행하며, 최종 결과를 출력합니다.
InputView: 사용자로부터 입력을 받는 클래스입니다.
OutputView: 게임의 결과를 출력하는 클래스입니다.
CarName.java (원시값 포장)
Position.java (원시값 포장)
Cars.java (일급 컬렉션)
Car: 개별 자동차를 나타내는 클래스입니다. 자동차의 이름과 현재 위치를 포함하고 전진 여부를 결정하는 메서드를 포함합니다.


Car 클래스: 자동차의 이름과 위치를 관리하며, 전진 로직을 포함합니다.
RaceGame 클래스: 게임의 전체 흐름을 관리하는 컨트롤러 역할을 합니다. 입력을 받고, 게임을 실행하며, 결과를 출력합니다.
InputView와 OutputView 클래스: 입력과 출력을 담당하여 UI와 비즈니스 로직을 분리합니다.

원시값 포장:
자동차 이름(CarName)과 위치(Position)을 각각 포장하여 유효성 검증과 상태 관리를 해당 클래스에서 수행하도록 했습니다.
일급 컬렉션:
Cars 클래스를 도입하여 모든 자동차의 리스트를 관리하며, 자동차의 이동과 우승자 결정 등의 로직을 한 곳에서 처리했습니다.