package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printResult(List<Car> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i < winners.size() -1 ) {
                result.append(", ");
            }
        }
        System.out.println(result);
    }
}
