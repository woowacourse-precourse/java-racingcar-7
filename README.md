## 자동차 경주

### [1. 기능 요구 사항](#functional-requirements)

### [2. 입출력 요구 사항](#io-requirements)

### [3-1. 프로그래밍 요구 사항 1](#programming-requirements1)
### [3-2. 프로그래밍 요구 사항 2](#programming-requirements2)

### [4. 기능 구현 목록](#implement-list)

## ✅ 기능 요구 사항 <a id="functional-requirements"></a>

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ✅ 입출력 요구 사항 <a id="functional-requirements"></a>

### 📍 **입력**

#### - 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    
    pobi,woni,jun

#### - 시도할 횟수

    5

### 📍 **출력**

#### - 차수별 실행 결과

    pobi : --
    woni : ----
    jun : ---

#### - 단독 우승자 안내 문구

    최종 우승자 : pobi

#### - 공동 우승자 안내 문구
    
    최종 우승자 : pobi, jun

### 📍 **실행 결과 예시**

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

## ✅ 프로그래밍 요구 사항 1 <a id="programming-requirements1"></a>

- DK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](#https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## ✅ 프로그래밍 요구 사항 2 <a id="programming-requirements2"></a>

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다
    - [JUnit5 User Guide](#https://junit.org/junit5/docs/current/user-guide/)
    - [AssertJ User Guide](#https://assertj.github.io/doc/)
    - [AssertJ Exception Assertions](#https://www.baeldung.com/assertj-exception-assertion)
    - [Guide to JUnit5 Parameterized Tests](#https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리

- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  
- 사용 예시
    - 0에서 9까지의 정수 중 한 개의 정수 반환


    Randoms.pickNumberInRange(0,9);

## 📚 기능 구현 목록 <a id="implement-list"></a>

## 기능
  
- [x] 전진 
  - 전진은 자동차 이름과 함께 하이픈(-)으로 표시한다.
  - 자동차별로 무작위 값(0~9)을 뽑아 값이 4 이상일 경우 한 칸씩 전진한다.
- [x] 우승자 선정
  - 자동차 객체 내의 dist 변수를 참고하여 전진한 거리가 가장 큰 자동차를 우승자로 선정한다.
  - 전진 거리가 같은 자동차가 여러 대 존재할 경우 공동 우승자로 선정한다.
  - 선정된 우승자를 화면에 출력한다.


## 입력

- [x] 사용자
  - 사용자는 경주할 자동차 이름을 쉼표로 구분하여 띄어쓰기 없이 입력한다.
  - 자동차 이름은 5자 이하의 영어로 입력해야 한다.
  - round를 몇 번 시도할 것인지 int 범위 내의 자연수(1~2,147,483,647)로 입력한다.

- [x] 입력 처리기
  - 사용자가 입력한 자동차 이름을 쉼표로 구분하여 토큰화한 뒤 공백을 제거하고 5자 이하인 경우 저장한다. (ex. "hail, ssin"은 허용)
    - 입력 문자열이 완전 공백인 경우에는 오류로 처리한다. (ex. "", "   ") 
  - 시도할 횟수가 int 범위의 자연수일 경우 저장한다. 
    - 숫자로 변환할 수 있는 숫자 문자열은 허용한다. (ex. "01"은 허용)

## 출력

- [x] inputView
  - 프로그램을 시작할 때 [입출력 요구 사항](#-입출력-요구-사항-a-idfunctional-requirementsa)에 맞추어 입력 메시지를 출력하고 문자열을 입력받는다.

- [x] outputView
  - 시도 횟수만큼 실행한 결과를 메서드로 호출하여 출력한다.
  - 가장 많이 전진한 자동차를 최종 우승자로 선정하여 우승자 안내 메시지를 출력한다.

## 예외
IllegalArgumentException을 발생시키는 경우
- 사용자가 경주할 자동차 이름을 입력하지 않은 경우: "[ERROR] 경주할 자동차 이름이 공백이 되어서는 안 됩니다."
- 사용자가 경주할 자동차 이름을 영어로 입력하지 않은 경우: "[ERROR] 경주할 자동차 이름을 영어로만 입력해 주세요."  
- 사용자가 경주할 자동차 이름을 5자를 초과하여 입력한 경우: "[ERROR] 경주할 자동차 이름을 5자 이하로 입력해 주세요."
- 사용자가 경주할 자동차 이름을 중복하여 입력한 경우: "[ERROR] 경주할 자동차 이름이 중복되었습니다."
- 사용자가 시도 횟수를 음수, 소수, int 범위를 초과하는 수, 숫자가 아닌 문자열로 입력한 경우: "[ERROR] 시도할 횟수를 자연수(1~2,147,483,647)로 입력해 주세요."
- 전진 거리가 모두 0인 경우: "[ERROR] 전진 거리가 모두 0이므로 우승자가 없습니다."

## 테스트

CarNameValidatorTest
  - 자동차 이름이 공백인 경우
  - 자동차 이름이 영어로만 입력되지 않은 경우
  - 자동차 이름이 5자를 초과하는 경우
  - 자동차 이름이 중복된 경우
  - 자동차 이름을 정상적으로 입력한 경우

GameCountValidatorTest
  - 시도 횟수가 음수인 경우 
  - 시도 횟수가 소수인 경우
  - 시도 횟수가 int 범위를 벗어나는 경우
  - 시도 횟수를 정상적으로 입력한 경우
