package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.service.validation.CarNamesValidation;
import racingcar.service.validation.TimesValidation;

public class RacingService {

    public Cars getCars(String input) {
        CarNamesValidation.validateAllInput(input);
        Cars cars = CarNameParser.createCars(CarNameParser.parseCarName(input));
        return cars;
    }

    public int getTimes(String timesInput) {
        TimesValidation.validateAllInput(timesInput);
        return TimesParser.parseTimes(timesInput);
    }

    public List<String> getWinner(Cars cars) {
        return WinnerService.selectWinner(cars);
    }
}
