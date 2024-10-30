package racingcar.controller;

import racingcar.dto.CarsDto;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    public void run() {
        String inputCars = InputView.inputCars();
        String roundCount = InputView.inputRounds();

        RaceService raceService = new RaceService();
        CarsDto carsDto = raceService.raceSetting(inputCars);

        int round = raceService.roundService(roundCount);
        OutputView.outputBeforeRound();
        for (int i = 0; i < round; i++) {
            carsDto = raceService.playOneRound(carsDto);
            OutputView.outputEachRound(carsDto);
        }
        List<String> result =  raceService.raceResult(carsDto);
        OutputView.outputRaceResult(result);
    }
}
