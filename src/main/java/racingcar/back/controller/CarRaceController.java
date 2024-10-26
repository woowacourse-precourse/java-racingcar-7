package racingcar.back.controller;

import racingcar.global.dto.CarRaceRequestDTO;
import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.back.service.impl.CarRaceGameRunnerServiceImpl;

public class CarRaceController {

    private final CarRaceGameRunnerServiceImpl carRaceGameRunnerServiceImpl;

    public CarRaceController(CarRaceGameRunnerServiceImpl carRaceGameRunnerServiceImpl) {
        this.carRaceGameRunnerServiceImpl = carRaceGameRunnerServiceImpl;
    }

    public CarRaceResponseDTO playRaceGame(CarRaceRequestDTO carRaceRequestDTO) {
        Integer gamePlayCount = carRaceRequestDTO.gamePlayCount();
        return carRaceGameRunnerServiceImpl.runGame(carRaceRequestDTO.carNames(), gamePlayCount);
    }
}
