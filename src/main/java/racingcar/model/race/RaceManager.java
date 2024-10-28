package racingcar.model.race;

import java.util.List;
import racingcar.model.winner.Winners;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceManager {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public RaceManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        prepareRace();
        startRace();
        showWinner();
    }

    private void prepareRace() {
        Cars cars = Cars.from(inputView.inputCarNames());
        TryCount tryCount = TryCount.from(inputView.inputTryCount());
        race = new Race(cars, tryCount);
    }

    private void startRace() {
        outputView.printRoundHeader();
        for (int i = 0; i < race.getTryCount(); i++) {
            race.round();
            outputView.printRoundResult(displayRoundResult());
        }
    }

    private void showWinner() {
        Winners winners = race.createWinner();
        String result = displayWinners(winners.getWinners());
        outputView.printWinners(result);
    }

    private String displayRoundResult() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> cars = race.getPlayers();
        cars.forEach(car -> {
            stringBuilder.append(car.getCarName());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(Math.max(0, car.getCurrentLocation())));
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }

    private String displayWinners(List<Car> winners) {
        List<String> winnersName = winners.stream().map(Car::getCarName).toList();
        return String.join(",",winnersName);
    }
}
