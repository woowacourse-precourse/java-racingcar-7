package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.service.CarNameParser;
import racingcar.service.RacingRunSercie;
import racingcar.service.TimesParser;
import racingcar.service.WinnerService;
import racingcar.service.validation.CarNamesValidation;
import racingcar.service.validation.TimesValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void run(){
        Cars cars = getCars();

        int times = getTimes();

        racing(times, cars);

        getWinner(cars);
    }

    private static void getWinner(Cars cars) {
        List<String> winner = WinnerService.selectWinner(cars);
        OutputView.printWinner(winner);
    }

    private static void racing(int times, Cars cars) {
        OutputView.racingResult();

        for (int i = 0; i< times; i++){
            RacingRunSercie.doRacing(cars);
            OutputView.newLine();
        }
    }

    private static int getTimes() {
        String timesInput = InputView.timesInput();
        TimesValidation.validateAllInput(timesInput);

        int times = TimesParser.parseTimes(timesInput);
        return times;
    }

    private static Cars getCars() {
        String input = InputView.carsInput();
        CarNamesValidation.validateAllInput(input);

        Cars cars = CarNameParser.createCars(CarNameParser.parseCarName(input));
        return cars;
    }
}
