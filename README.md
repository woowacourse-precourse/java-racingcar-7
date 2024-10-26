# java-racingcar-precourse

1. Application.java : 코드의 실행 흐름을 관리하는 클래스


2. Game.java : 자동차 경주를 진행하는 클래스
    * inputLane
    * printCarState
    * play

3. Car.java : 자동차 경주를 진행하는 Car의 이름과 진행 상황을 담는 객체


4. Input.java : Console 을 통해 Car의 이름과 시도 횟수를 입력 받는 클래스


5. Output.java : 최종 우승자 이름 출력하는 클래스

````
├─main
│  └─java
│      └─racingcar
│              Application.java
│              CarGame.java
│              CarName.java
│              Input.java
│              Output.java
│
└─test
    └─java
        └─racingcar
                ApplicationTest.java
