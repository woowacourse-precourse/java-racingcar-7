package racingcar.view;

import static racingcar.utils.Constant.INPUT_CAR_NAME_PROMPT;
import static racingcar.utils.Constant.INPUT_GAME_COUNT_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.utils.Validator;

public class InputView {
    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public ArrayList<String> inputCarName() {
        ArrayList<String> carNames = new ArrayList<>();

        System.out.println(INPUT_CAR_NAME_PROMPT);
        String cars = Console.readLine();

        String[] carArray = cars.split(",");

        for (String car : carArray) {
            carNames.add(car.trim());
        }

        validator.validateInputCarName(carNames);

        return carNames;

    }

    public String inPutGameCount() {
        System.out.println(INPUT_GAME_COUNT_PROMPT);
        String gameCount = Console.readLine();

        validator.validateInputGameCount(gameCount);

        return gameCount;
    }
}
