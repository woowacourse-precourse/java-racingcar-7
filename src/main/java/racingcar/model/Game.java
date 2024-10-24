package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<RacingCar> racingCars;

    public Game(String carNames) {
        this.racingCars = new ArrayList<>();

        String[] names = carNames.split(",");
        for (String name : names) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        racingCars.add(new RacingCar(name));
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void playRound() {
        for (RacingCar car : racingCars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }
}
