package racingcar.view;

import java.util.List;
import racingcar.constant.OutputConstant;
import racingcar.model.Car;

public class OutputView {

    public static void outputProcessResultView() {
        System.out.println(OutputConstant.OUTPUT_PROCESS_RESULT_VIEW);
    }

    public static void outputProcessResultListView(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getMoveCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void outputFinalWinnerView(List<Car> winnerList) {
        System.out.print(OutputConstant.OUTPUT_FINAL_WINNER_VIEW);
        for (Car car : winnerList) {
            System.out.print(car.getName() + ",");
        }
    }
}
