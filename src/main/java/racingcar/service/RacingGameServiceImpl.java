package racingcar.service;

import static racingcar.util.Constant.COMMA_DELIMITER;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.CommonUtil;
import racingcar.validation.CarNamesValidator;

public class RacingGameServiceImpl implements RacingGameService {

    private final CarNamesValidator carNamesValidator;
    private final MoveDistanceProvider moveDistanceProvider;

    public RacingGameServiceImpl(CarNamesValidator carNamesValidator, MoveDistanceProvider moveDistanceProvider) {
        this.carNamesValidator = carNamesValidator;
        this.moveDistanceProvider = moveDistanceProvider;
    }

    @Override
    public List<Car> splitAndInitializeRacingCars(String carNames) {
        carNamesValidator.validate(carNames);
        List<String> racingCarNames = new ArrayList<>(CommonUtil.splitToList(carNames, COMMA_DELIMITER));
        return getRacingCars(racingCarNames);
    }

    @Override
    public void startCarRaceGame(List<Car> racingCars) {
        for (Car racingCar : racingCars) {
            racingCar.move(moveDistanceProvider.generateMoveDistance());
        }
    }

    @Override
    public List<String> getWinners(List<Car> racingCars) {
        int maxDistance = racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car racingCar : racingCars) {
            if (racingCar.getDistance().equals(maxDistance)) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }

    private List<Car> getRacingCars(List<String> racingCarNames) {
        List<Car> racingCars = new ArrayList<>(racingCarNames.size());
        for (String racingCarName : racingCarNames) {
            racingCars.add(new Car(racingCarName));
        }
        return racingCars;
    }
}
