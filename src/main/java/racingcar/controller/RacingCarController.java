package racingcar.controller;

import racingcar.model.RacingCarRepository;
import racingcar.validator.Validator;
import racingcar.view.RacingCarIO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.util.Collections.max;

public class RacingCarController {
    private final RacingCarIO racingCarIO;
    private final RacingCarRepository racingCarRepository;
    private final Validator validator;

    public RacingCarController(RacingCarIO racingCarIO, RacingCarRepository racingCarRepository, Validator validator) {
        this.racingCarIO = racingCarIO;
        this.racingCarRepository = racingCarRepository;
        this.validator = validator;
    }

    public void getCarList() {
        String carInfo = racingCarIO.getCarInfo();

        ArrayList<String> cars = validator.splitByComma(carInfo);
        ArrayList<String> refinedCars = validator.changeSameName(cars);

        for (String car : refinedCars) {
            racingCarRepository.addCar(car);
        }
    }

    public void getTryCount() {
        String tryCountStr = racingCarIO.tryCountInfo();

        Long tryCount = validator.convertTryCount(tryCountStr);

        racingCarRepository.setTryCount(tryCount);
    }

    public void calculateRandomNumber() {
        Long tryCount = racingCarRepository.getTryCount();
        ArrayList<String> cars = racingCarRepository.getCars();

        for (int i = 0; i < tryCount; i++) {
            calculateNumbersInCars(cars);
        }
    }

    private void calculateNumbersInCars(ArrayList<String> cars) {
        IntStream.range(0, cars.size())
                .filter(j -> pickNumberInRange(0, 9) >= 4)
                .forEach(racingCarRepository::plusValue);
    }

    public void calculateWinner() {
        ArrayList<String> cars = racingCarRepository.getCars();
        ArrayList<BigInteger> values = racingCarRepository.getValues();
        BigInteger maxiValue = max(values);

        List<String> winners = IntStream.range(0, values.size())
                .filter(index -> values.get(index).compareTo(maxiValue) == 0)
                .mapToObj(cars::get)
                .collect(Collectors.toList());

        racingCarIO.printResult(cars, values);
        racingCarIO.printWinners(winners);
    }
}
