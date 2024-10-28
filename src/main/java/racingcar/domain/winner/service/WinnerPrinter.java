package racingcar.domain.winner.service;

import racingcar.domain.car.entity.Car;
import racingcar.domain.winner.entity.Winner;

import java.util.List;

public class WinnerPrinter {

    public void printWinner(List<Car> carList) {

        StringBuilder winnerNames = new StringBuilder();
        WinnerCalculator winnerCalculator = new WinnerCalculator();

        Winner winner = winnerCalculator.calculateWinner(carList);

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.getWinningCars().size(); i++) {
            winnerNames.append(winner.getWinningCars().get(i).getName());
            if (isMoreWinner(i, winner)) {
                winnerNames.append(", ");
            }
        }
        System.out.println(winnerNames);
    }

    private boolean isMoreWinner(int i, Winner winner) {
        return i < winner.getWinningCars().size() - 1;
    }
}
