package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RoundProgress;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Name;
import racingcar.vo.Round;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringSplitter stringSplitter;
    private final NumberParser numberParser;

    public RacingController(
            InputView inputView,
            OutputView outputView,
            StringSplitter stringSplitter,
            NumberParser numberParser
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringSplitter = stringSplitter;
        this.numberParser = numberParser;
    }

    public void run() {
        String userInput = inputView.getCarNames();
        List<String> splitString = stringSplitter.split(userInput);

        userInput = inputView.getTotalRace();
        Integer parsedNumber = numberParser.parse(userInput);

        List<Name> names = splitString.stream().map(Name::from).toList();
        List<Car> cars = names.stream().map(Car::withName).toList();

        Round round = Round.from(parsedNumber);

        Race race = Race.initializeRace(
                Cars.from(cars),
                RoundProgress.createFromTotalRounds(round)
        );

        race.execute(RandomMovingStrategy.getInstance());
        outputView.printRoundResults(race.getEntireHistory());
        outputView.printWinners(race.getWinners());
    }
}
