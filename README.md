# java-racingcar-precourse

### 큰 단위 위주 기능 리스트

### Controller

> **GameController 클래스**
>
> - TurnManager와 View 사이의 매개 역할을 하는 게임 컨트롤러
> - 중간 결과, 최종 결과를 OutputView와 연결

> **UserController 클래스**
>
> - 사용자 이름을 쉼표 기준으로 구분해 내고 userObject를 생성하는 컨트롤러
----

### module

> **GameEngine 클래스**
>
> - 각 턴에 진행되야 할 실질적인 프로세스 수행

> **RandomNumberGenerator 클래스**
>
> - 0~9 사이의 랜덤 숫자 추출

> **WinnerSelector 클래스**
>
> - 최종 우승자 선별

> **TurnManager 클래스**
>
> - 턴 실행 및 각각의 유저마다 GameEngine(게임 로직) 실행

### User

> **UserObject 클래스**
>
> - 사용자의 이름, 점수가 담긴 유저 정보 객체
> - 유저의 스코어 업데이트 기능

### View

> 입, 출력 기능

### validator

> **Validator 클래스**
>
> - 입력 형식에 대한 예외 처리
> - paring된 username형식에 대한 예외 처리
> - 숫자 예외 처리
-----
스스로 정한 요구사항

1. 최대 턴수는 1000회
2. 최대 자동차 개수는 1000개
3. 쉼표 사이를 기준으로 앞, 뒤 공백은 제거.