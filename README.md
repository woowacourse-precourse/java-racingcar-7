# java-racingcar-precourse

## 초간단 자동차 경주 게임을 구현한다

* 주어진 횟수 동안 n대의 자동차를 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 ```IllegalArgumentException```을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입력 요구사항(예시)

* 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) > ```a,b,c```
* 시도할 횟수를 정수로 입력하세요 > ```2```

## 출력 요구사항(예시)

* 차수별 시행 결과(입력한 시도할 횟수만큼 프린트)
    ```bash
  a : -
  b : 
  c : -

  a : --
  b : -
  c : -
  ```
* 우승자 안내 문구(예시)
    * (단독 우승의 경우) ```최종 우승자 : a```
    * (공동 우승의 경우) ```최종 우승자 : a, b```

## 프로그래밍 요구사항

* JDK 21버전에서 실행 가능해야 한다.
* 프로그램의 시작점은 ```main()```이다
* ```build.gradle```은 변경할 수 없고, 제공된 라이브러리 이외의 외부 라이브러리를 이용하면 안된다.
* 프로그램 종료 시 ```System.exit()```를 호출하지 않는다.
* 프로그래밍 요구사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* Java Style Guide를 지킨다.
* indent depth를 3이 넘지 않도록 한다.
* 3항 연산자를 사용하지 않는다.
* 메소드가 한 가지 일만 하도록 최대한 작게 만든다.
* JUnit5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.