package racingcar.controller;

import racingcar.dto.CarNamesInputHandler;
import racingcar.dto.GameRoundInputHandler;
import racingcar.message.Message;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    public void run() {
        // Car Names
        List<String> carNames = InputView.getCarNames();
        CarNamesInputHandler.handle(carNames);

        // Game Round
        String gameRound = InputView.getGameRound();
        GameRoundInputHandler.handle(gameRound);
        int parsedGameRound = Integer.parseInt(gameRound);

        RacingCars racingCars = new RacingCars(carNames);

        System.out.println(Message.EXECUTION_MESSAGE);
        for(int i = 0; i < parsedGameRound; i++) {
            racingCars.moveCars();
            System.out.println(racingCars.toString());
        }

        System.out.print(Message.WINNER_MESSAGE);
        System.out.println(racingCars.getWinners());
    }
}
