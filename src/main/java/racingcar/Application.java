package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.collection.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {

        String racingCarName = inputView.inputRacingCarName();
        int gameCount = inputView.inputGameCount();

        RacingCar racingCar = new RacingCar(racingCarName);

        System.out.println("실행 결과");

        for (int i = 0; i < gameCount; i++) {
            racingCarController.gameStart(racingCar);
            outputView.printPerDegreeResult(racingCar);
            System.out.println();
        }

        outputView.printWinners(racingCarController.findWinner(racingCar));
    }
}
