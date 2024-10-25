# java-racingcar-precourse

---

## 자동차 경주

- 여러 대의 자동차가 참가하는 자동차 경주 게임
- 각 자동차에는 5자 이하의 이름을 부여할 수 있고, 사용자는 몇 번의 이동을 할지 설정
- 각 이동마다 0~9 사이의 무작위 숫자를 생성하여, 숫자가 4 이상일 경우 해당 자동차는 전진
- 게임 종료 후 가장 멀리 이동한 자동차가 우승자.

---
### 기능목록
- 자동차 이름 입력 기능
  - 자동차 이름 조건에 맞는지 확인
  - ,(쉼표) 를 기준으로 자동차 이름을 리스트에 저장

- 시도횟수 입력 기능
  - 입력값이 숫자인지 확인

- 자동차 생성 기능
  - 자동차 이름 생성
  - 자동차 이동거리 생성
  - 자동차 전진기능 구현

- 자동차 목록
  - 자동차 목록 생성
  - 자동차 목록에 자동차 이름 추가
  - 매 턴마다 자동차 전진 기능
  - 매 턴마다 상황 출력 기능
  - 상황 종료 이후 우승자 목록 출력 기능

- 레이싱 시작 이후 기능
  - 자동차 목록 생성
    - 자동차 목록에 추가
  - 입력된 턴수 만큼 실행
    - 자동차 전진
    - 레이싱 현재 상황 출력
  - 우승자 목록 생성
    - 우승자 출력


---

### 검증 목록(예외 상황)
- 입력값 검증
  - 입력값에 문자, 숫자, ,(쉽표) 외에 다른 것이 입력된 경우
  - 엽력값이 빈값(공백)인 경우
- 자동차 이름 검증
  - 자동차 이름은 5자 초과한 경우
  - 자동차 이름이 빈값(공백)인 경우
  - 자동차 이름이 중복이 발생한 경우
- 시도 횟수 검증
  - 시도 횟수 입력값이 빈값(공백)인 경우
  - 시도 횟수 입력값이 숫자가 아닌 경우
  - 시도 횟수 입력값이 0 이하인 경우

---

