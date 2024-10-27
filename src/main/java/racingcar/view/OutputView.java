package racingcar.view;

import racingcar.message.OutputMessage;
import racingcar.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printWinner(List<Car> winnerList) {

        if (winnerList.size() == 1) {
            OutputMessage.SOLO_WINNER.printMessage();
        }
        else {
            OutputMessage.JOINT_WINNER.printMessage();
        }

        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print(winners);
    }
}
