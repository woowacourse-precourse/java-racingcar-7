# 자동차 경주 게임

## 프로젝트 개요
간단한 자동차 경주 게임을 통해 자바 언어와 객체지향 프로그래밍의 기초를 익히기 위한 프로젝트입니다. 사용자가 지정한 횟수 동안 여러 대의 자동차가 무작위 조건에 따라 전진하거나 멈추며, 최종적으로 가장 멀리 이동한 자동차가 우승자가 됩니다.

## 기능 구현 목록

### 1. 자동차 이름 입력 및 초기화
- **설명**: 사용자에게 쉼표(`,`)로 구분된 자동차 이름 목록을 입력받고, 각 자동차에 이름을 부여합니다.
- **조건**:
    - 각 자동차의 이름은 최대 5글자 이하여야 합니다.
    - 이름이 5글자를 초과할 경우 `IllegalArgumentException`이 발생하며, 프로그램이 종료됩니다.
    - 중복된 이름이나 빈 문자열이 포함된 경우도 예외를 발생시킵니다.
- **예시**:
    - 입력: `"car1,car2,car3"`
    - 결과: 자동차 목록 초기화 완료

### 2. 이동 횟수 입력 받기
- **설명**: 사용자로부터 자동차가 전진할 시도 횟수를 입력받습니다.
- **조건**:
    - 입력된 이동 횟수가 1 미만일 경우 `IllegalArgumentException`이 발생하며, 프로그램이 종료됩니다.
- **예시**:
    - 입력: `"5"`
    - 결과: 이동 횟수 설정 완료

### 3. 자동차 전진 여부 결정
- **설명**: 각 자동차는 무작위 숫자를 통해 전진 여부가 결정됩니다.
- **조건**:
    - 0에서 9 사이의 무작위 숫자를 생성하고, 숫자가 4 이상일 경우 자동차가 전진합니다.
- **기능 요약**:
    - `Randoms.pickNumberInRange(0, 9)` 메서드를 사용하여 무작위 값을 생성합니다.
    - 값이 4 이상이면 자동차의 위치가 1만큼 증가합니다.

### 4. 자동차 경주 실행
- **설명**: 설정된 이동 횟수 동안 모든 자동차를 순차적으로 이동시키며, 매 이동 후 현재 위치를 출력합니다.
- **조건**:
    - 각 이동 결과는 자동차 이름과 현재 위치를 포함하여 출력합니다.
- **출력 형식**:
    - 각 자동차는 이름과 "-" 기호로 위치를 나타냅니다.
    - 예: `car1 : ---` (자동차의 위치가 3인 경우)

### 5. 자동차 위치 출력
- **설명**: 각 이동 후 모든 자동차의 현재 위치를 이름과 함께 화면에 출력합니다.
- **출력 예시**:
  ```plaintext
  car1 : ----
  car2 : --
  car3 : ---

### 6. 우승자 결정
- **설명**: 경주가 끝난 후 가장 멀리 이동한 자동차를 우승자로 선정합니다.
- **조건**:
    - 여러 대의 자동차가 동일한 위치에 도달한 경우, 모두 우승자로 처리됩니다.
    - 우승자가 여러 명일 경우 쉼표(`,`)로 구분하여 출력합니다.
- **출력 예시**:
  ```plaintext
  우승자: car1, car3

### 7. 예외 처리
- **설명**: 잘못된 입력이 발생할 경우 `IllegalArgumentException`을 통해 오류 메시지를 출력하고 프로그램을 종료합니다.
- **예외 상황**:
    - 자동차 이름이 5자 초과일 경우
    - 이동 횟수가 1 미만일 경우
    - 빈 이름이나 중복된 이름이 입력된 경우

### 8. 결과 출력
