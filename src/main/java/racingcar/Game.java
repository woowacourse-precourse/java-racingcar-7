package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarGenerator carGenerator;
    private final WinnerDecider winnerDecider;
    private final InputValidator inputValidator;
    private final RandomNumberGenerator randomNumberGenerator;

    public Game(InputView inputView, OutputView outputView, CarGenerator carGenerator, WinnerDecider winnerDecider,
                InputValidator inputValidator,
                RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carGenerator = carGenerator;
        this.winnerDecider = winnerDecider;
        this.inputValidator = inputValidator;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        List<Car> carList = initializeCars();
        int tryCount = getRoundCount();

        List<RoundHistory> roundHistoryList = runRounds(carList, tryCount);

        displayRoundResults(roundHistoryList);
        displayWinners(carList);
    }

    private List<Car> initializeCars() {
        outputView.printCarNameInputMessage();
        List<String> carNames = inputView.inputCarNames();
        return carGenerator.generateCars(carNames);
    }

    private int getRoundCount() {
        outputView.printRoundCountInputMessage();
        return inputView.inputRoundCount();
    }

    private List<RoundHistory> runRounds(List<Car> carList, int tryCount) {
        List<RoundHistory> roundHistoryList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            moveCars(carList);
            roundHistoryList.add(RoundHistory.saveCarPosition(carList));
        }
        return roundHistoryList;
    }

    private void moveCars(List<Car> carList) {
        for (Car car : carList) {
            if (isMovable(randomNumberGenerator.generate())) {
                car.move();
            }
        }
    }

    private void displayRoundResults(List<RoundHistory> roundHistoryList) {
        outputView.printRoundResults(roundHistoryList);
    }

    private void displayWinners(List<Car> carList) {
        List<String> winners = winnerDecider.decideWinner(carList);
        outputView.printWinner(winners);
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }
}
