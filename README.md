# java-racingcar-precourse

# 기능 목록

## ✅ 1. 각 자동차의 이름을 입력받는다.
- [x] 사용자에게 입력을 유도하는 문구를 출력한다.
- [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x] 자동차 이름은 쉼표(`,`)로 구분된다.
- [x] 각 자동차의 이름은 5자 이하이다.
  - [x] 아닐 경우 `IllegalArgumentException`을 발생시킨다.
- [x] `name1,,name2`와 같이, 자동차 이름이 `0`글자일 경우 `IllegalArgumentException`을 발생시킨다.

## ✅ 2. 시도할 횟수를 입력받는다.
- [x] 사용자에게 입력을 유도하는 문구를 출력한다.
- [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x] 시도할 횟수가 정수가 아닐 경우, `IllegalArgumentException`을 발생시킨다.
- [x] 시도할 횟수가 `0`이하일 경우, `IllegalArgumentException`을 발생시킨다.

## ✅ 3. 무작위 값으로 자동차가 전진할지 결정한다.
- [x] `0`에서 `9`사이의 무작위 값에서 값이 `4`이상인 경우에 전진한다.
  - [x] `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

## ✅ 4. 사용자가 입력한 시도할 횟수만큼 자동차 이동을 반복한다.
- [x] 정해진 형식대로 차수별 실행 결과를 출력한다.

## ❌ 5. 최종 우승자 출력
- [ ] 최종 우승자를 `1`명 이상 출력한다.
- [ ] 우승자가 여러 명일 경우 `,`로 구분하여 출력한다. 

# 과제 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 이용하여 프로그램이 정상 동작하는지 테스트한다.
- 코딩 컨벤션을 지키자!
- Git 명령어, `.gitignore` 등의 Git 사용법을 학습한다.