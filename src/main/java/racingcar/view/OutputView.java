package racingcar.view;

import static racingcar.util.ConstantData.ONE_MOVE;
import static racingcar.util.Message.OUTPUT_RACE_RESULT;
import static racingcar.util.Message.OUTPUT_WINNER;

import java.util.List;
import racingcar.dto.OutputDTO;
import racingcar.model.CarRacer;

public class OutputView {

    public void display(int totalCount, OutputDTO raceResult) {
        displayRaceResult(totalCount, raceResult);
        displayWinner(raceResult);
    }

    public void displayRaceResult(int totalCount, OutputDTO raceResult) {
        System.out.println(OUTPUT_RACE_RESULT);
        for (int i = 1; i <= totalCount; i++) {
            displayRaceResult(i, raceResult.getRaceRecord());
        }
    }

    public void displayRaceResult(int currentTrial, List<CarRacer> allRacers) {
        allRacers.forEach(carRacer -> {
            String name = carRacer.getName();
            String currentMoves = ONE_MOVE.repeat(carRacer.getCurrentMoveCount(currentTrial));

            System.out.printf("%s : %s\n", name, currentMoves);
        });
        System.out.println();
    }

    public static void displayWinner(OutputDTO raceResult) {
        System.out.printf("%s : %s\n", OUTPUT_WINNER, raceResult.getWinners());
    }
}
