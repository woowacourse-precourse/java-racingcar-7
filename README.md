# java-racingcar-precourse

## 구현 기능 목록

### 1. 경주할 자동차 이름을 입력받는다.

    - 자동차 이름은 쉼표(,)로 구분한다
    - List에 저장한다
    - 이름은 5자 이하만 가능하다
    - 이름에 쉼표가 포함될 수 없다
    - 대소문자를 구분한다
    - 같은 이름이 반복될 수 없다

### 2. 경주를 몇 번(회차) 시도할 지 입력받는다.

    - 자연수만 입력 가능하다
    - 횟수 제한(~100,000)

### 3. 입력받은 회차동안 반복하며, 회차별로 각 자동차가 전진 혹은 정지하는지 결정한다.

    - 전진하는 조건: 0~9 사이 무작위 값이 4 이상일 경우

### 4. 반복이 종료된 시점에 우승자를 결정한다.

    - 가장 많이 전진한 자동차가 우승이다.
    - 우승자는 한 명 이상일 수 있다.

### 5. 우승자를 출력한다.

    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다