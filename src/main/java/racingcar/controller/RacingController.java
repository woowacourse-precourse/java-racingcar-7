package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.service.CarNameParser;
import racingcar.service.RacingRunService;
import racingcar.service.RacingService;
import racingcar.service.TimesParser;
import racingcar.service.WinnerService;
import racingcar.service.validation.CarNamesValidation;
import racingcar.service.validation.TimesValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    RacingService racingService = new RacingService();

    public void run(){
        String input = InputView.carsInput();
        Cars cars = racingService.getCars(input);

        String timesInput = InputView.timesInput();
        int times = racingService.getTimes(timesInput);

        OutputView.racingResult();
        excuteRacing(times, cars);

        List<String> winner = racingService.getWinner(cars);
        OutputView.printWinner(winner);
    }

    private void excuteRacing(int times, Cars cars) {
        for (int i = 0; i< times; i++){
            RacingRunService.doRacing(cars);
            OutputView.newLine();
        }
    }







}
