package racingcar.view;

import java.util.List;
import racingcar.model.position.Position;

public interface OutputHandler {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<String> names, List<Position> positions);

    void showWinners(String winners);
}
