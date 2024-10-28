package racingcar.view;

import racingcar.service.util.ManageCarMovement;
import racingcar.view.constant.OutputConstant;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printExecutionStartMessage() {
        System.out.println(OutputConstant.EXECUTION_RESULT);
    }

    public void printExecutionResult(ManageCarMovement manageCarMovement, List<String> carNames) {
        Map<String, String> movementCount = manageCarMovement.getCarMovementCount();
        for (String carName : carNames) {
            System.out.println(carName + OutputConstant.COLON + movementCount.get(carName));
        }
        System.out.println();
    }

    public void printFinalResult(List<String> winners) {
        System.out.println(OutputConstant.FINAL_WINNER
                + OutputConstant.COLON
                + String.join(", ", winners));
    }
}