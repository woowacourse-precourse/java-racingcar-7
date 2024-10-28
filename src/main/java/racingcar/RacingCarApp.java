package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.condition.SixtyPercentMovingCondition;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class RacingCarApp {

    private final CarManager carManager;
    private final Referee referee;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarApp() {
        this.carManager = new CarManager(new SixtyPercentMovingCondition());
        this.referee = new Referee();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Car> cars = readCarsFromUserInput();
        int numberOfTimes = readNumberOfTimesFromUserInput();

        processRacing(numberOfTimes, cars);
        printWinners(referee.findWinners(cars));
    }

    private void processRacing(int numberOfTimes, List<Car> cars) {
        outputView.printResultMessage();
        for (int i = 0; i < numberOfTimes; i++) {
            carManager.moveCarsForward(cars);
            outputView.printResult(makeInterimResult(cars));
        }
    }

    private int readNumberOfTimesFromUserInput() {
        outputView.printRequestInputNumberOfTimesMessage();
        return inputView.readNumberOfTimes();
    }

    private List<Car> readCarsFromUserInput() {
        outputView.printRequestInputCarNameMessage();
        return carManager.makeCarsFromText(inputView.readCarNameText());
    }

    private String makeInterimResult(List<Car> cars) {
        return cars.stream()
                .map(Car::convertCurrentStateToString)
                .collect(Collectors.joining("\n"));
    }

    private void printWinners(List<Car> winners) {
        String winnerMessage = winners.stream()
                .map(Car::toString)
                .collect(Collectors.joining(", "));

        outputView.printWinners(winnerMessage);

    }
}
