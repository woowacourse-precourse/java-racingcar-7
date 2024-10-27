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

**예외 기능**

입력 형식 예외 처리 -> IllegalArgumentException

1. 쉼표 기준으로 문자열 분리 후 각각의 문자열의 길이가 5자 이하인지 확인
2. 빈 문자열일때
3. 쉼표가 제일 앞에 나올 때 ex) ,pobi,james
4. 공백을 허용하되 맨 앞에 공백은 허용 안됨
4. 시도 횟수가 정수 범위 벗어날때