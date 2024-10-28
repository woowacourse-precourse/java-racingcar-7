// Racer.java
package racingcar.model;

import static racingcar.validation.ValidatorFactory.buildFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.Message;
import racingcar.dto.Result;
import racingcar.service.AcceleratorService;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Racer {
    private final List<Car> cars;

    private Racer(List<Car> cars) {
        this.cars = cars;
    }

    public static Racer of(String input) {
        ValidatorFactory validatorFactory = buildFactory();
        Validator validator = validatorFactory.getValidator(Racer.class);
        validator.validate(input);

        List<Car> cars = Arrays.stream(input.split(Message.CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(Car::ofStartingPoint)
                .collect(Collectors.toList());

        return new Racer(cars);
    }

    public void play(AcceleratorService accelerator) {
        cars.forEach(
                car -> car.move(accelerator)
        );
    }

    public Result getResult() {
        return Result.of(cars);
    }

    public Result getWinner() {
        int max = cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);

        return Result.of(cars.stream()
                .filter(car -> car.getCurrentPosition() == max)
                .toList());
    }
}
