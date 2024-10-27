package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Parser;
import racingcar.dto.CarsPositions;
import racingcar.dto.Winners;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.TotalRoundsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final String DELIMITER = ",";

    public void startRacing(){
        String rawCarNames = InputView.requestCarNames();
        List<String> carNames = Parser.parse(rawCarNames,DELIMITER);
        CarNamesValidator.validate(carNames);
        Cars cars = Cars.createCars(carNames);

        String rawTotalRounds = InputView.requestTotalRounds();
        TotalRoundsValidator.validate(rawTotalRounds);
        int totalRounds = Integer.parseInt(rawTotalRounds);

        proceedRacing(cars, totalRounds);
        announceWinner(cars);

        Console.close();
    }

    private void proceedRacing(final Cars cars ,final int totalRounds ) {
        OutputView.printProcessResult();

        for (int i = 0; i < totalRounds; i++) {
            cars.proceedOneRound();
            CarsPositions carsPositions = cars.buildCarsPositions();
            OutputView.printRoundResult(carsPositions.getVisualizedPositions());
        }
    }

    private void announceWinner(Cars cars) {
        Winners winners = cars.buildWinners();
        OutputView.printWinner(winners.getWinners());
    }

}
