package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;


public class ResultView {

    RacingCars racingCars;

    public void printResult(RacingCars racingCars) {
        this.racingCars = racingCars;
        if (racingCars.size() == 1) {
            printWinner();
        } else {
            printWinners();
        }
    }

    public void printWinner() {
        racingCars.getRacingCars().forEach(racingCar -> {
            System.out.println("최종 우승자 : " + racingCar.getName());
        });
    }

    public void printWinners() {
        System.out.print("최종 우승자 : " + String.join(", ", racingCars.getRacingCars()
                .stream()
                .map(RacingCar::getName)
                .toList()));
    }

}
