package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static final String EMPTY_INPUT_MESSAGE = "입력이 비어 있습니다. 자동차 이름을 쉼표로 구분하여 입력해주세요.";
    public static final String COMMA_REQUIRED_MESSAGE = "쉼표(,)로 구분된 이름을 입력해야 합니다.";
    public static final String NAME_EMPTY_MESSAGE = "자동차 이름이 비어 있습니다. 모든 자동차의 이름을 올바르게 입력해주세요.";
    public static final String MIN_CARS_REQUIRED_MESSAGE = "최소 두 대의 자동차 이름을 입력해야 합니다.";
    public static final String MESSAGE_INVALID_TRY_COUNT = "시도할 횟수는 양수여야 합니다.";
    public static final String MESSAGE_INVALID_NUMBER_FORMAT = "유효한 숫자 형식이 아닙니다.";

    public static void main(String[] args) {
        Map<String, Integer> cars = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        validateCarsInput(carsInput);

        String[] carNames = carsInput.split(",");
        for (String name : carNames) {
            cars.put(name.trim(), 0);
        }

        System.out.println("시도할 횟수를 입력하세요.");
        String tryCountInput = Console.readLine();
        Integer tryCount = validateTryCountInput(tryCountInput);
    }

    public static void validateCarsInput(String carsInput) {
        if (carsInput == null || carsInput.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }

        if (!carsInput.contains(",")) {
            throw new IllegalArgumentException(COMMA_REQUIRED_MESSAGE);
        }

        String[] carNames = carsInput.split(",");

        if (carNames.length < 2) {
            throw new IllegalArgumentException(MIN_CARS_REQUIRED_MESSAGE);
        }

        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(NAME_EMPTY_MESSAGE);
            }
        }
    }

    public static Integer validateTryCountInput(String tryCountInput) {
        try {
            int tryCount = Integer.parseInt(tryCountInput);

            if (tryCount <= 0) {
                throw new IllegalArgumentException(MESSAGE_INVALID_TRY_COUNT);
            }

            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_INVALID_NUMBER_FORMAT);
        }
    }
}
