package racingcar.view;

import java.util.List;
import racingcar.model.position.Positions;
import racingcar.util.StringRepeater;

public interface OutputView {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<String> names, Positions positions, StringRepeater stringRepeater);

    void showWinners(String winners);
}
