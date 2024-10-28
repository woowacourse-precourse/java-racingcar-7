# java-racingcar-precourse


## 구현할 기능 목록

1. **CarNameInput 클래스 작성**
    - `settingCarName()` 메소드 호출
        - 자동차 이름 입력 문구 출력 및 입력 받기
        - 이름은 쉼표(,)를 기준으로 구분하여 각각 배열에 저장
        - `nameLengthCheck()` 메소드 호출
            - 이름이 6자 이상일 경우 `IllegalArgumentException` 발생 후 종료

2. **TrialNumInput 클래스 작성**
    - `settingTrialNum()` 메소드 호출
        - 시도할 횟수 입력 문구 출력 및 입력 받기
        - `numCheck()` 메소드 호출
            - 횟수가 양의 정수일 경우 입력값 변수에 저장
            - 아닐 경우 `IllegalArgumentException` 발생 후 종료

3. **Car 클래스 작성**
    - 자동차의 `dashCount`를 0으로 초기화
    - `move()` 메소드: `dashCount`를 증가시키고 출력 메소드 호출
    - `stop()` 메소드: `dashCount`를 유지하고 출력 메소드 호출
    - 자동차 이름 반환 메소드 제공

4. **Play 클래스 작성**
    - `play()` 메소드
        - 자동차마다 0~9 사이의 무작위 값 추출
        - 값이 4 이상일 경우 해당 자동차의 `move()` 메소드 호출
        - 값이 3 이하일 경우 해당 자동차의 `stop()` 메소드 호출

5. **ResultPrinter 클래스 작성**
    - `printWinner()` 메소드
        - `findWinner()` 메소드 호출하여 우승자 이름 배열 반환
        - "최종 우승자 : 이름, 이름, 이름" 형태로 반환값 출력

6. **Application 클래스 main() 메소드 작성**
    - `settingCarName()` 호출
    - `Car` 객체 배열 생성
        - 각 자동차 이름을 매개변수로 하여 `Car` 객체 각각 생성
    - `settingTrialNum()` 호출
    - 시도 횟수 만큼 반복하여 `play()` 호출
    - `printWinner()` 호출