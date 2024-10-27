# 자동차 경주
## 목표
여러 개의 자동차가 n번 동안 **확률적으로** 전진을 시도.   
**확률적으로**라는 뜻은 0과 9 사이에서 무작위로 나온 값이 **4 이상**일 경우를 뜻함    
마지막 시도가 끝난 후 가장 많이 전진한 자동차를 **우승자**로 결정함    
우승자가 **여러 명일 수 있음**
## 기능
### - 자동차명과 총 차수 입력받기
### - 각 자동차별로 해당 차수에 전진 여부를 무작위로 결정
### - 마지막 차수가 끝난 뒤 전진한 거리 비교
### - 거리 비교 후 단독 우승자 또는 공동 우승자 출력
### - 잘못된 입력이 들어올 시 `IllegalArgumentException` 발생
## 패키지 / 클래스 
```angular2html
├─main
│  └─java
│      └─racingcar
│          │  Application.java
│          │
│          ├─controller // 컨트롤러 계층으로 경주, 자동차, 입출력에 관한 메서드들을 가져와 사용자 친화적으로 조합
│          │  │  RaceController.java // 경주를 총괄하는 클래스
│          │  │  RaceControllerEmb.java
│          │  │  RacingCarController.java // 자동차를 움직이는 클래스
│          │  │  RacingCarControllerEmb.java
│          │  │
│          │  └─IO // 컨트롤러 중 입출력 관련 클래스 모음
│          │          InputController.java // 자동차명 입력과 총 차수 입력을 담당하는 클래스
│          │          InputControllerEmb.java
│          │          OutputController.java // 유저에게 입력을 요구하는 출력과 경주 진행 현황, 우승자를 출력하는 클래스
│          │          OutputControllerEmb.java
│          │
│          ├─model // 모델 계층으로 자동차를 정의
│          │      RacingCar.java // 자동차 객체를 정의한 클래스
│          │      RacingCarEmb.java
│          │
│          ├─service // 서비스 계층으로 여러 클래스에서 쓰이거나 별도의 기능을 구현한 곳
│          │  ├─decision // 자동차의 전진 로직
│          │  │      ForwardOrNot.java // 자동차의 전진 여부를 무작위 숫자로 결정해 알려주는 클래스
│          │  │      ForwardOrNotEmb.java
│          │  │
│          │  ├─evaluator // 우승자를 탐색
│          │  │      WinnerEvaluator.java // 자동차들이 전진한 거리를 비교해 우승자를 찾는 클래스
│          │  │      WinnerEvaluatorEmb.java
│          │  │
│          │  ├─factory // 객체 생성을 담당
│          │  │      CarFactory.java // 들어온 입력을 자동차 객체로 만들어주는 클래스
│          │  │      CarFactoryEmb.java
│          │  │      RaceControllerFactory.java // 경주 컨트롤러 객체를 만드는 클래스
│          │  │      RaceControllerFactoryEmb.java
│          │  │
│          │  └─parser // 입력을 관리
│          │          ParsingService.java // 자동차 이름들을 각자로 나누고, 차수를 숫자형으로 바꿔주는 클래스
│          │          ParsingServiceEmb.java
│          │          ValidCheck.java // 들어온 입력이 프로그램의 규칙에 맞는지 체크하는 클래스
│          │          ValidCheckEmb.java
│          │
│          └─view // 뷰 계층으로 유저와의 상호작용을 담당
│                  InputHandler.java // 입력을 담당하는 클래스
│                  InputHandlerEmb.java
│                  ResultViewer.java // 출력을 담당하는 클래스
│                  ResultViewerEmb.java
│
└─test
└─java
└─racingcar
ApplicationTest.java
```
유지보수와 확장성을 고려해 인터페이스를 만든뒤 선언한 메서드들을 인터페이스명에 Emb를 붙인 클래스에서 정의해서 분리시킴
## 입출력 예시
### 입력
- 먼저 개수가 정해지지 않은 자동차들을 한 줄로 입력
- 그 후 총 차수를 입력받음
```
pobi,woni,jun // 자동차 이름들
5 // 
```
### 출력
- 단독 우승자 안내 문구
```angular2html
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```angular2html
최종 우승자 : pobi, jun
```
### 실행결과
```
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