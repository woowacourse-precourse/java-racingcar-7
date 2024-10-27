# 1. 🚘java-racingcar-precourse 기능 목록🚘
---

### ▪️ 입력
- [x] 자동차 이름 입력 받기
    - [x] 이름은 1~5자만 가능 / 이름 null, 0자 혹은 6자 이상인 경우 IllegalArgumentException 발생
    - [x] 이름은 영어나 숫자만 사용 가능 / 공백, 숫자, 특수문자가 포함된 경우 IllegalArgumentException 발생
    - [x] 쉼표를 기준으로 이름 구분 / 이외 구분자 사용 시 IllegalArgumentException 발생
    - [x] 최소 2명, 최대 10명 경주 가능 / 혼자 경주하거나 11명 이상 경주 시도할 경우 IllegalArgumentException 발생
    - [x] 중복된 이름 사용 시 IllegalArgumentException 발생
    - [x] 영어, 한글, 숫자 외 특수문자 사용 시 IllegalArgumentException 발생
- [x] 시도할 횟수 입력 받기
    - [x] 최소 1번, 최대 10번까지 시도 가능  / null 혹은 0번 횟수 입력 시 IllegalArgumentException 발생
    - [x] 숫자만 가능 / 숫자가 아닐 시 IllegalArgumentException 발생

### ▪️ 게임
- [x] 0-9 무작위 값 구하기(`camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용)
- [x] 무작위 값이 4이상인 경우 전진
- [x] 입력한 횟수만큼, 입력받은 인원만큼 반복
- [x] 우승자 구하기(공동 우승 가능)

### ▪️ 출력
- [x] 실행 결과 문구 출력
- [x] 차수별 실행 결과 출력 및 출력 후 한 줄 개행
- [x] 최종 우승자 안내 문구 및 최종 우승자 출력
    -[x] 우승자가 여러 명일 경우 쉼표로 구분   


## 2. ✅ 과제 제출 전 확인 사항 ✅
- [] `./gradlew clean test` 명령어로 테스트 모두 통과되는지 확인
- [] 함수가 단일 역할을 수행하는 작은 함수들로 이뤄져있는지 확인
- [] indent depth 3 안 넘었는지 확인
- [] 3항 연산자를 쓰지 않았는지 확인

## 3. 👊🏻 개인적인 구현 목표 👊🏻
- [] stream문 사용해보기
- [] 원시값, 문자열 포장하기
- [] 인터페이스 사용해보기
- [] 일급컬렉션 사용해보기
