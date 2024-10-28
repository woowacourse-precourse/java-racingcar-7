package racingcar.service;

import racingcar.model.Car;
import racingcar.repository.RacingCarRepository;
import racingcar.validator.Validator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCarService {
    private final RacingCarRepository racingCarRepository;
    private final Validator validator;

    public RacingCarService() {
        this.racingCarRepository = new RacingCarRepository();
        this.validator = new Validator();
    }

    public List<Car> getAllCarList() {
        return racingCarRepository.getCars();
    }

    public void getCarList(String carInfo) {
        ArrayList<String> cars = validator.splitByComma(carInfo);
        ArrayList<String> refinedCars = validator.changeSameName(cars);

        refinedCars.forEach(racingCarRepository::addCar);
    }

    public void getTryCount(String tryCountStr) {
        Long tryCount = validator.convertTryCount(tryCountStr);

        racingCarRepository.setTryCount(tryCount);
    }

    public void calculateRandomNumber() {
        Long tryCount = racingCarRepository.getTryCount();
        ArrayList<Car> cars = racingCarRepository.getCars();

        for (int i = 0; i < tryCount; i++) {
            calculateNumbersInCars(cars);
        }
    }

    private void calculateNumbersInCars(ArrayList<Car> cars) {
        IntStream.range(0, cars.size())
                .filter(x -> pickNumberInRange(0, 9) >= 4)
                .forEach(racingCarRepository::plusValue);
    }

    public List<String> calculateWinner() {
        ArrayList<Car> cars = racingCarRepository.getCars();
        BigInteger maxiValue = cars.stream().map(Car::getMove).max(BigInteger::compareTo).get();

        return cars.stream()
                .filter(car -> car.getMove().equals(maxiValue))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
