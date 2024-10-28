# java-racingcar-precourse

### 1. 자동차 경주 게임의 입력처리 로직 구현
    ## a. 사용자가 경주할 자동차 이름을 입력할 수 있도록 요청할 수 있다. 입력 형식은 쉼표(,)로 구분된 리스트이다.
            a-1) Scanner를 사용해 사용자 입력을 받고, 쉼표를 기준으로 문자열을 분할해 자동차 이름 뮨자열 배열 (carNames)에 저장한다.
    ## b. 각 자동차 이름의 길이를 검사해서 입력받은 문자열이 5글자를 초과하면 IllegalArgumentException을 발생시킨다.
            b-1) trt - catch 문 사용
            b-2) finally 에서 Scanner 객체를 해제함

