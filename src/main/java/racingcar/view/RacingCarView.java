package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;

public class RacingCarView {

    private static final String INPUT_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_GUIDE = "시도할 횟수는 몇 회인가요?";
    private static final String NEW_LINE = "\n";

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

    public static void displayMovement(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        cars.forEach(car -> sb.append(car.getName())
                .append(" : ")
                .append("-".repeat(car.getDistance()))
                .append(NEW_LINE));

        System.out.println(sb);
    }
}
