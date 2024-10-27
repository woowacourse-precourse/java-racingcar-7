# java-racingcar-precourse

1. Application.java : 코드의 실행 흐름을 관리하는 클래스


2. Game.java : 자동차 경주를 진행하는 클래스
    * inputLane : 참가하는 자동차의 이름과 처음 위치(0)를 Car 객체에 저장하여 carList에 추가
    * printCarState : 현재 자동차들의 진행 상태를 출력
    * play : 시도 횟수(attemptCount) 만큼 자동차 경주를 진행
    * randomNumberTriggerAndStoreList : 난수 생성 후 4이상일 경우 carList의 position + 1

3. Car.java : 자동차 경주를 진행하는 Car의 이름과 현재 위치를 담는 객체


4. Input.java : Car의 이름과 시도 횟수를 입력 받는 클래스


5. Output.java : 최종 우승자 이름 출력하는 클래스
   * printWinner
   * setMax
   * addList

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
