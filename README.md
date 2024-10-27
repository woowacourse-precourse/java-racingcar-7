# java-racingcar-precourse

### 큰 단위 위주 기능 리스트

### Controller

> **GameController 클래스**
>
> - 사용자가 입력한 턴 수 만큼 반복하여 게임을 실행
> - 중간 결과, 최종 결과를 OutputView와 연결

----

### Operator

> **GameEngine 클래스**
>
> - 각 턴에 진행되야 할 프로세스 수행

> **RandomNumberGenerator 클래스**
>
> - 0~9 사이의 랜덤 숫자 추출

> **WinnerSelector 클래스**
>
> - 최종 우승자 선별

### User

> **SettingGameUser 클래스**
>
> - 입력된 User의 객체를 생성

> **UserObject 클래스**
>
> - 사용자의 이름, 점수가 담긴 유저 정보 객체
> - 유저의 스코어 업데이트

### View

> 실제 입,출력 담당

**예외 기능 추가 필요**