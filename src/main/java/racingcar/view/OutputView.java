package racingcar.view;

import java.util.List;
import java.util.Map;

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
        System.out.println("==== 레이스 시작 ====");
    }


    public void printOutputView(Map<String, Integer> racingCars) {
        printRound(racingCars);
    }

    private void printRound(Map<String, Integer> racingCars) {
        for (String carName : racingCars.keySet()) {
            int carPosition = racingCars.get(carName);

            System.out.println(carName + " : " + "-".repeat(carPosition) );
        }
        System.out.println();
    }

    public void printWinnerView(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

}
