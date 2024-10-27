package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<RacingCar> racingCars;
    private final Integer raceCount;

    public void race() {

        for (int i = 0; i < raceCount; i++) {
            for (RacingCar racingCar : racingCars) {
                if (canMove()) {
                    racingCar.move();
                }
            }

            printRoundResult();
        }
    }

    private List<RacingCar> createRacingCars(String[] carNames) {

        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }

        return racingCars;
    }

    private boolean canMove() {
        return pickNumberInRange(0, 9) >= 4;
    }

    private void printRoundResult() {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getCarName() + " : " + racingCarPosition(racingCar.getPosition()));
        }
        System.out.println();
    }

    private String racingCarPosition(int position) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append('-');
        }

        return sb.toString();
    }

    public Race(String[] racingCars, Integer raceCount) {
        this.racingCars = createRacingCars(racingCars);
        this.raceCount = raceCount;
    }
}
