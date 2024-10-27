# java-racingcar-precourse

# 자동차 경주

## 기능소개

- 주어진 횟수안에서 확률에 따라 전진하는 자동차 경주 게임
    - 자동차 이름은 알파벳과 숫자만 입력
    - 시도할 횟수는 1이상의 숫자로 입력

## 패키지구조

- domain
    - Car
    - Cars
    - NumberGenerator
    - Race

- view
    - InputHandler
    - InputView
    - OutputView

## 기능목록

- [x] 자동차를 전진시키기 - Car#move()
- [x] 우승자를 구하기 - Cars#getWinners()

### 입력

- [x] 쉼표로 구분된 경주할 자동차 이름 입력 - InputView#readCarNames()
    - [x] 문자열이 null이거나 비어있는 경우 예외처리 - InputHandler#checkEmpty()
    - [x] 중복된 이름이 있으면 예외처리 - InputHandler#validateUniqueNames()
    - [x] 이름이 없거나 5자초과이면 예외처리 - Car#checkNameLength()
    - [x] 알파벳이나 숫자가 아닌 문자가 입력되면 예외처리 - Car#checkNameForm()
- [x] 시도할 횟수 입력 - InputView#readAttemptCount()
    - [x] 숫자가 입력되지 않은 경우 예외처리 - InputHandler#validateNumber()
    - [x] 1미만의 숫자가 입력되면 예외처리 - InputHandler#checkMinimumOne()

### 출력

- [x] 실행 결과 메시지 출력 - OutputView#printResultMessage()
- [x] 실핼 결과 출력 - OutPutView#printResult()
- [x] 개행 출력 - OutputView#printNewLine()
- [x] 우승자 출력 - OutputView#printWinners()

