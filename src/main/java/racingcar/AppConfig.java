package racingcar;

import racingcar.domain.RacingCarList;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingCarList racingCarList() {
        return new RacingCarList(randomMoveStrategy());
    }

    public RandomMoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy();
    }

    public GameClient gameClient() {
        return new GameClient(racingCarList(), inputView(), outputView());
    }

    public InputView inputView() { return new InputView(); }

    public OutputView outputView() { return new OutputView(); }

}
