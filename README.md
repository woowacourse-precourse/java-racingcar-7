# 자동차 경주

## 기능 구현 목록

### 사용자 👥

- [x] 사용자는 자동차의 이름을 입력할 수 있어야 한다.
    - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
        - [x] 이름이 5자가 넘어가면 예외 발생
        - [x] 입력된 자동차 개수가 2대 이상이 아닐 경우, 예외 발생
        - [x] 자동차 이름에 숫자와 문자 외 다른 문자가 입력되었을 경우, 예외 발생
        - [x] 자동차 이름이 중복되어 입력되었을 경우, 예외 발생
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
        - [x] 입력 값이 정수가 아니라면 예외 발생
        - [x] 입력 값이 0일 경우 예외 발생
- [x] 우승자가 누구인지 확인할 수 있어야 한다.
    - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 자동차 🚗

- [x] 자동차의 이름은 5자 이상이여서는 안된다.
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - [x] 무작위 값이 4 이상일 경우 전진한다.
    - [x] 무작위 값이 4 미만일 경우 멈춘다.(전진하지 않는다)

### 시스템 ⚙️

- [x] 0에서 9 사이에서 무작위 값을 생성 한다.
- [x] 전진하는 자동차를 출력할 때, 자동차 이름을 같이 출력한다.
- [x] 자동차 경주 게임을 완료한 후, 우승자를 출력한다.
    - [x] 우승자는 여러 명일 수 있다.
