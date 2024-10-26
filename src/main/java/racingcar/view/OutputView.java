package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.domain.StringConstant.*;

public class OutputView {

    public void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0));

        if (winners.size() == 1) {
            System.out.printf(WINNER_MESSAGE.getValue(), sb);
            return;
        }

        for (int i = 1; i < winners.size(); i++) {
            sb.append(COMMON_WINNER_DELIMITER.getValue()).append(winners.get(i));
        }
        System.out.printf(WINNER_MESSAGE.getValue(), sb);
    }

    public void printPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(POSITION_MESSAGE.getValue(),
                    car.getName(), POSITION_MARK.getValue().repeat(car.getPosition()));
        }
        System.out.println();
    }
}
