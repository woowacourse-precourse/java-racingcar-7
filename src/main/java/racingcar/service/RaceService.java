package racingcar.service;

import racingcar.constant.Message;
import racingcar.dto.CarsDto;
import racingcar.model.Separator;

public class RaceService {

    public CarsDto raceSetting(String inputCars) {
        Separator separator = new Separator();
        return new CarsDto(separator.separateCars(inputCars));
    }

    public CarsDto playOneRound(CarsDto carsDto) {
        for (int i = 0; i < carsDto.getCars().size(); i++) {
            carsDto.getCars().get(i).goRound();
        }
        return carsDto;
    }
}
