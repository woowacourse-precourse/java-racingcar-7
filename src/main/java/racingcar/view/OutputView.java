package racingcar.view;

import static racingcar.view.OutputMessage.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void outputMoveResult(Map<String, Integer> result) {
        for (String carName : result.keySet()) {
            System.out.println(carName + RESULT_SEPARATOR.getMessage() + makeMoveMark(result.get(carName)));
        }
    }

    private String makeMoveMark(Integer move) {
        return MOVE_MARK.getMessage().repeat(move);
    }

    public void outputWinnerCars(List<String> winnerCars) {
        System.out.println(WINNER.getMessage() + RESULT_SEPARATOR.getMessage() + makeWinnerCarsNames(winnerCars));
    }

    private String makeWinnerCarsNames(List<String> winnerCars) {
        return winnerCars.toString().replaceAll("[\\\\[\\\\]]", "");
    }
}
