package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.validator.Validator;
import static racingcar.constant.Constant.COMMA;

public class CarNameService {
    private static CarNameService carNameService;

    private CarNameService() {}

    public static CarNameService getCarNameServiceInstance() {
        if(carNameService == null) {
            carNameService = new CarNameService();
            return carNameService;
        }
        return carNameService;
    }

    public Map<String, Integer> splitAndSaveCarName(String carNames) {
        Map<String, Integer> racingCars = new LinkedHashMap<>();
        Validator validator = Validator.getValidator();

        for (String carName : carNames.split(COMMA)) {
            validator.isValidName(carName); //유효성 검사
            racingCars.putIfAbsent(carName, 0);
        }

        return racingCars;
    }
}
