# java-racingcar-precourse
# 자동차 경주 게임

## 프로젝트 개요
이 프로젝트는 콘솔 기반의 간단한 자동차 경주 게임입니다. 사용자는 경주할 자동차의 이름과 이동 횟수를 입력하여 경주를 진행합니다. 경주 결과로 가장 멀리 전진한 자동차가 우승자가 됩니다.

## 기능 목록
1. **자동차 이름 입력 기능**
    - 쉼표(,)로 구분된 여러 자동차 이름을 입력받습니다.
    - 각 자동차 이름은 5자 이하만 가능하며, 유효하지 않은 이름 입력 시 `IllegalArgumentException`을 발생시키고 프로그램이 종료됩니다.

2. **이동 횟수 입력 기능**
    - 경주할 이동 횟수를 입력받습니다.
    - 유효하지 않은 입력 값일 경우 `IllegalArgumentException`을 발생시키고 프로그램이 종료됩니다.

3. **자동차 전진 조건**
    - 0에서 9 사이의 무작위 값을 생성하여, 값이 4 이상일 경우 자동차가 전진합니다.
    - 무작위 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 메서드를 사용해 생성합니다.

4. **경주 결과 출력**
    - 각 이동 시도마다 각 자동차의 이름과 전진 상태를 출력합니다.
    - "-" 기호로 자동차가 얼마나 전진했는지 표시합니다.

5. **우승자 판별 기능**
    - 경주가 끝난 후 가장 멀리 전진한 자동차가 우승자가 됩니다.
    - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 공동 우승자를 출력합니다.

## 입출력 예시
### 입력
1. 경주할 자동차 이름을 쉼표로 구분하여 입력합니다.
   pobi,woni,jun

markdown
코드 복사
2. 시도할 이동 횟수를 입력합니다.
   5

shell
코드 복사

### 출력
각 시도별로 자동차의 전진 결과를 출력하고, 경주가 종료된 후 최종 우승자를 출력합니다.
실행 결과 pobi : - woni : jun : -

pobi : -- woni : - jun : --

pobi : --- woni : -- jun : ---

pobi : ---- woni : --- jun : ----

pobi : ----- woni : ---- jun : -----

최종 우승자 : pobi, jun

markdown
코드 복사

## 실행 방법
1. 저장소를 클론합니다:
   git clone <repository-url>

markdown
코드 복사

2. 프로젝트를 빌드하고 실행합니다:
   ./gradlew build ./gradlew run

markdown
코드 복사

## 커밋 메시지 규칙
- 커밋 메시지는 [AngularJS Git Commit Message Conventions](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#commits)에 따라 작성합니다.
- 커밋 유형에는 `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`가 포함됩니다.
- 예시:
  feat(input): add car name input validation

markdown
코드 복사

## 개발 환경
- JDK 21
- Gradle
- JUnit 5
- AssertJ

## 라이브러리 사용
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`와 `Console` API를 사용하여 무작위 숫자 생성과 사용자 입력을 처리합니다.
- `Randoms.pickNumberInRange(0, 9)` 메서드를 사용해 0에서 9까지의 무작위 값을 생성합니다.
- `Console.readLine()`을 사용하여 사용자로부터 입력을 받습니다.
