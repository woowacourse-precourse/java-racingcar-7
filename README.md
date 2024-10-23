# java-racingcar-precourse

# 2주차 프리코스 미션 자동차 경주

## 구현할 기능 정리

### 자동차 경주를 위한 자동차 이름 받기

* 사용자(USER)로 부터 자동차의 이름을 입력 받음 (Console API => Console.readLine()활용)

* 입력 받을때 자동차의 이름은 쉼표(",")를 기준으로 구분
* Ex) "car1, car2, car3" => "car1", "car2", "car3"

### 사용자가 자동차 이름을 잘못된 값 입력할경우 예외 처리

* 자동차의 이름은 5자 이하로만 가능 
* Ex) "legendCar" <= 5글자 초과 IllegalArgumentException 발생후 애플리케이션 종료

* 자동차의 이름 입력값중 같은값이 있을 경우
* Ex) "kimCar, kimCar, seoKar" <= kimCar 중복 IllegalArgumentException 발생후 애플리케이션 종료

* 입력하지않고 그냥 엔터입력 할 경우
* Ex) \n(줄바꿈 문자) <= 아무값이 들어오지 않아 IllegalArgumentException 발생후 애플리케이션 종료

* 아무 입력 없이 공백 만 입력 할 경우
* Ex) "   " <= 공백 IllegalArgumentException 발생후 애플리케이션 종료

### 사용자에게 전진 또는 후진을 위한 시도할 횟수 입력 받기

* 사용자(USER)로부터 몇번의 이동을 할 것인지를 횟수 입력 받음 (Console API => Console.readLine()활용)

### 사용자가 시도할 횟수를 잘못된 값 입력할경우 예외 처리

* 횟수기 때문에 숫자만 입력가능 
* Ex) "다섯번" <= 문자 입력 IllegalArgumentException 발생후 애플리케이션 종료

* 경주기 때문에 안 움직이는건 말이 안되기 때문에 0또는 음수 입력 할 경우
* "0", "-1" <= 0 또는 음수 입력 IllegalArgumentException 발생후 애플리케이션 종료

* 아무 입력 없이 공백 만 입력 할 경우
* Ex) "   " <= 공백 IllegalArgumentException 발생후 애플리케이션 종료

### 자동차의 전진 또는 후진 기능

* 랜덤 값을 이용해서 전진 또는 후진을 하기위해 랜덤값 생성 (Randoms API => pickNumberInRange()활용)
* 랜덤 값 범위는 0 ~ 9

* 전진 : 구한 랜덤 값이 4 ~ 9 일 경우 

* 후진 : 구한 랜덤 값이 0 ~ 3 일 경우

### 자동차 이동 실행 결과 출력

* 각각의 차를 줄바꿈으로 나열한 뒤 실행결과 출력 자동차별 위치는 "-"로 표시
* Ex) kimCar : -----
      seoCar : ----
      choiCar: --
      parkCar: -----

### 자동차 경주 우승자 자동차 이름 출력

* 전진 후진 모든 이동이 끝난후 우승자 출력

* 우승자가 한명일 경우 
* Ex) 최종 우승자 : kimCar

* 우승자가 여러명일 경우 쉼표(",")를 이용해서 구분하여 출력
* Ex) 최종 우승자 : kimCar, seoCar
