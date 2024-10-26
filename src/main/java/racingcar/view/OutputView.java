package racingcar.view;

import java.util.List;
import racingcar.model.CarInformation;

public class OutputView {

    private static final String DASH = "-";
    private static final String COLON = ":";
    private static final String COMMA = ", ";
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String FINAL_WINNERS = "최종 우승자 : ";
    private static final String INFORMATION_FORMAT = "%s %s %s";

    public void printExecuteResultMessage() {
        printBlankLine();
        System.out.println(EXECUTE_RESULT);
    }

    public void printRoundResult(final List<CarInformation> cars) {
        for (CarInformation car : cars) {
            String distance = DASH.repeat(car.position());
            System.out.printf(INFORMATION_FORMAT, car.name(), COLON, distance);
            printBlankLine();
        }
        printBlankLine();
    }

    public void printRacingWinners(final List<CarInformation> cars) {
        List<String> winners = cars.stream()
                .map(CarInformation::name)
                .toList();
        System.out.print(FINAL_WINNERS + String.join(COMMA, winners));
    }

    private void printBlankLine() {
        System.out.println();
    }
}
