package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Count;
import racingcar.domain.Racing;
import racingcar.dto.RacingCarResult;
import racingcar.dto.RacingCarWinner;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(final InputView inputView, final OutputView outputView,
                               final RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void start() {
        final List<Car> cars = requestRacingCar();
        final Count count = requestCount();
        final Racing racing = new Racing(cars);
        final List<RacingCarResult> results = racingCarService.getRacingCarResult(racing, count);
        responseResults(results);
        final RacingCarWinner racingCarWinner = racingCarService.getRacingCarWinner(racing);
        responseWinner(racingCarWinner);
    }

    private void responseWinner(final RacingCarWinner racingCarWinner) {
        outputView.printWinner(racingCarWinner);
    }

    private void responseResults(final List<RacingCarResult> results) {
        outputView.printResultTitle();
        outputView.printResults(results);
    }

    private List<Car> requestRacingCar() {
        outputView.printAskCars();
        final String carNames = inputView.readInput();
        return racingCarService.generateCars(carNames);
    }

    private Count requestCount() {
        outputView.printAskCount();
        final String countValue = inputView.readInput();
        return racingCarService.generateCount(countValue);
    }

}
