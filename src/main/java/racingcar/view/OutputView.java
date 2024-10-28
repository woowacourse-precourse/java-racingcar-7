package racingcar.view;

import static racingcar.constant.Constant.*;
import java.util.List;
import java.util.Map;
import racingcar.constant.OutputMessage;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {}

    public static OutputView getOutputViewInstance() {
        if (outputView == null) {
            outputView = new OutputView();
            return outputView;
        }
        return outputView;
    }

    public void printRaceStart() {
        System.out.println(OutputMessage.RACE_START);
    }

    public void printRoundState(Map<String, Integer> racingCars) {
        for (String carName : racingCars.keySet()) {
            int carPosition = racingCars.get(carName);
            System.out.println(carName + COLON + graphicCarPosition(carPosition));
        }
        System.out.println();
    }

    private String graphicCarPosition (int carPosition) {
        return BAR.repeat(carPosition);
    }

    public void printWinnerView(List<String> winners) {
        System.out.println(OutputMessage.CELEBRATE_WIN);
        System.out.print(OutputMessage.PRESENT_WINNER);
        System.out.println(String.join(COMMA + BLANK, winners));
    }

}
