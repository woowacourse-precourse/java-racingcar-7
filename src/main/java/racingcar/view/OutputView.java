package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.config.constant.io.OutputConstant;
import racingcar.model.Car;

public class OutputView {

    public static void outputProcessResultView() {
        System.out.println(OutputConstant.OUTPUT_PROCESS_RESULT_VIEW);
    }

    public static void outputProcessResultListView(List<Car> carList) {
        for (Car car : carList) {
            outputResultCarView(car);
        }
        System.out.println();
    }

    public static void outputResultCarView(Car car) {
        System.out.print(car.getName() + OutputConstant.OUTPUT_COLON);
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(OutputConstant.OUTPUT_MINUS);
        }
        System.out.println();
    }

    public static void outputFinalWinnerView(List<Car> winnerList) {
        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(OutputConstant.OUTPUT_COMMA));
        System.out.print(OutputConstant.OUTPUT_FINAL_WINNER_VIEW + winners);
    }
}
