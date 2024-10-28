# java-racingcar-precourse

# 기능 목록

## 1. Object RacingCar


: 대회에 참가하는 자동차와 관련된 필드와 메서드를 담당하는 객체


### 필드 구성
- **carName** : 자동차 객체의 이름
- **currentLocation** : 자동차의 현재 이동 상태를 시각적으로 표현하는 필드 ex) ---
- **currentDistance** : 자동차의 이동 거리를 수치적으로 나타내는 필드 ex) 3
- **randomNumber** : 자동차의 randomNumber를 저장하는 필드
- **forwardCondition** : 자동차의 전진 여부를 나타내는 필드

### 메서드 구성

**기능 1. 생성자 구현**
- 객체 생성 시 'currentLocation', 'currentDistance' 필드를 각각 ""와 0으로 초기화 하는 기능

**기능 2. setCarName 메서드 구현**
- 이름 받아들여서 형식에 맞으면 객체의 이름으로 저장하고, 형식에 맞지 않을 경우 IllegalArgumentException 예외 처리하는 메서드
- 예외 처리
    - 예외 case 1) 한글 또는 영어 외의 문자로 이루어진 문자열일 경우
    - 예외 case 2) 문자열의 길이가 1보다 작거나, 5보다 클 경우
  
**기능 3. checkForwardCondition 메서드 구현**
- 1부터 9 사이의 숫자 중 임의로 하나를 골라서 전진 조건인 3보다 큰지 확인하는 메서드
  - 뽑은 무작위값은 randomNumber 필드에 저장
  - 조건 만족 여부는 forwardCondition 필드에 저장

**기능 4. moveForward 메서드 구현**
- 자동차가 전진할 경우, currentLocation과 currentDistance를 변경하는 메서드
  - currentLocation 필드에는 "-"를 더하기
  - currentDistance 필드에는 1을 더하기

**기능 5. compareTo 메서드 구현**
- 자동차 객체로 구성된 우선순위큐에서의 비교 기준을 정의한 메서드
  - 자동차 객체의 currentDistance 필드를 기준으로 내림차순으로 정렬할 수 있게 하는 기능



## 2. Object RaceGame


 : 경주와 관련된 필드와 메서드를 담당하는 객체


### 필드 구성
  - **carNameList** : 자동차 객체의 이름들을 모아놓은 배열
  - **totalCars** : 자동차 객체의 수
  - **totalRounds** : 경기의 총 진행 횟수
  - **priorityqueue** : 자동차 객체의 currentDistance를 기준으로 정렬하여 저장하는 큐
  - **winners** : 가장 큰 currentDistance 값을 가지는 자동차 객체(또는 객체들)를 모은 배열

### 메서드 구성

**기능 1. getUserInput 메서드 구현**
- 사용자 입력을 받는 메서드
  - 이후 사용자로부터 자동차 이름 문자열을 받을 때나 경기 횟수 입력값을 받을 때 활용
- 예외 처리
  - 예외 case 1) 입력이 null이면 IOException 발생

**기능 2. getNamesList 메서드 구현**
- 사용자 입력에서 이름값을 뽑아내는 메서드
  - 사용자 입력을 ','를 기준으로 분리
  - 분리된 이름 값 앞,뒤로 공백이 있다면 제거
  - 이름을 이름 배열에 저장
  - 이름의 개수를 통해 경기에 참가하는 총 자동차 수(totalCars) 파악하기
- 예외 처리
  - 예외 case 1) 사용자 입력이 null일 경우
  - 예외 case 2) 사용자 입력이 공백일 경우
  - 예외 case 3) 사용자 입력이 빈 문자열일 경우
  - 예외 case 4) 구분된 이름들 중 공백이 있을 경우
  - 예외 case 5) 구분된 이름들 중 빈 문자열이 있을 경우
  - 예외 case 6) 구분된 이름들 중 같은 문자열이 있을 경우(이름이 중복되는 경우)

**기능 3. getTotalRounds 메서드 구현**
- 사용자 입력에서 총 경기 횟수를 뽑아내는 메서드
  - 사용자 입력값을 양의 정수로 변환하여 저장
- 예외 처리
  - 예외 case 1) 입력값이 정수가 아니라서 paseInt()로 변환이 불가능할 경우
  - 예외 case 2) 입력값이 정수지만 1보다 작을 경우

**기능 4. registerCar 메서드 구현**
- 자동차 객체를 생성하고, 객체마다 이름을 할당하는 메서드
  - 자동차 이름 배열과 총 자동차 수를 인자로 받아 이름을 할당받은 자동차 객체들을 배열에 저장

**기능 5. playOneRound 메서드 구현**
- 경기를 1회만 진행하는 메서드
  - 자동차 객체 배열에 있는 자동차 객체마다 전진 조건을 확인한 후, 조건을 만족할 경우 전진하는 기능
  - 자동차 객체의 checkForwardCondition 메서드와 moveForward 메서드 활용

**기능 6. printRoundResult 메서드 구현**
- 매 회차마다 형식에 맞춰 경기 진행 상황을 출력하는 메서드
  - 자동차 객체 배열을 받아 각 자동차별로 <이름> : <현재 이동 상태> 형식으로 진행상황 출력
  - 자동차 객체의 carName 필드와 currentLocation 필드 이용

**기능 7. findWinningCars 메서드 구현**
- 우승자를 찾는 메서드
  - 자동차 객체로 구성된 우선순위큐를 선언
  - 경기에 참가한 자동차 객체를 모두 우선순위큐에 넣기
  - 제일 먼저 최대 currentDistance 를 가지는 객체를 추출하고, 해당 객체의 carName 필드값을  winners 배열에 저장
  - 이후에 추출한 객체의 currentDistance가 최대 currentDistance보다 작아지기 전까지 해당 객체의 carName 필드 값도 winner 배열에 저장