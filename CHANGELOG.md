#### 2024-10-27

##### Documentation Changes

* **README.md:**
  *  구현한 기능 체크 (708020a6)
  *  기능 구현 완료한 목록 체크 (6a123434)
  *  구현한 기능 체크 (fe5617a1)
  *  기능 목록 정리 (97286061)

##### New Features

* **application:**  레이싱 게임 실행하는 application 구현 (37d256dd)
* **controller:**  model과 view를 연결하는 controller 객체 추가 (92e06ab1)
* **view:**  입출력 구현하는 클래스 추가 - InputView: 입력 담당 - OutputView: 출력 담당 (5be237fa)
* **dto:**  데이터 전달 클래스 구현 - CarRaceSnapshotDTO: 자동차 이름과 움직인 거리 리스트를 포함하여, 외부로 전달하기 위한 형식으로 변환한다. - CarRaceSnapshotDTOs: `CarRaceSnapshotDTO` 리스트를 필드로 가지며, 전체 스냅샷 정보를 외부로 전달하기 위한 형식으로 변환한다. (0d1cead4)
* **model:**
  *  자동차 경주를 구현하는 클래스 추가 - 지정된 횟수만큼 자동차 경주를 실행하며, 각 라운드의 스냅샷을 기록한다. - 최종 우승자 결정: 마지막 라운드 스냅샷을 기반으로 우승자를 결정하고 저장한다. (b3343e24)
  *  경주 결과를 기록하는 객체 구현 - 각 라운드에서 자동차들의 이름과 움직인 거리를 기록한다. - 가장 멀리 이동한 자동차들의 이름을 반환하는 기능을 제공한다. (ff9a343b)
  *  자동차들을 관리하는 객체 구현 - 여러 자동차(Car)를 관리하는 일급컬렉션 - 모든 자동차에 대해 주어진 조건에 따라 이동할 수 있는 기능을 제공한다. (74b4efe8)
  *  자동차 관리하는 객체 추가 - 자동차 이름과 움직인 거리를 저장한다. - 외부에서 주어진 조건에 따라 자동차를 움직일 수 있다. (a5c620e3)
*  자동차 움직임 여부를 결정하는 객체 구현 - 자동차 이동 로직을 추상화하기 위해 MovementStrategy 인터페이스 정의 - 이동을 위한 임의의 기준 로직을 갖는 RandomMovementStrategy 구현 (7bd3a55c)
*  setup project (5ec13447)

##### Tests

* **util:**  테스트에 사용할 고정된 움직인 전략 구현 (b4dd881a)
* **model:**  model test 구현 - CarTest - CarsTest - CarRaceSnapshotTest - CarRaceTest (a1a9c3da)

