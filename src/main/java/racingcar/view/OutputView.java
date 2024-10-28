package racingcar.view;

import static racingcar.view.OutputMessage.*;

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
}
