package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printResult(List<Car> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            winners.get(i).printWinner();
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
