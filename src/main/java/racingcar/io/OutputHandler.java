package racingcar.io;

import java.util.List;
import racingcar.car.Position;

public interface OutputHandler {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<String> names, List<Position> positions);

    void showWinners(String winners);
}
