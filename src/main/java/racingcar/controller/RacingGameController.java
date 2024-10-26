package racingcar.controller;

import java.util.List;
import racingcar.Io.Input;
import racingcar.Io.Output;
import racingcar.domain.Car;
import racingcar.service.GameService;

public class RacingGameController {
    public static void run() {
        List<Car> cars = Input.carNames();
        int attempt = Input.attempt();
        GameService gameService = new GameService(cars);
        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            gameService.progress();
            Output.currentProgress(cars);
        }
        List<Car> winners = gameService.getWinners();
        Output.winners(winners);
    }
}
