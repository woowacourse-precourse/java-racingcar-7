package racingcar.domain.car;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final String input) {
        validateInput(input);
        Arrays.stream(input.split(",")).forEach(user -> {
            cars.add(new Car(user));
        });
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_IS_NOT_NULL);
        }

        if (input.equals(",")) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_IS_NOT_NULL);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
