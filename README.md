## 기능 요구 사항

레이싱게임의 이벤트들을 처리하는 구조로 설계

## 구현

### Car

책임 : 자동차의 이름과 위치를 관리

1. 자동차는 이름과 위치 상태를 필드로 갖는다.
2. 1 <= 자동차의 이름 길이 <= 5

### Printer

책임 : 이벤트에 따라 로그를 출력

1. 생성자에서 이벤트들을 구독
2. 이벤트들이 발생할 때마다 실행시킬 함수들을 작성
   1. GameStart ->  실행 결과
   2. RoundEnd -> 각 자동차들의 위치상태 출력
      ```
      pobi : -
      woni :
      jun : -

      ```
   3. GameEnd -> 우승자 출력
      ```
      최종 우승자 : pobi, jun
      ```
### Game

책임 : 게임에 필요한 필드들을 관리

1. 필드
   1. List<Car> : 자동차 리스트
   2. int : 총 진행할 라운드 카운트
   3. GameRoundHandler : 각 라운드마다 게임 진행을 RoundHandler에 위임
   4. enum GameEvent : 게임을 진행할 때 발생하는 이벤트를 열거형으로 저장
      1. Game Start
      2. Round End
      3. Game End

### GameRoundHandler

책임 : 게임의 한 라운드를 실행시키는 게임 로직을 작성
게임 로직이 변경될 수 있기 때문에 상위에 인터페이스를 두었다.

1. handle() : 게임 로직을 처리할 메서드 작성


### GameContext

책임 : 게임을 진행할 때 필요한 문맥정보들을 관리

1. Map 형식으로 문맥 정보들을 저장

### EventPubSubManager

책임 : 이벤트들의 발행과 구독

1. Map<Game.GameEvent, List<Consumer<Game>>> 구독은 Game.GameEvent을 key로 하고, 트리거되는 이벤트가 발생했을 때 실행할 함수형 인터페이스들을 저장
2. 구독과 발행 메서드 작성

