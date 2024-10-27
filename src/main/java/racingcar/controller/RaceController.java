package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Race race = prepareRace();
        startRace(race);
        finishRace(race);
    }

    private Race prepareRace() {
        outputView.printInputCarNameMessage();
        String carNames = inputView.inputStringWithoutSpaces();

        outputView.printInputCountMessage();
        String count = inputView.inputStringWithoutSpaces();
        return new Race(carNames, count);
    }

    private void startRace(Race race) {
        outputView.printResultMessage();
        for (int i = 0; i < race.getCount(); i++) {
            race.moveCars();
            outputView.printRace(race);
        }
    }

    private void finishRace(Race race) {
        race.findMaxPosition();
        race.findWinner();
        outputView.printWinner(race);
    }
}
