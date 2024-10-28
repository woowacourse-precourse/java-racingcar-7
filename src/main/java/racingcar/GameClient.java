package racingcar;

import java.util.List;
import racingcar.domain.RacingCarList;
import racingcar.domain.RacingCarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameClient {
    private final RacingCarList racingCarList;
    private final InputView inputView;
    private final OutputView outputView;

    public GameClient(RacingCarList racingCarList, InputView inputView, OutputView outputView) {
        this.racingCarList = racingCarList;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        addRacingCarsToRacingCarList();
        moveCarsForCount();
        printWinners();
    }

    private void printWinners() {
        List<String> winners = racingCarList.findWinners();
        outputView.printWinners(winners);
    }

    private void moveCarsForCount() {
        int count = inputView.getCount();
        outputView.printResultMessage();
        for (int i = 0; i < count; i++) {
            racingCarList.moveAllCars();
            printRacingCarsStatus();
        }
    }

    private void printRacingCarsStatus() {
        List<RacingCarStatus> racingCarsStatus = racingCarList.getRacingCarsStatus();
        outputView.printRacingCarsStatus(racingCarsStatus);
    }

    private void addRacingCarsToRacingCarList() {
        String[] carNames = inputView.getCarNames().split(",");
        for(String carName : carNames) {
            racingCarList.addRacingCar(carName);
        }
    }
    
}
