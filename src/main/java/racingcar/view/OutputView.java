package racingcar.view;

import java.util.List;
import racingcar.dto.ResultDTO;
import racingcar.model.MoveRecord;
import racingcar.model.carRacer;

public class OutputView {

    public void display(ResultDTO raceResult) {
        displayRaceResult(raceResult);
        displayWinner(raceResult);
    }

    public void displayRaceResult(ResultDTO raceRecord) {
        System.out.println("\n실행 결과");
        for (int i = 1; i <= raceRecord.getTotalCount(); i++) {
            displayRaceResult(raceRecord.getCarRacers(), i);
        }
    }

    public void displayRaceResult(List<carRacer> allRacers, int currentTrial) {
        allRacers.forEach(carRacer -> {
            MoveRecord current = carRacer.getRecord(currentTrial);
            System.out.printf(current.getCurrentMove());
        });
        System.out.println();
    }

    public static void displayWinner(ResultDTO raceResult) {
        System.out.printf("최종 우승자 : %s\n", String.join(", ", raceResult.getWinner()));
    }
}
