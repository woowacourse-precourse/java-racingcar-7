# java-racingcar-precourse

### 입력
1. 경주할 자동차 이름을 쉼표(,)를 기준으로 구분하여 입력받는다.
    - 각 이름은 최대 5자까지 입력 가능하다. 
2. 경기를 시도할 횟수를 입력받는다.

### 기능
1. 0에서 9 사이의 랜덤 값을 구한 후, 4 이상일 경우에만 전진한다.

### 출력
1. 시작 전, 안내 메시지를 출력한다.
2. 최종 우승자를 출력한다.

### 예외 처리
1. 잘못된 값을 입력할 경우, IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료된다.
    - 이름이 누락되거나, 6자 이상인 경우