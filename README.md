## java-racingcar-precourse

---
### 📋개요
* 우아한 테크코스 2주차 프리코스 미션 : 자동차 경주 게임
* 사용자가 입력한 경주할 자동차 이름과 경주 시도 횟수를 바탕으로 경주 회차별 실행 결과와 최종 우승자를 출력하는 게임입니다.
---
### 📂기능 설계 구조
```
src
├─main
│  └─java
│      └─racingcar
│          │  Application.java
│          │  
│          ├─controller
│          │      Controller.java
│          │      
│          ├─model
│          │      Cars.java
│          │      Evaluator.java
│          │      Race.java
│          │      Validator.java
│          │      
│          └─view
│                 Input.java
│                 Output.java
│                  
└─test
    └─java
        └─racingcar
            │  ApplicationTest.java
            │  
            ├─model
            │      CarsTest.java
            │      RaceTest.java
            │      
            └─view
                   InputTest.java
```
---
### 📃기능 설계 목록
1. Model
    * Cars 클래스
        - 경주 자동차의 회차별 위치 상태를 관리합니다.
        - Validator 클래스의 메서드를 상속받아 경주 자동차의 이름과 회차별 위치 상태를 갱신합니다.
    * Race 클래스
        - 경주 시도 횟수 및 최종 우승자 명단을 관리합니다.
        - Evaluator 클래스의 메서드를 상속받아 최종 우승자 명단을 생성합니다.
    * Validator 클래스
        - 경주 자동차의 이름 길이 및 위치 갱신 조건을 검증합니다.
        - 문자열 점검을 위한 정제 작업을 수행합니다.
    * Evaluator 클래스
        - 경주 자동차의 최종 위치 상태를 비교하여 최종 우승자를 검토합니다.
2. View
    * Input 클래스
        - 경주 자동차 이름 문자열과 시도 횟수 정수값을 입력받습니다.
        - 입력된 값이 올바른 형식인지 검증합니다.
    * Output 클래스
        - 경주 자동차의 회차별 위치 상태 및 최종 우승자를 출력합니다.
3. Controller
    * Controller 클래스
        - 경주 시도 횟수만큼 반복하여 수행하는 작업을 포함헤 자동차 경주 게임의 전체 흐름을 제어합니다.
        - Application 클래스가 해당 클래스의 메서드를 호출합니다.
---
### 🏁기능 검사 목록
* 신규 테스트:
    1. Model
        * CarsTest 클래스
            - 경주 자동차의 회차별 위치 상태 생성 및 갱신 작업을 검사합니다.
            - 경주 자동차의 이름 길이 초과 혹은 미달 관련 예외 처리 작업을 검사합니다.
        * RaceTest 클래스
            - 경주 최종 우승자 명단 생성 작업을 검사합니다.
    2. View
        * InputTest 클래스
            - 잘못된 형식의 경주 자동차 이름 문자열 및 시도 횟수 숫자값 입력 관련 예외 처리 작업을 검사합니다.
* 기존 테스트: 
    * ApplicationTest 클래스
        - 경주 자동차의 회차별 위치 상태 출력 작업을 검사합니다.
        - 경주 자동차의 이름 길이 초과 입력 관련 예외 처리 작업을 검사합니다.
---