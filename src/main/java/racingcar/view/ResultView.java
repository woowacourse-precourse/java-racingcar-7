package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class ResultView {

    List<RacingCar> racingCars;

    public void printResult(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        if (racingCars.size() == 1) {
            printWinner();
        } else {
            printWinners();
        }
    }

    public void printWinner() {
        racingCars.forEach(racingCar -> {
            System.out.println("최종 우승자 : " + racingCar.getName());
        });
    }

    public void printWinners() {
        System.out.print("최종 우승자 : " + String.join(", ", racingCars.stream()
                .map(RacingCar::getName)
                .toList()));
    }

}
