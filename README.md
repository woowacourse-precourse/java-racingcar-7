# java-racingcar-precourse

## 자동차 경주
매 턴 랜덤한 거리를 움직이는 자동차 경주 프로그램

---

## ✅ 구현할 기능 목록

### Car 클래스

- 속성 및 생성자: 자동차 이름과 초기 주행 거리를 설정.
- getter 함수: 주행 거리 반환.
- 이동 함수: 랜덤한 값에 따라 주행 여부 결정.
- 상태 반환 함수: 자동차의 주행 상태를 문자열로 반환.

### Race 클래스

- 속성 및 생성자: 입력된 문자열이나 리스트로 자동차 생성.
- 이동 시도 함수: 모든 자동차의 이동을 진행.
- 상태 반환 함수: 각 자동차의 이동 상황을 문자열로 반환.
- 우승자 결정 함수: 최대 주행 거리를 가진 자동차를 찾아 우승자 반환.

### 메인 함수 (Application 클래스)

- 사용자로부터 문자열 입력을 받아 자동차 목록 생성.
- 시도 횟수를 입력받아 경주를 진행하며 각 라운드 결과를 출력.
- 최종 결과 출력.

---

## 📋 클래스 설명

### Application.class

- `void main(String[])`
    - 프로그램의 시작점으로, 입력과 출력을 담당
    - 사용자 입력을 받으며, 각 함수 호출을 통해 계산 결과를 출력

### Race.class

- `Race(String input)`
    - Race의 생성자
    - string을 , 단위로 분할하여 자기 자신의 생성자를 호출


- `Race(List<String> names)`
  - List의 각 이름으로 Car를 생성하여 배열에 저장하며 Race를 생성


- `void run()`
  - 각 차량에 move를 호출


- `String toString()`
  - 각 차량의 현재 운행 정보를 문자열로 반환


- `String getWinners()`
  - 가장 먼 주행거리를 확인
  - 가장 먼 주행거리를 가진 차량의 이름을 정리
  - 최종 우승자를 정리한 문자열을 반환


- `int getMaxMileage()`
  - race에 참여중인 car중 가징 긴 주행 거리를 반환


- `List<String> getWinnerList()`
  - race에 참여중인 car중 가장 긴 주행거리를 가진 car의 이름을 리스트로 반환

### Car.class

- `Car(string name)`
    - 이름이 name인 Car를 생성
    - 이름의 길이가 5를 초과하면 오류 발생
    - 주행 거리를 0으로 초기화


- `void move()`
  - 랜덤 함수를 실행해서 움직임 여부를 결정


- `String toString()`
    - 현재까지의 주행 상황을 문자열로 반환


- `int getMileage()`
  - 현재까지의 주행거리를 반환


- `String getName()`
  - 차량의 이름을 반환