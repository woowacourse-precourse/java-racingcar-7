package racingcar;

import java.util.List;
import racingcar.domain.RacingCarList;
import racingcar.domain.RacingCarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameClient {
    private final RacingCarList racingCarList;

    public GameClient(RacingCarList racingCarList) {
        this.racingCarList = racingCarList;
    }

    public void run() {
        addRacingCarsToRacingCarList();
        moveCarsForCount();
        List<String> winners = racingCarList.findWinners();
        OutputView.printWinners(winners);
    }

    private void moveCarsForCount() {
        int count = InputView.getCount();
        OutputView.printResultMessage();
        for (int i = 0; i < count; i++) {
            racingCarList.moveAllCars();
            printRacingCarsStatus();
        }
    }

    private void printRacingCarsStatus() {
        List<RacingCarStatus> racingCarsStatus = racingCarList.getRacingCarsStatus();
        OutputView.printRacingCarsStatus(racingCarsStatus);
    }

    private void addRacingCarsToRacingCarList() {
        String[] carNames = InputView.getCarNames();
        for(String carName : carNames) {
            racingCarList.addRacingCar(carName);
        }
    }
    
}
