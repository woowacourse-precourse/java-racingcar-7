package racingcar.view.output;

import java.util.List;
import racingcar.model.car.Name;
import racingcar.support.repeater.StringRepeater;

public interface OutputView {
    void showCommentForCarNames();

    void showCommentForAttempt();

    void showCommentForResult();

    void showCarPosition(List<Name> names, List<Long> positions, StringRepeater stringRepeater);

    void showWinners(String winners);
}
