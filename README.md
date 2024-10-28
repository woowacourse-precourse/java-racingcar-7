# 💌java-racingcar-precourse

## 🔖👉기능목록: 기능단위로 커밋 진행

1. 메인 애플리케이션 실행 (RacingGameApplication)
    - 기능: 메인 메서드 작성하여 전체 프로그램 실행
    - 구현: main 메서드에 `RaceService`, `RaceView`, `RaceController` 객체를 생성하고 게임을 시작 준비하기.

2. 사용자 입력 및 출력 뷰 (RaceView 클래스) 구현
    - 기능: 자동차 이름, 라운드 수 입력과 경주 진행 및 우승자 출력
    - 구현: RaceView 클래스에 `inputCarNames`, `inputRounds`, `printRaceProgress`, `printWinners` 메서드를 추가.

    - 참고사항 :
        - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
        - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
        - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()

3. 경주 게임 컨트롤러 (RaceController 클래스) 구현
    - 기능: 게임의 흐름을 제어하여 경주 실행, 예외 처리
    - 구현: RaceController 클래스에 startGame 메서드를 작성하여 입력을 받고, 라운드를 진행하며 결과를 출력.

4. 자동차 모델 (Car 클래스) Model에 구현
    - 기능: 자동차 이름 유효성 검사, 전진/멈춤 로직, 위치 관리
    - 구현: Car 클래스에 이름과 위치를 초기화하고 전진 조건을 기반으로 위치를 증가시키는 move 메서드를 구현.

5. 자동차 경주 모델 (Race 클래스) 새로운 Model 구현
    - 기능: 여러 Car 객체를 포함한 경주 로직과 우승자 판단 로직
    - 구현: Race 클래스에 자동차 리스트를 관리하고, raceOnce 메서드를 통해 각 자동차의 위치를 한 번씩 갱신. 최종 우승자를 반환하는 getWinners 메서드도 구현.

6. 경주 초기화 및 진행 서비스 (RaceService 클래스) 구현
    - 기능: 입력된 자동차 이름 리스트로 Race 객체 초기화, 게임 라운드 반복 실행
    - 구현: RaceService 클래스에 initializeRace와 startRace 메서드를 추가해 경주를 시작하고 반복적으로 raceOnce를 호출.


## 예외처리 검증 테스트 추가 및  클린코드
1. 입력값 유효성 검사 및 예외 처리 (InputValidator 클래스)
    - 기능: 사용자 입력에 대한 유효성 검사 및 예외 처리를 수행
    - 구현:
        - 자동차 이름이 빈 값인 경우, 공백이 있는 경우, 영어와 숫자만 포함 가능하며, 쉼표로 구분되어야 함, 중복 불가, 최대 5자까지 허용
        - 자동차는 최소 2대 이상 등록해야 함
        - rounds의 횟수가 비어 있는 경우, 1 이상이어야 하며, 숫자여야 하고, int 범위를 초과할 경우 예외 처리

2. 코드 리팩토링 (car 클래스)
    - 기능: 불필요한 코드 제거 및 중복된 유효성 검사 부분 삭제
    - 구현: InputValidator에서 유효성 검사와 관련된 중복 코드를 리팩토링하여 코드 가독성을 향상

3. 입력값 검증 테스트 (InputValidatorTest 클래스)
    - 기능: 자동차 이름 및 rounds 횟수에 대한 유효성 검증 테스트 추가
    - 구현:
        - 자동차 이름 유효성 검증: null/빈 문자열, 쉼표로 끝나는 입력, 특수문자 포함, 공백 이름, 중복 이름, 이름 길이(5자 초과), 최소 자동차 수(2대 미만) 검증 및 정상 입력값 검증
        - rounds 횟수 유효성 검증: null/빈 문자열, 숫자가 아닌 입력, 1 미만의 숫자 검증 및 정상 입력값 검증


## 🔖💡 자동차 경주 요구사항
### 기능 요구사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 프로그래밍 요구사항
1. indent(인덴트, 들여쓰기) depth는 3을 넘기지 않아야함. 2까지만 허용
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
2. 3항 연산자를 쓰지 않는다.
3. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
4. Unit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인
5. Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
6. 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
 - 사용 예시
    -  0에서 9까지의 정수 중 한 개의 정수 반환
    ```java
    Randoms.pickNumberInRange(0, 9);
    ```

## 🔖👨‍💻 커밋 큐칙
### 주제 라인
- 형식: <type>(<scope>): <subject>
- 주제 내용: 간결하게 변경 사항 설명

#### 👉 허용된 <type>
- feat (기능)
- fix (버그 수정)
- docs (문서)
- style (형식, 세미콜론 누락 등)
- refactor
- test (테스트 추가)
- chore (유지보수)

#### 👉 허용된 <scope>
- 커밋 변경의 위치를 명시하는 범위. 예: $location, $browser, $compile, $rootScope, 등.

#### 👉 <subject> 텍스트
- 명령형 현재 시제 사용: “change”가 아닌 “changed” 또는 “changes”
- 첫 글자 대문자 사용 금지
- 마침표(.) 사용 금지

#### 메시지 본문
- 명령형 현재 시제 사용
- 변경 동기 및 이전 동작과의 대비 설명
- Close에 이슈 번호를 지정하여 몇번 이슈를 추가하거나 제거하였는지 확인할 수 있도록 작성함 

#### 예시) feat($browser): onUrlChange 이벤트 추가
```
- feat($browser): onUrlChange 이벤트 추가

$browser에 새로운 이벤트 추가:
- 가능할 경우 popstate 이벤트 전달
- popstate가 불가능할 경우 hashchange 이벤트 전달
- 두 이벤트 모두 불가능할 경우 polling 수행

BREAKING CHANGE: $browser.onHashChange가 제거되었습니다. 대신 onUrlChange를 사용해야 합니다.

Closes #1
```