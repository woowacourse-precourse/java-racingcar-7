# java-racingcar-precourse
# 총 6개의 class와 1개의 interface를 만들어서 진행했습니다. 
## 1. Application 클래스
* 역할: 게임의 시작점을 제공하는 클래스입니다.

## 2. Car 클래스
* 역할: 각각의 자동차 객체를 생성하고, 이름 및 위치 상태를 관리합니다.

## 3. RacingGame 클래스
* 역할: 게임의 전체 진행 로직을 관리하는 메인 클래스입니다.

## 4. MoveStrategy 인터페이스
* 역할: 자동차가 이동할 수 있는지 여부를 결정하는 전략을 정의하는 인터페이스입니다.

## 5. RandomMoveStrategy 클래스
* 역할: MoveStrategy 인터페이스의 구현체로, 무작위 값에 따라 자동차 이동 여부를 결정합니다.

## 6. WinnerDeterminer 클래스
* 역할: 게임 종료 후 우승자를 결정하는 역할을 합니다.

## 7. RacingGameController 클래스
* 역할: 사용자 입력을 받아 게임을 초기화하고 시작하는 컨트롤러 클래스입니다.