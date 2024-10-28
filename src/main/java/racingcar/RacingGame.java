package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {
    InputView inputView;
    OutputView outputView;
    InputParser inputParser;
    Referee referee;

    public RacingGame(InputView inputView, OutputView outputView, InputParser inputParser, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.referee = referee;
    }

    public void start() {
        String inputCarNames = inputView.readCarNames();
        ArrayList<Car> cars = inputParser.parseCarNames(inputCarNames);
        String inputTryCount = inputView.readTryCount();
        int tryCount = inputParser.parseTryCount(inputTryCount);

        System.out.println("\n실행결과");
        for (int i = 0; i < tryCount; i++) {
            determineCarsMovement(cars);
            outputView.printMovementResult(cars);
        }
        ArrayList<String> winners = referee.selectWinners(cars);
        outputView.printWinner(winners);
    }

    private void determineCarsMovement(ArrayList<Car> cars) {
        for (Car car : cars) {
            determineCarMovement(car);
        }
    }

    private void determineCarMovement(Car car) {
        int randomNumber = Randoms.pickNumberInRange(Constant.RANDOM_START, Constant.RANDOM_END);
        if (randomNumber >= Constant.MOVE_FORWARD) {
            car.move();
        }
    }
}
