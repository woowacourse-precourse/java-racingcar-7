# java-racingcar-precourse
## 기능 목록

### Model

---
### Car (자동차)
* 자동차를 관리하는 역할을 한다.
* [x] 자동차 이름: 자동차의 이름을 저장한다.
    * [x] 자동차 이름은 최대 5자까지만 허용된다.
    * [x] 자동차의 이름이 비어있을 수 없다.
* [x] 움직인 거리: 자동차가 움직인 거리를 저장하며, 기본값은 0이다.
* [x] 움직임: 외부에서 주어진 조건에 따라 자동차를 움직일 수 있는 기능을 제공한다.

#### Cars (자동차들)
* [x] 일급 컬렉션: 여러 자동차(Car)를 관리하는 일급컬렉션
    * [x] 자동차 갯수는 최대 10개까지만 등록 가능하다.
* [x] 자동차 이동: 모든 자동차에 대해 주어진 조건에 따라 이동할 수 있는 기능을 제공한다.

#### CarRaceSnapshot (자동차 경주 스냅샷)
* [x] 스냅샷 기록: 각 라운드에서 자동차들의 이름과 움직인 거리를 기록한다.
* [x] 가장 많이 이동한 자동차 리스트 반환: 가장 멀리 이동한 자동차들의 이름을 반환하는 기능을 제공한다.

#### CarRace (자동차 경주)
* [x] 경주 시작: 지정된 횟수만큼 자동차 경주를 실행하며, 각 라운드의 스냅샷을 기록한다.
* [x] 최종 우승자 결정: 마지막 라운드 스냅샷을 기반으로 우승자를 결정하고 저장한다.
* [x] 입력 검증: 경주를 시작하기 전에 유효한 시도 횟수인지 검사한다.
    * [x] 시도 횟수는 1번 이상 100번 이하여야 한다.

### Utility

---
#### RandomMovementStrategy (자동차 움직임 전략)
* [x] 무작위 움직임 결정: 자동차가 움직일 수 있는지 여부를 무작위로 결정하는 기능을 제공한다.
    * 랜덤 숫자가 4이상일 경우 true 반환한다.

### DTO (Data Transfer Object)

---
#### CarRaceSnapshotDTO
* [x] 데이터 전송 객체: 자동차 이름과 움직인 거리 리스트를 포함하여, 외부로 전달하기 위한 형식으로 변환한다.

#### CarRaceSnapshotDTOs
* [x] 여러 스냅샷 DTO: `CarRaceSnapshotDTO` 리스트를 필드로 가지며, 전체 스냅샷 정보를 외부로 전달하기 위한 형식으로 변환한다.

### View

---
#### InputView (입력 뷰)
* [x] 사용자 입력: 자동차 이름과 시도 횟수를 사용자로부터 입력받는 기능을 제공한다.

#### OutputView (출력 뷰)
* [x] 결과 출력: 각 라운드의 결과와 최종 우승자를 사용자에게 출력하는 기능을 제공한다.
* [x] 시각적 표시: 자동차의 움직인 거리를 시각적으로 표현하기 위해 바 형태로 출력한다.

### Controller

---
#### CarRaceController (자동차 경주 컨트롤러)
* [x] 입출력 관리: 사용자 입력을 처리하고, 경주를 시작하며 결과를 출력하는 기능을 제공한다.
* [x] 흐름 제어: 경주 시작, 스냅샷 기록, 결과 출력의 전체적인 흐름을 관리한다.