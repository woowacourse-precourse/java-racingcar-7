package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.Rule;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Count;
import racingcar.domain.Racing;
import racingcar.domain.Score;
import racingcar.dto.RacingCarProgress;
import racingcar.dto.RacingCarResult;
import racingcar.dto.RacingCarWinner;
import racingcar.util.validator.ListValidator;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.validator.NumberValidator;
import racingcar.util.validator.StringValidator;

public class RacingCarService {

    private final ListValidator<String> listValidator;
    private final NumberGenerator numberGenerator;
    private final NumberValidator<Integer> numberValidator;
    private final StringValidator stringValidator;

    public RacingCarService(final ListValidator<String> listValidator, final NumberGenerator numberGenerator,
                            final NumberValidator<Integer> numberValidator, final StringValidator stringValidator) {
        this.listValidator = listValidator;
        this.numberGenerator = numberGenerator;
        this.numberValidator = numberValidator;
        this.stringValidator = stringValidator;
    }

    public List<Car> generateCars(final String values) {
        final List<String> carNames = parseToList(values);
        listValidator.validateSize(carNames, Rule.CAR_MAX_SIZE);
        listValidator.validateDuplicate(carNames);
        return carNames.stream()
                .map(this::createCar)
                .toList();
    }

    public Count generateCount(final String value) {
        return Count.of(value, numberValidator);
    }

    public List<RacingCarResult> getRacingCarResult(final Racing racing, final Count count) {
        final List<RacingCarResult> racingCarResult = new ArrayList<>();
        final int value = count.getValue();
        for (int turn = 0; turn < value; turn++) {
            final List<Car> cars = racing.move(Rule.FORWARD_SCORE);
            racingCarResult.add(RacingCarResult.of(mapToRacingCarProgresses(cars)));
        }
        return racingCarResult;
    }

    public RacingCarWinner getRacingCarWinner(final Racing racing) {
        final List<Car> winners = racing.getWinners();
        return RacingCarWinner.of(winners);
    }

    private List<RacingCarProgress> mapToRacingCarProgresses(final List<Car> cars) {
        return cars.stream()
                .map(RacingCarProgress::of)
                .toList();
    }


    private Car createCar(final String value) {
        final CarName carName = CarName.of(value, stringValidator);
        return new Car(carName, new Score(Rule.INITIAL_SCORE), numberGenerator);
    }

    private List<String> parseToList(final String values) {
        final String[] carNames = values.split(",", -1);
        return Arrays.stream(carNames)
                .toList();
    }

}
