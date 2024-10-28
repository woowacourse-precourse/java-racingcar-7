package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public List<RacingCar> runGame(final List<String> inputCars, final int trial) {

        List<RacingCar> racingCars = generateCar(inputCars);

        System.out.println("실행 결과");
        for (int trialIndex = 0; trialIndex < trial; ++trialIndex) {
            for (RacingCar racingCar : racingCars) {

                racingCar.conditionalMove();

                printCurrentState(racingCar);
            }
            System.out.println();
        }

        return racingCars;
    }

    private void printCurrentState(final RacingCar racingCar) {

        System.out.print(racingCar.getName() + " : ");
        for (int j = 0; j < racingCar.getLocation(); ++j) {
            System.out.print("-");
        }
        System.out.println();
    }

    private List<RacingCar> generateCar(final List<String> inputCars) {

        List<RacingCar> racingCars = new ArrayList<>();
        for (String inputCar : inputCars) {
            racingCars.add(new RacingCar(inputCar));
        }

        return racingCars;
    }
}
