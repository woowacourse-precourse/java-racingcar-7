package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.request.TryCountRequest;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputHandler {

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[^\\s]+(,[^\\s])*$");

    public Cars getCarNamesFromUser() {
        String userInput = Console.readLine();
        return generateCarsFrom(userInput);
    }

    public TryCountRequest getTryCountFromUser() {
        String userInput = Console.readLine();
        return new TryCountRequest(userInput);
    }

    private Cars generateCarsFrom(final String namesOfCars) {
        validateCarNames(namesOfCars);
        String[] split = namesOfCars.split(",");
        return Cars.from(Arrays.stream(split)
            .map(Car::from)
            .toList());
    }

    private void validateCarNames(final String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (!CAR_NAME_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
        }
    }

}
