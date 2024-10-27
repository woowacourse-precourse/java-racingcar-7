package racingcar.view;

import racingcar.model.Car;
import racingcar.util.CommonIo;
import racingcar.util.Message;

import java.util.List;

public class OutputView {
    private final CommonIo io;

    public OutputView() {
        this.io = new CommonIo();
    }

    public void printGetCarNames() {
        io.printMessage(Message.RECEIVE_CAR_NAMES.getSentence());
    }

    public void printGetPlayCount() {
        io.printMessage(Message.RECEIVE_PLAY_COUNT.getSentence());
    }

    public void printSingleResult(Car car) {
        io.printMessage(car.getName() + Message.COLON_WITH_SPACE.getSentence()
                + Message.POSITION_DASH.getSentence().repeat(car.getPosition()));
    }

    public void printWinners(List<String> winner) {
        String finalWinner = String.join(Message.COMMA.getSentence() + Message.WHITE_SPACE.getSentence(), winner);

        io.printMessage(Message.FINAL_WINNER.getSentence()
                + Message.COLON_WITH_SPACE.getSentence()
                + finalWinner);
    }
}
