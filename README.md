# java-racingcar-precourse

우아한테크코스 7기 프리코스 2주차 미션
======================================
기능목록
--------
1. InputView, OutputView : 입출력을 담당한다. RacingController의 요청을 받아 입력을 받아서 전달하고 출력값을 전달받아서 출력한다.
2. RacingController : View에 입출력을 요청한다. 주요 모델을 생성해서 RacingService에 전달해서 경주 및 저장을 요청한다.
3. RacingService : RacingController로 주요 모델을 전달 받아서 자동차 경주를 하고 과정 및 결과를 Repository에 저장한다.
4. Repository : RacingService로부터 전달 받은 주행 과정 및 결과를 저장하고 요청이 있으며 반환하는 저장소 역할을 수행한다.
5. RacingTurn : 자동차 이름 별 자동차 이동 전략을 매핑 값을 순차적으로 저장한 모델이다.
6. RacingTurns : RacingTurn를 순차적으로 저장한 모델이다.
7. StrategiesAtCarNames : 자동차 이름과 자동차 별 주행 시도 차례에 따른 이동 전략을 기록한 자료를 매핑 값을 저장한 모델이다.
8. Car : 자동차의 이름과 주행 거리를 저장한 모델이다.
9. Cars : 자동차 이름과 자동차 객체를 매핑 값을 저장한 모델이다.
10. CarNames : 자동차 이름을 저장한 모델이다.
11. RacingProgress : 자동차 주행 과정에 따른 이름과 주행 거리를 전달하는 DTO이다.
12. RacingRecording : 자동차 경주에 따른 과정과 우승자 발표 출력 값을 전달하는 DTO이다.
13. RacingWinners : 자동차 경주 우승자를 전달하는 DTO이다.
14. RacingChance : 자동차 주행 시도 횟수를 저장한 모델이다.
15. MoveStrategy : 자동차 주행 방법을 결정하는 전략을 담은 클래스이다.
16. ErrorMessage : 예외 메시지를 저장한 클래스이다.
17. IOMessage : 정해진 출력 값을 저장한 클래스이다.
18. CarNamesValidator : 자동차 이름값을 검증하는 기능을 담은 클래스이다.