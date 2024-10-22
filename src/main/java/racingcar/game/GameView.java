package racingcar.game;

import racingcar.car.Car;
import racingcar.utils.IOUtils;

import java.util.List;

public class GameView {
    GameService gameService;

    public GameView(GameService gameService) {
        this.gameService = gameService;
    }

    void printMove(List<Car> cars) {
        for (Car car : cars) {
            IOUtils.outputStringWithoutEnter(car.getName() + " : ");

            for (int i = 0; i < car.getCurrentMoveCount(); i++) {
                IOUtils.outputStringWithoutEnter("-");
            }

            IOUtils.outputStringWithEnter("");
        }

        IOUtils.outputStringWithEnter("");
    }
}
