package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceLog;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void process() {
        String[] carNames = inputView.inputCarNames().split(",");
        Cars cars = Cars.from(List.of(carNames));

        int raceRound = inputView.inputRaceRound();

        Race race = Race.from(raceRound, cars);
        race.play();

        List<RaceLog> raceLogs = race.getRaceLogs();
        List<Car> victoryCars = race.getVictoryCars();
        outputView.printRaceResult(raceLogs, victoryCars);
    }
}
