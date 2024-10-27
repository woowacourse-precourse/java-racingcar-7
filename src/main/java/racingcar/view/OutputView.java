package racingcar.view;

import racingcar.Car;
import racingcar.util.CommonIo;
import racingcar.util.Limit;
import racingcar.util.Message;

import java.util.List;

public class OutputView {
    private CommonIo io = new CommonIo();

    public void printGetCarNames(){
        io.printMessage(Message.RECEIVE_CAR_NAMES.getSentence());
    }

    public void printGetPlayCount(){
        io.printMessage(Message.RECEIVE_PLAY_COUNT.getSentence());
    }

    public void printSingleResult(Car car) {
        io.printMessage(car.getName() + Message.COLON_WITH_SPACE.getSentence()
                + Message.POSITION_DASH.getSentence().repeat(car.getPosition()));
    }

    public void printWinners(List<Car> cars) {
        int maxPosition = Limit.MIN_POSITION.getValue();
        StringBuilder winner = new StringBuilder();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                winner.setLength(Limit.DEFAULT.getValue());
                winner.append(car.getName());
                maxPosition = car.getPosition();
            } else if (car.getPosition() == maxPosition) {
                winner.append(Message.COMMA.getSentence())
                        .append(Message.WHITE_SPACE.getSentence())
                        .append(car.getName());
            }
        }

        io.printMessage(Message.FINAL_WINNER.getSentence() + Message.COLON_WITH_SPACE.getSentence() + winner);
    }
}
