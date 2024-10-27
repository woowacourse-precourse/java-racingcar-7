package racingcar.view.output;

import java.util.List;
import racingcar.model.game.position.Positions;
import racingcar.support.repeater.StringRepeater;

public interface OutputView {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<String> names, Positions positions, StringRepeater stringRepeater);

    void showWinners(String winners);
}
