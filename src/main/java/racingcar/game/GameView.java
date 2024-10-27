package racingcar.game;

import racingcar.car.Car;
import racingcar.utils.IOUtils;

import java.util.List;

public class GameView {
    RankService rankService;

    public GameView(RankService rankService) {
        this.rankService = rankService;
    }

    void printExecutionResultOfCars(List<Car> cars) {
        for (Car car : cars) {
            printExecutionResultOfEachCar(car);
        }

        IOUtils.outputStringWithEnter("");
    }

    void printWinner(List<Car> cars) {
        List<String> winners = rankService.getWinnerByRanks(cars);

        IOUtils.outputStringWithoutEnter("최종 우승자 : ");
        int winnersSize = winners.size();

        for (int i = 0; i < winners.size() - 1; i++) {
            IOUtils.outputStringWithoutEnter(winners.get(i) + ", ");
        }

        IOUtils.outputStringWithEnter(winners.get(winnersSize - 1));
    }

    private void printExecutionResultOfEachCar(Car car) {
        IOUtils.outputStringWithoutEnter(car.getName() + " : ");

        for (int i = 0; i < car.getCurrentMoveCount(); i++) {
            IOUtils.outputStringWithoutEnter("-");
        }

        IOUtils.outputStringWithEnter("");
    }
}
