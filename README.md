# java-racingcar-precourse

## 📋 구현할 기능 목록

### 경주할 자동차 이름 입력

- [x] 이름이 5자가 넘어가면 예외 발생
- [x] 쉼표(,)를 기준으로 구분이 안되면 예외 발생
- [x] 이름은 영어로만 구성되어있는지 확인
- [x] 중복되는 이름이 있는지 확인

### 이동 시도 횟수 입력

- [x] 양의 정수인지 확인
- [x] 빈값 인지 확인
- [x] 음수인지 확인
- [x] 0 입력시 공동우승 처리

### 자동차들 위치 출력

- [x] ${이름} : --- 와 같은 형식으로 출력
- [x] 입력받은 순서대로 실행결과 출력
- [x] 출력 간의 간격 일정하게 맞추기

### 우승자 출력 기능

- [x] 단독 우승자의 경우  `최종 우승자 : ${이름}` 형태로 출력
- [x] 공동 우승자의 경우 쉼표와 띄어쓰기를 이용해 구분하여 `최종 우승자 : pobi, jun` 형태로 출력

### 게임 진행

- [x] 각 자동차 마다 0-9 사이 무작위 숫자 생성
    - [x] 4이상 -> 전진
    - [x]  3이하 -> 전진 X

## 🛠️ 객체별 설계 구조

#### Model : 사용할 데이터와 비즈니스 로직

- Cars :  우승자 데이터 보유, 우승자 찾는 비즈니스 로직
- Car : 자동차의 이름과 현재 위치 데이터 보유, 자동차 이동 비즈니스 로직

#### View : 데이터 입력 및 안내 문구 및 출력 포맷 로직

#### Controller : Model에 있는 데이터를 View에게 전달 및 중계



