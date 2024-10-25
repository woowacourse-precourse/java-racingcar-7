package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    static final String ROUND_RESULT_HEADER = "실행 결과\n";

    public static void printRoundResult(List<Car> racingCars) {
        StringBuilder sb = new StringBuilder(ROUND_RESULT_HEADER);
        for (Car racingCar : racingCars) {
            sb.append(racingCar.getName()).append(" : ");
            for (int i = 0; i < racingCar.getProgressCount(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        sb.append("\n");

        System.out.print(sb.toString());
    }

    public static void printWinnerResult(List<String> winnerNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (String winnerName : winnerNames) {
            sb.append(winnerName).append(", ");
        }
        sb.setLength(sb.length() - 2);

        System.out.print(sb.toString());
    }
}
