# java-racingcar-precourse

2주차 미션 - 자동차 경주

### 기능 목록

1. ✅ 사용자 입력값을 받는 기능
    - [x] 경주할 자동차 `이름`을 입력 받는다
    - [x] `시도 횟수`를 입력 받는다

2. ✅ 입력값에서 데이터를 추출하는 기능
    - [x] 입력값을 `구분자로` 자른다
    - [x] 추출한 이름을 `입력한 순서대로` 저장한다

3. ✅ 자동차 이름의 값을 검증하는 기능
    - [ ] `영어` 혹은 `한글`이 아닌 문자가 포함된 이름은 예외다
    - [ ] `공백`으로 이루어진 이름도 예외다
    - [x] 제한된 범위를 초과하여 입력하면 예외다
    - [ ] 문자와 문자 사이에 `공백`이 포함된 이름도 예외로 처리한다. 단, 이름의 양끝에 입력된 공백은 허용
    - [ ] 입력된 이름이 `1개 미만`일 경우 예외다

4. ✅ 시도 횟수를 검증하는 기능
    - [ ] `공백`을 입력하면 예외다
    - [x] `숫자 타입이 아닌` 값을 입력하면 예외다
    - [ ] `0` 혹은 `음수`를 입력해도 예외다

5. ✅ 자동차 경주를 실행하는 기능
    - [x] 주어진 범위 내에서 무작위 숫자를 생성한다
    - [x] 무작위 값의 조건에 따라 자동차는 전진하거나 혹은 전진하지 않는다
    - [x] 차수별로 진행 결과를 안내한다

6. ✅ 우승자를 판별하는 기능
    - [x] 자동차들의 전진 거리를 비교한다
    - [x] 가장 먼 거리를 전진한 자동차를 저장한다

7. ✅ 우승자를 안내하는 기능
    - [x] 공동 우승자가 있으면 `,`로 구분하여 모두 안내한다
    - [x] 공동 우승자는 입력한 순서대로 출력한다