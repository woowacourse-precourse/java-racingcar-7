# java-racingcar-precourse

### 1. 자동차 경주 게임의 입력처리 로직 구현
    ## a. 사용자가 경주할 자동차 이름을 입력할 수 있도록 요청할 수 있다. 입력 형식은 쉼표(,)로 구분된 리스트이다.
            a-1) Scanner를 사용해 사용자 입력을 받고, 쉼표를 기준으로 문자열을 분할해 자동차 이름 뮨자열 배열 (carNames)에 저장한다.
    ## b. 각 자동차 이름의 길이를 검사해서 입력받은 문자열이 5글자를 초과하면 IllegalArgumentException을 발생시킨다.
            b-1) trt - catch 문 사용
            b-2) finally 에서 Scanner 객체를 해제함
    ## c. 사용자에게 시도할 횟수를 입력받아 movecount에 저장한다.

### 2. Car 클래스 구현
    ## a. name, position, random
            a-1) random : Random 객체를 사용하여 랜덤 확률을 설정함
            a-2) 생성자 및 getter
            a-3) move() : 자동차가 전진할지 말지 결정하는 메서드.
            a-4) toString() : "name : -" 출력 형식

### 3. 메인 경주 게임 기능 구현 - RacingGo 클래스 정의
    ## a. 생성자
        a-1) carNames 리스트를 순회하며 각 이름을 가진 Car 객체를 생성하여 Cars 리스트에 추가함
        a-2) moveCount를 인자로 받아서 this.moveCount에 설정함 (이후 경주에 사용할 예정)
