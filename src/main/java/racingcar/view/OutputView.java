package racingcar.view;

import static racingcar.message.InfoMessages.OUTPUT_FINAL_WINNER;
import static racingcar.message.InfoMessages.OUTPUT_RUN_RESULT;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String ONE_STEP = "-";

    public void displayRaceResult() {
        System.out.println(System.lineSeparator() + OUTPUT_RUN_RESULT);
    }

    public void displayRaceProgress(List<Car> cars) {
        StringBuilder raceProgress = new StringBuilder();

        cars.forEach(car ->
                raceProgress.append(car.getName())
                        .append(" : ")
                        .append(ONE_STEP.repeat(car.getPosition()))
                        .append(System.lineSeparator())
        );

        System.out.println(raceProgress);
    }

    public void displayFinalWinner(List<String> winnerNames) {
        String finalWinnerNames = String.join(", ", winnerNames);
        System.out.println(OUTPUT_FINAL_WINNER + finalWinnerNames);
    }
}
