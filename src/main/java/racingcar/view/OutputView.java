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
}
