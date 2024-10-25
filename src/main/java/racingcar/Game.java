package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Game(List<String> carList, int round) {

    }

    public static List<RacingCar> generateRacingCarList(List<String> carList) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String car : carList) {
            racingCarList.add(new RacingCar(car));
        }
        return racingCarList;
    }
}
