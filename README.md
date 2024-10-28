# java-racingcar-precourse

시도 횟수 만큼 각 자동차의 전진 여부를 랜덤값으로 결정하고, 최종 우승자를 출력한다.

### 주요 기능

- 시도 횟수 만큼 랜덤 숫자 생성
- 각 자동차 전진 여부 업데이트 + 중간 점수 출력
    - 전진 조건 : 랜덤 숫자가 0에서 9 사이 /4 이상일 경우

### 기능 세분화

- 자동차 이름 입력받기
- 쉼표 기준으로 분리하고 저장(Cars) + 유효검사
- 시도 횟수 입력받기
- 시도 횟수 저장 + 유효검사
- 시도 횟수 만큼, 랜덤 숫자 생성해서 각 자동차 전진 여부 판단
    - for시도횟수(for자동차(랜덤 번호 생성 및 거리 업데이트)[중간 출력])
- Cars 에서 가장 높은 점수 찾기
- 가장 높은 점수와 동일한 Car 가져오기 = 최종 우승자
- 출력 [최종 출력]
    - 1명 이상 가능, 쉼표로 구분

### 플로우

1. 자동차 이름 쉼표 기준으로 입력 받기
2. 시도할 횟수 입력 받기
3. 시도할 횟수 만큼 각 자동차 거리 업데이트하기 + 출력하기
4. 최종 우승자 출력하기

### 유효 검사

- 자동차 이름
    - 이름이 5자 이하인가?
    - ""와 " " 이(공백) 포함되었는가? -> ex)뽀로로,,포비
        - 이름 띄어쓰기는 사용 가능 ex) 뽀 로로
    - 특수문자 x

    - 자동차들 이름이 중복이 되었는가?
    - 입력받은 자동차의 개수가 1~50개 범위인가?
- 시도 횟수
    - 숫자인가?
    - 1~100번 범위인가?

### 추가 기능 요구 사항

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

---

```

 └── java
     └── racingcar
         ├── Application.java
         ├── controller
         │   └── MainController.java
         ├── domain
         │   ├── AttemptCounter.java
         │   ├── Car.java
         │   ├── Cars.java
         │   ├── CarsFactory.java
         │   ├── ErrorMessage.java
         │   └── number
         │       ├── NumberMaker.java
         │       └── RandomNumberMaker.java
         ├── service
         │   └── RaceService.java
         └── view
             ├── Input.java
             └── Output.java

```