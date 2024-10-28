package racingcar.View;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Constants.ViewMessage;
import racingcar.Model.Car;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessages(List<String> messages) {
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println();
    }

    public void printResult(List<Car> winnerList) {
        System.out.print(ViewMessage.FINAL_WINNER_MESSAGE);
        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners);
    }

}
