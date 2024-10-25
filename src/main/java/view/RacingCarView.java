package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import model.RacingCar;

public class RacingCarView {
    private static final String INPUT_RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE_OUTPUT_TEXT = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String LINE_SEPARATOR = "\n";
    private static final String PRINT_INTERMEDIATE_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_RESULT_FORMAT = "최종 우승자 : %s";

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

    public void printWinner(List<RacingCar> winners) {
        StringBuilder result = new StringBuilder(LINE_SEPARATOR);
        List<String> winnerNames = winners.stream()
                .map(RacingCar::getName)
                .toList();

        result.append(String.format(
                WINNER_RESULT_FORMAT,
                String.join(WINNER_SEPARATOR, winnerNames)));

        System.out.println(result);
    }

    public void printResultMessage() {
        StringBuilder result = new StringBuilder();

        result.append(LINE_SEPARATOR)
                .append(RESULT_MESSAGE);

        System.out.println(result);
    }
}
