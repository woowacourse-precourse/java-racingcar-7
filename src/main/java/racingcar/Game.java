package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<RacingCar> racingCarList;
    int round;

    public Game(List<String> carList, int round) {
        this.racingCarList = generateRacingCarList(carList);
        this.round = round;
    }

    public static List<RacingCar> generateRacingCarList(List<String> carList) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String car : carList) {
            racingCarList.add(new RacingCar(car));
        }
        return racingCarList;
    }

    public void play() {
        for (RacingCar racingCar : this.racingCarList) {
            racingCar.rollDice();
        }
    }
}
