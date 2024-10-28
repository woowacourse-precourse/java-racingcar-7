package racingcar.controller;

import racingcar.view.View;
import racingcar.domain.*;
import racingcar.util.Parser;

public class RaceController {
    public void startRace() {
        Cars cars = Cars.saveNames(View.requestCarNames());
        Integer count = Parser.parseStringToInteger(View.requestTryMoveNumber());
        play(cars, count);
    }

    private void play(final Cars cars, final Integer totalCount) {
        View.printlnMessage("실행 결과");
        for (int count = 0; count < totalCount; count++) {
            cars.tryMoveCars();
            View.printlnString(cars.toString() + "\n");
        }
    }
}