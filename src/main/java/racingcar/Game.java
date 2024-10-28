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
        outputView.printCarNameInputMessage();
        List<Car> carList = carGenerator.generateCars(inputView.inputCarNames());
        outputView.printRoundCountInputMessage();
        int tryCount = inputView.inputRoundCount();

        List<RoundHistory> roundHistoryList = new ArrayList<>();

        for(int i = 0; i < tryCount; i++){
            for (Car car : carList) {
                if(isMovable(randomNumberGenerator.generate())){
                    car.move();
                }
            }
            roundHistoryList.add(RoundHistory.saveCarPosition(carList));
        }

        outputView.printRoundResults(roundHistoryList);

        List<String> winners = winnerDecider.decideWinner(carList);
        outputView.printWinner(winners);
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }
}
