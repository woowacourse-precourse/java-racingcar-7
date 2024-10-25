package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.utill.InputValidator;
import java.util.List;

public class Application {

    private static final String INPUT_CAR_NAMES_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUNDS_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_PREFIX = "최종 우승자 : ";

    public static void main(String[] args) {
        List<Car> cars = getCarsFromInput();
        int rounds = getRoundsFromInput();

        Race race = new Race(cars, rounds);
        race.start();
        List<String> winners = race.getWinners();

        System.out.println(RESULT_PREFIX + String.join(", ", winners));
    }

    private static List<Car> getCarsFromInput() {
        System.out.println(INPUT_CAR_NAMES_PROMPT_MESSAGE);
        String input = Console.readLine().trim();
        InputValidator.validateCarNames(input);
        return Car.createCarsFromInput(input);
    }

    private static int getRoundsFromInput() {
        System.out.println(INPUT_ROUNDS_PROMPT_MESSAGE);
        String input = Console.readLine().trim();
        InputValidator.validateRounds(input);
        return Integer.parseInt(input);
    }
}
