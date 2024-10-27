package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.service.RacingRunService;
import racingcar.service.RacingService;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService){
        this.racingService = racingService;
    }

    public void run(){
        String input = InputView.carsInput();
        Cars cars = racingService.getCars(input);

        String timesInput = InputView.timesInput();
        int times = racingService.getTimes(timesInput);

        OutputView.racingResult();
        executeRacing(times, cars);

        List<String> winner = racingService.getWinner(cars);
        OutputView.printWinner(winner);
    }

    private void executeRacing(int times, Cars cars) {
        for (int i = 0; i< times; i++){
            RacingRunService.doRacing(cars);
            OutputView.newLine();
        }
    }
}
