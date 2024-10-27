package racingcar.back.controller;

import racingcar.back.service.CarRaceGameRunnerService;
import racingcar.global.dto.CarRaceRequestDTO;
import racingcar.global.dto.CarRaceResponseDTO;

public class CarRaceController {

    private final CarRaceGameRunnerService carRaceGameRunnerService;

    public CarRaceController(CarRaceGameRunnerService carRaceGameRunnerService) {
        this.carRaceGameRunnerService = carRaceGameRunnerService;
    }

    public CarRaceResponseDTO playRaceGame(CarRaceRequestDTO carRaceRequestDTO) {
        Integer gamePlayCount = carRaceRequestDTO.gamePlayCount();
        return carRaceGameRunnerService.runGame(carRaceRequestDTO.carNames(), gamePlayCount);
    }
}
