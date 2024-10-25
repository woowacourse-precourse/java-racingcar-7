package racingcar.service;

import java.util.List;
import racingcar.domain.CarManager;
import racingcar.domain.Racing;

public class RacingService {

    private static final String INPUT_DELIMITER = ",";

    private final CarManager carManager;
    private final Racing racing;

    public RacingService(CarManager carManager, Racing racing) {
        this.carManager = carManager;
        this.racing = racing;
    }

    public void setupCarsFromUserInput(String userInput){
        List<String> split = List.of(userInput.split(INPUT_DELIMITER));
        carManager.initCars(split);
    }

}
