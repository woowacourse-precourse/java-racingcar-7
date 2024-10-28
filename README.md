# java-racingcar-precourse
# 1. 요구 사항
## 1-1. 입력
### 첫 번째 라인
| 경주할 자동차의 이름을 포함하는 문자열
- 쉼표로 구분됨
- 자동차의 이름은 5자 이하
- 자동차의 이름만큼 자동차가 생성됨

### 두 번째 라인
| 시도할 횟수를 나타내는 정수
- 1 이상의 정수 (자연수)

## 1-2. 출력
### 입력 가이드 텍스트
- "경주할 자동차 이름을 입력하세요."
- "시도할 횟수는 몇 회인가요?"

### 실행 결과
- 경주 결과 표시
- $(자동차 이름) : "-"
- 전진한 칸 수만큼 '-'로 표시
- 각 자동차는 줄로 구분됨
- 최종 우승자 표시
- "최종 우승자 : " $(자동차 이름), ...
- 표시될 이름은 1개 이상

# 2. 구현 사항
## 2-1. 클래스/인터페이스
### class Race
- private List<string> winnerList
- private List<Car> carList
- private string carName
- private int round

- public Race()
- public string setCarNameFromInput()
- public bool checkCarName() > 예외 처리 가능
- public List<Car> setCarListByName()
- public void StartRace(int round)
- public bool checkWinner()
- public List<string> setWinner()
- public void printWinner()

### class Car
- private string name
- private int currentPosition

- public Car(string, int)
- public void moveForward()
- public bool checkMoveForward(int)
- public void printPosition()

## 2-2. Main Application 플로우
- Race 생성
- 사용자로부터 자동차 이름 문자열 입력 받기
- 문자열을 쉼표로 구분하기
- 적절한 이름인지 검사하기
- 문자열을 토대로 CarList 배정하기
- round 만큼 Race 시작하기
- Race 우승자 출력하기

## 2-3. 예외 처리 (IllegalArgumentException)
### 경주할 자동차 이름
- 빈 문자열일 경우
- 예외 처리
- 영문자(소, 대)와 ',' 이외의 문자가 들어올 경우 > 정규 표현식으로 거르기
- 예외 처리
- 자동차 이름에 대한 예외는 checkCarName에서
### checkCarName()
- 빈 문자열일 경우
- 예외 처리
- 5자 초과할 경우
- 예외 처리
- 중복된 이름일 경우
- 예외 처리
### 시도할 횟수
- 다른 자료형일 때
- 문자, 소수 등 > 예외 처리
- 음수 일 때
- 예외 처리
- 0일 때
- 일단 예외 처리
- 테스트 제출해서 바꿀 예정

# 3. 테스트 코드
## 3-1. 테스트 케이스
### 자동차 이름
- 빈 문자열
- 쉼표가 앞에 온 경우
- 쉼표가 뒤에 온 경우
- 쉼표와 쉼표 사이가 빈 경우
- 다른 특수문자 및 한글
- 5자 이상의 이름
- 모두 5자 이상
- 섞기
### 시행 횟수
- 음수
- 0
- 빈 칸
- 소수, 문자
