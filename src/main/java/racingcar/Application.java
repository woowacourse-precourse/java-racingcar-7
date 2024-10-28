package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGameView view = new RacingGameView();

        List<String> carNames = view.getCarNames();
        int rounds = view.getRounds();

        RacingGameService service = new RacingGameService(carNames);
        RacingGameController controller = new RacingGameController(service, view);

        controller.start(rounds);
    }
}