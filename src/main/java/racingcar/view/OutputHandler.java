package racingcar.view;

import java.util.List;
import racingcar.model.position.Positions;

public interface OutputHandler {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<String> names, Positions positions);

    void showWinners(String winners);
}
