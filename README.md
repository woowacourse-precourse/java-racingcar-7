# java-racingcar-precourse

1. Application.java : 코드의 실행 흐름을 관리하는 클래스
   1) Input 클래스를 이용하여 자동차 이름과 시도 횟수 입력
   2) Cars 객체를 생성한 뒤 자동차 이름을 List로 변환하여 생성자로 전달
   3) Game 객체를 생성한 뒤 경주를 수행할 자동차를 인자로 넘겨줌
   4) 시도 횟수만큼 game.play()를 수행
   5) 경주가 끝난 뒤 최종 우승자를 출력


2. Game.java : 자동차 경주를 진행하는 클래스
    * play : 자동차 경주에 참가하는 자동차들 모두에 대해 move 진행 후 실행 결과 출력
   

3. Car.java : 자동차 경주를 진행하는 자동차의 이름과 현재 위치를 담는 객체
    * validateName : 자동차의 이름이 비었거나 이름이 5글자 이상이면 오류 발생 후 프로그램 종료
    * move : 난수를 생성한 뒤 4이상이면 해당 자동차의 위치(position)+1 
    * getPosition : 자동차의 위치(position) 반환
    * getName : 자동차의 이름(name) 반환


4. Cars.java : Car 객체 전체를 묶어 함께 동작하게 만드는 일급 컬렉션 용도 객체
   * moveAll : 자동차 경주에 참가하는 모든 자동차에 대해 move 진행
   * findWinner : 자동차 경주에 참가하는 모든 자동차에 대해 최종 우승자 List를 반환
   * getCarList : 자동차 경주에 참가하는 자동차 리스트 반환


5. Input.java : 자동차의 이름과 시도 횟수를 입력 받는 클래스
   * inputCarNames : 경주할 자동차 이름을 입력받아 문자열 반환
   * inputAttempt : 시도 횟수를 입력받아 반환
   

6. Output.java : 가장 많은 거리를 이동한 최종 우승자의 자동차 이름 출력하는 클래스. 정적 메서드로 구성.
   * printWinner : winners 리스트를 전달받아 최종 우승자 출력
   * printCarPosition : 현재 자동차 별 위치를 출력

## Folder Structure
````
├───main
    │   └───java
    │       └───racingcar
    │               Application.java
    │               Car.java
    │               Cars.java
    │               Game.java
    │               Input.java
    │               Output.java
    │
    └───test
        └───java
            └───racingcar
                    ApplicationTest.java

