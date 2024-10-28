# java-racingcar-precourse

🚗 **Java 기반의 자동차 경주 게임** 🚗

사용자가 입력한 자동차 이름과 이동 횟수에 따라 경주를 진행하고 우승자를 가리는 프로그램입니다.

---

## 📋 기능 구현 목록

- **자동차 이동**: 주어진 횟수 동안 n대의 자동차가 전진 또는 멈춤
- **자동차 이름 부여**: 각 자동차에 이름을 부여하고, 전진할 때 이름과 함께 출력
- **이름 조건**: 자동차 이름은 쉼표(,)로 구분되며 5자 이하만 가능
- **이동 조건**: 0에서 9 사이의 무작위 값을 생성하여 4 이상일 경우 전진
- **사용자 입력**: 사용자가 이동 횟수를 입력할 수 있어야 함
- **우승자 판별**: 게임이 끝난 후 우승자(들)의 이름을 출력 (우승자가 여러 명일 경우 쉼표로 구분)
- **예외 처리**: 잘못된 값 입력 시 `IllegalArgumentException` 발생 후 애플리케이션 종료

---

## 🛠️ 프로그래밍 요구 사항

- **들여쓰기 제한**: indent(인덴트, 들여쓰기) depth는 최대 2까지만 허용
- **3항 연산자 금지**: 3항 연산자 사용 금지
- **단일 책임**: 함수(메서드)는 한 가지 작업만 수행하도록 최소화
- **테스트 코드**: JUnit 5와 AssertJ를 이용하여 모든 기능이 정상적으로 작동하는지 테스트

---

## 📂 프로젝트 구조

- main
    - java
        - controller
            - RacingGameController
        - model
            - Car
            - Cars
        - movement
            - MovementHandler
            - CarMovementHandler
        - service
            - RacingGameService
        - splitter
            - CarNameSplitter
            - CarNameSplitterImpl
        - validator
            - Validator
            - CarNameValidator
            - RaceCountValidator
            - ParseValidator
            - ParseIntValidator
            - Message
        - view
            - InputView
            - OutputView
            - Message

---

## 📚 라이브러리 및 도구

- **Random 값 추출**: `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 무작위 값 생성
- **사용자 입력**: `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용하여 사용자 입력 받기

