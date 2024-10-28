package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;

public class RacingCarView {

    private static final String INPUT_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_GUIDE = "시도할 횟수는 몇 회인가요?";
    private static final String DISPLAY_RESULT_MESSAGE = "\n실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String DISPLAY_WINNER_MESSAGE = "최종우승자 : ";
    private static final String NO_WINNER_MESSAGE = "없음";

    private RacingCarView() {

    }

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_GUIDE);
        return Console.readLine();
    }

    public static String inputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER_GUIDE);
        return Console.readLine();
    }

    public static void printDisplayResultMessage() {
        System.out.println(DISPLAY_RESULT_MESSAGE);
    }

    public static void displayMovement(List<Car> cars) {

        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> sb.append(car.getName())
                .append(" : ")
                .append("-".repeat(car.getDistance()))
                .append(NEW_LINE));

        System.out.println(sb);
    }

    public static void displayWinner(List<String> raceWinner) {
        String winner = String.join(", ", raceWinner);
        System.out.println(DISPLAY_WINNER_MESSAGE + winner);
    }

    public static void displayNoWinner() {
        System.out.println(DISPLAY_WINNER_MESSAGE + NO_WINNER_MESSAGE);
    }
}
