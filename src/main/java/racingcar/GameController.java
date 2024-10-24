package racingcar;

// GameManager 클래스명 바꿀까 고민
public class GameController {

    RacingCarList racingCarList = new RacingCarList();

    public GameController(String carName) {
        racingCarList.add(carName);
    }
}