package racingcar.common;

import racingcar.model.Car;
import racingcar.model.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputMaker {
    private static final String ROUND_RESULT_START_MESSAGE = "\n실행 결과\n";
    private static final String FINAL_RESULT_START_MESSAGE = "\n최종 우승자 : ";

    public static String roundResult(List<Car> cars) {
        return cars.stream()
                .map(c -> makeCarState(c))
                .collect(Collectors.joining("\n", ROUND_RESULT_START_MESSAGE, ""));
    }

    public static String finalResult(Winners winners) {
        return winners.getWinnerNames()
                .stream()
                .collect(Collectors.joining(", ", FINAL_RESULT_START_MESSAGE, ""));
    }

    private static String makeCarState(Car car) {
        return car.getName() + " : " + makeProgressBar(car.getForwardLevel());
    }

    private static String makeProgressBar(int cnt) {
        StringBuilder sb = new StringBuilder();
        while (cnt > 0) {
            sb.append("-");
            cnt--;
        }
        return sb.toString();
    }
}
