# java-racingcar-precourse
## 자동차 경주 프로그램

<br>

## 🚀소개
자동차 경주 프로그램은 사용자가 입력한 자동차 이름을 기반으로 경주를 시뮬레이션하는 프로그램입니다. 
간단한 사용자 입력을 통해 자동차가 얼마나 멀리 전진할지를 무작위로 결정하고, 최종적으로 우승자를 선정합니다.🚗🚓🚕

<br>

## 🔑스스로의 규칙
1. AngularJS Git Commit Message Conventions을 적용해 커밋메시지 작성하기 <br>
2. Java Style Guide을 지키며 프로그래밍 하기<br>
3. 객체지향적 코드 생성하기<br>
4. 클래스와 method를 역할에 기반한 이름 부여하기
5. 테스트 코드 활용하기
6. 상수를 활용하기
7. 다양한 예외상황 생각하기

<br>

## 디렉토리 구조
```
```

## 📘프로그래밍 요구 사항 1
1. 21 버전에서 실행 가능해야 한다.
2. 프로그램 실행의 시작점은 `Application`의` main()`이다.
3. `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
4. 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
5. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
6. `자바 코드 컨벤션`을 지키면서 프로그래밍한다.
7. 기본적으로 `Java Style Guide`를 원칙으로 한다.

## 📘프로그래밍 요구 사항 2
1. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
2. 3항 연산자를 쓰지 않는다.
3. 함수가 한가지 일만 하도록 최대한 작게 분리해라
4. JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

<br>

## 🔻기능 목록

### 1️⃣사용자 안내 및 입력 기능
#### 1-1. 게임 시작 안내 메시지 출력
- 프로그램이 시작되면 사용자에게 입력을 유도하는 안내 메시지를 출력합니다.
- 출력되는 메시지:`"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"`
#### 1-2. 자동차 이름 입력 받기
- 사용자는 경주에 참여할 이름을 쉼표(,)로 구분하여 입력합니다.
  - 올바른 입력값이 아니라면 `예외`를 발생한다.
#### 1-3. 이동 횟수 입력 안내 메시지 출력
- 자동차 이름을 입력받은 후 시도할 횟수를 입력 받기 위한 안내 메시지를 출력합니다.
- 출력되는 메시지: `"시도할 횟수는 몇 회인가요?"`
#### 1-4. 시도할 횟수 입력 받기
- 사용자는 경주를 몇 번 진행할 것인지 입력합니다.
  - 올바른 입력값이 아니라면 `예외`를 발생한다.

<br>

### 2️⃣입력 값 검증 기능
⭕발생하는 예외는 IllegalArgumentException으로 지정한다.
#### 2-1. 자동차 이름이 유효한지 확인한다.
- 입력된 자동차 이름이 유효한지 확인한다.

    - 자동차 이름이 `5자 이하`가 아니라면 예외를 발생시킵니다.  
    - 자동차 이름에 `공백`과 `빈 문자열`일 경우 예외를 발생시킵니다.
    - 자동차 이름이 `중복`된다면 예외를 발생시킵니다.
    - 
#### 2-2. 이동 횟수 유효성 검증
- 입력된 이동 횟수가 유효한지 확인합니다.
    - 입력값이 `숫자(정수)`가 아니라면 예외를 발생시킵니다.
    - 입력 값이 `양의 정수`가 아니라면 예외를 발생시킵니다.
    - 입력 값이 이동 횟수의 `최대값`을 넘아가면 예외를 발생시킨다.

 <br>
  
### 3️⃣게임 진행 기능
#### 3-1. 라운드별 자동차 전진 여부 결정
- 각 라운드마다 자동차가 전진할지 결정합니다.
  - 무작위로 0에서 9사이의 숫자를 생성합니다.
  - 숫자가 4이상일 경우 자동차가 전진합니다.
#### 3-2. 라운드별 실행 결과 출력
- 각 라운드마다 모든 자동차의 전진 상황을 출력합니다.
  - 각 자동차 이름과 그동한 거리를 "-"로 출력합니다.

<br>

 
### 4️⃣우승자 계산 및 출력 기능
#### 4-1. 우승자 계산
- 모든 라운드가 끝난 후 가장 많이 전진한 자동차(들)을 계산합니다.
    - 모든 자동차 전진 거리를 비교하여 가장 큰 값을 가진 자동차(들)을 찾습니다.
    - 공동 우승자가 있을 수 있으며, 우승자가 여러 명일 경우 쉼표로 구분합니다.
#### 4-2. 우승자 출력
- 우승자(들)의 이름을 출력합니다.
    - 단독 우승자인 경우 `"최종 우승자: pobi"`와 같이 출력합니다.
    - 공동 우승자가 있을 경우 `"최종 우승자: pobi, jun"`와 같이 출력합니다.

<br>

## 🛠테스트 목록
### 1️⃣자동차 이름 입력 검증 테스트
1. 입력된 자동차 이름이 모두 1자에서 5자 사이인 경우 정상적으로 통과되는지 테스트.[ ✔ ]
2. 6자 이상의 이름을 입력하면 예외가 발생하는지 테스트.[ ✔ ]
3. 공백("") 또는 빈 문자열이 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
4. 동일한 이름이 중복 입력된 경우 예외가 발생하는지 테스트.[ ✔ ]
5. 중복되지 않은 이름이 입력될 경우 정상 통과되는지 테스트.[ ✔ ]
6. 입력된 자동차 이름이 Car 객체로 변환되는지 검증 테스트.[ ✔ ]

<br>

### 2️⃣이동 횟수 입력 검증 테스트
1. 공백("") 또는 빈 문자열이 입력된 경우 예외가 발생하는지 테스트.[  ]
2. 양의 정수 값이 입력된 경우 정상적으로 통과되는지 테스트.[  ]
3. 이동 횟수 입력 값이 숫자가 아닌 경우(문자나 특수문자) 예외가 발생하는지 테스트.[  ]
4. 음수나 0이 입력된 경우 예외가 발생하는지 테스트.[  ]
5. 설정한 이동 횟수의 최대값을 넘는 경우 예외가 발생하는지 테스트.[  ]

<br>

### 3️⃣게임 진행 기능 테스트
1. 각 라운드에서 0부터 9까지의 숫자가 무작위로 생성되는지 테스트.[  ]
2. 생성된 숫자가 4 이상일 경우 자동차가 전진하는지 확인하는 테스트.[  ]
3. 생성된 숫자가 4 미만일 경우 자동차가 전진하지 않는지 테스트.[  ]
4. 각 라운드가 진행된 후, 자동차 이름과 "-"로 표시된 전진 결과가 올바르게 출력되는지 테스트.[  ]

<br>

### 4️⃣우승자 계산 및 출력 테스트
1. 모든 라운드가 끝난 후, 가장 많이 전진한 자동차가 하나인 경우 그 자동차가 우승자로 계산되는지 테스트.[  ]
2. 가장 많이 전진한 자동차가 여러 대인 경우, 공동 우승자로 계산되는지 테스트.[  ]

<br>

### 5️⃣경기 전체 시나리오 테스트
1. 정상적인 자동차 이름과 이동 횟수를 입력하고, 모든 라운드가 정상적으로 진행되어 최종 우승자를 출력하는 전체 시나리오 테스트.[  ]

