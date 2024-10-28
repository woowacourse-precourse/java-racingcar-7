package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.StringConvertor;
import racingcar.model.Verifier;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    public void playGame() {
        final String carNames = InputView.inputCarNames();
        StringConvertor convertor = new StringConvertor();
        List<Car> carList = convertor.convertToCarList(carNames);

        final int tryCount = InputView.inputTryCount();
        Verifier.verifyTryCountRange(tryCount);

        Race race = new Race(carList);
        race.startRace(tryCount);

        String winners = convertor.convertToString(race.getWinners());
        OutputView.printWinners(winners);
    }
}
