package racingcar.view;

import static racingcar.util.message.IOMessage.OUTPUT_RACE_RESULT;
import static racingcar.util.message.IOMessage.OUTPUT_WINNER;

import java.util.List;
import racingcar.dto.OutputDTO;
import racingcar.model.RacingCar;

public class OutputView {

    public void display(OutputDTO raceResult) {
        displayRaceResult(raceResult);
        displayWinner(raceResult);
    }

    public void displayRaceResult(OutputDTO raceResult) {
        System.out.println(OUTPUT_RACE_RESULT);
        for (int trial = 1; trial <= raceResult.getTotalTrialCount(); trial++) {
            displayRaceResult(trial, raceResult.getResult());
        }
    }

    public void displayRaceResult(Integer currentTrial, List<RacingCar> allRacers) {
        allRacers.forEach(racingCar -> System.out.println(racingCar.getDistance(currentTrial)));
        System.out.println();
    }

    public void displayWinner(OutputDTO raceResult) {
        System.out.printf("%s : %s\n", OUTPUT_WINNER, raceResult.getWinners());
    }
}
