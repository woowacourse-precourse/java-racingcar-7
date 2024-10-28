package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public List<RacingCar> runGame(final List<String> inputCars, final int trial) {

        List<RacingCar> racingRacingCars = generateCar(inputCars);

        System.out.println("실행 결과");
        for (int trialIndex = 0; trialIndex < trial; ++trialIndex) {
            for (RacingCar racingCar : racingRacingCars) {
                // 자동차 이동
                racingCar.conditionalMove();

                //현재 상황 출력
                printCurrentState(racingCar);
            }
            System.out.println();
        }

        return racingRacingCars;
    }

    private void printCurrentState(final RacingCar racingCar) {
        // 현재 상황 출력
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
