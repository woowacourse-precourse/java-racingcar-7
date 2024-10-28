package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.RacingRequestDto;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingService {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public RacingService(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public RacingRequestDto racingSetUpRequest() {
        outputView.printInputCarNameGuideMessage();
        final String carNames = Console.readLine();

        outputView.printInputRacingTryCount();
        final int tryCountNumber = inputView.readRacingTryCount();

        return new RacingRequestDto(carNames, tryCountNumber);
    }

    public void runTotalRoundRacing(final List<Car> cars, final int tryCountNumber) {
        outputView.printRacingResultGuideMessage();
        for (int i = 0; i < tryCountNumber; i++) {
            runOneRoundRacing(cars);
        }
    }

    private void runOneRoundRacing(final List<Car> cars) {
        for (Car car : cars) {
            final int randomInt = Randoms.pickNumberInRange(0, 9);
            final String moveDistance = "-".repeat(randomInt);
            if (randomInt >= 4) {
                car.addDistance(1);
            }
            outputView.printCarNameAndMoveDistance(car.getCarName(), moveDistance);
        }
        System.out.println();
    }

    public void findRacingWinner(final Racing racing, final List<Car> cars) {
        for (Car car : cars) {
            if (car.getDistance() > racing.getWinnerDistance()) {
                racing.setWinnerDistance(car.getDistance());
                racing.getWinnerNames().clear();
                racing.getWinnerNames().add(car.getCarName());
            } else if (car.getDistance() == racing.getWinnerDistance()) {
                racing.getWinnerNames().add(car.getCarName());
            }
        }

        String delimitedWinners = String.join(", ", racing.getWinnerNames());
        outputView.printFinalWinners(delimitedWinners);
    }
}
