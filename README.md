# 자동차 경주

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)을 입력한다.
  - pobi,woni,jun
- 시도할 횟수를 입력한다.
  - 5

### 입출력 예시

```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 구현할 기능 목록

### 도메인

- Car
  - 자동차 경주의 자동차
  - 외부 값에 따라 움직이거나 멈춰있을 수 있다.
  - CarFactory: 자동차 이름 문자열을 통해 Car 리스트를 생성한다.
- Lap
  - 자동차들을 관리하고, 움직이게 한다.
  - oneLap 메서드를 통해 한번씩 시도할 수 있다.
- Race
  - 랩을 관리하고, 시도 횟수만큼 여러번 랩을 실행하여 자동차 경주 결과를 반환한다.
  - RaceFactory: 자동차 리스트와 moveProvider를 통해 Race를 생성한다.
  - RaceManager: Race를 구성하고 실행시킨 후, 결과를 반환한다.
- Referee
  - 자동차 경주의 최종 우승자를 가린다.
- RandomAdapter
  - 랜덤값을 가져오는 행위를 추상화한다.
  - MissionUtilsRandomAdapter 구현체를 통해 실제 랜덤값을 가져올 수 있다.
- MoveProvider
  - 움직일 수 있는지 여부를 반환한다.
  - RandomMoveProvider 구현체를 통해 RandomAdapter의 값으로 이동 여부를 가져올 수 있다.
  - MoveProviderFake 구현체를 통해 정해진 순서에 따라 이동 여부를 모킹하여 가져올 수 있다.

### 구성

- MoveProviderConfig
  - MoveProvider를 구성하여 반환한다.
  - DefaultMoveProviderConfig 구현체를 통해 실제 실행시 필요한 MoveProvider를 반환한다.
  - TestMoveProviderConfig 구현체를 통해 테스트에서 필요한 MoveProvider를 반환한다.
- ReaderConfig
  - Reader를 구성하여 반환한다.
  - DefaultReaderConfig 구현체를 통해 실제 실행시 필요한 Reader를 반환한다.
  - TestReaderConfig 구현체를 통해 테스트에서 필요한 Reader를 반환한다.
- WriterConfig
  - Writer를 구성하여 반환한다.
  - DefaultWriterConfig 구현체를 통해 실제 실행시 필요한 Writer를 반환한다.
  - TestWriterConfig 구현체를 통해 테스트에서 필요한 Writer를 반환한다.
- RaceGameConfig
  - MoveProviderConfig, ReaderConfig, WriterConfig를 주입받아 자동차 경주 게임에 필요한 컴포넌트를 반환한다.

### 입출력 처리

- Reader
  - 입력을 추상화
  - MissionUtilsReader 구현체를 통하여 콘솔에서 값을 입력할 수 있다.
  - ReaderFake 구현체를 통하여 테스트 입력값을 모킹할 수 있다.
- Writer
  - 출력을 추상화
  - SystemWriter 구현체를 통하여 콘솔에 값을 출력할 수 있다.
  - WriterFake 구현체를 통하여 테스트 출력값 검증할 수 있다.
- RaceInputHandler
  - 자동차 경주를 시작하기 위한 자동차 이름, 시도 횟수를 받아서 반환한다.
  - RaceInputValidator: 자동차 이름, 시도 횟수 입력값을 검증한다.
- RaceOutputHandler
  - 자동차 경주의 결과를 출력한다.
  - RaceResultValidator: 자동차 경주의 결과를 검증한다.
  - RaceResultParser: 자동차 경주의 결과를 문자열 값으로 변환한다.

### 애플리케이션 시작

- RaceGame: RaceGameConfig를 통해 의존성을 주입받고, Race를 시작한다.

### 상수값 관리

- ExceptionMessages: 에외 메시지를 관리한다.
- InputMessages: 입력 메시지를 관리한다.
- OutputMessages: 출력 메시지를 관리한다.
- StringConstants: 문자열 상수값들을 관리한다.