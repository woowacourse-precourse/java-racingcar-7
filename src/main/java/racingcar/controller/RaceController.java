package racingcar.controller;

import racingcar.dto.CarsDto;
import racingcar.service.RaceService;
import racingcar.view.InputView;

public class RaceController {
    public void run() {
        String inputCars = InputView.inputCars();
        String roundCount = InputView.inputRounds();

        RaceService raceService = new RaceService();
        CarsDto carsDto = raceService.raceSetting(inputCars);

        int round = raceService.roundService(roundCount);
        for (int i = 0; i < round; i++) {
            carsDto = raceService.playOneRound(carsDto);
        }

    }
}
