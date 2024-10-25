package racingcar.view;

import java.util.List;
import racingcar.constant.OutputConstant;
import racingcar.model.Car;

public class OutputView {

    public static void outputProcessResultView(List<Car> carList) {
        System.out.println(OutputConstant.OUTPUT_PROCESS_RESULT_VIEW);
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForward(); i++) {
                System.out.println("-");
            }
            System.out.println();
        }
    }

    public static void outputFinalWinnerView(List<Car> winnerList) {
        System.out.println(OutputConstant.OUTPUT_FINAL_WINNER_VIEW);
        for (Car car : winnerList) {
            System.out.println(car.getName() + ",");
        }
    }
}
