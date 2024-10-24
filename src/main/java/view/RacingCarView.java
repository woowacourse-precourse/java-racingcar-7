package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import model.RacingCar;

public class RacingCarView {
    private static final String INPUT_RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DISTANCE_OUTPUT_TEXT = "-";
    private static final String LINE_SEPARATOR = "\n";
    private static final String PRINT_INTERMEDIATE_RESULT_FORMAT = "%s : %s";

    public String readCars() {
        System.out.println(INPUT_RACING_CAR_MESSAGE);
        return Console.readLine();
    }

    public String readRaceRound() {
        System.out.println(INPUT_RACING_ROUND_MESSAGE);
        return Console.readLine();
    }

    public void closeInput() {
        Console.close();
    }

    public void printIntermediateResult(List<RacingCar> cars) {
        StringBuilder result = new StringBuilder(LINE_SEPARATOR);
        for (RacingCar car : cars) {
            String dashes = DISTANCE_OUTPUT_TEXT.repeat(car.getDistance());
            result.append(String.format(PRINT_INTERMEDIATE_RESULT_FORMAT, car.getName(), dashes))
                    .append(LINE_SEPARATOR);
        }

        System.out.print(result);
    }
}
