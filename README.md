# java-racingcar-precourse

### 기능 목록
- [X] 자동차 전진
  - [X] 60% 확률로 전진 (랜덤 값 4~9)
  - [X] 40% 확률로 멈춤 (랜덤 값 0~3)
- [X] 사용자 입력
  - [X] 경주할 자동차 이름 목록 입력
  - [X] 시도할 횟수 입력
- [X] 입력받은 자동차 이름 목록을 쉼표(,)를 기준으로 분리하여 이름 부여
- [X] 입력받은 횟수 동안 경주 반복
  - [X] 각 횟수에 대해서 중간 결과 출력
- [X] 우승자 판단
  - [X] 가장 전진을 많이한 자동차 (복수 가능)
- [X] 우승자 출력
- [X] 예외 처리
  - [X] 자동차 이름 5자 초과시 `IllegalArgumentException` 발생
  - [X] 입력 값이 공백 또는 `null`이면 `IllegalArgumentException` 발생
  - [X] 입력 받은 횟수가 자연수가 아니면 `IllegalArgumentException` 발생