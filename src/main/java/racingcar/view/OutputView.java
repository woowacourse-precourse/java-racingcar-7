package racingcar.view;

import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class OutputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACE_RESULT_MESSAGE = "\n실행 결과";

    private static final String NEW_LINE = "\n";
    private static final String RACE_RESULT_FORMAT = "%s : %s";
    private static final String POSITION_VALUE = "-";

    public static void printCarNamesMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
    }

    public static void printRaceCountMessage() {
        System.out.println(RACE_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void printCarsWithPosition(Cars cars) {
        cars.getValues().forEach(car -> System.out.println(formatCar(car.getName(), car.getPosition())));
        System.out.print(NEW_LINE);
    }

    private static String formatCar(Name name, Position position) {
        return String.format(
                RACE_RESULT_FORMAT,
                name.getValue(),
                POSITION_VALUE.repeat(position.getValue())
        );
    }
}
