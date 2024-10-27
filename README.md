# java-racingcar-precourse

1. RacingCar 클래스 새로 만들어보기   
    - 경주할 자동차들이 공통된 속성을 갖고 있다는 것을 알았습니다.
    - RacingCar 클래스를 새로 만들고, 필드는 name, moves로 구성할 것입니다.
    - 각 필드의 getter를 만들어 인스턴스 필드에 대해 직접적인 접근을 막도록 하겠습니다. (moves의 경우 setter 대신 addMove()를 구현할 것입니다.)
    - canMove() 메소드를 만들어 전진하는 조건을 구현합니다.

2. 구현 기능 계획  
    - getNameOfCars() : 이름을 입력받고, string 배열을 만듭니다.
    - createCars(): 자동차 인스턴스들을 생성하고 RacingCar 배열을 반환합니다.
    
    - getNumberOfTry() : 시도할 횟수를 입력받고 횟수를 반환합니다.

    - runGame() : 시도 횟수 만큼 게임을 실행합니다. 만약 canMove()가 true라면 addMove()합니다.
        - printResult() : 결과를 출력합니다.
    
    - printFinalWinner() : 최종 moves를 비교하여 최종 우승자를 출력합니다.
