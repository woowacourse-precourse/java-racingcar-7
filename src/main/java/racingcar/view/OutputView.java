package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printLeaderBoard(List<Car> carList) {
        StringBuilder leaderBoard = new StringBuilder();

        carList.forEach(car -> {
            leaderBoard.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        });

        System.out.println(leaderBoard);
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        winners.forEach(car -> System.out.print(car.getName() + " "));
    }
}
