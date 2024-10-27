package racingcar.view;

import java.util.List;
import racingcar.message.Message;
import racingcar.model.Cars;

public class OutputView {
    public void printResult(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();

        cars.getCars().forEach(car -> {
            stringBuilder.append(car.getName() + Message.colon.getMessage());
            stringBuilder.append(Message.bar.getMessage().repeat(car.getDistance()));
            stringBuilder.append(Message.newLine.getMessage());
        });

        System.out.println(stringBuilder);
    }

    public void printWinner(List<String> winner) {
        String winners = String.join(", ", winner);
        System.out.print(Message.winner.getMessage() + winners);
    }
}
