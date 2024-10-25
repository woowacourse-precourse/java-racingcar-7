package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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
        Map<String, Integer> carPositions = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        validateCarNames(carsInput);

        String[] carNames = carsInput.split(",");
        for (String name : carNames) {
            carPositions.put(name.trim(), 0);
        }

        System.out.println("시도할 횟수를 입력하세요.");
        String tryCountInput = Console.readLine();
        Integer tryCount = validateTryCount(tryCountInput);
    }

    public static void moveCars(Map<String, Integer> carPositions) {
        for (Map.Entry<String, Integer> car : carPositions.entrySet()) {
            int randomNum = Randoms.pickNumberInRange(0, 9);

            if (randomNum >= 4) {
                car.setValue(car.getValue() + 1); // 점수 증가
            }
        }
    }

    public static void validateCarNames(String carsInput) {
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

    public static Integer validateTryCount(String tryCountInput) {
        try {
            int attemptCount = Integer.parseInt(tryCountInput);

            if (attemptCount <= 0) {
                throw new IllegalArgumentException(MESSAGE_INVALID_TRY_COUNT);
            }

            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_INVALID_NUMBER_FORMAT);
        }
    }
}
