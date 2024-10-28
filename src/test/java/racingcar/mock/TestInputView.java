package racingcar.mock;

import java.util.List;
import racingcar.view.InputView;

public class TestInputView implements InputView {
    private final List<String> names;
    private final int rounds;

    public TestInputView(List<String> names, int rounds) {
        this.names = names;
        this.rounds = rounds;
    }

    @Override
    public List<String> readNames() {
        return names;
    }

    @Override
    public int readRounds() {
        return rounds;
    }
}
