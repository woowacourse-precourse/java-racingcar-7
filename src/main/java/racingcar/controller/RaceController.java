package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.StringConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    public void playGame() {
        final String carNames = InputView.inputCarNames();
        final int tryCount = InputView.getTryCount();

        StringConvertor convertor = new StringConvertor();
        List<Car> carList = convertor.convertToCarList(carNames);
        Race race = new Race(carList);
        race.startRace(tryCount);

        String winners = convertor.convertToString(race.getWinners());
        OutputView.printWinners(winners);
    }
}
