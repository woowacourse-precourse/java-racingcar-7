# java-racingcar-precourse

# 기능 목록
## 입력
### 경주할 자동차의 이름 입력
- [x] 경주할 자동차의 이름을 요구하는 프롬프트를 작성한다.
- [x] 경주할 자동차의 이름을 입력받는다. (이름은 쉼표(,)를 기준으로 구분한다.)
- [x] 이름은 오직 영어 소문자와 대문자로만 입력할 수 있다.
- [x] 입력받은 자동차는 각각 자동차 객체를 생성하여 저장한다.

아래 4가지 경우에 오류를 반환한다.
- [x] 이름이 비어 있을 경우
- [x] 이름이 5자를 초과할 경우
- [x] 동일한 이름이 2번 이상 사용된 경우
- [x] 영어 소문자와 대문자를 제외한 문자, 특수 문자, 숫자 등이 포함된 경우


### 시도할 횟수 입력
- [x] 시도할 횟수를 요구하는 프롬프트를 작성한다.
- [x] 시도할 회수를 입력받는다.

아래 4가지 경우에 오류를 반환한다.
- [x] 문자를 입력한 경우
- [x] 정수가 아닌 수를 입력한 경우
- [x] 음수를 입력한 경우
- [x] 0을 입력한 경우

## 게임 진행
### 전진
- [x] 매 이동마다 0에서 9 사이의 무작위 값을 생성한다.
- [x] 무작위 값이 4 이상일 경우, 자동차를 전진시킨다.

### 결과 출력
- [x] "[이름] : [이동횟수]" 형식으로 결과를 출력한다.
- [x] 이동 횟수는 지금까지 이동한 횟수만큼 "-"를 출력한다.

## 게임 결과
### 최종 결과 계산
- [x] 가장 멀리 전진한 자동차를 확인한다.
- [x] 가장 멀리 전진한 자동차가 여러 대일 경우, 우승자를 모두 표시한다.

### 최종 결과 발표
- [x] 결과를 발표하는 프롬프트를 출력한다.
- [x] 우승자를 출력한다. (우승자가 여러 명일 경우, 쉼표(,)를 이용하여 구분한다.)