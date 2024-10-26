package racingcar.controller;

import java.util.List;
import racingcar.Io.Input;
import racingcar.domain.Car;
import racingcar.service.GameService;

public class RacingGameController {
    public static void run() {
        List<Car> cars = Input.carNames();
        int attempt = Input.attempt();

        GameService gameService = new GameService(cars);
        for (int i = 0; i < attempt; i++) {
            gameService.progress();
            // todo 차수별 실행 결과 출력
        }
        List<Car> winners = gameService.getWinners();
        // todo 최종 우승자 출력
    }
}
