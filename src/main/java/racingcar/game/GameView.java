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
            executionResultOfEachCar(car);
        }

        IOUtils.outputStringWithEnter("");
    }

    void printWinner(List<Car> cars) {
        List<String> winners = gameService.getWinnerByRanks(cars);

        IOUtils.outputStringWithoutEnter("최종 우승자 : ");
        int winnersSize = winners.size();

        for (int i = 0; i < winners.size() - 1; i++) {
            IOUtils.outputStringWithoutEnter(winners.get(i) + ", ");
        }

        IOUtils.outputStringWithEnter(winners.get(winnersSize - 1));
    }

    private void executionResultOfEachCar(Car car) {
        IOUtils.outputStringWithoutEnter(car.getName() + " : ");

        for (int i = 0; i < car.getCurrentMoveCount(); i++) {
            IOUtils.outputStringWithoutEnter("-");
        }

        IOUtils.outputStringWithEnter("");
    }
}
