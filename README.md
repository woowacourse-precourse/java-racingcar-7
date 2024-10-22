# java-racingcar-precourse

## 🚀 기능 목록

### 🏁 CarRacing 객체

- [x] 자동차 이름에 대한 입력 힌트를 출력한다.
- [x] 자동차 정보를 저장한다.
  - [x] 자동차 이름을 입력받는다.
  - [x] 쉼표를 기준으로 이름을 나눈다.
  - [x] 각 이름의 유효성을 검사한다.
    - [x] ⚠️ 이름은 5글자 이하이다.
    - [x] 유효하지 않을 경우 `IllegalArgumentException`을 발생시킨다.
  - [x] 각 이름을 토대로 Car 인스턴스를 생성한다.
    - [x] 각 자동차 인스턴스를 멤버 변수로 저장한다.
- [x] 이동할 횟수에 대한 입력 힌트를 출력한다.
- [x] 이동할 횟수를 입력받는다.
  - [x] 이동할 횟수를 멤버 변수로 저장한다.
  - [x] ⚠️ 숫자만 입력으로 들어와야 한다.
  - [x] ⚠️ 양수만 입력으로 들어와야 한다.
- [x] 자동차의 수 만큼 Random 값을 생성한다.
- [x] 순서대로 자동차의 위치를 이동시킨다.
- [x] 이전 과정을 이동할 횟수만큼 반복한다.
- [x] 각 자동차의 위치를 출력한다.
- [ ] 각 자동차의 위치 중 가장 큰 값을 찾는다.
- [ ] 가장 큰 값을 가진 자동차의 이름을 출력한다.

### 🏎️ Car 객체

- [x] 생성자 구현
  - [x] 이름을 입력받아 멤버변수에 저장한다.
  - [x] 위치를 0으로 초기화한다.
- [x] 위치를 업데이트한다.
- [x] 자신의 위치를 출력한다.
