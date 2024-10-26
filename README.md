# java-racingcar-precourse

## 구현할 기능

- [x] **1. 입력 기능**
    - 안내문 출력
    - 이름 입력
    - 시도횟수 입력

- [x] **2. 이름 추출 기능**
  - ,를 구분자로 하여 이름을 배열로 리턴
  
- [x] **3. 입력값 유효성 검증 기능**
    - 이름이 5자이하인지 검증

- [x] **4. 전진 기능**
    - 시도횟수를 받고 반복
    - 시도횟수만큼 전진 기능 사용후 결과를 배열에 담아 리턴

- [x] **5. 출력 기능**
    - 각 실행별 결과와 최종 우승자 출력

### 프로젝트 구조
```
├── Application.java
├── controller
│   └── CarController.java
├── domain
│   ├── Car.java
│   └── RaceRecord.java
├── service
│   └── CarService.java
└── view
    ├── InputView.java
    └── OutputView.java
```
