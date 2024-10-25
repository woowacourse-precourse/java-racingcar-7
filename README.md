# 프리코스 2주차 미션 - 자동차 경주

> 우아한테크코스 7기 2주차 미션, 자동차 경주를 구현한 저장소입니다.

&nbsp;

![Java](https://img.shields.io/badge/Java-17-orange)

# 🏂 전체적인 흐름
1. 사용자로부터 자동차 이름과 게임을 진행할 횟수를 입력받는다.
2. 잘못된 값을 입력한 경우 에러를 발생시킨 후 종료한다.
3. 각 자동차마다 무작위 값에 의해 전진 또는 멈춤이 진행된다.
4. 자동차 경주 게임을 완료한 후 우승자를 모두 출력한다.

실행 결과 예시
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

&nbsp;

# 🥇 2주차 미션 목표
1. 클래스를 분리하며 개발하기
2. 예외에 대하여 더 꼼꼼히 검증하기
3. stream 사용하기

&nbsp;

# 🔧 구현할 기능 목록
- [✅] 자동차 이름이 쉼표 기준으로 모두 포함된 문자열을 입력받는다.
  - [✅] 자동차 이름이 로직에 맞게 입력됐는지 검증한다.
  - [✅] 잘못된 값이 입력된 경우, `IllegalArgumentException` 을 발생시킨 후 종료한다.
  - [✅] 자동차 이름을 쉼표 기준으로 나눈다.
- [✅] 게임을 진행할 횟수를 입력받는다.
  - [✅] 시도 횟수가 로직에 맞게 입력됐는지 검증한다.
  - [✅] 잘못된 값이 입력된 경우, `IllegalArgumentException` 을 발생시킨 후 종료한다.
- [✅] 입력받은 자동차 이름과 시도 횟수를 domain 으로 전달한다.
- [✅] 무작위 값에 의해 각 자동차의 전진 혹은 멈춤을 판단한다.
- [✅] 게임 실행 과정을 출력한다.
- [✅] 최종 우승자를 모두 출력한다.

&nbsp;

# 🥋 테스트 케이스
## 💣 에외에 대한 에러

### 자동차 이름에 대한 검증
- 아무 값도 입력하지 않았을 때 -> `[ERROR] 자동차가 없습니다.`
- 쉼표로 문자열이 종료될 때 ( 쉼표 뒤에 공백으로 된 비어있는 자동차 이름이 추가됐다고 간주 ) -> `[ERROR] 모든 자동차가 준비되지 않았습니다.`
- 자동차 이름이 비어있을 때 **ex) pobi,,woni** -> `[ERROR] 모든 자동차가 준비되지 않았습니다.`
- 자동차 이름이 5글자 초과일 때 -> `[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.`
- 자동차 이름이 중복될 때 -> `[ERROR] 같은 이름을 가진 자동차가 있습니다.`
- 자동차 이름 사이 공백은 허용 ->  **ex) kia 1, Benz,audi**

### 시도 횟수에 대한 검증
- 시도 횟수를 양의 정수로 입력하지 않았을 때 -> `[ERROR] 시도 횟수는 양의 정수여야 합니다.`
- 시도 횟수가 소수점으로 입력되었을 때 -> `[ERROR] 시도 횟수는 양의 정수여야 합니다.`
- 시도 횟수가 Integer 최댓값을 넘어갔을 때 -> `[ERROR] 시도 횟수는 최대값을 초과할 수 없습니다.`

&nbsp;

# 🗂️ 패키지 구조

### **view**
- InputView
  * readCarNames() - 사용자로부터 문자열 입력
  * readCountOfRounds() - 사용자로부터 정수 입력
- OutputView
  * showResultMessage() - 실행 결과 문구 출력
  * printCarPositions() - 실행 과정 출력
  * printWinners() - 우승자 명단 출력

### **model**
- Car
  * Car() - 생성자, 개별 자동차들의 이름과 초기 위치를 0 으로 저장 
  * move() - 무작위 값을 입력받아 자동차의 전진 여부 결정
  * getPosition() - 각각의 자동차의 위치 반환
  * getName() - 각각의 자동차 이름 반환
- CarStatus
  * CarStatus() - 생성자, 각각의 자동차들을 Car 객체로 생성해 ArrayList 에 추가
  * moveCars() - 무작위 값 생성
  * getCarNames() - 모든 자동차들의 이름이 담긴 리스트 반환
  * getCarPositions() - 모든 자동차들의 위치가 인덱스 값으로 담긴 리스트 반환
  * getWinners() - 최종 우승자 명단 반환
- WinnerFinder
  * findWinners() - 최종 우승자가 담긴 리스트 생성

#### **util**
- CarNameValidator
- RoundNumberValidator
- ExceptionMessage

### **controller**
- Controller
  * playGame() - 게임 진행

- Application
  * main() - 실행