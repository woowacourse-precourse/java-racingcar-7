package racingcar.service;

import static racingcar.util.Constant.COMMA_DELIMITER;
import static racingcar.util.Constant.MAX_RANDOM_VALUE;
import static racingcar.util.Constant.MIN_RANDOM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.CommonUtil;
import racingcar.validation.CarNamesValidator;

public class RacingCarServiceImpl implements RacingCarService {

    private final CarNamesValidator carNamesValidator;

    public RacingCarServiceImpl(CarNamesValidator carNamesValidator) {
        this.carNamesValidator = carNamesValidator;
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
            racingCar.move(Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE));
        }
    }

    private List<Car> getRacingCars(List<String> racingCarNames) {
        List<Car> racingCars = new ArrayList<>(racingCarNames.size());
        for (String racingCarName : racingCarNames) {
            racingCars.add(new Car(racingCarName));
        }
        return racingCars;
    }
}
