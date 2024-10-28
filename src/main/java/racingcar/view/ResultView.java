package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import static racingcar.util.PromptMessage.FINAL_WINNER_MESSAGE;


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
            System.out.println(FINAL_WINNER_MESSAGE + racingCar.getName());
        });
    }

    public void printWinners() {
        System.out.print(FINAL_WINNER_MESSAGE + String.join(", ", racingCars.getRacingCars()
                .stream()
                .map(RacingCar::getName)
                .toList()));
    }

}
