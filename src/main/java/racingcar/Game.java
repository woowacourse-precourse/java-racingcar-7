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

    public List<String> findWinners() {
        int max = 0;
        List<String> winnerList = new ArrayList<>();

        for (RacingCar racingCar : this.racingCarList) {
            if (racingCar.getCount() > max) {
                max = racingCar.getCount();
                winnerList.clear();
                winnerList.add(racingCar.getName());
            } else if (racingCar.getCount() == max) {
                winnerList.add(racingCar.getName());
            }
        }
        return winnerList;
    }
}
