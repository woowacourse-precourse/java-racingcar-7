package racingcar;

import static racingcar.view.InputView.inputString;
import static racingcar.view.ResultView.printGoDistance;
import static racingcar.view.ResultView.printResultMessage;
import static racingcar.view.ResultView.printWinnerCarName;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.TryCount;
import racingcar.domain.WinnerCars;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = makeRace();

        startRace(race);

        finishRace(race);
    }

    private static Race makeRace() {
        Cars cars = new Cars(inputString(ResultView::printRaceCarName));
        TryCount tryCount = new TryCount(inputString(ResultView::printTryCount));
        return new Race(tryCount, cars);
    }

    private static void startRace(Race race) {
        printResultMessage();
        while (!race.isFinishRace()) {
            race.doRace();
            printGoDistance(race.getCars());
        }
    }

    private static void finishRace(Race race) {
        WinnerCars winnerCars = race.getWinnerCars();
        printWinnerCarName(winnerCars.getWinnerCarNames());
    }
}
