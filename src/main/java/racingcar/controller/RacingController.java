package racingcar.controller;

import racingcar.domain.*;
import racingcar.util.NameParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public void run(final NumberGenerator numberGenerator) {
        String input = InputView.getNames();
        List<Name> names = getNames(input);
        Round round = new Round(InputView.getRound());
        List<Car> cars = CarFactory.createCars(names, numberGenerator);
        startRacing(cars, round, numberGenerator);
    }

    private List<Name> getNames(String input) {
        List<String> inputToList = NameParser.convertStringToName(input);
        return NameFactory.createNames(inputToList);
    }

    private void startRacing(List<Car> cars, Round round, NumberGenerator numberGenerator) {

        Racing racing = new Racing(cars);

        for (int i = 0; i < round.value(); i++) {
            racing.race();
            cars.forEach(car -> OutputView.printResult(car.getName(), car.getDistance()));
            OutputView.printEmptyLine();
        }

        List<String> winners = racing.findWinners();
        OutputView.printWinners(winners);

    }
}
