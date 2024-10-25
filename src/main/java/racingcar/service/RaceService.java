package racingcar.service;

import racingcar.dto.CarsDto;
import racingcar.model.Separator;

public class RaceService {

    public CarsDto raceSetting(String inputCars) {
        Separator separator = new Separator();
        return new CarsDto(separator.separateCars(inputCars));
    }
}
