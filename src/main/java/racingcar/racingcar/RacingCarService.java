package racingcar.racingcar;

import static racingcar.constant.Integers.CAR_NAME_MAX_LENGTH;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private static final RacingCarService RACING_CAR_SERVICE = new RacingCarService();
    private final RacingCarValidator racingCarValidator = RacingCarValidator.getInstance();

    private RacingCarService() {

    }

    public static RacingCarService getInstance() {
        return RACING_CAR_SERVICE;
    }

    public List<String> splitCarName(String joinedCarNames) {
        racingCarValidator.existCheck(joinedCarNames);
        return List.of(joinedCarNames.split(","));
    }

    public List<RacingCar> makeCar(List<String> carNames) {
        racingCarValidator.lengthCheck(carNames, CAR_NAME_MAX_LENGTH.getNumber());
        racingCarValidator.sameNameCheck(carNames);
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }

}
