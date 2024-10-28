# java-racingcar-precourse
# 자동차 경주
## 기능 목록
-- --
### 1. Model 패키지
- Car.java : 자동차를 나타내는 모델 클래스
  - move() : 자동차 위치 이동
  - getPositionSymbols() : 현재 위치를 '-'기호로 변환 후 반환
- RacingGame.java : 게임 상태 관리
  - getCars() : 자동차들의 리스트 반환

### 2. View 패키지
- InputView.java : 사용자로부터 입력을 받음
  - inputCarNames() : 자동차 이름 입력 받기
  - inputNumberOfAttempts() : 시도 횟수 입력 받기
- OutputView.java : 게임 진행 결과를 출력
  - printExecutionResult() : 실행 결과 헤더 출력
  - printCars() : 자동차의 이름과 위치 출력
  - printWinners() : 최종 우승자 출력

### 3. Controller 패키지 
- GameController.java : 게임 컨트롤러 클래스
  - 입력 처리
  - 게임 진행
  - 결과 출력

### 4. Service 패키지 
- GameService.java : 게임 비즈니스 로직 처리
  - initGame() : 게임 초기화
  - processCarName() : 자동차 이름을 분리, 자동차 이름 유효성 검사
  - validateNumberOfAttempts() : 시도 횟수의 유효성 검사
  - moveCars() : 자동차 이동 여부 판단 후 업데이트
  - getCars() : 현재 자동차 리스트 반환
  - getWinners() : 우승자 찾은 후 반환

### 5. Util 패키지 
- InputValidator.java : 입력값의 유효성 검사
  - validateCarName() : 자동차 이름 검사
  - splitCarName() : 입력값 각 자동차 이름으로 분리
- RandomNumberGenerator.java : 랜덤 숫자 생성
  - shouldMove() : 랜덤 값 생성 후 4이상일 경우 이동 반환

## 발전 사항
이전 차수보다 더 발전 시켜본 점
- MVC 패턴 적용  
  => 역할 분담을 통해 효율적인 개발  
  => 설계 변경에 유연하게 대응


## 과제 진행 요구 사항
--- ---
- 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 ``README.md``에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항
--- ---
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 ``IllegalArgumentException``을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항
### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```commandline
pobi,woni,jun
```
- 시도할 횟수
```commandline
5
```
### 출력
- 차수별 실행 결과
```commandline
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```commandline
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```commandline
최종 우승자 : pobi, jun
```
### 실행 결과 예시
```commandline
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

## 프로그래밍 요구 사항 1
--- ---
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 ```Application```의 ```main()```이다.
- build.gradle 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다**.
- 프로그램 종료 시 ```System.exit()```를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2
--- ---
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    - JUnit 5 User Guide
    - AssertJ User Guide
    - AssertJ Exception Assertions
    - Guide to JUnit 5 Parameterized Tests

### 라이브러리
- ```camp.nextstep.edu.missionutils```에서 제공하는 ```Randoms``` 및 ```Console``` API를 사용하여 구현해야 한다.
  - Random 값 추출은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()```를 활용한다.
  - 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용한다.
#### 사용 예시
- 0에서 9까지의 정수 중 한 개의 정수 반환
```
Randoms.pickNumberInRange(0, 9);
```