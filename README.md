# java-racingcar-precourse
## 자동차 경주 게임 파일 구조
```
main/java/racingcar
├── Application
├── controller
│   └── GameController
├── model
│   └── RandomNumberGenerator
├── domain
│   ├── Car
│   ├── Cars
│   ├── GameResult
│   └── RoundResult
├── service
│   └── GameService
├── validator
│   └── Validator
└── view
    ├── InputView
    └── OutputView
```
## 클래스 및 기능 목록
### Application
  프로그램 시작점. 게임 시작
### InputView
사용자로부터 입력받는 클래스
 * 사용자로부터 자동차 이름 입력 받기
 * 사용자로부터 시도할 횟수 입력 받기
### OutputView
게임의 결과를 출력하는 클래스
* 차 위치 출력
* 게임 우승자 출력
### RandomNumberGenerator
범위 내 랜덤 숫자 생성 클래스
### Validator
사용자 입력값 유효성 검증 클래스
* 자동차 이름 5자 이하인지 검증
* 자동차 이름 입력값이 비어있는지 검증
* 시도할 횟수가 양수인 숫자인지 검증
### GameController
사용자의 입력을 받아 게임의 결과를 출력하는 전체 흐름 
* 입력값 Game에게 전달
* 응답값 View에게 전달
### GameService
게임 진행 로직 담당하는 클래스
* 입력 문자열 분리
* 라운드별 진행
* 자동차들 이동
* 라운드 결과 기록
* 최종 게임 결과 생성
### RoundResult
라운드 결과 출력 반환하는 클래스
### GameResult
우승자와 라운드 결과들 반환하는 클래스
### Car
각 자동차의 상태와 동작을 관리하는 클래스
* 자동차 객체 생성
* 자동차 이동
* 위치 반환
* 자동차 이름 반환
### Cars
Car 객체들의 컬렉션을 관리하는 일급 컬렉션 클래스
* 입력만큼 자동차 객체 생성
* 자동차들 이동
* 우승자 반환
* 최대 이동 거리 판단
* 자동차들 위치 반환
