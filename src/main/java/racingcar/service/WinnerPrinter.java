package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Winner;

import java.util.List;

public class WinnerPrinter {

    public void printWinner(List<Car> carList) {

        StringBuilder winnerNames = new StringBuilder();
        WinnerCalculator winnerCalculator = new WinnerCalculator();

        Winner winner = winnerCalculator.calculateWinner(carList);

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.getWinningCars().size(); i++) {
            winnerNames.append(winner.getWinningCars().get(i).getName());
            if (isMoreWinner(i, winner)) { // 마지막 이름이 아닐 경우에만 쉼표 추가
                winnerNames.append(", ");
            }
        }
        System.out.println(winnerNames);
    }

    private boolean isMoreWinner(int i, Winner winner) {
        return i < winner.getWinningCars().size() - 1;
    }
}
