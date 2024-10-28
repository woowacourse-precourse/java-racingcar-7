# :car: 자동차 경주
**java-racingcar-precourse**

우아한테크코스 7기 프리코스 양성호 (SyingSHY)

## 과제 진행 요구 사항
- [X] 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- [X] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [X] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- [ ] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- [ ] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

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

### 구현할 기능 목록
| No.   | 기능              | 구현 여부 | 기능 상세 내용                         |
|-------|-----------------|:-----:|----------------------------------|
| **1** | **입력**          | **X** | **사용자에게 입력에 대해 안내하고 문자열을 입력받는다** |
| 1-1   | 이름 입력 받기        |   X   | 사용자로부터 문자열을 입력받는다                |
| 1-2   | 경주 횟수 입력 받기     |   X   | 사용자로부터 숫자를 입력받는다                 |
| 1-3   | 입력 유효성 검증       |   X   | 입력된 값이 유효한 값인지 검증한다              |
| 1-4   | 입력 내 값 추출       |   X   | 입력 문자열 내 이름에 해당하는 문자열을 추출한다      |
| **2** | **자동차 경주**      | **X** | **자동차들의 경주를 진행한다**               |
| 2-1   | 전진 조건 확인        |   X   | `Randoms`에 기반해 자동차의 전진 여부를 확인한다  |
| 2-2   | 자동차 전진 처리       |   X   | 전진 조건 만족 여부에 따라 자동차를 1칸 전진시킨다    |
| 2-3   | 경주 후 선두 확인      |   X   | 경주가 종료된 시점의 선두를 확인하고 추출한다        |  
| **3** | **출력**          | **X** | **계산된 덧셈 결과를 사용자에게 출력한다**        |
| 3-1   | 입력 안내 메시지 출력    |   X   | 사용자에게 입력에 관한 안내 메시지를 출력한다        |
| 3-2   | 경주 개시 안내 메시지 출력 |   X   | 사용자에게 경주 개시를 안내하는 메시지를 출력한다      |
| 3-3   | 우승자 안내 메시지 출력   |   X   | 사용자에게 경주 우승자를 안내하는 메시지를 출력한다     |
| 3-4   | 경주 중 상황 출력      |   X   | 사용자에게 경주 상황을 출력한다                |
| 3-5   | 우승자 출력          |   X   | 사용자에게 우승자 목록을 출력한다               |
| **4** | **테스트 코드**      | **X** | **위 기능들을 검증하는 테스트 코드**           |
| 4-1   | 입력 테스트          |   X   | 입력 처리 과정 테스트                     |
| 4-2   | 자동차 경주 테스트      |   X   | 자동차 경주 과정 테스트                    |
| 4-3   | 출력 테스트          |   X   | 출력 처리 과정 테스트                     |

### 예외 처리
**예상되는 예외 입력**
- [ ] 입력 중 이름의 길이가 5자 초과인 경우 (`"namename"`) &rarr; `IllegalArgumentException`
- [ ] 입력 중 중복된 이름이 들어올 경우 (`"name,name"`) &rarr; `IllegalArgumentException`
- [ ] 입력 중 숫자가 아닌 다른 값이 들어올 경우 (`5` &rarr; `five`) &rarr; `IllegalArgumentException`
- [ ] 숫자 입력 값이 양수가 아닌 경우 (`0`, `-1`) &rarr; `IllegalArgumentException`
- [ ] 입력이 `null`이거나, 문자가 아니거나, 비어있을 경우 (`'\n'`,`" "`) &rarr; `IllegalArgumentException`

**예측하지 못한 예외 입력**
- [ ] 확인되지 않음

## 프로그래밍 요구 사항 1
- [X] JDK 21 버전에서 실행 가능해야 한다.
- [X] 프로그램 실행의 시작점은 Application의 main()이다.
- [X] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [X] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [X] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [X] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [X] 기본적으로 Java Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - [ ] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - [ ] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.