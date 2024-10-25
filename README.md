# java-racingcar-precourse

# 구현할 기능 목록
- Model
    - [x] TextSeparator
    - [x] Car
    - [x] CarName
    - [x] Movement
    - [x] NumberValidator
    - [x] RandomNumberGenerator
    - [x] ProgressResultGenerator
    - [x] WinnerDeterminer
    - [ ] WinnerResultGenerator
- View
    - [x] InputView
    - [ ] OutputView
- Controller
    - [ ] GameController
- Test
    - [ ] TextSeparatorTest
    - [ ] CarNameTest
    - [ ] MovementTest
    - [ ] NumberValidatorTest
    - [ ] ProgressResultGeneratorTest
    - [ ] WinnerDeterminerTest
    - [ ] WinnerResultGeneratorTest

# 기능 동작 순서
1. 입력 메세지(경주할 자동차 이름)를 출력한다. (View / OutputView)
    - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
2. 경주할 자동차 이름을 입력받는다. (View / InputView)
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
3. 입력받은 문자열을 처리한다. (Model / TextSeparator)
    1. ,를 기준으로 문자열을 분리한다.
4. 분리한 자동차 이름으로 Car 객체를 생성한다. (Model / Car, CarName)
    1. 각 자동차 이름이 5자 이하인지 확인한다.
    2. 위 조건에 부합하지 않으면 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
5. 입력 메세지(시도할 횟수)를 출력한다. (View / OutputView)
    - 시도할 횟수는 몇 회인가요?
6. 시도할 횟수를 입력받는다. (View / InputView)
7. 입력받은 숫자를 처리한다. (Model / NumberValidator)
    1. 입력이 숫자인지 검증한다.
    2. 위 조건에 부합하지 않으면 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
8. 메세지(실행 결과)를 출력한다. (View / OutputView)
    - 실행 결과
9. 시도할 횟수만큼 아래 과정을 반복한다. (Controller / GameController)
    1. Car 객체의 개수만큼 아래 과정을 반복한다.
        1. 0에서 9 사이에서 무작위 값을 구한다. (Model / RandomNumberGenerator)
        2. 무작위 값을 Car 객체에 전달한다.
        3. 무작위 값이 4 이상인 경우 Car 객체는 전진한다. (Model / Car, Movement)
        4. 자동차 이름과 전진 현황을 출력한다. (View / OutputView)
            - pobi : —
    2. 빈 줄을 출력한다. (View / OutputView)
10. 메세지(최종 우승자)를 출력한다. (View / OutputView)
    - 최종 우승자 :
11. 최종 우승자를 뽑아 정답 문자열을 생성한다. (Model / WinnerDeterminer)
    1. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한 정답 문자열을 생성한다.
12. 정답 문자열을 출력한다. (View / OutputView)
    - pobi, jun